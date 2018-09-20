<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/28
  Time: 下午3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录结果</title>
</head>
<body>
<%
    /*
        内置对象:
            request
            response
            ServletContext application
            session
            out
            config
            page == this
            pageContext
            exception
     */

    String contextPath = request.getContextPath();
    String servletPath = request.getServletPath();

    // 项目的路径.
    out.println("contextPath: " + contextPath);
    out.println("<br>");
    out.println("servletPath: " + servletPath);

%>
<h1><%=request.getAttribute("msg")%>
</h1>
</body>
</html>
