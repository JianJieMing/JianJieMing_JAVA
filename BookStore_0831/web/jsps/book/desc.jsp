<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="book.bean.BookBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>图书详细</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>


    <style type="text/css">
        body {
            font-size: 10pt;
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

        a {
            background: url(<c:url value='/images/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -70px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }
        a:HOVER {
            background: url(<c:url value='/images/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -106px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }
    </style>
</head>

<body>

<%
    List<BookBean> bookMessage = (List<BookBean>) request.getAttribute("bookMessage");
    for (BookBean bookBean : bookMessage) {
%>
<div>
    <img style="width: 109px;height: 150px" src="<%=bookBean.getImage()%>" border="0"/>
</div>
<ul>
    <li>书名:&emsp;<%=bookBean.getBname()%></li>
    <li>作者:&emsp;<%=bookBean.getAuthor()%></li>
    <li>单价:&emsp;<%=bookBean.getPrice()%></li>
</ul>

<form id="form" action="cart?bid=<%=bookBean.getBid()%>&price=<%=bookBean.getPrice()%>" method="post">
    <input type="text" size="3" name="count" value="1"
           onkeyup="value=(parseInt((value=value.replace(/\D/g,''))==''||parseInt((value=value.replace(/\D/g,''))==0)?'1':value,10))"/>
</form>
<a href="javascript:document.getElementById('form').submit();"></a>
<%
    }
%>

</body>
</html>
