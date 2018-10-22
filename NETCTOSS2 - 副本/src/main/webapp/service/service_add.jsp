<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/15
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <script src="../js/jquery-3.2.1.js"></script>
    <script src="../js/jquery.validate.js"></script>
    <script src="../js/messages_zh.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>
    <script language="javascript" type="text/javascript"></script>
    <script>
        // IP地址验证
        // IP地址验证
        jQuery.validator.addMethod("ip", function(value, element) {
            return this.optional(element) || /^(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.)(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.){2}([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))$/.test(value);
        }, "请填写正确的IP地址。");

        function isIdCardNo(num) {

            var factorArr = new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1);
            var parityBit=new Array('1','0','X','9','8','7','6','5','4','3','2');
            var varArray = new Array();
            var intValue;
            var lngProduct = 0;
            var intCheckDigit;
            var intStrLen = num.length;
            var idNumber = num;
// initialize
            if ((intStrLen != 15) && (intStrLen != 18)) {
                return false;
            }
// check and set value
            for(i=0;i<intStrLen;i++) {
                varArray[i] = idNumber.charAt(i);
                if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
                    return false;
                } else if (i < 17) {
                    varArray[i] = varArray[i] * factorArr[i];
                }
            }

            if (intStrLen == 18) {
//check date
                var date8 = idNumber.substring(6,14);
                if (isDate8(date8) == false) {
                    return false;
                }
// calculate the sum of the products
                for(i=0;i<17;i++) {
                    lngProduct = lngProduct + varArray[i];
                }
// calculate the check digit
                intCheckDigit = parityBit[lngProduct % 11];
// check last digit
                if (varArray[17] != intCheckDigit) {
                    return false;
                }
            }
            else{ //length is 15
//check date
                var date6 = idNumber.substring(6,12);
                if (isDate6(date6) == false) {

                    return false;
                }
            }
            return true;

        }
        // 身份证号码验证
        jQuery.validator.addMethod('idcardno', function(value, element) {
            return this.optional(element) || isIdCardNo(value);
        }, '请正确输入身份证号码');

        $().ready(function () {
            $('#ss').validate({
                rules: {
                    password1: {
                        required: true,
                        minlength: 6
                    },
                    password2: {
                        required: true,
                        minlength: 6,
                        equalTo: '#loginPasswd'
                    },
                    osUsername: {
                        required: true,
                        minlength: 2,
                        maxlength: 15,
                    },
                    unixHost: {
                        required: true,
                        minlength: 12,
                        ip: true
                    },
                    loginName: {
                        required: true
                    },
                    idcardno: {
                        idcardno: true
                    },
                },
                messages: {
                    password1: {
                        required: '必填字段',
                        minlength: '最少需要六个字符'
                    },
                    password2: {
                        required: '必填字段',
                        minlength: '最少需要六个字符',
                        equalTo: '密码不一致'
                    },
                    osUsername: {
                        required: '必填字段',
                        minlength: '最少需要两个字符',
                        maxlength: '最多15个字符'
                    },
                    unixHost: {
                        required: '必填字段',
                        minlength: '最少需要12个字符',
                        ip: "ip地址不正确"
                    },
                    loginName: {
                        required: '必填字段'
                    },
                    idcardno: {
                        idcardno: '身份证格式不正确'
                    }
                }
            })
        })
    </script>

    <style>
        .error {
            color: #ff0214;
        }
    </style>
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
    <ul id="menu">
        <li><a href="<%=request.getContextPath()%>/admin/showModule" class="index_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/role/role_list" class="role_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/admin/admin_list" class="admin_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/cost/findAll" class="fee_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/account/findAll" class="account_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/service/service_list" class="service_on"></a></li>
        <li><a href="../bill/bill_list.jsp" class="bill_off"></a></li>
        <li><a href="../report/report_list.jsp" class="report_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/informationcontroller/selectAll" class="information_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/user/user_modi_pwd.jsp" class="password_off"></a></li>
    </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <!--保存操作的提示信息-->
    <form id="ss" class="main_form">
        <!--内容项-->
        <div class="text_info clearfix"><span>身份证：</span></div>
        <div class="input_info">
            <input id="idcardNo" type="text" value="" class="width180"/>
            <input name="idcardno" id="queryAccount" type="button" value="查询账务账号" class="btn_search_large" required/>
        </div>
        <div class="text_info clearfix"><span>账务账号：</span></div>
        <div class="input_info">
            <input id="loginName" name="loginName" type="text" value=""/>
        </div>
        <div class="text_info clearfix"><span>资费类型：</span></div>
        <div class="input_info">
            <select id="costName">

            </select>
        </div>
        <div class="text_info clearfix"><span>服务器 IP：</span></div>
        <div class="input_info">
            <input id="unixHost" name="unixHost" type="text" value=""/>
        </div>
        <div class="text_info clearfix"><span>登录 OS 账号：</span></div>
        <div class="input_info">
            <input id="osUsername" type="text" name="osUsername"/>
        </div>
        <div class="text_info clearfix"><span>密码：</span></div>
        <div class="input_info">
            <input id="loginPasswd" name="password1" type="password"/>
        </div>
        <div class="text_info clearfix"><span>重复密码：</span></div>
        <div class="input_info">
            <input type="password" name="password2"/>
        </div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input id="save" type="button" value="保存" class="btn_save" onclick="validation()"/>
            <input type="button" value="取消" class="btn_save"/>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
    <br/>
    <span>版权所有(C)云科技有限公司 </span>
</div>

<script>

    var accountId;

    $(function () {

        $.ajax({
            typ: "GET",
            url: "queryCostName",
            dataType: "json",
            success: function (resp) {
                var costNames = $('#costName');
                for (var item of resp) {
                    var costName = $('<option></option>').text(item.name).val(item.costId);
                    costNames.append(costName);
                }
            }
        });


        $('#queryAccount').click(function () {
            var idcardNo = $('#idcardNo').val();
            var data = {
                "idcardNo": idcardNo
            };
            var setting = {
                url: 'queryIdCardNo',
                method: 'post',
                headers: {
                    'Content-Type': 'application/json'
                },
                // 把对象转出json数据.
                data: JSON.stringify(data)
            };
            $.ajax(setting).done(function (resp) {
                var loginName = $('#loginName').val(resp.loginName);
                accountId = resp.accountId;
            });
        });


    });

    function validation() {
        var flag = $("#ss").valid();
        if (!flag) {
            return;
        } else {
            var name = $('#costName').val();
            var osUsername = $('#osUsername').val();
            var loginPasswd = $('#loginPasswd').val();
            var unixHost = $('#unixHost').val();
            var costId = $('#costName').val();

            var data = {
                "accountId": accountId,
                "costId": costId,
                "name": name,
                "osUsername": osUsername,
                "loginPasswd": loginPasswd,
                "unixHost": unixHost
            };
            var setting = {
                url: "insertServiceCost",
                method: "post",
                headers: {
                    "Content-Type": 'application/json'
                },
                data: JSON.stringify(data)
            };
            $.ajax(setting).done(function () {
                location.href = "/service/service_list"
            })
        }
    }


</script>

</body>
</html>
