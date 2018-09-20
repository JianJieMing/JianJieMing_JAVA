<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/28
  Time: 下午5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-3.2.1.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <style>
        .left {
            width: 40%;
            border: 1px solid #05fff4;
            float: left;
        }

        .right {
            width: 50%;
            border: 1px solid #05fff4;
            float: right;
        }
    </style>
</head>
<body>
<h1><%=request.getAttribute("hint")%></h1>
<% if (request.getAttribute("hint").equals("恭喜你登录成功!")) {%>
<span>用户名:<%=request.getAttribute("username")%></span><br>
头像:<img src="<%=request.getAttribute("img")%>" style="width: 70px">
<br>
<div class="left">
    <button id="btn1" type="button" class="btn btn-primary">查询个人信息</button>
    <button id="btn2" type="button" class="btn btn-primary">查询所有人信息</button>
    <a href="../register.html" style="text-decoration: none"><input type="button" value="返回注册界面" class="btn btn-primary"></a>
</div>
<div class="right">
    <table class="table .table-striped .table-bordered">
        <thead>
        <tr>
            <th>用户ID</th>
            <th>图片ID</th>
            <th>用户名</th>
            <th>密码</th>
        </tr>
        </thead>
        <tbody id="tbody">

        </tbody>
    </table>
</div>
<script>
    $(function () {

        $('#btn1').click(function () {
            var url = "http://localhost:8080/ajax2";
            $.get(url, queryAll)
        });

        $('#btn2').click(function () {
            var url = "http://localhost:8080/ajax1";
            $.get(url, queryAll)
        });

        function queryAll(resp) {
            var body = $('#tbody');
            body.empty();
            for (var item of resp) {
                var tr = $('<tr></tr>');
                var userId = $('<td></td>').text(item.userId);
                var imageId = $('<td></td>').text(item.imageId);
                var username = $('<td></td>').text(item.username);
                var password = $('<td></td>').text(item.password);
                tr.append(userId).append(imageId).append(username).append(password);
                body.append(tr);
            }
        }

    });
</script>
<%}%>
</body>
</html>
