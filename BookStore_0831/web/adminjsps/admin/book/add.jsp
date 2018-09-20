<%@ page language="java" import="category.domain.Category" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>添加图书</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <style type="text/css">
        body {
            background: rgb(254, 238, 189);
        }
    </style>
</head>

<body>
<h1>添加图书</h1>
<p style="font-weight: 900; color: red">${msg }</p>
<form action="addBook.do" method="post" enctype="multipart/form-data">
    图书名称：<input style="width: 150px; height: 20px;" type="text" name="bname"/><br/>
    图书图片：<input style="width: 223px; height: 20px;" type="file" name="image"/><br/>
    图书单价：<input style="width: 150px; height: 20px;" type="text" name="price" value="1"
                onkeyup="value=(parseInt((value=value.replace(/\D/g,''))==''||parseInt((value=value.replace(/\D/g,''))==0)?'1':value,10))"/><br/>
    图书作者：<input style="width: 150px; height: 20px;" type="text" name="author"/><br/>
    图书分类：<select style="width: 150px; height: 20px;" name="cid">

    <%
        List<Category> categoryList = (List<Category>) request.getAttribute("categoryList");

        for (Category category : categoryList) {

    %>
    <option value="<%=category.getCid()%>"><%=category.getCname()%>
    </option>
    <%
        }
    %>
</select>
    <br/>
    <input id="inp1" type="submit" value="添加图书" onclick="confirm('添加成功!')"/>
</form>

</body>
</html>
