## MySQL 复习

- 创建数据库

    
    create database 数据库名
    
- 删除数据库


    drop database 数据库名
    
- 选择数据库


    use 数据库名
    
- 查看所有数据库

    
    show databases
    
- 查看所有表


    show tables
    
- 建表


    create table 表名 (
    列名 列类型 约束 [default 默认值] [comment 注释],
    列名 列类型 约束 [default 默认值] [comment 注释],
    ...
    )
    
- 约束


    unique 唯一
    not null 非空
    primary key 主键
    auto_increment 自增长
    
- 数据类型


    bit
    tinyint smallint mediumint int bigint
    整数: int[m] [unsigned] [zerofill]
    boolean/bool
    float double
    decimal
    char
    varchar(M)
    text
    blob 存二进制的
    binary
    date time datetime timestamp year
  
- 添加列

    
    alter table 表名 add 列名 列类型
    
- 删除列


    alter table 表名 drop 列名
    
- 修改列的类型

    
    alter table 表名 modify 列名 列类型
        
- 修改列的名称和类型


    alter table change 旧列名 新列名 新列类型
    
- 表的重命名

    
    rename 旧表名 to 新表名
    表的重命名可以将一个表移动到另外的数据库中.
    rename table 旧库.旧表名 to 新库.新表名
    
- 删除表
 
 
    drop table 表名
    
- 根据列的顺序一次插入一条数据

    
    值得顺序和数量需要和列的定义保持一致.
    insert into 表名 value (值1,值2,...)
    
- 向指定的列中插入一条数据


    insert into 表名 (列名1,列名2,...) value (值1,值2,...)

- 根据列的顺序一次插入多条数据
    
    
    insert into 表名 values (值1,值2,...),(值1,值2,...),...
    
- 向指定的列中一次插入多条数据


    insert into 表名 (列1,列2,...) values (值1,值2,...),(值1,值2,...),...
    
- 根据条件删除数据


    delete from 表名 where 条件
    
- 删除某个表的所有数据


    delete from 表名
    
- 清空某个表

    
    truncate table 表名
    
- 修改数据

    
    update 表名 set 列 = 新值 where 条件
    
- 查询数据

    
    查询某个表的所有列的所有数据:
    select * from 表名
    查询某个表的所有指定列的所有数据:
    select 列1 as 别名1,列2 as 别名2 from 表名
    where 条件
    
- 条件

    
    1. 比较运算符: > >= = < <= !=
    2. 是否在某个集合中 in
    3. 是否不在某个集合中 not in
    4. 在两个值之间 between min and max
    5. 不在两个值之间 not between min and max
    6. 逻辑运算符: and or ! 
    7. 判断是否为null is null
    8. 判断是否不为空 is not null
    9. 判断字符串符合某个格式 like _ % 
       '%str' 以str结尾的
       'str%' 以str开头的
       '%str%' 包含str的
    
- 分组


    group by 列1,列2,... having 条件
    分组一般会跟着分组函数(聚合函数)一起使用.
     
    max 
    sum 
    avg 
    min 
    count
    group_concat
    
- 分页


    limit m,n
    从第m条数据开始,取n条数据.
    
- 函数


    1. if(com,value1,value2)
       相当于三目运算符.
    2. ifnull(列,值)
       如果列的值为null,结果取值.
    3. case ... when ... then ... end
       一共有两种写法,一种相当于switch,
       一种相当于 if ... else if ...
       
    switch
    有一列的地址(address),取值有如下形式:
    10001: 户籍地址
    10002: 家庭地址
    10003: 公司地址
    case address
    when 10001 then '户籍地址
    when 10002 then '家庭地址
    when 10003 then '公司地址
    else 其他地址
    end 地址
    
    case
    when score >= 80 then '优秀'
    when score >= 60 then '及格'
    when score < 60 then '不及格'
    else '垃圾'
    end 成绩评价
    
    4. concat
    5. trim
    6. char_length
    
- 添加外键


    alter table 表名 
    add constraint 外键名字
    foreign key (需要添加外键的列)
    references 关联的表(关联表的列)
    [on delete '约束形式1']
    [on update '约束形式2']
     
    外键约束: 约束的是对父表的数据删除或者更新时,对子表的影响.
    restrict 限制 父表的数据不能动.
    cascade 级联 更新或删除父表数据的时候,子表也做相同的操作.
    set null 置空 子表的外键列置为null
    no action 与 restrict一样
    set default
    外键名字命名规范: 源表名_目标表名_添加外键的列_fk
    
- 删除外键


    alter table 表名 drop foreign key 外键名

- 删除主键

    
    alter table 表名 drop primary key
    
- 删除唯一键名(unique),删除索引 


    alter table 表名 drop index 唯一键名
    
- 视图


    create view v_stu as 查询语句
    
- 设置变量


    set @变量名 := 10


    
