<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="book.bean.BookBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>图书列表</title>

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
        body {
            font-size: 10pt;
        }

        .icon {
            margin: 10px;
            border: solid 2px gray;
            width: 160px;
            height: 180px;
            text-align: center;
            float: left;
        }
    </style>
</head>

<body>

<%
    List<BookBean> bookBeans = (List<BookBean>) request.getAttribute("bookBeans");
    for (BookBean bookBean : bookBeans) {
%>
<div class="icon">
    <a href="/bookMessage?bid=<%=bookBean.getBid()%>"><img style="width: 109px;height: 150px" src="<%=bookBean.getImage()%>" border="0"/></a>
    <br>
    <a href="/bookMessage?bid=<%=bookBean.getBid()%>"><%=bookBean.getBname()%>
    </a>
</div>
<%}%>

</body>
</html>

