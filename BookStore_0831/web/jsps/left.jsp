<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="admin.domain.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>left</title>
    <base target="body"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

    <style type="text/css">
        * {
            font-size: 10pt;
            text-align: center;
        }

        div {
            background: #87CEFA;
            margin: 3px;
            padding: 3px;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>

<body>
<div>
    <a href="<c:url value='/bookCategory?cid=all'/>">全部分类</a>
</div>

<div>
    <%
        List<Category> categories = (List<Category>) request.getAttribute("categories");
        for (Category category : categories) {
    %>
    <a href="/bookCategory?cid=<%=category.getCid()%>"><%=category.getCname()%></a><br>
    <%
        }
    %>
</div>
</body>
</html>
