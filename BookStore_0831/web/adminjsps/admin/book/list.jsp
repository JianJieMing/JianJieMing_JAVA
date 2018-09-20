<%@ page language="java" import="book.domain.Book" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>图书分类</title>

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
            background: rgb(254, 238, 189);
        }

        .icon {
            margin: 10px;
            border: solid 2px gray;
            width: 160px;
            height: 190px;
            text-align: center;
            float: left;
        }
    </style>
</head>

<body>
         <%List<Book> books = (List<Book>) request.getAttribute("books");
             for (Book book : books) {
         %>
<div class="icon">
    <a href="${pageContext.request.contextPath}/findAll.do?method=findOne&bid=<%=book.getBid()%>">
        <img style="width: 109px;height: 150px" src="<c:url value="<%=book.getImage()%>"/>"
             border="0"/></a>
    <br/>
    <a href="${pageContext.request.contextPath}/findAll.do?method=findOne&bid=<%=book.getBid()%>">
        <%=book.getBname()%></a>
</div>
<%
    }
%>

</body>
</html>

