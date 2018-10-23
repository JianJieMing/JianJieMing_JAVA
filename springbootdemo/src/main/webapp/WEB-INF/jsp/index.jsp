<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/20
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>你已经成功访问到主页面!</h1>
<br>
<p>Get your greeting <a href="/greeting">here</a></p>
<form action="/upload" method="POST" enctype="multipart/form-data">
    文件：<input type="file" name="test"/>
    <input type="submit" />
</form>
<a href="/download">下载test</a>
<p>多文件上传</p>
<form method="POST" enctype="multipart/form-data" action="/uploads">
    <p>文件1：<input type="file" name="file" /></p>
    <p>文件2：<input type="file" name="file" /></p>
    <p><input type="submit" value="上传" /></p>
</form>
</body>
</html>
