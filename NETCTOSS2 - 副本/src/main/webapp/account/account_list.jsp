<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/13
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>云科技</title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>
    <%--<script src="<%=request.getContextPath()%>/js/jquery-2.2.4.min.js"/>--%>
    <script src="<%=request.getContextPath()%>/js/jquery-2.2.4.min.js"></script>
    <script language="javascript" type="text/javascript">

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
    <form action="<%=request.getContextPath()%>/account/selectOne" method="post">
        <!--查询-->
        <div class="search_add">
            <div>身份证：<input type="text" name="idcardNo" value="" class="text_search"/></div>
            <div>姓名：<input type="text" name="realName" class="width70 text_search" value=""/></div>
            <div>登录名：<input type="text" name="loginName" value="" class="text_search"/></div>
            <div>
                状态：
                <select name="status" class="select_search">
                    <option>全部</option>
                    <option value="1">开通</option>
                    <option value="0">暂停</option>
                </select>
            </div>
            <div><input type="submit" value="搜索" class="btn_search"/></div>
            <input type="button" value="增加" class="btn_add" onclick="location.href='<%=request.getContextPath()%>/account/account_add.jsp';"/>
        </div>
        <!--删除等的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../images/close.png" onclick="this.parentNode.style.display='none';"/>
            删除成功，且已删除其下属的业务账号！
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th>账号ID</th>
                    <th>姓名</th>
                    <th class="width150">身份证</th>
                    <th>登录名</th>
                    <th>状态</th>
                    <th class="width100">创建日期</th>
                    <th class="width150">上次登录时间</th>
                    <th class="width200"></th>
                </tr>
                <c:forEach var="account" items="${accounts}">
                <tr>
                    <td>${account.accountId}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/account/selectOneById?accountId=${account.accountId}">${account.realName}</a>
                    </td>
                    <td>${account.idcardNo}</td>
                    <td>${account.loginName}</td>
                    <c:if test="${account.status eq 0 }">
                        <td>暂停</td>
                    </c:if>
                    <c:if test="${account.status eq 1 }">
                        <td>开通</td>
                    </c:if>
                    <td>${account.createDate}</td>
                    <td>${account.lastLoginTime}</td>
                    <c:if test="${account.status eq 0 }">
                        <td class="td_modi">
                            <input type="button" value="开通" class="btn_pause"/>
                            <input type="button" value="修改" class="btn_modify"
                                   onclick="location.href='<%=request.getContextPath()%>/account/showMessage?accountId=${account.accountId}';"/>
                            <input type="button" value="删除" class="btn_delete"/>
                        </td>
                    </c:if>
                    <c:if test="${account.status eq 1 }">
                        <td class="td_modi">
                            <input type="button" value="暂停" class="btn_pause"/>
                            <input type="button" value="修改" class="btn_modify"
                                   onclick="location.href='<%=request.getContextPath()%>/account/showMessage?accountId=${account.accountId}';"/>
                            <input type="button" value="删除" class="btn_delete"/>
                        </td>
                    </c:if>
                    </c:forEach>
                </tr>


            </table>
            <p>业务说明：<br/>
                1、创建则开通，记载创建时间；<br/>
                2、暂停后，记载暂停时间；<br/>
                3、重新开通后，删除暂停时间；<br/>
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br/>
                5、暂停账务账号，同时暂停下属的所有业务账号；<br/>
                6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br/>
                7、删除账务账号，同时删除下属的所有业务账号。</p>
        </div>
        <!--分页-->
        <div id="pages">
            <a href="<%=request.getContextPath()%>/account/findByPage?page=1">首页</a>
            <a href="<%=request.getContextPath()%>/account/findByPage?page=${page-1}">上一页</a>

            <c:forEach begin="1" end="${totalPage}" var="i">
                <a href="<%=request.getContextPath()%>/account/findByPage?page=${i}">${i}</a>
            </c:forEach>
            <a href="<%=request.getContextPath()%>/account/findByPage?page=${page+1}">下一页</a>
            <a href="<%=request.getContextPath()%>/account/findByPage?page=${totalPage}">末页</a>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
    <p>版权所有(C)云科技有限公司 </p>
</div>
<script>

    $('#datalist').click(function (e) {
        var id = e.target.parentNode.parentNode.firstChild.nextSibling.textContent;
        console.log(id);
        var value = e.target.value;
        console.log(value);
        if (value === "暂停") {
            $.ajax({
                url: "<%=request.getContextPath()%>/account/updateStop",
                type: "POST",
                data: {
                    "accountId": id
                },
                success: function (resp) {
                    location.reload(true)
                }
            })
        } else if (value === "开通") {
            $.ajax({
                url: "<%=request.getContextPath()%>/account/updateStart",
                type: "POST",
                data: {
                    "accountId": id
                },
                success: function (resp) {
                    location.reload(true)
                }
            })
        } else if (value === "删除") {
            $.ajax({
                url: "<%=request.getContextPath()%>/account/deleteOne",
                type: "POST",
                data: {
                    "accountId": id
                },
                success: function (resp) {
                    location.reload(true)
                }
            })
        }
    })

</script>
</body>
</html>

