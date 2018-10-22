<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title></title>
    <script src="../js/jquery-3.2.1.js"></script>
    <script src="../js/jquery.validate.js"></script>
    <script src="../js/messages_zh.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>

    <script>
        $().ready(function () {
            $('#ss').validate({
                rules: {

                },
                messages: {

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
        <li><a href="<%=request.getContextPath()%>/informationcontroller/selectAll" class="information_on"></a></li>
        <li><a href="<%=request.getContextPath()%>/user/user_modi_pwd.jsp" class="password_off"></a></li>
    </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">

    <form action="/informationcontroller/update" class="main_form">
        <div class="text_info clearfix"><span>管理员账号：</span></div>
        <div class="input_info">
            <input type="text" id="adminId" name="adminId" disabled="disabled" value="${adminInfo1.adminCode}"/></div>
        <div class="text_info clearfix"><span>角色：</span></div>
        <div class="input_info">
            <input type="text" id="role" name="adminCode" disabled="disabled" value="${adminInfo1.rNames}"/>
        </div>
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info">
            <input type="text" value="${adminInfo1.name}" id="realname" name="name"  minlength="2" maxlength="15" required/>
        </div>
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input type="text" id="telephone" class="width200" value="${adminInfo1.telephone}" name="telephone" required
                   minlength="11"/>
        </div>
        <div class="text_info clearfix"><span>Email：</span></div>
        <div class="input_info">
            <input type="email" id="email" name="email" class="width200" value="${adminInfo1.email}" required/>
        </div>
        <div class="text_info clearfix"><span>创建时间：</span></div>
        <div class="input_info"><input type="text" id="enrolldate" disabled="disabled" name="enrolldate"
                                       value="${adminInfo1.enrolldate}"/></div>
        <div class="button_info clearfix">
            <input type="submit" value="保存" class="btn_save" onclick="showResult()"/>
            <input type="button" value="取消" class="btn_save" onclick="replaceDoc()"/>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
    <p>版权所有(C)云科技有限公司</p>

</div>
<script>
    function replaceDoc() {
        window.location.replace("/informationcontroller/selectAll")
    }

</script>
</body>
</html>
