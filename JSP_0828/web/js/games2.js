let url = 'game';
$(function () {

    var currentPage = 1;
    var count = 20;


    $.get(url, showResult);

    $('form').submit(function (e) {
        // 匿名函数的参数表示表单
        // 阻止表单的默认提交方式
        e.preventDefault();
        // 使用ajax发送表单数据
        // serialize(),就会把表单中的数据转化为:
        // page=10&count=20 的形式.
        var arr = $(this).serializeArray();
        currentPage = Number(arr[0].value);
        count = Number(arr[1].value);
        // console.log($(this).serializeArray());
        $.get('game', $(this).serialize(), showResult)
    });


    $('#prev').click(function () {
        if (currentPage <= 0) {
            currentPage = 1;
        }
        if (count <= 0) {
            count = 20;
        }
        var params = {
            page: --currentPage,
            count: count
        };
        $.get('game', params, showResult)
    });

    $('#next').click(function () {
        if (currentPage <= 0) {
            currentPage = 1;
        }
        if (count <= 0) {
            count = 20;
        }
        var params = {
            page: ++currentPage,
            count: count
        };
        $.get('game', params, showResult)
    })
});


function showResult(resp) {
    console.log(resp);
    if (resp.status === 200) {
        console.log(200);
        // 取到数据的总条数
        var totalCount = resp.data.totalCount;
        // 取到请求的数据
        var items = resp.data.items;

        var body = $('#body');
        body.empty();
        for (var item of items) {
            console.log(item);
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
}