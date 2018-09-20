<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/26
  Time: 上午11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    Date date = new Date(System.currentTimeMillis());
//    out.print(date);

    Cookie cookie = new Cookie("last", date.toString());
    cookie.setMaxAge(-1);
    response.addCookie(cookie);

    if (session.isNew()) {
        out.print("欢迎登录");
    } else {
        out.print("你是老司机");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie1 : cookies) {
            if (cookie1.getName().equals("last")) {
                out.print(cookie1.getValue());
            }
        }
    }


%>


</body>
</html>
