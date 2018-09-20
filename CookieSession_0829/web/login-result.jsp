<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/8/29
  Time: 下午5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.2.1.js"></script>
</head>
<body>

<h1>${result}</h1>
<h1 id="sss">5</h1>
<a href="${path}">${msg}</a>

<script>

    var p = $('#sss');
    var i = 1;
    var interval = setInterval(function () {
        if (i === 5) {
            clearInterval(interval)
        }
        p.text(5 - i);
        i++;
    }, 1000);


    // var p = document.getElementsByTagName("p")[0];
    // var i = 1;
    // var interval = setInterval(function () {
    //     if (i === 5) {
    //         clearInterval(interval)
    //     }
    //     p.innerText = 5 - i;
    //     i++;
    // }, 1000)
</script>

</body>
</html>
