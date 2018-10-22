
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <script src="../js/jquery-3.2.1.js"></script>
    <script src="../js/jquery.validate.js"></script>
    <script src="../js/messages_zh.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>
    <script language="javascript" type="text/javascript">
        //保存成功的提示消息
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
                    checkbox: {
                        required: true
                    },
                    telephone: {
                        required: true,
                        mobile: true
                    }
                },
                messages: {
                    checkbox: {
                        required: '选一个哦'
                    },
                    telephone: {
                        required: '必填字段',
                        mobile: "手机号码格式错误"
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
            <input id="name" type="text" value="" minlength="2" maxlength="15" required/>
        </div>
        <div class="text_info clearfix"><span>管理员账号：</span></div>
        <div class="input_info"><input id="adminCode" type="text" readonly="readonly" class="readonly"
                                       value="" minlength="2" maxlength="15" required/></div>
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input id="telephone" name="telephone" type="text" value=""/>
        </div>
        <div class="text_info clearfix"><span>Email：</span></div>
        <div class="input_info">
            <input id="email" type="email" name="email" class="width200" value="" required/>
        </div>
        <div class="text_info clearfix"><span>角色：</span></div>
        <div class="input_info_high">
            <div class="input_info_scroll">
                <ul id="roleNames">

                </ul>
            </div>
        </div>
        <div class="button_info clearfix">
            <input id="btn1" type="button" value="保存" class="btn_save" onclick="test()"/>
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

        var urlParm = decodeURI(window.location.href.split("?")[1]);
        aId = urlParm.split("adminId=")[1];

        var data2 = {
            "adminId": aId
        };
        var setting = {
            type: "POST",
            url: "queryAdminInfo",
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(data2),
        };
        $.ajax(setting).done(function (resp) {
            console.log(resp);
            var name = $('#name');
            var telephone = $('#telephone');
            var email = $('#email');
            var adminCode = $('#adminCode');
            name.val(resp.name);
            telephone.val(resp.telephone);
            email.val(resp.email);
            adminCode.val(resp.adminCode)
        });


        var data = {
            "adminId": aId
        };
        var setting = {
            url: 'queryAdminInfo',
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            // 把对象转出json数据.
            data: JSON.stringify(data)
        };
        $.ajax(setting);


        $.ajax({
            typ: "GET",
            url: "queryRoleInof",
            dataType: "json",
            success: requestFinished
        });

        function requestFinished(resp) {
            var roleNames = $('#roleNames');
            for (var item of resp) {
                var li = $('<li></li>').text(item.name);
                var input = $('<input name=\'checkbox\' type="checkbox"/>').val(item.roleId);
                li.append(input);
                roleNames.append(li)
            }
        }
    });


    function test() {

        var flag = $("#ss").valid();
        if (!flag) {
            return;
        } else {
            var adminId = aId;
            console.log(adminId);
            var roleIds = [];
            $("input[name='checkbox']:checked").each(function (i) {
                roleIds[i] = +$(this).val();
            });
            console.log(roleIds);
            var name = $('#name').val();
            var telephone = $('#telephone').val();
            var email = $('#email').val();

            var data = {
                "adminId": adminId,
                "name": name,
                "telephone": telephone,
                "email": email,
                "roleIds": roleIds
            };
            var setting = {
                url: "updateAdminData",
                method: "post",
                headers: {
                    'Content-Type': 'application/json'
                },
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

