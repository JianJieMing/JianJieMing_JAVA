<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/9
  Time: 17:45
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
    <script language="javascript" type="text/javascript"></script>
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
            <input id="test" type="text" class="width200" required minlength="2" maxlength="15"/>
        </div>
        <div class="text_info clearfix"><span>设置权限：</span></div>
        <div class="input_info_high">
            <div class="input_info_scroll">
                <ul>
                    <c:forEach var="qx" items="${moduleInfos}">
                        <li><input name="checkbox" value="${qx.moduleId}" type="checkbox"/>${qx.name}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="button_info clearfix">
            <input type="button" value="保存" class="btn_save" onclick="validation()"/>
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

    function validation() {
        var flag = $("#ss").valid();
        if (!flag) {
            return;
        } else {
            var test = $('#test').val();
            var checkIDs = [];
            $("input[name='checkbox']:checked").each(function (i) {
                checkIDs[i] = $(this).val();
            });
            var data = {
                "roleName": test,
                "moduleIds": checkIDs
            };
            var setting = {
                url: 'insertRole',
                method: 'post',
                headers: {
                    'Content-Type': 'application/json'
                },
                // 把对象转出json数据.
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
