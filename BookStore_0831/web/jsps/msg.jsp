<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'msg.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="/js/spig.js"></script>
    <link rel="stylesheet" href="/css/spigPet.css">
    <script type="text/javascript">
        var isindex = true;
        var visitor = true;
    </script>
    <style>
        iframe {
            position: absolute;
            z-index: -1;
            width: 100%;
            height: 100%;
        }
        h1{
            color: #ff0326;
        }
        h1:link {
            color: #fcff0d;
        }

        h1:visited {
            color: #ff0511;
        }

        h1:hover {
            color: #0dff29;
            border-radius: 5px;
        }

        h1:active {
            color: #ff05f1;
        }
        iframe {
            position: absolute;
            z-index: -1;
            width: 100%;
            height: 100%;
        }
    </style>
</head>

<body>
<div id="spig" class="spig">
    <div id="message">正在加载中……</div>
    <div id="mumu" class="mumu"></div>
</div>
<iframe src="/test/樱花雨背景.html"></iframe>
<h1>${msg }</h1>
<ul>
    <li><a href="<c:url value='/index.jsp'/>"><h1>首页</h1></a></li>
    <li><a href="<c:url value='/jsps/user/login.jsp'/>"><h1>登录</h1></a></li>
    <li><a href="<c:url value='/jsps/user/regist.jsp'/>"><h1>注册</h1></a></li>
</ul>


</body>
</html>
