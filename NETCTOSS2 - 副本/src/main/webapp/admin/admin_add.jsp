<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        // 手机号码验证
        jQuery.validator.addMethod("mobile", function(value, element) {
            var length = value.length;
            var mobile =  /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "手机号码格式错误");

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
                        equalTo: '#password'
                    },
                    adminCode: {
                        required: true,
                        minlength: 2,
                        maxlength: 15
                    },
                    telephone: {
                        required: true,
                        mobile: true
                    },
                    checkbox: {
                        required: true
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
                    },
                    adminCode: {
                        required: '必填字段',
                        minlength: '最少需要2个字符',
                        maxlength: '最多15个字符'
                    },
                    telephone: {
                        required: '必填字段',
                        mobile: "手机号码格式错误"
                    },
                    checkbox: {
                        required: '选一个哦'
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
        <li><a href="<%=request.getContextPath()%>/admin/admin_list" class="admin_on"></a></li>
        <li><a href="<%=request.getContextPath()%>/cost/findAll" class="fee_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/account/findAll" class="account_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/service/service_list" class="service_off"></a></li>
        <li><a href="../bill/bill_list.jsp" class="bill_off"></a></li>
        <li><a href="../report/report_list.jsp" class="report_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/informationcontroller/selectAll" class="information_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/user/user_modi_pwd.jsp" class="password_off"></a></li>
    </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form id="ss" class="main_form">
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info">
            <input id="name" type="text" minlength="2" maxlength="15" required/>
        </div>
        <div class="text_info clearfix"><span>管理员账号：</span></div>
        <div class="input_info">
            <input id="adminCode" name="adminCode" type="text"/>
        </div>
        <div class="text_info clearfix"><span>密码：</span></div>
        <div class="input_info">
            <input id="password" type="password" name="password1"/>
        </div>
        <div class="text_info clearfix"><span>重复密码：</span></div>
        <div class="input_info">
            <input type="password" name="password2"/>
        </div>
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input id="telephone" name="telephone" type="text" class="width200"/>
        </div>
        <div class="text_info clearfix"><span>Email：</span></div>
        <div class="input_info">
            <input id="email" type="email" name="email" class="width200" required/>
        </div>
        <div class="text_info clearfix"><span>角色：</span></div>
        <div class="input_info_high">
            <div class="input_info_scroll">
                <ul id="roleName">

                </ul>
            </div>
        </div>
        <div class="button_info clearfix">
            <input type="button" onclick="test()" value="保存" class="btn_save"/>
            <input type="button" value="取消" class="btn_save"/>
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

        $.ajax({
            method: "GET",
            url: "queryRoleInfoName",
            dataType: "json",
            success: requestFinished
        });

        function requestFinished(resp) {
            console.log(resp);
            var roleName2 = $('#roleName');
            for (var item of resp) {
                var roleName = item.name;
                var roleId = item.roleId;
                var li = $('<li></li>').text(roleName);
                var input = $('<input name="checkbox" type="checkbox"/>').val(roleId);
                li.append(input);
                roleName2.append(li)
            }
        }

    });

    function test() {
        var flag = $("#ss").valid();
        if (!flag) {
            return;
        } else {
            var name = $('#name').val();
            var adminCode = $('#adminCode').val();
            var password = $('#password').val();
            var telephone = $('#telephone').val();
            var email = $('#email').val();
            var roleIds = [];
            $("input[name='checkbox']:checked").each(function (i) {
                roleIds[i] = +$(this).val();
            });
            var data = {
                "name": name,
                "adminCode": adminCode,
                "password": password,
                "telephone": telephone,
                "email": email,
                "roleIds": roleIds
            };
            var setting = {
                url: 'insertAdminRole',
                method: 'post',
                headers: {
                    'Content-Type': 'application/json'
                },
                // 把对象转出json数据.
                data: JSON.stringify(data)
            };
            $.ajax(setting).done(function () {
                location.href = "/admin/admin_list.jsp"
            })
        }
    }


</script>

</body>
</html>
