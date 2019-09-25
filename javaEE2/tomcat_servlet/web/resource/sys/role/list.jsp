<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="../../../Style/skin.css" />
    <script type="text/javascript" src="../../../js/jquery.js"></script>

    <script type="text/javascript">
        function del(id) {
            var msg = "您确定要删除该学生信息吗？";
            if (confirm(msg)==true){
             $.ajax({
                 url: "/student/delStudentServlet",
                 type:"get",
                 data:{id:id},
                 dataType: "text",
                 async:false,
                 success:function (data) {

                     alert(data+"!\n"+"一秒后跳转到学生列表页！");
                     setTimeout(function () {
                         location.href = "/studentSearchServlet/search?id=${user.id}&&thisPage=1";
                     },1000);
                 },
                 error: function(XMLHttpRequest, textStatus, errorThrown) {
                     alert(3)
                     alert(XMLHttpRequest.status);
                     alert(XMLHttpRequest.readyState);
                     alert(textStatus);
                 }
             })
            }
        }



       $(function () {

           /*全选按钮逻辑*/
           $(".allChoice").change(function() {
               if($(this).prop("checked") == true) {
                   $(".xbox").each(function(i, v) {
                       $(this).prop("checked", "checked");
                   })
               } else {
                   $(".xbox").each(function(i, v) {
                       $(this).prop("checked", !$(this).prop("checked"));

                   })
               }
           });



           /*反选按钮*/
           $(".NoneChoice").change(function(){

               $(".xbox").each(function(){
                   $(this).prop("checked", !$(this).prop("checked"));
               })
           })
           /*批量删除*/
           $(".delNodes").click(function () {
               alert("批量");
               var datas=new Array();

               $("input[class='xbox']:checked").each(function (i,v) {
                   datas[i]=$(this).parent().next().text();
                   /*执行ajax*/
                   $.ajax({
                       url:"/student/delStudentServlet",
                       type:"get",
                       data:{id:datas[i]},
                       dataType:"text",
                       async:false,
                       // traditional: true,//这里设置为true
                       success:function (data) {

                       },
                       error: function(XMLHttpRequest, textStatus, errorThrown) {
                           alert(3)
                           alert(XMLHttpRequest.status);
                           alert(XMLHttpRequest.readyState);
                           alert(textStatus);
                       }
                   })

               })

               alert("删除成功"+"!\n"+"一秒后跳转到学生列表页！");
               setTimeout(function () {
                   location.href = "/studentSearchServlet/search?id=${user.id}&&thisPage=1";
               },1000);
           })


       })



    </script>
