<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/15
  Time: 7:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <script src="../js/jquery-2.2.4.min.js"></script>
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
        $().ready(function () {
            $('#ss').validate({
                rules: {
                    checkbox: {
                        required: true
                    }
                },
                messages: {
                    checkbox: {
                        required: '必选项'
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
        <li><a href="<%=request.getContextPath()%>/role/role_list" class="role_on"></a></li>
        <li><a href="<%=request.getContextPath()%>/admin/admin_list" class="admin_off"></a></li>
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
        <div class="text_info clearfix"><span>角色名称：</span></div>
        <div class="input_info">
            <input id="name" type="text" class="width200" required minlength="2" maxlength="15"/>
        </div>
        <div class="text_info clearfix"><span>设置权限：</span></div>
        <div class="input_info_high">
            <div class="input_info_scroll">
                <ul id="moduleNames">

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
        rId = urlParm.split("roleId=")[1];

        var data = {
            "roleId": rId
        };
        var setting = {
            url: '',
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
            url: "queryModule",
            dataType: "json",
            success: requestFinished
        });

        function requestFinished(resp) {
            var moduleNames = $('#moduleNames');
            for (var item of resp) {
                var li = $('<li></li>').text(item.name);
                var input = $('<input name=\'checkbox\' type="checkbox"/>').val(item.moduleId);
                li.append(input);
                moduleNames.append(li)
            }
        }

    });

    function test() {
        var flag = $("#ss").valid();
        if (!flag) {
            return;
        } else {
            var roleId = rId;
            console.log(roleId);
            var moduleIds = [];
            $("input[name='checkbox']:checked").each(function (i) {
                moduleIds[i] = +$(this).val();
            });
            console.log(moduleIds);
            var name = $('#name').val();


            var data = {
                "roleId": roleId,
                "name": name,
                "moduleIds": moduleIds
            };
            var setting = {
                url: "updateRoleData",
                method: "post",
                headers: {
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify(data)
            };
            $.ajax(setting).done(function () {
                location.href = "/role/role_list"
            })
        }
    }


</script>


</body>
</html>
