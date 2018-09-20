<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/9/14
  Time: 下午2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
</head>
<body>
<table class="table .table-striped .table-bordered">
    <tr>
        <th>用户名</th>
        <th>密&emsp;码</th>
        <th>功&emsp;能</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td><input id="s1" type="text" value="${user.username}" class="btn btn-primary"></td>
            <td><input id="s2" type="text" value="${user.password}" class="btn btn-primary"></td>
            <td>
                <input id="btn1" type="button" value="修改" class="btn btn-success">
                &emsp;&emsp;&emsp;
                <input id="btn2" type="button" value="删除" class="btn btn-danger">
            </td>
        </tr>
    </c:forEach>
</table>

<script>

    $(function () {
        $('#btn1').click(function () {

        })
    })

</script>

</body>
</html>
