##String

#### String类相关

String 我们叫它,字符串常量,是专门用来处理文本信息的.

所有的双引号,都是字符串.字符串是通过封装char得到的.

* 常用方法事例:

String test = "座右铭:Aa21静坐常思己过,闲谈莫论人非.Ss1, 静坐常思己过,闲谈莫论人非.哈4哈3哈";

1. 获取字符串的长度:

    int length = test.length();
    
2. 字符串是否是以XXX开头:

    boolean a = test.startsWith("Aa")
    
3. 获取字符串中的第几个字符:

    char c = test.charAt(0);
    
4. 字符串全部转换为大写:

    String a1 = test.toUpperCase();

5. 字符串全部转换为小写:

    String a2 = test.toLowerCase();
    
6. 判断字符串中是否包含一个字符串:

    boolean isContains = test.contains("莫");
    
7. 获取某个字符在字符串中第一次出现的位置:

    int index = test.indexOf("思");
    
8. 查询第二个字符在字符中出现的位置.(查询思,从下标6开始查.)

    int index2 = test.indexOf("思",6);
    
9. 查字符串中某个子串的位置:(输出的是子串中的第一个元素的下标.)

    int index3 = test.indexOf("座右铭");
    
10. 判断字符串是以XXX结束:

    boolean isEndWith = test.endsWith("人非.");
    
11. 检索某一个字符,在字符串中最后出现的位置.

    String s = test.lastIndexOf("非");
    
12. 将字符串中的某个字符都替换为新的字符:

    String a = str2.replace('哈', '呵');
    
13. 把满足正则表达式的字符串都替换为某个字符串:

    将字符串中的所有数字,转换为AB.

    String s2 = str2.replaceAll("\\d", "AB");
    
14. 判断字符串是否为空:

    String b1; // 只声明了,没有值,不能用.
    
    String b2 = null; // 空指针异常.
    
    String b3 = ""; // true.
    
    String b4 = " "; // false.
    
    boolean b5 = test.isEmpty();
    
15. 字符串的截取:(包含第一个字符,不包含最后一个字符.)

    String d = test.substring(0,8);
    
16. 去掉字符串的首尾所有空格:

    String trim = test.trim();
    
17. 把字符串转换为字节数组:

    byte[] bytes = test.getBytes();
    
18. 把字符串转换为字符数组:

    char[] chars = test.toCharArray();
    
19. 根据正则表达式把字符串分割为字符串的数组:

    String[] strings = test.split("\\非");
    
    System.out.println(Arrays.toString(strings));
    
20. 判断两个字符串是否一样

    boolean isEquals = test.equals("哈哈哈");
    
21. 忽略大小写判断两个字符串是否一样.(比如判断验证码)

    String q1 = "HELLO";
    
    String q2 = "hello";
    
    boolean q3 = q2.equalsIgnoreCase(q1);
    
* 查询时,如果没有结果就会输出-1.

* 所有的替换操作,原字符串对象没有变化,该方法会返回一个新的字符串对象.
