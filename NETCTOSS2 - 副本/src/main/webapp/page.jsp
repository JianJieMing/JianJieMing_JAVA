<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/15
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="pages">
    <a href="<%=request.getContextPath()%>/cost/findByPage?page=1">首页</a>
    <a href="<%=request.getContextPath()%>/cost/findByPage?page=${currentPage-1}">上一页</a>
    <%--<c:if test="${totalPage}!= 0  ">--%>
    <%--<c:forEach varStatus="i" begin="0" end="${totalPage-1}">--%>
    <%--&lt;%&ndash;<c:forEach items="${totalPage}" var="page">&ndash;%&gt;--%>
    <%--<a href="<%=request.getContextPath()%>/cost/findByPage?page=${i.count}">${i.count}</a>--%>
    <%--</c:forEach>--%>
    <%--</c:if>--%>

    <c:forEach begin="1" end="${totalPage}" var="i">
        <a href="<%=request.getContextPath()%>/cost/findByPage?page=${i}">${i}</a>
    </c:forEach>
    <a href="<%=request.getContextPath()%>/cost/findByPage?page=${currentPage+1}">下一页</a>
    <a href="<%=request.getContextPath()%>/cost/findByPage?page=${totalPage}">末页</a>
</div>

</body>
</html>
