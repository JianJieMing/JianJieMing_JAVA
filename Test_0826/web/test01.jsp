<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/27
  Time: 上午8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    application.setAttribute("key", "application");
    session.setAttribute("key", "session");
    request.setAttribute("key", "request");
    pageContext.setAttribute("key", "pageContext");
%>

全域查找 优先去找作用域小的内容
<%--${key} <br>--%>
${key} <br>
${key} <br>
${key} <br>

</body>
</html>
