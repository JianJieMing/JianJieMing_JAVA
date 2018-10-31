## Redis缓存
### 一.注解
1. @EnableCaching 在SpringRedisApplication类中加添加,开启高速缓存.

2. @Cacheable(value = "roleService", key = "#roleId") 
   在service实现类中的方法上添加,表示给某个方法开启缓存,
   后面的key就是在返回值中拿到插入之后的数据,是在redis中的缓存中拿到的,
   不用再查询数据库.
   
3. @CachePut(value = "roleService", key = "#roleInfo.roleId"),
   在执行插入操作的时候,直接把插入的数据存到redis缓存中,查数据时,直接缓存中取数据.
   
4. @CacheEvict(value = "roleService", allEntries = true),
   在执行删除操作的时候,会把缓存中的所有缓存清空.
   
5. @GeneratedValue(strategy = GenerationType.IDENTITY),
   给实体类属性id列设置为主键,自增长.
   
### 二.缓存具体实现(附加点赞demo) 

1. 在SpringRedisApplication类中加上注解: @EnableCaching
2. 创建entity层,代码如下:

    
    import javax.persistence.*;
    import java.io.Serializable;
    
    @Entity
    @Table(name = "role_info")
    public class RoleInfo implements Serializable {
    
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long roleId;
      private String name;
    
      @Override
      public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                '}';
      }
    
      public Long getRoleId() {
        return roleId;
      }
    
      public void setRoleId(Long roleId) {
        this.roleId = roleId;
      }
    
    
      public String getName() {
        return name;
      }
    
      public void setName(String name) {
        this.name = name;
      }
    
    }

3. 创建mapper层,代码如下: 


    import org.springframework.data.jpa.repository.JpaRepository;
    
    public interface RoleMapper extends JpaRepository<RoleInfo,Long> {
    
    
    }
    
