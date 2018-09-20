## SQL

#### 数据类型

    数据类型[(M)],[]的部分代表可以不写.
    
#### 一. 数值

    0. BIT[(M)] M 表示最大的`位`数,1~64.
    1. TINYINT 相当于java中的byte,8位,1字节.
    2. SMALLINT short 2字节.
    3. MEDIUMINT 3字节.
    4. INT[(M)] [UNSIGNED] [ZEROFILL] `or` INTEGER java中的int,4字节.
       M 的意义与BIT的时候不一样,只是决定显示的长度,不指定数的范围.
       UNSIGNED 代表无符号,该列的数据只能是0或者正数.
       ZEROFILL 如果插入的数据长度小于M,那么其他位置都会用0填充.
       如果指定了ZEROFILL,那么会自动加上UNSIGNED.
    5. BIGINT long 8字节.
    6. BOOL `or` BOOLEAN.
       在MySQL中 true就等于1,false就等于0.
       但是如果把一个值放入到if函数中,除了0就都是true.
    7. FLOAT
    8. DOUBLE
    9. DECIMAL[(M[,D])] `or` DEC[(M[,D])], M 总位数, D 小数位.
       字符串存储的小数.
       
#### 二. 字符串

    1. CHAR[(M)], 0~255,后面的空格不会被保留.
    2. VARCHAR[(M)], 0~65535,后面空格会被保留.
    3. BINARY, 0~255,补默认字符.
    4. VARBINARY
    5. TINYTEXT, TEXT, MEDIUMTEXT, LONGTEXT
    6. TYNYBLOB, BLOB, MEDIOMBLOB, LONGBLOB
    
#### 三. 时间

    1. DATE 存年月日
    2. DATATIME 存年月日时分秒
    3. TIMESTAMP 时间戳(毫秒数)
    4. TIME 时间
    5. YEAR 年
    
#### 插入数据

    insert into `表名` value (`值1`,`值2`,...);
     
    insert into `表名` values (`值1`,...),(`值2`,...),...;
     
    insert into `表名` (`列1`,`列2`,...) value (`值1`,`值2`,...);
     
    insert into `表名` (`列1`,`列2`,...) values (`值1`,`值2`,...),(`值1`,`值2`,...);
    
#### 删除数据

    delect from `表名` where `条件`;
     
    delect from `表名`; # 清空表中的数据.
    
    与: 用 and 表示.
        
    或: 用 or 表示.
        
    某个数据在某个集合中: in
    delete from goods where id in (2,4,5);
        
#### 更新语法

    update table `表名` set `列1`,`列2` = `值n` where `条件`;
    
#### 外键总结

    1. 什么是外键:
        在物理上表示表与表之间的关联关系的一个桥梁.
        
    2. 什么是父表和子表:
        设置外键的表就是子表,关联的表就是父表.
        
    3. 可以设置外键的前提:
        1. 数据库引擎是InnoDB的.
        2. 子表的外键列与父表的主键列数据类型统一.
        3. 当前表中的数据是符合外键的关联关系的.
     
    4. 设置外键sql语句:
        本质上是在修改一张表.
        外键名字的规范: 源表_目标表_列_fk
        alter table `表名` add
        [constraint `外键名字`]
        foreign key ('需要添加外键的列')
        references '需要关联的表'(`关联的列`);
         
    5. 外键约束:
        是修改或删除父表的某条数据时,对子表产生的不同影响.
        在设置外键的时候,可以分别对删除和更新设置不同的约束方式.
       约束方式:
        restrict 限制 不允许删除或更新父表数据(外键关联的那一列).
        cascade 级联 删除或更新父表数据时,子表同步更改.
        set null 置空 删除或更新父表数据时,子表外键列的值会置空(null).
        使用set null的前提是: 子表的外键列是可以为null的.
       
       设置外键约束的语法:
        on delete '约束形式1'
        on update '约束形式2'
         
       比较常用的形式为: on delete set null on update cascade
        
    6. 删除外键:
        外键不可更改
        alter table '表名' drop foreign key '外键名字';
        
#### 存储过程


    动词 数据库对象
    存储过程 procedure
     
    create procedure query_stu()
    如果存储过程里面只有一行语句
    那么begin和end可以省略
    begin 代表定义了存储过程起始位置
    select * from Student;
    end 标记存储过程结束的位置
    $$
    删除存储过程
    drop procedure query_stu;
        
    新定义存储过程,用来向学生表添加一条数据.
    格式: in 变量名 数据类型
    in 表示该变量是调用存储过程时,需要传入的变量,
    可以传递具体的值,也可以传递变量.
        
    out 表示存储过程执行完毕之后,要来获取处理的结果,
    在调用该过程的时候,该参数只能填写变量,
    进入存储过程中,会把该变量置空.
        
    inout 相当于结合了in和out,
    可以向过程中传递值,
    过程执行完毕后,也可以修改该变量的值,
    只能传递变量,不能传递具体的值.
        
    delimiter $$
    create procedure insert_stu(
        in SID int,
        in name varchar(200),
        in birthday date,
        in gender varchar(20),
        out qty int
    )
    begin
    select qty;
    insert into Student (SID,Sname,Sage,Ssex) 
    value
    (SID,name,birthday,gender);
    set qty = (select row_count());
    end $$
    delimiter ;
    
    数据库对象:
    表    视图    存储过程
    
        
        
        