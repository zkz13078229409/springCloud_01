<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/9/8
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../../Style/skin.css" />
    <script type="text/javascript" src="../../../js/jquery.js"></script>
</head>
<%--ajax--%>
<script>

    function add() {
        alert("添加")
        var data = {};
        var t = $('#form1').serializeArray();
        $.each(t, function() {
            data [this.name] = this.value;
        });
        alert(JSON.stringify(data))

        $.ajax({
            url: "/student/addStudentServlet",
            type:"post",
            data:{"json1":JSON.stringify(data)},
            dataType: "text",
            success:function (data) {
                alert(data+"!\n"+"一秒后跳转到学生列表页！");
                setTimeout(function () {
                    location.href = "/studentSearchServlet/search?id=${user.id}&&thisPage=1";
                },1000);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        })
    }
    $(function () {
    })
</script>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <!-- 头部开始 -->
    <tr>
        <td width="17" valign="top" background="../../../imagess/mail_left_bg.gif">
            <img src="../../../imagess/left_top_right.gif" width="17" height="29" />
        </td>
        <td valign="top" background="../../../imagess/content_bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="./../../../imagess/content_bg.gif">
                <tr><td height="31"><div class="title">角色添加</div></td></tr>
            </table>
        </td>
        <td width="16" valign="top" background="../../../images/mail_right_bg.gif"><img src="../../../images/nav_right_bg.gif" width="16" height="29" /></td>
    </tr>
    <!-- 中间部分开始 -->
    <tr>
        <!--第一行左边框-->
        <td valign="middle" background="../../../images/mail_left_bg.gif">&nbsp;</td>
        <!--第一行中间内容-->
        <td valign="top" bgcolor="#F7F8F9">
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <!-- 空白行-->
                <tr><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
                <tr>
                    <td colspan="4">

                    </td>
                </tr>
                <!-- 一条线 -->
                <tr>
                    <td height="40" colspan="4">
                        <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                            <tr><td></td></tr>
                        </table>
                    </td>
                </tr>
                <!-- 角色修改开始 -->
                <tr>
                    <td width="2%">&nbsp;</td>
                    <td width="96%">
                        <table width="100%">
                            <tr>
                                <td colspan="2">
                                    <form action="##" method="post" onsubmit="return false" id="form1">
                                        <table width="100%"class="cont">
                                            <input type="text" style="display: none" name="stuId" value="1"  class="stuId">
                                            <tr>
                                                <td width="2%">&nbsp;</td>
                                                <td width="8%"><font color="red"><b>*</b></font>学生学号：</td>
                                                <td width="25%"><input  type="text"  name="stuNum" class="stuNum text"  placeholder="长度限制，必填，唯一" /></td>
                                                <td></td>
                                                <td width="2%">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <td width="2%">&nbsp;</td>
                                                <td><font color="red"><b>*</b></font>学生姓名：</td>
                                                <td><input class="text stuName"  type="text" name="stuName" placeholder="长度限制，必填，唯一" /></td>
                                                <td></td>
                                                <td width="2%">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <td width="2%">&nbsp;</td>
                                                <td><font color="red"><b>*</b></font>学生性别：</td>
                                                <td>
                                                    <input type="checkbox" name="sex" class="sex" value="男">男&nbsp;&nbsp;
                                                    <input type="checkbox" name="sex" class="sex" value="女">女
                                                </td>
                                                <td></td>
                                                <td width="2%">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <td width="2%">&nbsp;</td>
                                                <td><font color="red"><b>*</b></font>学生联系方式：</td>
                                                <td><input class="text phone" name="phone" type="text" placeholder="长度限制，必填，唯一" /></td>
                                                <td></td>
                                                <td width="2%">&nbsp;</td>
                                            </tr>

                                            <tr>
                                                <td>&nbsp;</td>
                                                <td colspan="2" align="center">
                                                    <input class="btn" onclick="add()" type="button" value="提交" />&nbsp;&nbsp;&nbsp;
                                                    <input class="btn"  type="reset" value="重置" />
                                                </td>
                                                <td></td>
                                                <td>&nbsp;</td>
                                            </tr>
                                        </table>
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td width="2%">&nbsp;</td>
                </tr>
                <!-- 角色修改结束 -->
                <tr>
                    <td height="40" colspan="4">
                        <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                            <tr><td></td></tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td width="2%">&nbsp;</td>
                    <td width="51%" class="left_txt">

                    </td>
                    <td>&nbsp;</td><td>&nbsp;</td>
                </tr>
            </table>
        </td>

        <td background="../../../images/mail_right_bg.gif">&nbsp;</td>
    </tr>
    <!-- 底部部分 -->
    <tr>
        <td valign="bottom" background="../../../images/mail_left_bg.gif">
            <img src="../../../images/buttom_left.gif" width="17" height="17" />
        </td>
        <td background="../../../images/buttom_bgs.gif">
            <img src="../../../images/buttom_bgs.gif" width="17" height="17">
        </td>
        <td valign="bottom" background="../../../images/mail_right_bg.gif">
            <img src="../../../images/buttom_right.gif" width="16" height="17" />
        </td>
    </tr>
</table>
</body>
</html>
