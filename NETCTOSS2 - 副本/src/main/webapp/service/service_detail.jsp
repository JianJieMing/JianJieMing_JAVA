<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/16
  Time: 16:16
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
    <form action="" method="" class="main_form">
        <!--必填项-->
        <div class="text_info clearfix"><span>业务账号ID：</span></div>
        <div class="input_info"><input id="serviceId" type="text" value="" readonly class="readonly"/></div>
        <div class="text_info clearfix"><span>账务账号ID：</span></div>
        <div class="input_info"><input id="accountId" type="text" value="" readonly class="readonly"/></div>
        <div class="text_info clearfix"><span>客户姓名：</span></div>
        <div class="input_info"><input id="realName" type="text" readonly class="readonly" value=""/>
        </div>
        <div class="text_info clearfix"><span>身份证号码：</span></div>
        <div class="input_info"><input id="idcardNo" type="text" readonly class="readonly" value=""/>
        </div>
        <div class="text_info clearfix"><span>服务器 IP：</span></div>
        <div class="input_info"><input id="unixHost" type="text" value="" readonly class="readonly"/></div>
        <div class="text_info clearfix"><span>OS 账号：</span></div>
        <div class="input_info"><input id="osUsername" type="text" value="" readonly class="readonly"/></div>
        <div class="text_info clearfix"><span>状态：</span></div>
        <div class="input_info">
            <select disabled>
                <option id="status"></option>
            </select>
        </div>
        <div class="text_info clearfix"><span>开通时间：</span></div>
        <div class="input_info"><input id="createDate" value="" type="text" readonly class="readonly"/></div>
        <div class="text_info clearfix"><span>资费 ID：</span></div>
        <div class="input_info"><input id="costId" value="" type="text" class="readonly" readonly/></div>
        <div class="text_info clearfix"><span>资费名称：</span></div>
        <div class="input_info"><input id="name" value="" type="text" readonly class="width200 readonly"/>
        </div>
        <div class="text_info clearfix"><span>资费说明：</span></div>
        <div class="input_info_high">
            <textarea id="descr" class="width300 height70 readonly" readonly></textarea>
        </div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input type="button" value="返回" class="btn_save" onclick="location.href='/service/service_list';"/>
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
    var urlParm = decodeURI(window.location.href.split("?")[1]);
    serviceId = urlParm.split("serviceId=")[1];
    console.log(serviceId);

    $(function () {

        var data = {
            "serviceId": serviceId
        };
        var setting = {
            url: "queryDetails",
            method: "post",
            headers: {
                "Content-Type": "application/json"
            },
            data: JSON.stringify(data)
        };
        $.ajax(setting).done(function (resp) {
            console.log(resp);
            var serviceId = $('#serviceId');
            serviceId.val(resp.serviceId);
            var accountId = $('#accountId');
            accountId.val(resp.accountId);
            var realName = $('#realName');
            realName.val(resp.account.realName);
            var idcardNo = $('#idcardNo');
            idcardNo.val(resp.account.idcardNo);
            var unixHost = $('#unixHost');
            unixHost.val(resp.unixHost);
            var osUsername = $('#osUsername');
            osUsername.val(resp.osUsername);
            var status1 = resp.status;
            if (status1 === "0") {
                var status = $('#status');
                status.text("暂停")
            } else if (status1 === "1") {
                var status = $('#status');
                status.text("开通");
            }
            var createDate = $('#createDate');
            createDate.val(resp.createDate);
            var costId = $('#costId');
            costId.val(resp.costId);
            var name = $('#name');
            name.val(resp.cost.name);
            var descr = $('#descr');
            descr.text(resp.cost.descr);
        });
    })

</script>

</body>
</html>

