<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/9
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>
    <script src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
    <script language="javascript" type="text/javascript">
        //排序按钮的点击事件
        function sort1(btnObj) {
            if (btnObj.className === "sort_desc") {
                btnObj.className = "sort_asc";
                $.ajax({
                    url: "sort?num=1",
                    type: "POST",
                    success: function (resp) {
                        console.log(resp);
                        drawTable(resp);
                    }
                })
            } else {
                btnObj.className = "sort_desc";
                $.ajax({
                    url: "sort?num=2",
                    type: "POST",
                    success: function (resp) {
                        console.log(resp);
                        drawTable(resp);
                    }
                })
            }
        }

        function sort2(btnObj) {
            if (btnObj.className === "sort_desc") {

                btnObj.className = "sort_asc";
                $.ajax({
                    url: "sort?num=3",
                    type: "POST",
                    success: function (resp) {
                        console.log(resp);
                        drawTable(resp);
                    }
                })
            } else {
                btnObj.className = "sort_desc";
                $.ajax({
                    url: "sort?num=4",
                    type: "POST",
                    success: function (resp) {
                        console.log(resp);
                        drawTable(resp);
                    }
                })
            }
        }


        function drawTable(resp) {
            var body = $('#tb');

            body.empty();
            for (const item of resp) {
                var tr = $('<tr></tr>');
                var id = $('<td></td>').text(item.costId);
                var test = "";
                var valueId = item.costId;
                test += "<a href= /cost/showAllByname?costId=" + valueId + "></a>";
                var f = $(test).text(item.name);
                var name = $('<td></td>');
                var duration = $('<td></td>').text(item.baseDuration);
                var baseCost = $('<td></td>').text(item.baseCost);
                var unitCost = $('<td></td>').text(item.unitCost);
                var creatime = $('<td></td>').text(item.creatime);
                var startime = $('<td></td>').text(item.startime);
                var status = $('<td></td>').text(item.status);
                var a = $('<input  type="button" value="启用" class="btn_start" onclick="onStartClick(this)"/>').attr("rowId", item.costId);
                var ss = "";
                ss += "<a href= /cost/showAll?costId=" + valueId + "></a>";
                var sss = $(ss);
                var input1 = $('<input id="inp2" type="button" value="修改" class="btn_modify"/>');
                sss.append(input1);
                var d = $('<input type="button" value="删除" class="btn_delete" onclick="onStopClick(this)"/>').attr("rowId", item.costId);
                var fun = $('<td></td>');
                var g = name.append(f);
                if (item.status !== 1) {
                    fun.append(a).append(sss).append(d);
                }
                tr.append(id).append(g).append(duration)
                    .append(baseCost).append(unitCost).append(creatime)
                    .append(startime).append(status).append(fun);
                body.append(tr);
            }
        }


        //启用
        function startFee() {
            var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
            document.getElementById("operate_result_info").style.display = "block";
        }

        //删除
        function deleteFee() {
            var r = window.confirm("确定要删除此资费吗？");
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
        <!--排序-->
        <div class="search_add">
            <div>
                <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />-->
                <input type="button" value="基费" class="sort_asc" id="btn1" onclick="sort1(this);"/>
                <input type="button" value="时长" class="sort_asc" id="btn2" onclick="sort2(this);"/>
            </div>
            <input type="button" value="增加" class="btn_add" onclick="location.href='/fee/fee_add.jsp';"/>
        </div>
        <!--启用操作的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../images/close.png" onclick="this.parentNode.style.display='none';"/>
            删除成功！
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th>资费ID</th>
                    <th class="width100">资费名称</th>
                    <th>基本时长</th>
                    <th>基本费用</th>
                    <th>单位费用</th>
                    <th>创建时间</th>
                    <th>开通时间</th>
                    <th class="width50">状态</th>
                    <th class="width200"></th>
                </tr>
                <tbody id="tb">


                <C:forEach items="${costList}" var="cost">
                    <tr class="${cost.costId}">
                        <td>${cost.costId}</td>
                        <td>
                            <a href="<%=request.getContextPath()%>/cost/showAllByname?costId=${cost.costId}">${cost.name}</a>
                        </td>
                        <td id="time">${cost.baseDuration}</td>
                        <td>${cost.baseCost}</td>
                        <td>${cost.unitCost}</td>
                        <td>${cost.creatime}</td>
                        <td>${cost.startime}</td>
                        <C:if test="${cost.status eq 0 }">
                            <td>暂停</td>
                            <td>
                                <input id="inp1" rowId="${cost.costId}" type="button" value="启用" class="btn_start"
                                       onclick="onStartClick(this)"/>
                                <a href="/cost/showAll?costId=${cost.costId}">
                                    <input id="inp2" type="button" value="修改" class="btn_modify"/>
                                </a>
                                <input id="inp3" rowId2="${cost.costId}" type="button" value="删除" class="btn_delete"
                                       onclick="onStopClick2(this)"/>
                            </td>
                        </C:if>
                        <C:if test="${cost.status eq 1 }">
                            <td>开通</td>
                            <td></td>
                        </C:if>
                    </tr>
                </C:forEach>
                </tbody>

            </table>
            <p>业务说明：<br/>
                1、创建资费时，状态为暂停，记载创建时间；<br/>
                2、暂停状态下，可修改，可删除；<br/>
                3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br/>
                4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
            </p>
        </div>
        <!--分页-->
        <div id="pages">
            <a href="<%=request.getContextPath()%>/cost/findByPage?page=1">首页</a>
            <a href="<%=request.getContextPath()%>/cost/findByPage?page=${page-1}">上一页</a>

            <c:forEach begin="1" end="${totalPage}" var="i">
                <a href="<%=request.getContextPath()%>/cost/findByPage?page=${i}">${i}</a>
            </c:forEach>
            <a href="<%=request.getContextPath()%>/cost/findByPage?page=${page+1}">下一页</a>
            <a href="<%=request.getContextPath()%>/cost/findByPage?page=${totalPage}">末页</a>
        </div>
    </form>

</div>
<!--主要区域结束-->
<div id="footer">
    <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
    <p>版权所有(C)云科技有限公司</p>
</div>
<script>

    function onStartClick(e) {

        console.log(e.getAttribute("rowId"));
        var id = e.getAttribute("rowId");
        console.log(id);
        $.ajax({
            url: "update",
            type: "POST",
            data: {
                "num": id
            },
            success: function (resp) {
                location.reload(true)
            }
        })
    }

    function onStopClick2(e) {
        console.log(e.getAttribute("rowId2"));
        var id2 = e.getAttribute("rowId2");
        console.log(id2);
        $.ajax({
            url: "delete",
            type: "POST",
            data: {
                "num": id2
            },
            success: function (resp) {
                location.reload(true)
            }
        })
    }
</script>
</body>
</html>
