<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/15
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>云科技</title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <img src="../images/logo.png" alt="logo" class="left"/>
    <a href="#">[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
    <c:import url="../showModule.jsp"/>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="" method="" class="main_form">
        <!--必填项-->
        <div class="text_info clearfix"><span>账务账号ID：</span></div>
        <div class="input_info"><input type="text" value="${account.accountId}" readonly class="readonly"/></div>
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info"><input type="text" value="${account.realName}" readonly class="readonly"/></div>
        <div class="text_info clearfix"><span>身份证：</span></div>
        <div class="input_info">
            <input type="text" value="${account.idcardNo}" readonly class="readonly"/>
        </div>
        <div class="text_info clearfix"><span>登录账号：</span></div>
        <div class="input_info">
            <input type="text" value="${account.loginName}" readonly class="readonly"/>
        </div>
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input type="text" class="width200 readonly" readonly value="${account.telephone}"/>
        </div>
        <div class="text_info clearfix"><span>推荐人账务账号ID：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="${account.recommenderId}"/></div>
        <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="230198765432123456"/></div>
        <div class="text_info clearfix"><span>状态：</span></div>
        <div class="input_info">
            <select class="select_search">
                <c:if test="${account.status == 0}">
                    <option>暂停</option>
                    <option>开通</option>
                </c:if>
                <c:if test="${account.status == 1}">
                    <option>开通</option>
                    <option>暂停</option>
                </c:if>
            </select>

        </div>
        <div class="text_info clearfix"><span>开通/暂停/删除时间：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="${account.pauseDate}"/></div>

        <div class="text_info clearfix"><span>上次登录时间：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="${account.lastLoginTime}"/></div>
        <div class="text_info clearfix"><span>上次登录IP：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="${account.lastLoginIp}"/></div>
        <!--可选项数据-->
        <div class="text_info clearfix"><span>生日：</span></div>
        <div class="input_info">
            <input type="text" readonly class="readonly" value="${account.birthdate}"/>
        </div>
        <div class="text_info clearfix"><span>Email：</span></div>
        <div class="input_info">
            <input type="text" class="width350 readonly" readonly value="${account.email}"/>
        </div>
        <div class="text_info clearfix"><span>职业：</span></div>
        <div class="input_info">

            <select class="select_search">
                <c:if test="${account.occupation == '干部' }">
                    <option>干部</option>
                    <option>学生</option>
                    <option>技术人员</option>
                    <option>其他</option>
                </c:if>
                <c:if test="${account.occupation == '学生' }">
                    <option>学生</option>
                    <option>技术人员</option>
                    <option>其他</option>
                    <option>干部</option>
                </c:if>
                <c:if test="${account.occupation == '技术人员' }">
                    <option>技术人员</option>
                    <option>其他</option>
                    <option>干部</option>
                    <option>学生</option>
                </c:if>
                <c:if test="${account.occupation == '其他' }">
                    <option>其他</option>
                    <option>干部</option>
                    <option>学生</option>
                    <option>技术人员</option>
                </c:if>
            </select>
        </div>
        <div class="text_info clearfix"><span>性别：</span></div>
        <div class="input_info fee_type">
            <c:if test="${account.gender == '女'}">
                <input type="radio" name="radSex" checked="checked" id="female" />
                <label for="female">女</label>
                <input type="radio" name="radSex" id="male" />
                <label for="male">男</label>
            </c:if>
            <c:if test="${account.gender == '男'}">
                <input type="radio" name="radSex" id="female" />
                <label for="female">女</label>
                <input type="radio" name="radSex" checked="checked" id="male" />
                <label for="male">男</label>
            </c:if>

        </div>
        <div class="text_info clearfix"><span>通信地址：</span></div>
        <div class="input_info"><input type="text" class="width350 readonly" readonly value="${account.mailaddress}"/>
        </div>
        <div class="text_info clearfix"><span>邮编：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${account.zipcode}"/></div>
        <div class="text_info clearfix"><span>QQ：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${account.qq}"/></div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input type="button" value="返回" class="btn_save"
                   onclick="location.href='<%=request.getContextPath()%>/account/findByPage'"/>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
    <br/>
    <span>版权所有(C)云科技有限公司 </span>
</div>

</body>
</html>
