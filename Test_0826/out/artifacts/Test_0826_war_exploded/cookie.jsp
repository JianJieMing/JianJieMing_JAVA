<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/26
  Time: 上午10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    Cookie cookie1 = new Cookie("cookie1", "data1");
    Cookie cookie2 = new Cookie("cookie2", "data2");
    Cookie cookie3 = new Cookie("cookie3", "data3");

    cookie1.setMaxAge(5);
    cookie2.setMaxAge(0);
    cookie3.setMaxAge(-1);

    response.addCookie(cookie1);
    response.addCookie(cookie2);
    response.addCookie(cookie3);

<%

    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("cookie1")) {
            out.println(cookie.getValue());
        } else if (cookie.getName().equals("cookie2")) {
            out.println(cookie.getValue());
        } else if (cookie.getName().equals("cookie3")) {
            out.println(cookie.getValue());
        }
    }
%>

</body>
</html>
