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
    <script language="javascript" type="text/javascript">
        //保存结果的提示
        function showResult() {
            showResultDiv(true);
            window.setTimeout("showResultDiv(false);", 3000);
        }

        function showResultDiv(flag) {
            var divResult = document.getElementById("save_result_info");
            if (flag)
                divResult.style.display = "block";
            else
                divResult.style.display = "none";
        }

        //切换资费类型
        function feeTypeChange(type) {
            var inputArray = document.getElementById("main").getElementsByTagName("input");
            if (type == 1) {
                inputArray[5].readOnly = true;
                inputArray[5].value = "";
                inputArray[5].className += " readonly";
                inputArray[6].readOnly = false;
                inputArray[6].className = "width100";
                inputArray[7].readOnly = true;
                inputArray[7].className += " readonly";
                inputArray[7].value = "";
            }
            else if (type == 2) {
                inputArray[5].readOnly = false;
                inputArray[5].className = "width100";
                inputArray[6].readOnly = false;
                inputArray[6].className = "width100";
                inputArray[7].readOnly = false;
                inputArray[7].className = "width100";
            }
            else if (type == 3) {
                inputArray[5].readOnly = true;
                inputArray[5].value = "";
                inputArray[5].className += " readonly";
                inputArray[6].readOnly = true;
                inputArray[6].value = "";
                inputArray[6].className += " readonly";
                inputArray[7].readOnly = false;
                inputArray[7].className = "width100";
            }
        }
    </script>
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
    <div id="save_result_info" class="save_success">保存成功！</div>
    <form action="/cost/updateAll?costId=${cost.costId}" method="post" class="main_form">
        <div class="text_info clearfix"><span>资费ID：</span></div>
        <div class="input_info"><input type="text" name="costId" class="readonly" readonly value="${cost.costId}"/>
        </div>
        <div class="text_info clearfix"><span>资费名称：</span></div>
        <div class="input_info">
            <input type="text" class="width300" name="name" value="${cost.name}"/>
            <span class="required">*</span>
            <div class="validate_msg_short">50长度的字母、数字、汉字和下划线的组合</div>
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
                <input type="radio" name="costType" id="package" value="2"
                       onclick="feeTypeChange(2);"/>
                <label for="package">套餐</label>
                <input type="radio" name="costType" id="timeBased" value="3" checked="checked" onclick="feeTypeChange(3);"/>
                <label for="timeBased">计时</label>
                </c:if>
        </div>
        <div class="text_info clearfix"><span>基本时长：</span></div>
        <div class="input_info">
            <input type="text" name="baseDuration" value="${cost.baseDuration}" class="width100"/>
            <span class="info">小时</span>
            <span class="required">*</span>
            <div class="validate_msg_long">1-600之间的整数</div>
        </div>
        <div class="text_info clearfix"><span>基本费用：</span></div>
        <div class="input_info">
            <input type="text" name="baseCost" value="${cost.baseCost}" class="width100"/>
            <span class="info">元</span>
            <span class="required">*</span>
            <div class="validate_msg_long">0-99999.99之间的数值</div>
        </div>
        <div class="text_info clearfix"><span>单位费用：</span></div>
        <div class="input_info">
            <input type="text" name="unitCost" value="${cost.unitCost}" class="width100"/>
            <span class="info">元/小时</span>
            <span class="required">*</span>
            <div class="validate_msg_long">0-99999.99之间的数值</div>
        </div>
        <div class="text_info clearfix"><span>资费说明：</span></div>
        <div class="input_info_high">
                    <textarea name="descr" class="width300 height70">${cost.descr}
                    </textarea>
            <div class="validate_msg_short">100长度的字母、数字、汉字和下划线的组合</div>
        </div>
        <div class="button_info clearfix">
            <input type="submit" value="保存" class="btn_save" onclick="showResult();"/>
            <input type="button" value="取消" class="btn_save" onclick="location.href='<%=request.getContextPath()%>/cost/findByPage'"/>
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
