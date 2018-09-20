// 当前页
var currentPage = 1;
// 行数
var rowCount = 20;

$(function () {
    getRemoteGames(currentPage, rowCount);
});

function getRemoteGames(page, count) {
    // 把字符串转换为数的方式:
    // var x = +page;
    page = +page <= 0 ? 1 : +page;
    count = +count <= 0 ? 20 : +count;
    // 创建一个对象,里面有两个属性,属性的值是上面的变量.
    var params = {
        page: page,
        count: count
    };
    $.get('game', params, handleResponse);
}

// 处理函数
function handleResponse(resp) {
    if (resp.status === 200) {
        // 1.画页码.
        var totalCount = resp.data.totalCount;
        // 计算一共多少页.
        // 70 70 / 20 = 3.5  4页.
        // 计算一共多少页,向上取整.
        var pages = Math.ceil(totalCount / rowCount);
        drawPageIndicator(pages);
        // 2.把数据添加到table中.
        var items = resp.data.items;
        putItemsInTable(items);
    }
}

/**
 * 画分页指示器
 * @param pages
 */
function drawPageIndicator(pages) {
    var ul = $('ul');
    // 清空原有的所有指示器.
    ul.empty();
    for (var i = 0; i < pages; i++) {
        var li = $('<li></li>');
        // 如果这个li是当前页,那么添加.active
        if (currentPage == i + 1) {
            li.addClass('active');
        }
        var a = $('<a></a>');
        // 点击一个链接的时候,啥也不干.
        a.attr('href', 'javascript:void(0)');
        // 给a标签添加文本.
        a.text(i + 1);
        // 设置点击事件.
        a.click(onIndicatorClick);
        li.append(a);
        ul.append(li);
    }
}

/**
 * 指示器的点击事件
 */
function onIndicatorClick() {
    // 1.设置被点击的指示器为当前页面.
    currentPage = +$(this).text();
    // 2.发起网络请求.
    getRemoteGames(currentPage, rowCount);
}

/**
 * 把请求下来的数据,填入到table中
 * @param items
 */
function putItemsInTable(items) {
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