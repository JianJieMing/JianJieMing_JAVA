<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 9:48
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
<body class="index">
<!--导航区域开始-->
<div id="index_navi">
    <c:import url="showModule.jsp"/>
</div>


</body>
</html>
