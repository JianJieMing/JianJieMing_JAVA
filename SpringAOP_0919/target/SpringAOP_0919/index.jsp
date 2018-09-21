<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>

<form action="/books/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="bookImage">
    <input type="submit" value="上传">
</form>

</body>
</html>
