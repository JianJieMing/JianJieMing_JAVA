<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/15
  Time: 12:01
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

        //删除
        function deleteAccount() {
            var r = window.confirm("确定要删除此业务账号吗？删除后将不能恢复。");
            document.getElementById("operate_result_info").style.display = "block";
        }

        //开通或暂停
        function setState() {
            var r = window.confirm("确定要开通此业务账号吗？");
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
    <form action="" method="">
        <!--查询-->
        <div class="search_add">
            <div>OS 账号：<input id="osUsername" type="text" value="" class="width100 text_search"/></div>
            <div>服务器 IP：<input id="unixHost" type="text" value="" class="width100 text_search"/></div>
            <div>身份证：<input id="idcardNo" type="text" value="" class="text_search"/></div>
            <div>状态：
                <select id="status" class="select_search">
                    <option>全部</option>
                    <option value="1">开通</option>
                    <option value="0">暂停</option>
                </select>
            </div>
            <div><input id="btn1" type="button" value="搜索" class="btn_search"/></div>
            <input type="button" value="增加" class="btn_add" onclick="location.href='service_add.jsp';"/>
        </div>
        <!--删除的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../images/close.png" onclick="this.parentNode.style.display='none';"/>
            删除成功！
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <thead>
                <tr>
                    <th class="width50">业务ID</th>
                    <th class="width70">账务账号ID</th>
                    <th class="width150">身份证</th>
                    <th class="width70">姓名</th>
                    <th>OS 账号</th>
                    <th class="width50">状态</th>
                    <th class="width100">服务器 IP</th>
                    <th class="width100">资费</th>
                    <th class="width200"></th>
                </tr>
                </thead>
                <tbody id="tbody">

                </tbody>
            </table>
            <p>业务说明：<br/>
                1、创建即开通，记载创建时间；<br/>
                2、暂停后，记载暂停时间；<br/>
                3、重新开通后，删除暂停时间；<br/>
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br/>
                5、业务账号不设计修改密码功能，由用户自服务功能实现；<br/>
                6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
        </div>
        <!--分页-->
        <div id="pages">
            <a href="#">首页</a>
            <a href="#">上一页</a>
            <a href="#" class="current_page">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">下一页</a>
            <a href="#">末页</a>
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

            function requestFinished(resp) {
                console.log(resp);
                var tbody = $('#tbody');
                tbody.empty();
                for (var item of resp) {
                    var serviceId2 = item.serviceId;
                    var tr = $('<tr></tr>');
                    var serviceId = $('<td></td>');
                    // var a = $('<a href="service_detail.jsp" title="查看明细"></a>').text(item.serviceId);
                    var atest = "";
                    atest += "<a href=service_detail.jsp?serviceId=" + serviceId2 + " title=\"查看明细\"></a>";
                    var a = $(atest);
                    a.text(item.serviceId)
                    serviceId.append(a);
                    var account = $('<td></td>').text(item.account.accountId);
                    var idcardNo = $('<td></td>').text(item.account.idcardNo);
                    var realName = $('<td></td>').text(item.account.realName);
                    var osUsername = $('<td></td>').text(item.osUsername);
                    if (item.status === "0") {
                        var status = $('<td></td>').text('暂停');
                    } else if (item.status === "1") {
                        var status = $('<td></td>').text('开通');
                    }
                    var unixHost = $('<td></td>').text(item.unixHost);
                    var costTd = $('<td></td>');
                    var costA = $('<a class="summary" onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);"></a>').text(item.cost.name);
                    var costDiv = $('<div class="detail_info"></div>').text(item.cost.descr);
                    costTd.append(costA).append(costDiv);
                    var tdBtn = $('<td class="td_modi"></td>');
                    if (item.status === "0") {
                        var tdBtnInput1 = $('<input type="button" value="开通" class="btn_pause"/>');
                    } else if (item.status === "1") {
                        var tdBtnInput1 = $('<input type="button" value="暂停" class="btn_pause"/>');
                    }
                    var tdBtnInput2 = $('<input type="button" value="修改" class="btn_modify"/>');
                    var tdBtnInput3 = $('<input id="delete" type="button" value="删除" class="btn_delete"/>');
                    tdBtn.append(tdBtnInput1).append(tdBtnInput2).append(tdBtnInput3);
                    tr.append(serviceId).append(account).append(idcardNo).append(realName)
                        .append(osUsername).append(status).append(unixHost).append(costTd)
                        .append(tdBtn);
                    tbody.append(tr);
                }
            }

            var url = "queryBusiness";
            $.get(url).done(requestFinished);

            $('#btn1').click(function () {
                var osUsername = $('#osUsername').val();
                var unixHost = $('#unixHost').val();
                var idcardNo = $('#idcardNo').val();
                var status1 = $('#status').val();
                var status = +status1;
                console.log(status);
                var data = {
                    "osUsername": osUsername,
                    "unixHost": unixHost,
                    "idcardNo": idcardNo,
                    "status": status
                };
                var setting = {
                    url: "queryOsUsernameOrUnixHostOrIdCardNo",
                    method: 'post',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    // 把对象转出json数据.
                    data: JSON.stringify(data)
                };
                $.ajax(setting).done(requestFinished);
            });

            $('#datalist').click(function (e) {
                var elem = e.target.value;
                var serviceId = e.target.parentNode.parentNode.childNodes.item(0).textContent;
                console.log(serviceId);
                if (elem === "开通" || elem === "暂停") {
                    console.log(elem);
                    status;
                    if (elem === "开通") {
                        status = 1;
                    } else if (elem === "暂停") {
                        status = 0;
                    }
                    console.log(status);
                    var data = {
                        "status": status,
                        "serviceId": serviceId
                    };
                    var setting = {
                        url: "updateStatus",
                        method: "post",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        data: JSON.stringify(data)
                    };
                    $.ajax(setting).done(function (resp) {
                            location.reload(true)
                        }
                    )
                } else if (elem === "修改") {
                    var serviceId = e.target.parentNode.parentNode.childNodes.item(0).textContent;
                    var osUsername = e.target.parentNode.parentNode.childNodes.item(4).textContent;
                    var unixHost = e.target.parentNode.parentNode.childNodes.item(6).textContent;
                    $.ajax({
                        url: "/service/service_modi.jsp",
                        success: function () {
                            location.href = "/service/service_modi.jsp?serviceId=" + serviceId + "&osUsername=" + osUsername + "&unixHost=" + unixHost
                        }
                    })
                } else if (elem === "删除") {
                    var accountId = e.target.parentNode.parentNode.childNodes.item(1).textContent;
                    var data = {
                        "accountId": accountId
                    };
                    var setting = {
                        url: "deleteAccountAndService",
                        method: "post",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        data: JSON.stringify(data)
                    };
                    $.ajax(setting).done(function () {
                        location.reload(true)
                    });
                }
            });

        }
    )

</script>

</body>
</html>
