<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/10
  Time: 8:45
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
        //显示角色详细信息
        function showDetail(flag, a) {
            var detailDiv = a.parentNode.getElementsByTagName("div")[0];
            if (flag) {
                detailDiv.style.display = "block";
            }
            else
                detailDiv.style.display = "none";
        }

        //重置密码
        function resetPwd() {
            alert("请至少选择一条数据！");
            //document.getElementById("operate_result_info").style.display = "block";
        }

        //删除
        function deleteAdmin() {
            var r = window.confirm("确定要删除此管理员吗？");
            document.getElementById("operate_result_info").style.display = "block";
        }

        //全选
        function selectAdmins(inputObj) {
            var inputArray = document.getElementById("datalist").getElementsByTagName("input");
            for (var i = 1; i < inputArray.length; i++) {
                if (inputArray[i].type == "checkbox") {
                    inputArray[i].checked = inputObj.checked;
                }
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
    <form>
        <!--查询-->
        <div class="search_add">
            <div>
                模块：
                <select id="selModules" class="select_search">
                    <option value="">全部</option>
                    <c:forEach var="moduleNames" items="${moduleNames}">
                        <option value="${moduleNames.moduleId}">${moduleNames.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>角色：<input id="roleName" type="text" value="" class="text_search width200"/></div>
            <div><input id="search" type="button" value="搜索" class="btn_search"/></div>
            <%--onclick="resetPwd();--%>
            <input id="passwordReset" type="button" value="密码重置" class="btn_add"/>
            <input type="button" value="增加" class="btn_add" onclick="location.href='admin_add.jsp';"/>
        </div>
        <!--删除和密码重置的操作提示-->
        <div id="operate_result_info" class="operate_fail">
            <img src="../images/close.png" onclick="this.parentNode.style.display='none';"/>
            <span>删除失败！数据并发错误。</span><!--密码重置失败！数据并发错误。-->
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <thead>
                <tr>
                    <th class="th_select_all">
                        <input type="checkbox" onclick="selectAdmins(this);"/>
                        <span>全选</span>
                    </th>
                    <th>管理员ID</th>
                    <th>姓名</th>
                    <th>登录名</th>
                    <th>电话</th>
                    <th>电子邮件</th>
                    <th>授权日期</th>
                    <th class="width100">拥有角色</th>
                    <th></th>
                </tr>
                </thead>
                <tbody id="body">

                </tbody>
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
    <span>版权所有(C)云科技有限公司 </span>
</div>

<script>

    $(function () {

        $.ajax({
            typ: "GET",
            url: "admin_list.do",
            dataType: "json",
            success: requestFinished
        });


        $('#selModules').click(function () {
            var moduleId = $('#selModules').val();
            var data = {
                "moduleId": moduleId
            };
            var setting = {
                url: 'queryModule',
                method: 'post',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify(data)
            };
            $.ajax(setting).done(requestFinished)
        });

        $('#search').click(function () {
            var roleName = $('#roleName').val();
            var data = {
                "name": roleName
            };
            var setting = {
                url: 'queryRoleName',
                method: 'post',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify(data)
            };
            $.ajax(setting).done(requestFinished)
        });

        function requestFinished(resp) {
            console.log(resp);
            var table = $('#body');
            table.empty();
            for (var item of resp) {
                var tr = $('<tr></tr>');
                var adminIds = item.adminId;
                var tdInput = $('<td></td>');
                var tdInput3 = $('<input name="checkbox" type="checkbox" id="checkbox"/>').val(adminIds);
                tdInput.append(tdInput3);
                var adminId = $('<td id="tdAdminId"></td>').text(item.adminId);
                var name = $('<td></td>').text(item.name);
                var adminCode = $('<td></td>').text(item.adminCode);
                var telephone = $('<td></td>').text(item.telephone);
                var email = $('<td></td>').text(item.email);
                var enrolldate = $('<td></td>').text(item.enrolldate);
                var td = $('<td></td>');
                var a = $('<a class="summary" onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);"></a>').text(item.qx.length > 5 ? (item.qx.substring(0, 5) + "...") : item.qx);
                var div = $('<div class="detail_info"></div>').text(item.qx);
                var td2 = $('<td class="td_modi"></td>');
                var input1 = $('<input type="button" value="修改" class="btn_modify"/>');
                var input2 = $('<input id="btnDelete" name="" type="button" value="删除" class="btn_delete"/>');

                var tdDiv = td.append(a).append(div);
                var tdInput2 = td2.append(input1).append(input2);

                var trAppend = tr.append(tdInput).append(adminId)
                    .append(name).append(adminCode).append(telephone)
                    .append(email).append(enrolldate).append(tdDiv)
                    .append(tdInput2);
                table.append(trAppend)
            }
        }

        $('#passwordReset').click(function () {

            var adminIds = [];
            $("input[name='checkbox']:checked").each(function (i) {
                adminIds[i] = +$(this).val();
            });

            var data = {
                "adminIds": adminIds
            };
            var setting = {
                url: 'updatePassword',
                method: 'post',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify(data)
            };
            $.ajax(setting).done(function () {
                    location.reload(true)
                }
            )
        });


        $('#datalist').click(function (e) {

            var adminId = e.target.parentNode.parentNode.childNodes.item(1).textContent;
            var elem = e.target.value;
            console.log(adminId);

            if (elem === "删除") {
                var data = {
                    "adminId": adminId
                };
                var setting = {
                    url: 'deleteAdminInfoAndAnminRole',
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
                    url: "/admin/admin_modi.jsp",
                    success: function () {
                        location.href = "/admin/admin_modi.jsp?adminId=" + adminId
                    }
                })

            }
        })


    })

</script>


</body>
</html>
