<%@ page language="java" import="cart.bean.CartBookBean" pageEncoding="UTF-8" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.UUID" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>购物车列表</title>

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
            font-size: 11pt;
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

        #buy {
            background: url(<c:url value='/images/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -902px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }

        #buy:HOVER {
            background: url(<c:url value='/images/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -938px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }
    </style>
</head>

<body>
<h1>购物车</h1>

<table id="table" border="1" width="100%" cellspacing="0" background="black">
    <tr>
        <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
            <a href="/emptyCart?uid=1">清空购物车</a>
        </td>
    </tr>
    <tr>
        <th>图片</th>
        <th>书名</th>
        <th>作者</th>
        <th>单价</th>
        <th>数量</th>
        <th>小计</th>
        <th>操作</th>
    </tr>

    <%
        List<CartBookBean> bookList = (List<CartBookBean>) request.getAttribute("bookList");
        for (CartBookBean cartBookBean : bookList) {
    %>

    <tr>
        <td>
            <div><img style="width: 109px;height: 150px" src="<%=cartBookBean.getImage()%>"></div>
        </td>
        <td><%=cartBookBean.getBname()%></td>
        <td><%=cartBookBean.getAuthor()%></td>
        <td><%=cartBookBean.getPrice()%></td>
        <td><%=cartBookBean.getCartCount()%></td>
        <%
            float price = Float.parseFloat(cartBookBean.getPrice());
            int cartCount = cartBookBean.getCartCount();
            float s = price * cartCount;
            int bid = cartBookBean.getBid();
        %>
        <td><%=s%></td>
        <td><a href="/cartDelete?delBid=<%=cartBookBean.getBid()%>"><input type="button" class="btn btn-primary" value="删除"></a></td>
    </tr>
    <%
        }
    %>
    <tr>
        <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
            <%=session.getAttribute("allPrice")%>
        </td>
    </tr>
    <tr>
        <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
            <a id="buy" href="/jsps/order/desc.jsp?allPrice=<%=session.getAttribute("allPrice")%>"></a>
        </td>
    </tr>
</table>

</body>
</html>
