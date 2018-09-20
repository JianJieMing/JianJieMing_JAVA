<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/9/14
  Time: 上午9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${user.username}</h1>
<h1>我于杀戮之中绽放,犹如黎明中的花朵</h1>
<form action="/user/page.action">
    第 <input type="text" name="pagenum"> 页
    <input type="submit" value="go">
</form>
</body>
</html>
