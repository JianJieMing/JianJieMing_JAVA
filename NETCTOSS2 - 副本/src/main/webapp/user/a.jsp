<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/19
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-3.2.1.js"></script>
    <script src="../js/jquery.validate.js"></script>
    <script src="../js/messages_zh.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>
<style>
    .error {
        color: #ff0214;
    }
</style>

</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <img src="../images/logo.png" alt="logo" class="left"/>
    <a href="/login.html">[退出]</a>
</div>
<div id="navi">
    <ul id="menu">
        <li><a href="<%=request.getContextPath()%>/admin/showModule" class="index_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/role/role_list" class="role_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/admin/admin_list" class="admin_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/cost/findAll" class="fee_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/account/findAll" class="account_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/service/service_list" class="service_off"></a></li>
        <li><a href="../bill/bill_list.jsp" class="bill_off"></a></li>
        <li><a href="../report/report_list.jsp" class="report_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/informationcontroller/selectAll" class="information_on"></a></li>
        <li><a href="<%=request.getContextPath()%>/user/user_modi_pwd.jsp" class="password_off"></a></li>
    </ul>
</div>
<center>
<h1 text-align:center>保存成功!</h1>
    <a href="<%=request.getContextPath()%>/informationcontroller/selectAll">点击跳转</a>
</center>
<div id="footer">
    <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
    <p>版权所有(C)云科技有限公司</p>

</div>
</body>
</html>
