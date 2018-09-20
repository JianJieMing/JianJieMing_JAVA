<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/9/1
  Time: 上午11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.2.1.js"></script>
</head>
<body>
<h1>只有登录才可以访问</h1>

<div id="right">
    <table>
        <thead>
        <tr>
            <th>gameId</th>
            <th>gameName</th>
            <th>platform</th>
            <th>publisher</th>
            <th>globalSales</th>
            <th>userScore</th>
        </tr>
        </thead>
        <tbody id="body">

        </tbody>
    </table>
</div>


<div id="left">
    <select name="page" id="pageSelect">
        <option value="1">第1页</option>
        <option value="2">第2页</option>
        <option value="3">第3页</option>
        <option value="4">第4页</option>
        <option value="5">第5页</option>
        <option value="6">第6页</option>
    </select>
    <button id="btn1">查询</button>
    <button id="prev">上一页</button>
    <button id="next">下一页</button>
</div>


<script>

    $('#pageSelect').change(function (ev) {
        // var count = $(this).val();
        var url = "http://localhost:8080/ajax";
        var data = {
            page: 20,
            count: $(this).val()
        };
        $.post(url, JSON.stringify(data))
    });

    $('#btn1').click(function () {
        let url2 = "http://localhost:8080/ajax2";
        $.get(url2, showResult);
    });

    function showResult(resp) {
        var body = $('#body');
        console.log(resp);
        body.empty();
        for (var item of resp) {
            var tr = $('<tr></tr>');
            var gameId = $('<td></td>').text(item.gameId);
            var gameName = $('<td></td>').text(item.gameName);
            var platform = $('<td></td>').text(item.platform);
            var publisher = $('<td></td>').text(item.publisher);
            var globalSales = $('<td></td>').text(item.globalSales);
            var userScore = $('<td></td>').text(item.userScore);
            tr.append(gameId).append(gameName).append(platform).append(publisher).append(globalSales).append(userScore);
            body.append(tr);
        }
    }

</script>


</body>
</html>
