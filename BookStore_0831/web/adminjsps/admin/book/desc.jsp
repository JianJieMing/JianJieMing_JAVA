<%@ page language="java" import="book.domain.Book" pageEncoding="UTF-8" %>
<%@ page import="category.domain.Category" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'bookdesc.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">

    <%--<script src="/js/jquery-3.2.1.js"></script>--%>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        body {
            font-size: 10pt;
            background: rgb(254, 238, 189);
        }

        div {
            margin: 20px;
            border: solid 2px gray;
            width: 150px;
            height: 150px;
            text-align: center;
        }

        li {
            margin: 10px;
        }
    </style>
</head>

<body>
<%
    Book book = (Book) request.getAttribute("book");
    List<Category> categories = (List<Category>) request.getAttribute("categories");
%>
<div>
    <img style="width: 109px;height: 150px" src="<%=request.getContextPath()%>/<%=book.getImage()%>" border="0"/>
</div>
<form style="margin:20px;" id="form" action="book?bid=<%=book.getBid()%>" method="post">
    图书名称：<input id="a" type="text" name="bname" value="<%=book.getBname()%>"><br/>
    图书单价：<input id="b" type="text" name="price" value=<%=book.getPrice()%>><br/>
    图书作者：<input id="c" type="text" name="author" value=<%=book.getAuthor()%>><br/>
    图书分类：<select id="d" style="width: 150px; height: 20px;" name="cid">
    <%
        for (Category category : categories) {
    %>
    <option value="<%=category.getCid()%>"><%=category.getCname()%></option>
    <%
        }
    %>
</select><br/>
    <input type="submit" name="method" value="del" onclick="return confirm('是否真要删除该图书？');"/>
    <input id="inp2" type="button" name="method" value="mod" />
</form>

<script>
    $(function () {
        $('#inp2').click(function () {
            var url = "/mod";
            let data = {
                bid: <%=book.getBid()%>,
                bname: encodeURI($('#a').val()),
                price: $('#b').val(),
                author: $('#c').val(),
                cid: $('#d').val(),
            };
            $.post(url, data);
        })
    })
</script>

</body>
</html>
