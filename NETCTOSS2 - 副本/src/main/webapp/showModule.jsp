<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>


<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-2.2.4.min.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global_color.css"/>
</head>


<body>
<ul id="menu">
    <li><a href="<%=request.getContextPath()%>/admin/showModule" class="index_off"></a></li>
    <c:set value="${adminInfoQxes.qx.split(',')}" var="ths"/>
    <c:forEach items="${ths}" var="list">
        <c:if test="${list == 1}">
            <li><a href="<%=request.getContextPath()%>/role/role_list" class="role_off"></a></li>
        </c:if>
        <c:if test="${list == 2}">
            <li><a href="<%=request.getContextPath()%>/admin/admin_list" class="admin_off"></a></li>
        </c:if>
        <c:if test="${list == 3}">
            <li><a href="<%=request.getContextPath()%>/cost/findByPage" class="fee_off"></a></li>
        </c:if>
        <c:if test="${list == 4}">
            <li><a href="<%=request.getContextPath()%>/account/findByPage" class="account_off"></a></li>
        </c:if>
        <c:if test="${list == 5}">
            <li><a href="<%=request.getContextPath()%>/service/service_list" class="service_off"></a></li>
        </c:if>
        <c:if test="${list == 6}">
            <li><a href="<%=request.getContextPath()%>/bill/bill_list.jsp" class="bill_off"></a></li>
        </c:if>
        <c:if test="${list == 7}">
            <li><a href="<%=request.getContextPath()%>/report/report_list.jsp" class="report_off"></a></li>
        </c:if>
    </c:forEach>
    <li><a href="<%=request.getContextPath()%>/informationcontroller/selectAll" class="information_off"></a></li>
    <li><a href="<%=request.getContextPath()%>/user/user_modi_pwd.jsp" class="password_off"></a></li>
</ul>
</body>
</html>
