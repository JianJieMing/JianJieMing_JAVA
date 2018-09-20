<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/30
  Time: 上午10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    HttpSession session1 = request.getSession();
    session1.setAttribute("user", 1);
%>
</body>
</html>
