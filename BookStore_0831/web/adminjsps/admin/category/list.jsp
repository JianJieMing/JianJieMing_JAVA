<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>分类列表</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>

    <style type="text/css">
        body {
            background: rgb(254, 238, 189);
        }

        table {
            font-family: 宋体;
            font-size: 11pt;
            border-color: rgb(78, 78, 78);
            width: 60%;
        }

        #th {
            background: rgb(78, 78, 78);
        }
    </style>
</head>

<body>
<h2 style="text-align: center;">分类列表</h2>
<table id="ajax" align="center" border="1" class="table" table-striped>
    <tr id="th" bordercolor="rgb(78,78,78)">
        <th>分类名称</th>
        <th>操作</th>
    </tr>

</table>

<script>

    $(function () {
        var url = "/adminCategory";
        $.get(url, f)
    });

    function f(resp) {
        console.log(resp);
        var table = $('#ajax');
        for (var item of resp) {
            var tr = $('<tr></tr>').css('bordercolor', 'rgb(78,78,78)');
            var result = item.cname;
            var str1 = "";
            var str2 = "";
            str1 += "<a href = /adminjsps/admin/category/mod.jsp?cname=" + result + "><input type='button' value='修改' class=\"btn btn-primary\">&emsp;&emsp;&emsp;</a>";
            str2 += "<a href = /adminjsps/admin/category/del.jsp?cname=" + result + "><input type='button' value='删除' class=\"btn btn-primary\"></a>";
            var cname = $('<td></td>').text(result);
            var a1 = $(str1);
            var a2 = $(str2);
            var td = $('<td></td>');
            td.append(a1);
            td.append(a2);
            tr.append(cname);
            tr.append(td);
            table.append(tr);
        }
    }

</script>

</body>
</html>
