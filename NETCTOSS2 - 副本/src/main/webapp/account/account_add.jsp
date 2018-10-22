<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/13
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>
    <script src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
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


    </script>
    <script>
        //显示选填的信息项
        function showOptionalInfo(imgObj) {
            var div = document.getElementById("optionalInfo");
            if (div.className === "hide") {
                div.className = "show";
                imgObj.src = "../images/hide.png";
            }
            else {
                div.className = "hide";
                imgObj.src = "../images/show.png";
            }
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
    <div id="save_result_info" class="save_fail">保存失败，该身份证已经开通过账务账号！</div>
    <form action="<%=request.getContextPath()%>/account/insertOne" method="post">
        <!--必填项-->
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info">
            <input id="inp1" type="text" name="realName" value=""/>
            <span class="required">*</span>
            <div class="validate_msg_long">
                <span id="span1" style="display: none;color: red">5长度以内的汉字、字母和数字的组合</span>
            </div>
        </div>
        <div class="text_info clearfix"><span>身份证：</span></div>
        <div class="input_info">
            <input id="inp2" type="text" name="idcardNo" value=""/>
            <span class="required">*</span>
            <div class="validate_msg_long">
                <span id="span2" style="display: none;color:red;">正确的身份证号码格式</span>
            </div>
        </div>
        <div class="text_info clearfix"><span>登录账号：</span></div>
        <div class="input_info">
            <input id="inp3" type="text" name="loginName" value=""/>
            <span class="required">*</span>
            <div class="validate_msg_long">
                <span id="span3" style="display: none;color: red">10长度以内的字母、数字和下划线的组合</span>
            </div>
        </div>
        <div class="text_info clearfix"><span>密码：</span></div>
        <div class="input_info">
            <input id="inp4" value="" type="password" name="loginPasswd"/>
            <span class="required">*</span>
            <div class="validate_msg_long">
                <span id="span4" style="display: none;color: red">10长度以内的字母、数字和下划线的组合</span>
            </div>
        </div>
        <div class="text_info clearfix"><span>重复密码：</span></div>
        <div class="input_info">
            <input id="inp5" value="" type="password"/>
            <span class="required">*</span>
            <div class="validate_msg_long">
                <span id="span5" style="display: none;color: red">两次密码必须相同</span>
            </div>
        </div>
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input id="inp6" type="text" name="telephone" class="width200"/>
            <span class="required">*</span>
            <div class="validate_msg_medium">
                <span id="span6" style="display: none;color: red">正确的电话号码格式：手机或固话</span>
            </div>
        </div>
        <!--可选项-->
        <div class="text_info clearfix"><span>可选项：</span></div>
        <div class="input_info">
            <img src="../images/show.png" alt="展开" onclick="showOptionalInfo(this);"/>
        </div>
        <div id="optionalInfo" class="hide">
            <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
            <div class="input_info">
                <input id="inp7" type="text" value="412702188608076551"/>
                <div class="validate_msg_long">
                    <span id="span7" style="display: none;color: red">正确的身份证号码格式</span>
                </div>
            </div>
            <div class="text_info clearfix"><span>生日：</span></div>
            <div class="input_info">
                <input id="birthdate" type="text" name="birthdate"/>
            </div>
            <div class="text_info clearfix"><span>Email：</span></div>
            <div class="input_info">
                <input id="inp8" type="text" name="email" class="width350"/>
                <div class="validate_msg_tiny">
                    <span id="span8" style="display: none;color: red">合法的 Email 格式</span>
                </div>
            </div>
            <div class="text_info clearfix"><span>职业：</span></div>
            <div class="input_info">
                <select name="occupation">
                    <option>干部</option>
                    <option>学生</option>
                    <option>技术人员</option>
                    <option>其他</option>
                </select>
            </div>
            <div class="text_info clearfix"><span>性别：</span></div>
            <div class="input_info fee_type">
                <input type="radio" name="gender" value="女" id="female"/>
                <label for="female">女</label>
                <input type="radio" name="gender" value="男" id="male"/>
                <label for="male">男</label>
            </div>
            <div class="text_info clearfix"><span>通信地址：</span></div>
            <div class="input_info">
                <input id="inp9" type="text" name="mailaddress" class="width350"/>
                <div class="validate_msg_tiny">
                    <span id="span9" style="display: none;color: red">10长度以内</span>
                </div>
            </div>
            <div class="text_info clearfix"><span>邮编：</span></div>
            <div class="input_info">
                <input id="inp11" type="text" name="zipcode"/>
                <div class="validate_msg_long">
                    <span id="span11" style="display: none;color: red




">6位数字</span>
                </div>
            </div>
            <div class="text_info clearfix"><span>QQ：</span></div>
            <div class="input_info">
                <input id="inp12" type="text" name="qq"/>
                <div class="validate_msg_long">
                    <span id="span12" style="display: none;color:red;">5到13位数字</span>
                </div>
            </div>
        </div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input type="submit" value="保存" class="btn_save"/>
            <input type="button" value="取消" class="btn_save"
                   onclick="location.href='<%=request.getContextPath()%>/account/findByPage'"/>
        </div>
    </form>
</div
>

<!--主要区域结束-->
<div id="footer">
    <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
    <br/>
    <span>版权所有(C)云科技有限公司 </span>
</div>
<script>

    $(function () {
        $('#inp1').blur(function () {
            var r1 = /^[a-zA-Z0-9u4E00-u9FA5_]{5}/;
            var inp1 = $('#inp1').val();
            if (!r1.test(inp1)) {
                $('#span1').css("display", 'inline')
            }
            if (r1.test(inp1)) {
                $('#span1').css("display", 'none')
            }
        });

        $('#inp2').blur(function () {
            var r2 = /^\d{15}|\d{18}$/;
            var inp2 = $('#inp2').val();
            if (!r2.test(inp2)) {
                $('#span2').css("display", 'inline')
            }
            if (r2.test(inp2)) {
                $('#span2').css("display", 'none')
            }
            var a = $('#inp2').val().substr(6,8);
            var year = a.substr(0, 4);
            var month = a.substr(4, 2);
            var day = a.substr(6, 2);
            var birthdate = year.concat('-').concat(month).concat('-').concat(day);
            $('#birthdate').val(birthdate);
            console.log(birthdate);

        });

        $('#inp3').blur(function () {
            var r3 = /^[a-zA-Z0-9u4E00-u9FA5_]{0,10}/;
            var inp3 = $('#inp3').val();
            if (!r3.test(inp3)) {
                $('#span3').css("display", 'inline')
            }
            if (r3.test(inp3)) {
                $('#span3').css("display", 'none')
            }
        });

        $('#inp4').blur(function () {
            var r4 = /^[a-zA-Z0-9u4E00-u9FA5_]{0,10}/;
            var inp4 = $('#inp4').val();
            if (!r4.test(inp4)) {
                $('#span4').css("display", 'inline')
            }
            if (r4.test(inp4)) {
                $('#span4').css("display", 'none')
            }
        });

        $('#inp5').blur(function () {
            var password1 = $('#inp4').val();
            console.log(password1);
            var password2 = $('#inp5').val();
            console.log(password2);
            if (password1 === password2) {
                $('#span5').css("display", 'none')
            } else {
                $('#span5').css("display", 'inline')
            }
        })

        $('#inp6').blur(function () {
            var r6 = /^[1][34578][0-9]{9}$/;
            var inp6 = $('#inp6').val();
            if (!r6.test(inp6)) {
                $('#span6').css("display", 'inline')
            }
            if (r6.test(inp6)) {
                $('#span6').css("display", 'none')
            }
        });

        $('#inp7').blur(function () {
            var r7 = /^\d{15}|\d{18}$/;
            var inp7 = $('#inp7').val();
            if (!r7.test(inp7)) {
                $('#span7').css("display", 'inline')
            }
            if (r7.test(inp7)) {
                $('#span7').css("display", 'none')
            }
        });

        $('#inp8').blur(function () {
            var r8 = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
            var inp8 = $('#inp8').val();
            if (!r8.test(inp8)) {
                $('#span8').css("display", 'inline')
            }
            if (r8.test(inp8)) {
                $('#span8').css("display", 'none')
            }
        });

        $('#inp9').blur(function () {
            var r9 = /^[\u4e00-\u9fa5]{5,10}/;
            var inp9 = $('#inp9').val();
            if (!r9.test(inp9)) {
                $('#span9').css("display", 'inline')
            }
            if (r9.test(inp9)) {
                $('#span9').css("display", 'none')
            }
        });

        $('#inp11').blur(function () {
            var r11 = /^[0-9]{6}/;
            var inp11 = $('#inp11').val();
            if (!r11.test(inp11)) {
                $('#span11').css("display", 'inline')
            }
            if (r11.test(inp11)) {
                $('#span11').css("display", 'none')
            }
        });
        $('#inp12  ').blur(function () {
            var r12 = /^[1-9][0-9]{5,13}/;
            var inp12 = $('#inp12').val();
            if (!r12.test(inp12)) {
                $('#span12').css("display", 'inline')
            }
            if (r12.test(inp12)) {
                $('#span12').css("display", 'none')
            }
        });

    })
</script>

</body>
</html>
