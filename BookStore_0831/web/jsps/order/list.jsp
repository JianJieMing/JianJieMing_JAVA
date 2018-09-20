<%@ page language="java" import="orders.bean.OrderItem" pageEncoding="UTF-8" %>
<%@ page import="orders.bean.OrdersBean" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>订单列表</title>

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
            border: solid 2px gray;
            width: 75px;
            height: 75px;
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
<h1>我的订单</h1>

<%
    List<OrdersBean> orders = (List<OrdersBean>) request.getAttribute("orders");
    for (OrdersBean order : orders) {

%>
<table border="1" width="100%" cellspacing="0" background="black">

    <tr bgcolor="gray" bordercolor="gray">
        <td colspan="6">
            订单编号：<%=order.getOid()%>　成交时间：<%=order.getOrdertime()%>　金额：<font color="red"><b><%=order.getAllprice()%>
        </b></font>　

            <a href="<c:url value='/jsps/order/kefu.jsp'/>">联系客服</a>
            <%
                if (order.getState() == 1) {
            %>
            等待发货
            <%
            } else if (order.getState() == 4) {
            %>
            订单已完成
            <%
                }
            %>
            <a href="/updateOrders?oid=<%=order.getOid()%>">确认收货</a>
        </td>
    </tr>


    <%
        List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem orderItem : orderItems) {

    %>

    <tr bordercolor="gray" align="center">
        <td width="15%">
            <div><img src="<%=orderItem.getBook().getImage()%>" height="75"/></div>
        </td>
        <td>书名：<%=orderItem.getBook().getBname()%>
        </td>
        <td>单价：<%=orderItem.getBook().getPrice()%>
        </td>
        <td>作者：<%=orderItem.getBook().getAuthor()%>
        </td>
        <td>数量：<%=orderItem.getCount()%>
        </td>
        <td>小计：<%=orderItem.getSubtotal()%>
        </td>
    </tr>

    <%
        }
    %>

</table>
<%
    }
%>
</body>
</html>