4. 创建service层,代码如下:


    public interface RoleService {
    
        List<RoleInfo> findAll();
    
        RoleInfo findOne(Long l);
    
        RoleInfo addOne(RoleInfo roleInfo);
    
        Boolean delete(Long roleId);
    
        public boolean thumb(Long roleId);
    
        public Set<?> thumbList();
    
    }
    service层实现类如下:
    @Service
    public class RoleServiceImpl implements RoleService {
    
        @Autowired
        private RoleMapper mapper;
    
        @Resource
        private RedisTemplate<Object, Object> redisTemplate;
    
        @Cacheable(value = "roleService")
        @Override
        public List<RoleInfo> findAll() {
            System.out.println("RoleServiceImpl.findAll");
            List<RoleInfo> all = this.mapper.findAll();
            return all;
        }
    
        @Cacheable(value = "roleService", key = "#roleId")
        @Override
        public RoleInfo findOne(Long l) {
            System.out.println("RoleServiceImpl.findOne");
            RoleInfo one = this.mapper.findById(l).get();
            return one;
        }
    
        // 这个key是重返回值中拿到插入之后的数据,是在redis中的缓存中拿到的
        @CachePut(value = "roleService", key = "#roleInfo.roleId")
        @Override
        public RoleInfo addOne(RoleInfo roleInfo) {
            System.out.println("RoleServiceImpl.addOne");
            RoleInfo save = this.mapper.save(roleInfo);
            return save;
        }
    
        // 清空所有缓存(卡死以为的,奥恩退思)
        @CacheEvict(value = "roleService", allEntries = true)
        @Override
        public Boolean delete(Long roleId) {
            System.out.println("RoleServiceImpl.delete");
            this.mapper.deleteById(roleId);
            return true;
        }
        
        // 点赞demo
        public boolean thumb(Long roleId) {
            ZSetOperations<Object, Object> forZSet = this.redisTemplate.opsForZSet();
            // 根据roleId查询信息.
            RoleInfo one = findOne(roleId);
            // 向redis缓存中缓存对象,每次刷新网页赞+1
            forZSet.incrementScore("thumb:roleId", one, 1);
            return true;
        }
    
        public Set<?> thumbList() {
            ZSetOperations<Object, Object> opsForZSet = this.redisTemplate.opsForZSet();
            // 根据key取出缓存中的数据,并排序,赞多的在前面.
            Set<ZSetOperations.TypedTuple<Object>> scores =
                    opsForZSet.reverseRangeWithScores("thumb:roleId", 0, 2);
            return scores;
        }

5. 创建controller层,代码如下: 


    import com.lanou3g.springredis.RoleService.RoleService;
    import com.lanou3g.springredis.entity.RoleInfo;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    import javax.annotation.Resource;
    import java.util.List;
    import java.util.Set;
    
    
    @RestController
    @RequestMapping("/role")
    public class RoleController {
    
        @Resource
        private RoleService roleService;
    
        @RequestMapping("/findAll")
        public List<RoleInfo> findAll() {
            List<RoleInfo> all = this.roleService.findAll();
            System.out.println(all + "**********");
            return all;
        }
    
        @RequestMapping("/findOne/{roleId}")
        public RoleInfo findOne(@PathVariable Long roleId) {
            RoleInfo one = this.roleService.findOne(roleId);
            return one;
        }
    
        @RequestMapping("/addOne")
        public Boolean addOne(RoleInfo roleInfo) {
            this.roleService.addOne(roleInfo);
            return true;
        }
    
        @RequestMapping("/delete/{roleId}")
        public Boolean delete(@PathVariable Long roleId) {
            return this.roleService.delete(roleId);
        }
    
        @RequestMapping("/like/{roleId}")
        public boolean like(@PathVariable Long roleId) {
            return this.roleService.thumb(roleId);
        }
    
        @RequestMapping("/thumbList")
        public Set<?> thumbList() {
            Set<?> set = this.roleService.thumbList();
            return set;
        }
    
    }
    
6. 创建配置文件类,代码如下:

    
    import com.fasterxml.jackson.databind.ObjectMapper;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.data.redis.connection.RedisConnectionFactory;
    import org.springframework.data.redis.core.RedisTemplate;
    import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
    
    import java.text.SimpleDateFormat;
    
    @Configuration
    public class RedisConfig {
    
        @Bean
        public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
            RedisTemplate<Object, Object> template
                    = new RedisTemplate<>();
            template.setConnectionFactory(factory);
            // 定制Jackson
            ObjectMapper mapper = new ObjectMapper();
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
            Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
            // 把value序列化成json格式.
            template.setValueSerializer(serializer);
            template.setKeySerializer(serializer); // 转json
            // 文件里的配置也会加载.
            template.afterPropertiesSet();
            return template;
        }
    
    }

7. application.yml配置文件如下:


    spring:
      datasource:
        driver-class-name: com.mysql.jdbc.Driver
        url: jdbc:mysql://localhost:3306/netctoss
        username: root
        password: root
        #最大活跃数
        maxActive: 20
        #初始化数量
        initialSize: 1
        #最大连接等待超时时间
        maxWait: 60000
        #打开PSCache，并且指定每个连接PSCache的大小
        poolPreparedStatements: true
        maxPoolPreparedStatementPerConnectionSize: 20
        #通过connectionProperties属性来打开mergeSql功能；慢SQL记录
        #connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
        minIdle: 1
        timeBetweenEvictionRunsMillis: 60000
        minEvictableIdleTimeMillis: 300000
        validationQuery: select 1 from dual
        testWhileIdle: true
        testOnBorrow: false
        testOnReturn: false
    
      jpa:
        show-sql: true
        hibernate:
          ddl-auto: none
      jackson:
        serialization:
          indent_output: true

```

pom.xml配置如下:
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-cache</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/redis.clients/jedis -->
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
            <version>2.9.0</version>
        </dependency>
```

