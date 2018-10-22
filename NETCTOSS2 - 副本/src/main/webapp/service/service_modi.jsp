<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/16
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <script src="../js/jquery-3.2.1.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>
    <script language="javascript" type="text/javascript">
        //保存成功的提示信息
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
    <ul id="menu">
        <li><a href="<%=request.getContextPath()%>/admin/showModule" class="index_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/role/role_list" class="role_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/admin/admin_list" class="admin_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/cost/findAll" class="fee_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/account/findAll" class="account_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/service/service_list" class="service_on"></a></li>
        <li><a href="../bill/bill_list.jsp" class="bill_off"></a></li>
        <li><a href="../report/report_list.jsp" class="report_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/informationcontroller/selectAll" class="information_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/user/user_modi_pwd.jsp" class="password_off"></a></li>
    </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <!--保存操作的提示信息-->
    <form action="" method="" class="main_form">
        <!--必填项-->
        <div class="text_info clearfix"><span>业务账号ID：</span></div>
        <div class="input_info">
            <input id="serviceId" type="text" value="" readonly class="readonly"/>
        </div>
        <div class="text_info clearfix"><span>OS 账号：</span></div>
        <div class="input_info">
            <input id="osUsername" type="text" value="" readonly class="readonly"/>
        </div>
        <div class="text_info clearfix"><span>服务器 IP：</span></div>
        <div class="input_info">
            <input id="unixHost" type="text" value="" readonly class="readonly"/>
        </div>
        <div class="text_info clearfix"><span>资费类型：</span></div>
        <div class="input_info">
            <select id="costName" class="width150">

            </select>
            <div class="validate_msg_long">请修改资费类型，或者取消修改操作。</div>
        </div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input id="btn1" type="button" value="保存" class="btn_save" onclick="showResult();"/>
            <input type="button" value="取消" class="btn_save"/>
        </div>


        <p>业务说明：<br/>
            1、修改资费后，点击保存，并未真正修改数据库中的数据；<br/>
            2、提交操作到消息队列；<br/>
            3、每月月底由程序自动完成业务所关联的资费；</p>

    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
    <br/>
    <span>版权所有(C)云科技有限公司 </span>
</div>

<script>
    var urlParm = decodeURI(window.location.href.split("?")[1]);
    serviceId1 = urlParm.split("&")[0];
    serviceId = serviceId1.split("serviceId=")[1];
    osUsername1 = urlParm.split("&")[1];
    osUsername = osUsername1.split("osUsername=")[1];
    unixHost1 = urlParm.split("&")[2];
    unixHost = unixHost1.split("unixHost=")[1];

    $(function () {

        var serviceId2 = $('#serviceId');
        var osUsername2 = $('#osUsername');
        var unixHost2 = $('#unixHost');
        serviceId2.val(serviceId);
        osUsername2.val(osUsername);
        unixHost2.val(unixHost);

        $.ajax({
            typ: "GET",
            url: "queryCostName",
            dataType: "json",
            success: function (resp) {
                var costNames = $('#costName');
                for (var item of resp) {
                    var costName = $('<option></option>').text(item.name).val(item.costId);
                    costNames.append(costName);
                }
            }
        });

        $('#btn1').click(function () {
            var costId = $('#costName').val();
            var data = {
                "serviceId": serviceId,
                "costId": costId
            };
            var setting = {
                url: "updateServiceCostId",
                method: "post",
                headers: {
                    "Content-Type": "application/json"
                },
                data: JSON.stringify(data)
            };
            $.ajax(setting);
        })

    })

</script>

</body>
</html>
