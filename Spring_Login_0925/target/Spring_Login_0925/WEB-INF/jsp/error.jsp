<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  UserBean: Administrator
  Date: 2018/9/20
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${error}</h1>
<c:forEach var="error" items="${errors}">
    <h1>${error.defaultMessage}<br></h1>
</c:forEach>
<a href="test1">返回登录</a>
<a href="test2">返回注册</a>
</body>
</html>