</head>
    <body>

    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!-- 头部开始 -->
        <tr>
            <td width="17" valign="top" background="../../../images/mail_left_bg.gif">
                <img src="../../../images/left_top_right.gif" width="17" height="29" />
            </td>
            <td valign="top" background="../../../images/content_bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="./../../../images/content_bg.gif">
                    <tr><td height="31"><div class="title">角色管理</div></td></tr>
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
                <table style="width:100%" width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <!-- 空白行-->
                    <tr><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
                    <tr>
                        <td colspan="4">
                            <form class="clearfix">
                                <div style="float:left">
                                    <p style="float:left; margin-left:30px;"><label>用户姓名：</label><input class="text" list="rolelist" style="width:80px;"/></p>&nbsp;&nbsp;&nbsp;

                                    <p style="float:left; margin-left:30px;"><input type="button" class="btn" value="查询"/></p>
                                    <p style="float:left; margin-left:30px;"><input type="button" class="btn delNodes" value="批量删除"/></p>
                                </div>
                                <div style="float:right">
                                    <input type="button" onclick='window.location="../resource/sys/role/add.jsp"' class="btn" value="角色添加"/>

                                </div>
                            </form>
                            <datalist id="rolelist">
                                <option></option>
                                <option></option>

                            </datalist>
                        <td>
                    </tr>
                    <!-- 一条线 -->
                    <tr>
                        <td height="40" colspan="4">
                            <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                <tr><td></td></tr>
                            </table>
                        </td>
                    </tr>
                    <!-- 列表展示开始 -->
                    <tr>
                        <td width="2%">&nbsp;</td>
                        <td width="96%">
                            <table width="100%">
                                <tr>
                                    <td colspan="2">
                                        <form action="" method="">
                                            <table width="100%"  class="cont tr_color">
                                                <tr>
                                                    <th>选择</th>
                                                    <th>Id</th>
                                                    <th>学生学号</th>
                                                    <th>学生名称</th>
                                                    <th>性别</th>
                                                    <th>联系方式</th>
                                                    <th>操作</th>
                                                </tr>
                                                <c:forEach items="${stuList}" var="stu">
                                                    <tr align="center" class="d">
                                                       <td><input  type="checkbox" name="checkbox" class="xbox"></td>
                                                        <td class="stuId">${stu.stuId}</td>
                                                        <td>${stu.stuNum}</td>
                                                        <td><a href="view.html">${stu.stuName}</a></td>
                                                        <td>${stu.sex}</td>
                                                        <td>${stu.phone}</td>

                                                        <td>

                                                            <a href="../resource/sys/role/edit.jsp?id=${stu.stuId}">修改学生信息</a>&nbsp;&nbsp;
                                                            <a href="" id="del" onclick="del(${stu.stuId})">删除学生信息</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>  <%----%>
                                                <%--   <tr align="center" class="d">
                                                   <td>1</td>
                                                   <td><input type="checkbox" value="" /></td>
                                                   <td><a href="view.html">系统管理员</a></td>
                                                   <td>综合部</td>
                                                   <td>2015-10-15</td>
                                                   <td>启用</td>
                                                   <td>
                                                       <a href="#">禁用</a>&nbsp;&nbsp;
                                                       <a href="role_authorise.html">授权</a>&nbsp;&nbsp;
                                                       <a href="edit.html">修改</a>&nbsp;&nbsp;
                                                       <a href="#" onclick="javascript:confirm('确定删除该角色吗？')">删除</a>
                                                   </td>
                                               </tr>
                                            <tr align="center" class="d">
                                                    <td>2</td>
                                                    <td><input type="checkbox" value="" /></td>
                                                    <td><a href="view.html">销售总监</a></td>
                                                    <td>市场发展部</td>
                                                    <td>2015-10-15</td>
                                                    <td>李诗诗</td>
                                                    <td>启用</td>
                                                    <td>
                                                        <a href="#">禁用</a>&nbsp;&nbsp;
                                                        <a href="role_authorise.html">授权</a>&nbsp;&nbsp;
                                                        <a href="edit.html">修改</a>&nbsp;&nbsp;
                                                        <a href="#" onclick="javascript:confirm('确定删除该角色吗？')">删除</a>
                                                    </td>
                                                </tr>

                                                <tr align="center" class="d">
                                                    <td>3</td>
                                                    <td><input type="checkbox" value="" /></td>
                                                    <td><a href="view.html">销售经理</a></td>
                                                    <td>市场发展部</td>
                                                    <td>2015-10-15</td>
                                                    <td>李诗诗</td>
                                                    <td>启用</td>
                                                    <td>
                                                        <a href="#">禁用</a>&nbsp;&nbsp;
                                                        <a href="role_authorise.html">授权</a>&nbsp;&nbsp;
                                                        <a href="edit.html">修改</a>&nbsp;&nbsp;
                                                        <a href="#" onclick="javascript:confirm('确定删除该角色吗？')">删除</a>
                                                    </td>
                                                </tr>
                                                <tr align="center" class="d">
                                                    <td>4</td>
                                                    <td><input type="checkbox" value="" /></td>
                                                    <td><a href="view.html">销售代表</a></td>
                                                    <td>市场发展部</td>
                                                    <td>2015-10-15</td>
                                                    <td>李诗诗</td>
                                                    <td>启用</td>
                                                    <td>
                                                        <a href="#">禁用</a>&nbsp;&nbsp;
                                                        <a href="role_authorise.html">授权</a>&nbsp;&nbsp;
                                                        <a href="edit.html">修改</a>&nbsp;&nbsp;
                                                        <a href="#" onclick="javascript:confirm('确定删除该角色吗？')">删除</a>
                                                    </td>
                                                </tr>
                                                <tr align="center" class="d">
                                                    <td>5</td>
                                                    <td><input type="checkbox" value="" /></td>
                                                    <td><a href="view.html">会计</a></td>
                                                    <td>账务科</td>
                                                    <td>2015-10-15</td>
                                                    <td>张山</td>
                                                    <td>禁用</td>
                                                    <td>
                                                        <a href="javascript:confirm('启用会计角色？');">启用</a>&nbsp;&nbsp;
                                                        <a href="role_authorise.html">授权</a>&nbsp;&nbsp;
                                                        <a href="edit.html">修改</a>&nbsp;&nbsp;
                                                        <a href="#" onclick="javascript:confirm('确定删除该角色吗？')">删除</a>
                                                    </td>
                                                </tr>--%>
                                            </table>
                                        </form>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td width="2%">&nbsp;</td>
                    </tr>
                    <!--列表展示结束 -->
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
                            <input type="checkbox" class="allChoice" value="全选" />全选&nbsp;&nbsp;&nbsp;
                            <input type="checkbox" class="NoneChoice" value="反选" />反选
                            <div style="float:right;">
                                <b>
                                    <c:if test="${currentPage==1}">
                                        首页&nbsp;&nbsp;&nbsp;
                                        上一页&nbsp;&nbsp;&nbsp;
                                        &lt;&lt;&nbsp;&nbsp;&nbsp;
                                    </c:if>
                                    <c:if test="${currentPage>1}">
                                        <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=1&&id=${user.id}&&ram="+new Date()>首页</a>&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=${currentPage-1}&&id=${user.id}&&ram="+new Date()>上一页</a>&nbsp;&nbsp;&nbsp;
                                        &lt;&lt;&nbsp;&nbsp;&nbsp;
                                    </c:if>
                                    <c:if test="${currentPage<10}">
                                        <c:forEach var="i" begin="1" end="${pagesCount}">
                                            <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=${i}&&id=${user.id}&&ram="+new Date()>${i}</a>&nbsp;&nbsp;&nbsp;
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${currentPage>10}">
                                        <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=1&&id=${user.id}&&ram="+new Date()>1</a>&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=2&&id=${user.id}&&ram="+new Date()>2</a>&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=3&&id=${user.id}&&ram="+new Date()>3</a>&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=4&&id=${user.id}&&ram="+new Date()>4</a>&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=5&&id=${user.id}&&ram="+new Date()>5</a>&nbsp;&nbsp;&nbsp;
                                        ....
                                        <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=${pagesCount-3}&&id=${user.id}&&ram="+new Date()>${pagesCount-3}</a>&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=${pagesCount-2}&&id=${user.id}&&ram="+new Date()>${pagesCount-2}</a>&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=${pagesCount-1}&&id=${user.id}&&ram="+new Date()>${pagesCount-1}</a>&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=${pagesCount}&&id=${user.id}&&ram="+new Date()>${pagesCount}</a>&nbsp;&nbsp;&nbsp;
                                    </c:if>
                                    <c:if test="${currentPage<pagesCount}">
                                        &gt;&gt;&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=${currentPage+1}&&id=${user.id}">下一页</a>&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/studentSearchServlet/search?thisPage=${pagesCount}&&id=${user.id}">尾页</a>&nbsp;&nbsp;&nbsp;
                                    </c:if>
                                    <c:if test="${currentPage==pagesCount}">
                                        &gt;&gt;&nbsp;&nbsp;&nbsp;
                                        下一页&nbsp;&nbsp;&nbsp;
                                        尾页&nbsp;&nbsp;&nbsp;
                                    </c:if>
                                    每页显示${num}条&nbsp;&nbsp;&nbsp;
                                    当前 ${currentPage}/${pagesCount} 页&nbsp;&nbsp;&nbsp;
                                    共${totalPagesNum}条
                                </b>
                            </div>
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