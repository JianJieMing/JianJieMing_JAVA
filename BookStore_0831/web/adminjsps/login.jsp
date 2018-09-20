<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>管理员登录页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="/js/canvas-particle.js"></script>

    <style>
        span {
            color: #ff0326;
        }
    </style>
</head>

<body class="container" style="background-color: #191919">
<center><h1><span>管理员登录页面</span></h1></center>
<hr/>
<%--<p style="font-weight: 900; color: red">${msg }</p>--%>
<form action="/admin.login" method="post" class="container">
    <span>管理员账户：</span><input type="text" name="adminname" class="form-control" placeholder="Username"
                              aria-describedby="sizing-addon3"/><br/>
    <span>密　　　码：</span><input type="password" name="password" class="form-control" placeholder="Password"
                              aria-describedby="sizing-addon3"/><br/>
    <input type="submit" value="进入后台" class="btn btn-primary"/>
</form>
<div style="text-align:center;clear:both"></div>
<div id="mydiv">
    <script type="text/javascript">
        window.onload = function () {
            //配置
            var config = {
                vx: 4,	//小球x轴速度,正为右，负为左
                vy: 4,	//小球y轴速度
                height: 2,	//小球高宽，其实为正方形，所以不宜太大
                width: 2,
                count: 500,		//点个数
                color: "121, 162, 185", 	//点颜色
                stroke: "130,255,255", 		//线条颜色
                dist: 6000, 	//点吸附距离
                e_dist: 20000, 	//鼠标吸附加速距离
                max_conn: 10 	//点到点最大连接数
            };
            //调用
            CanvasParticle(config);
        }
    </script>
    <script type="text/javascript" src="/js/canvas-particle.js"></script>
</div>
</body>
</html>
