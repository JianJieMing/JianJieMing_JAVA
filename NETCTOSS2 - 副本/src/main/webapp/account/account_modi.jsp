<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/13
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>云科技</title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"/>
    <script language="javascript" type="text/javascript">
        //保存成功的提示信息
        function showResult() {
            showResultDiv(true);
            window.setTimeout("showResultDiv(false);", 3000);
        }

        function showResultDiv(flag) {
            var divResult = document.getElementById("save_result_info");
            if (flag)
                divResult.style.display = "block";
            else
                divResult.style.display = "none";
        }

        //显示修改密码的信息项
        function showPwd(chkObj) {
            if (chkObj.checked)
                document.getElementById("divPwds").style.display = "block";
            else
                document.getElementById("divPwds").style.display = "none";
        }
    </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <img src="../images/logo.png" alt="logo" class="left"/>
    <a href="/login.html">[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
    <c:import url="../showModule.jsp"/>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <!--保存成功或者失败的提示消息-->
    <div id="save_result_info" class="save_fail">保存失败，旧密码错误！</div>
    <form action="<%=request.getContextPath()%>/account/updateOne" method="post" class="main_form">
        <!--必填项-->
        <div class="text_info clearfix"><span>账务账号ID：</span></div>
        <div class="input_info">
            <input type="text" name="accountId" value="${accounts.accountId}" readonly class="readonly"/>
        </div>
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info">
            <input type="text" name="realName" value="${accounts.realName}"/>
            <span class="required">*</span>
            <div class="validate_msg_long error_msg">20长度以内的汉字、字母和数字的组合</div>
        </div>
        <div class="text_info clearfix"><span>身份证：</span></div>
        <div class="input_info">
            <input type="text" name="idcardNo" value="${accounts.idcardNo}" readonly class="readonly"/>
        </div>
        <div class="text_info clearfix"><span>登录账号：</span></div>
        <div class="input_info">
            <input type="text" name="loginName" value="${accounts.loginName}" readonly class="readonly"/>
            <!--
            <div class="change_pwd">
                <input id="chkModiPwd" type="checkbox" onclick="showPwd(this);" />
                <label for="chkModiPwd">修改密码</label>
            </div>
            -->
        </div>
        <!--修改密码部分-->
        <!--
        <div id="divPwds">
            <div class="text_info clearfix"><span>旧密码：</span></div>
            <div class="input_info">
                <input type="password"  />
                <span class="required">*</span>
                <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
            </div>
            <div class="text_info clearfix"><span>新密码：</span></div>
            <div class="input_info">
                <input type="password"  />
                <span class="required">*</span>
                <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
            </div>
            <div class="text_info clearfix"><span>重复新密码：</span></div>
            <div class="input_info">
                <input type="password"  />
                <span class="required">*</span>
                <div class="validate_msg_long">两次密码必须相同</div>
            </div>
        </div>
        -->
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input type="text" name="telephone" value="${accounts.telephone}" class="width200"/>
            <span class="required">*</span>
            <div class="validate_msg_medium error_msg">正确的电话号码格式：手机或固话</div>
        </div>
        <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
        <div class="input_info">
            <input type="text" name="recommenderId" value="${accounts.recommenderId}"/>
            <div class="validate_msg_long error_msgs">正确的身份证号码格式</div>
        </div>
        <div class="text_info clearfix"><span>生日：</span></div>
        <div class="input_info">
            <input type="text" name="birthdate" value="${accounts.birthdate}"/>
        </div>
        <div class="text_info clearfix"><span>Email：</span></div>
        <div class="input_info">
            <input type="text" name="email" value="${accounts.email}" class="width200"/>
            <div class="validate_msg_medium">50长度以内，合法的 Email 格式</div>
        </div>
        <div class="text_info clearfix"><span>职业：</span></div>
        <div class="input_info">
            <select>
                <c:if test="${accounts.occupation == '干部' }">
                    <option>干部</option>
                </c:if>
                <c:if test="${accounts.occupation == '学生' }">
                    <option>学生</option>
                </c:if>
                <c:if test="${accounts.occupation == '技术人员' }">
                    <option>技术人员</option>
                </c:if>
                <c:if test="${accounts.occupation == '其他' }">
                    <option>其他</option>
                </c:if>

            </select>
        </div>
        <div class="text_info clearfix"><span>性别：</span></div>
        <div class="input_info fee_type">
            <c:if test="${accounts.gender == '' }">
                <input type="radio" name="gender" value="女" id="female" onclick="feeTypeChange(1);"/>
                <label for="female">女</label>
                <input type="radio" name="gender" value="男" id="male" onclick="feeTypeChange(2);"/>
                <label for="male">男</label>
            </c:if>
            <c:if test="${accounts.gender == '男' }">
                <input type="radio" name="gender" value="女" id="female" onclick="feeTypeChange(1);"/>
                <label for="female">女</label>
                <input type="radio" name="gender" value="男" checked="checked" id="male" onclick="feeTypeChange(2);"/>
                <label for="male">男</label>
            </c:if>
            <c:if test="${accounts.gender == '女' }">
                <input type="radio" name="gender" value="女" checked="checked" id="female" onclick="feeTypeChange(1);"/>
                <label for="female">女</label>
                <input type="radio" name="gender" value="男" id="male" onclick="feeTypeChange(2);"/>
                <label for="male">男</label>
            </c:if>
        </div>


        <div class="text_info clearfix"><span>通信地址：</span></div>
        <div class="input_info">
            <input type="text" name="mailaddress" value="${accounts.mailaddress}" class="width350"/>
            <div class="validate_msg_tiny">50长度以内</div>
        </div>
        <div class="text_info clearfix"><span>邮编：</span></div>
        <div class="input_info">
            <input type="text" name="zipcode" value="${accounts.zipcode}"/>
            <div class="validate_msg_long">6位数字</div>
        </div>
        <div class="text_info clearfix"><span>QQ：</span></div>
        <div class="input_info">
            <input type="text" name="qq" value="${accounts.qq}"/>
            <div class="validate_msg_long">5到13位数字</div>
        </div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input type="submit" value="保存" class="btn_save"/>
            <input type="button" value="取消" class="btn_save" onclick="location.href='<%=request.getContextPath()%>/account/findByPage'"/>
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
