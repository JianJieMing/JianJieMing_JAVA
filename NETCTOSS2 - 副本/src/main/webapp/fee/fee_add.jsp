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
    <script src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
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
                inputArray[4].readOnly = true;
                inputArray[4].value = "";
                inputArray[4].className += " readonly";
                inputArray[5].readOnly = false;
                inputArray[5].className = "width100";
                inputArray[6].readOnly = true;
                inputArray[6].className += " readonly";
                inputArray[6].value = "";
            }
            else if (type == 2) {
                inputArray[4].readOnly = false;
                inputArray[4].className = "width100";
                inputArray[5].readOnly = false;
                inputArray[5].className = "width100";
                inputArray[6].readOnly = false;
                inputArray[6].className = "width100";
            }
            else if (type == 3) {
                inputArray[4].readOnly = true;
                inputArray[4].value = "";
                inputArray[4].className += " readonly";
                inputArray[5].readOnly = true;
                inputArray[5].value = "";
                inputArray[5].className += " readonly";
                inputArray[6].readOnly = false;
                inputArray[6].className = "width100";
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
    <div id="save_result_info" class="save_fail">保存失败，资费名称重复！</div>
    <form action="/cost/add" method="post" id="addFrom" class="main_form">
        <div class="text_info clearfix"><span>资费名称：</span></div>
        <div class="input_info">
            <input id="inp1" type="text" name="name" class="width300" value=""/>
            <span class="required">*</span>
            <div class="validate_msg_short">
                <span id="span1" style="display: none;color: red">5长度的字母、数字、汉字和下划线的组合</span>
            </div>
        </div>
        <div class="text_info clearfix"><span>资费类型：</span></div>
        <div class="input_info fee_type">
            <input type="radio" name="costType" id="monthly" value="1" onclick="feeTypeChange(1);"/>
            <label for="monthly">包月</label>
            <input type="radio" name="costType" checked="checked" value="2" id="package" onclick="feeTypeChange(2);"/>
            <label for="package">套餐</label>
            <input type="radio" name="costType" id="timeBased" value="3" onclick="feeTypeChange(3);"/>
            <label for="timeBased">计时</label>
        </div>
        <div class="text_info clearfix"><span>基本时长：</span></div>
        <div class="input_info">
            <input id="inp2" type="text" name="baseDuration" value="" class="width100"/>
            <span class="info">小时</span>
            <span class="required">*</span>
            <div class="validate_msg_long">
                <span id="span2" style="display: none;color: red;">1-600之间的整数</span>
            </div>
        </div>
        <div class="text_info clearfix"><span>基本费用：</span></div>
        <div class="input_info">
            <input id="inp3" type="text" name="baseCost" value="" class="width100"/>
            <span class="info">元</span>
            <span class="required">*</span>
            <div class="validate_msg_long error_msg">
                <span id="span3" style="display: none;color:red;">0-99999.99之间的数值</span>
            </div>
        </div>
        <div class="text_info clearfix"><span>单位费用：</span></div>
        <div class="input_info">
            <input id="inp4" type="text" name="unitCost" value="" class="width100"/>
            <span class="info">元/小时</span>
            <span class="required">*</span>
            <div class="validate_msg_long error_msg">
                <span id="span4" style="display: none;color: red">0-99999.99之间的数值</span>
            </div>
        </div>
        <div class="text_info clearfix"><span>资费说明：</span></div>
        <div class="input_info_high">
            <textarea id="inp5" name="descr" class="width300 height70"></textarea>
            <div class="validate_msg_short error_msg">
                <span id="span5" style="display: none;color: red;">10长度的字母、数字、汉字和下划线的组合</span>
            </div>
        </div>
        <div class="button_info clearfix">
            <input type="submit" value="保存" class="btn_save" id="add"/>
            <input type="button" value="取消" class="btn_save"
                   onclick="location.href='<%=request.getContextPath()%>/cost/findByPage'"/>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
    <br/>
    <span>版权所有(C)云科技有限公司 </span>
</div>
<script>
    $(function () {

        $('#inp1').blur(function () {
            var r1 = /^[a-zA-Z0-9u4E00-u9FA5_]{5}/;
            var inp1 = $('#inp1').val();
            if (!r1.test(inp1)) {
                $('#span1').css("display", 'inline')
            }
            if (r1.test(inp1)) {
                $('#span1').css("display", 'none')
            }
        });
        $('#inp2').blur(function () {
            var r2 = /^([1-5]\d{0,2}|600)$/;
            var inp2 = $('#inp2').val();
            if (!r2.test(inp2)) {
                $('#span2').css("display", 'inline')
            }
            if (r2.test(inp2)) {
                $('#span2').css("display", 'none')
            }
        });
        $('#inp3').blur(function () {
            var r3 = /^\d{1,5}(\.\d{1,2})?$/;
            var inp3 = $('#inp3').val();
            if (!r3.test(inp3)) {
                $('#span3').css("display", 'inline')
            }
            if (r3.test(inp3)) {
                $('#span3').css("display", 'none')
            }
        });

        $('#inp4').blur(function () {
            var r4 = /^\d{1,5}(\.\d{1,2})?$/;
            var inp4 = $('#inp4').val();
            if (!r4.test(inp4)) {
                $('#span4').css("display", 'inline')
            }
            if (r4.test(inp4)) {
                $('#span4').css("display", 'none')
            }
        });
        $('#inp5').blur(function () {
            var r5 = /^[a-zA-Z0-9u4E00-u9FA5_]{10}/;
            var inp5 = $('#inp5').val();
            if (!r5.test(inp5)) {
                $('#span5').css("display", 'inline')
            }
            if (r5.test(inp5)) {
                $('#span5').css("display", 'none')
            }
        })
    })
</script>

</body>
</html>


