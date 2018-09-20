<%@ page language="java" pageEncoding="UTF-8" %>
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
    <style type="text/css">
        * {
            font-size: 11pt;
        }

        div {
            border: solid 2px rgb(78, 78, 78);
            width: 75px;
            height: 75px;
            text-align: center;
        }

        li {
            margin: 10px;
        }
    </style>
</head>

<body style="background: rgb(254,238,189);">
<h1>我的订单</h1>

<table border="1" width="100%" cellspacing="0" background="black">

    <c:forEach items="${orders}" var="orders">
    <tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
        <td colspan="6">
            订单：${orders.oid}
            成交时间：${orders.ordertime}　
            金额：<font color="red"><b>${orders.allprice}</b></font>

            <c:if test="${orders.state==1}">
                订单状态: 未付款
            </c:if>
            <c:if test="${orders.state==2}">
                订单状态: 已付款
            </c:if>
            <c:if test="${orders.state==3}">
                订单状态: 付款未发货
            </c:if>
            <c:if test="${orders.state==4}">
                订单状态: 已发货(订单完成)
            </c:if>
        </td>
    </tr>


    <c:forEach items="${orders.orderItems}" var="item">
           <c:if test="${item.book!=null}">
    <tr bordercolor="rgb(78,78,78)" align="center">
        <td width="15%">
            <div><img src="${item.book.image}" height="75"/></div>
        </td>
        <td>书名：${item.book.bname}
        </td>
        <td>单价：${item.book.price}
        </td>
        <td>作者：${item.book.author}
        </td>
        <td>数量：${item.count}
        </td>
        <td>小计：${item.subtotal}
        </td>
    </tr>
        </c:if>
        <c:if test="${item.book==null}">
        <tr bordercolor="rgb(78,78,78)" align="center">
            <td width="15%">
                <div><img src="${pageContext.request.contextPath}/book_img/4ae8cd9e-1691-4610-969e-03bd1a9d5e2e.png" height="75"/></div>
            </td>
            <td>书名：已删除
            </td>
            <td>单价：0.0
            </td>
            <td>作者：暂无
            </td>
            <td>数量：0
            </td>
            <td>小计：0.0
            </td>
        </tr>
        </c:if>
    </c:forEach>
    </c:forEach>
</body>
</html>
