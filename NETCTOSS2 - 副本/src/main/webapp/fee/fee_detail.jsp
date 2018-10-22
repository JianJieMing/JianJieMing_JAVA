<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/9
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <img src="../images/logo.png" alt="logo" class="left"/>
    <a href="/login.html">[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
    <c:import url="../showModule.jsp"/>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="" method="" class="main_form">
        <div class="text_info clearfix"><span>资费ID：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${cost.costId}"/></div>
        <div class="text_info clearfix"><span>资费名称：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${cost.name}"/></div>
        <div class="text_info clearfix"><span>资费状态：</span></div>
        <div class="input_info">
            <select class="select_search">
                <c:if test="${cost.status ==0 }">
                    <option>暂停</option>
                </c:if>
                <c:if test="${cost.status ==1 }">
                    <option>开通</option>
                </c:if>
            </select>
        </div>
        <div class="text_info clearfix"><span>资费类型：</span></div>
        <div class="input_info fee_type">
            <c:if test="${cost.costType == null}">
                <input type="radio" name="costType" id="monthly" value="1" onclick="feeTypeChange(1);"/>
                <label for="monthly">包月</label>
                <input type="radio" name="costType" id="package" value="2" onclick="feeTypeChange(2);"/>
                <label for="package">套餐</label>
                <input type="radio" name="costType" id="timeBased" value="3" onclick="feeTypeChange(3);"/>
                <label for="timeBased">计时</label>
            </c:if>
            <c:if test="${cost.costType == 1}">
                <input type="radio" name="costType" id="monthly" value="1" checked="checked"
                       onclick="feeTypeChange(1);"/>
                <label for="monthly">包月</label>
                <input type="radio" name="costType" id="package" value="2" onclick="feeTypeChange(2);"/>
                <label for="package">套餐</label>
                <input type="radio" name="costType" id="timeBased" value="3" onclick="feeTypeChange(3);"/>
                <label for="timeBased">计时</label>
            </c:if>
            <c:if test="${cost.costType == 2}">
                <input type="radio" name="costType" id="monthly" value="1" onclick="feeTypeChange(1);"/>
                <label for="monthly">包月</label>
                <input type="radio" name="costType" id="package" value="2" checked="checked"
                       onclick="feeTypeChange(2);"/>
                <label for="package">套餐</label>
                <input type="radio" name="costType" id="timeBased" value="3" onclick="feeTypeChange(3);"/>
                <label for="timeBased">计时</label>
            </c:if>
            <c:if test="${cost.costType == 3}">
                <input type="radio" name="costType" id="monthly" value="1" onclick="feeTypeChange(1);"/>
                <label for="monthly">包月</label>
                <input type="radio" name="costType" id="package" value="2" onclick="feeTypeChange(2);"/>
                <label for="package">套餐</label>
                <input type="radio" name="costType" id="timeBased" value="3" checked="checked"
                       onclick="feeTypeChange(3);"/>
                <label for="timeBased">计时</label>
            </c:if>
        </div>
        <div class="text_info clearfix"><span>基本时长：</span></div>
        <div class="input_info">
            <input type="text" class="readonly" readonly value="${cost.baseDuration}"/>
            <span>小时</span>
        </div>
        <div class="text_info clearfix"><span>基本费用：</span></div>
        <div class="input_info">
            <input type="text" class="readonly" readonly value="${cost.baseCost}"/>
            <span>元</span>
        </div>
        <div class="text_info clearfix"><span>单位费用：</span></div>
        <div class="input_info">
            <input type="text" class="readonly" readonly value="${cost.unitCost}"/>
            <span>元/小时</span>
        </div>
        <div class="text_info clearfix"><span>创建时间：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${cost.creatime}"/></div>
        <div class="text_info clearfix"><span>启动时间：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${cost.startime}"/></div>
        <div class="text_info clearfix"><span>资费说明：</span></div>
        <div class="input_info_high">
            <textarea class="width300 height70 readonly" readonly>${cost.descr}</textarea>
        </div>
        <div class="button_info clearfix">
            <a href="<%=request.getContextPath()%>/cost/findByPage"><input type="button" value="返回" class="btn_save"/></a>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
    <br/>
    <span>版权所有(C)云科技有限公司 </span>
</div>
</body>
</html>
