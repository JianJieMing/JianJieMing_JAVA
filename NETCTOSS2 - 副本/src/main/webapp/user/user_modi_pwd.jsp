<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>云科技</title>
    <script src="../js/jquery-3.2.1.js"></script>
    <script src="../js/jquery.validate.js"></script>
    <script src="../js/messages_zh.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>

    <script>
        $().ready(function () {
            $('#ss').validate({
                rules: {
                    password1: {
                        required: true,
                        minlength: 6
                    },
                    password2: {
                        required: true,
                        minlength: 6,
                        equalTo: '#oldpwd2'
                    }
                },
                messages: {
                    password1: {
                        required: '必填字段',
                        minlength: '最少需要六个字符'
                    },
                    password2: {
                        required: '必填字段',
                        minlength: '最少需要六个字符',
                        equalTo: '密码不一致'
                    }
                }
            })
        })
    </script>

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
<!--Logo区域结束-->
<!--导航区域开始-->
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
        <li><a href="<%=request.getContextPath()%>/informationcontroller/selectAll" class="information_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/user/user_modi_pwd.jsp" class="password_on"></a></li>
    </ul>
</div>
<!--导航区域结束-->
<div id="main">
    <!--保存操作后的提示信息：成功或者失败-->
    <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，旧密码错误！-->
    <form id="ss" action="" method="" class="main_form">
        <div class="text_info clearfix"><span>旧密码：</span></div>
        <div class="input_info">
            <input type="text" id="oldpwd" class="width200" required/><span class="required">*</span>
            <div class="validate_msg_medium">若没跳转,则旧密码错误,请重新输入</div>

        </div>
        <div class="text_info clearfix"><span>新密码：</span></div>
        <div class="input_info">
            <input id="oldpwd2" name="password1" type="text" value="" class="width200"/>
        </div>
        <div class="text_info clearfix"><span>重复新密码：</span></div>
        <div class="input_info">
            <input id="newpwd" name="password2" type="text" class="width200" value=""/>
        </div>
        <div class="button_info clearfix">
            <input type="button" value="保存" class="btn_save" onclick="test()"/>
            <input type="button" value="取消" class="btn_save" onclick="replaceDoc()"/>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
    <p>版权所有(C)云科技有限公司 </p>
</div>

<script>

    function replaceDoc() {
        window.location.replace("/user/user_modi_pwd.jsp")
    }

    function test() {
        var flag = $("#ss").valid();
        if (!flag) {
            return;
        } else {
            var oldPassword = $('#oldpwd').val();
            var newPassword = $('#oldpwd2').val();

            var data = {
                "oldPassword": oldPassword,
                "newPassword": newPassword
            };
            var setting = {
                url: "select",
                method: "post",
                headers: {
                    "Content-Type": "application/json"
                },
                data: JSON.stringify(data)
            };
            $.ajax(setting).done(function (resp) {
                console.log(resp);
                location.href = "/admin/showModule";
            })
        }
    }

</script>

</body>
</html>

