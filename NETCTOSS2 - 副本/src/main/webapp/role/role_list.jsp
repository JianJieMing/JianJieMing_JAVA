<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/9
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <script src="../js/jquery-2.2.4.min.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>
    <script language="javascript" type="text/javascript">
        function deleteRole() {
            var r = window.confirm("确定要删除此角色吗？");
            document.getElementById("operate_result_info").style.display = "block";
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
    <form>
        <!--查询-->
        <div class="search_add">
            <input type="button" value="增加" class="btn_add" onclick="location.href='role_add';"/>
        </div>
        <!--删除的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../images/close.png" onclick="this.parentNode.style.display='none';"/>
            删除成功！
        </div> <!--删除错误！该角色被使用，不能删除。-->
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th>角色 ID</th>
                    <th>角色名称</th>
                    <th class="width600">拥有的权限</th>
                    <th class="td_modi"></th>
                </tr>
                <c:forEach var="result" items="${adminInfos}">
                    <tr>
                        <td id="ss">${result.roleId}</td>
                        <td>${result.name}</td>
                        <td>${result.qx}</td>
                        <td>
                            <input type="button" value="修改" class="btn_modify"/>
                            <input type="button" value="删除" class="btn_delete"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <!--分页-->
        <div id="pages">
            <a href="#">上一页</a>
            <a href="#" class="current_page">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">下一页</a>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
    <p>版权所有(C)云科技有限公司 </p>
</div>

<script>

    $(function () {

        $('#datalist').click(function (e) {

            var roleId = e.target.parentNode.parentNode.childNodes.item(1).textContent;
            var elem = e.target.value;
            console.log(roleId);

            if (elem === "删除") {
                var data = {
                    "roleId": roleId
                };
                var setting = {
                    url: 'deleteRoleAndRoleModule',
                    method: 'post',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    // 把对象转出json数据.
                    data: JSON.stringify(data)
                };
                $.ajax(setting).done(function () {
                    location.reload(true)
                });
            }
            if (elem === "修改") {
                $.ajax({
                    url: "/role/role_modi.jsp",
                    success: function () {
                        location.href = "/role/role_modi.jsp?roleId=" + roleId
                    }
                })
            }

        })

    })

</script>

</body>
</html>
