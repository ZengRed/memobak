<%@ page language="java" pageEncoding="UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://www.extremecomponents.org" prefix="ec" %>
<html>
	<head>
		<title>用户列表</title>
		<link href="${pageContext.request.contextPath}/css/extremecomponents.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/js/select.js"></script> 
		<script language="javascript">
			function doSubmit() {
				if(!hasChecked(subForm.username)) {
					alert("请选择需要删除的用户!");
					return false;
				} else {
					if(!confirm("您确定要删除吗?")) {
						return false;
					} else {
						subForm.submit();
					}
				}
			}
		</script>
	</head>
	<body>
		<h2 align="center">用户列表</h2>
		<form name="subForm" method="post" action="${pageContext.request.contextPath}/deleteUserAction.action">
			<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1">
		        <tr>
		   			<td>
		                <input type="checkbox" name="checkbox2" 
		                	onclick="checkboxselect(document.subForm.username, document.subForm.checkbox2.checked)" style="border:0px"/>
		                   全选
		                <input type="button" name="delall" value="删除所选" onclick='doSubmit();'/>
		   			</td>
		   		</tr>
		        <tr> 
		          <td height="74">
		          	<table width="100%"  border="0">
		          		<tr>
		          			<td>
							    <ec:table
									items="userList" 
									action="?"
									imagePath = "${pageContext.request.contextPath}/images/ec/*.gif"
								    cellpadding = "1" 
								    width = "100%" 
								    locale = "zh_CN"
								    sortable="false"
								    var = "user"
								    filterable = "false"
								    form="subForm">
									<ec:row highlightRow="true">
										<ec:column property="checkbox" title="选择" width="30" sortable="false">
						           			<input type="checkbox" name="username" value="${user.username}" style="border:0px"/>
						       			</ec:column>
										<ec:column property="username" title="用户名" width="60"/>
										<ec:column property="gender" title="性别" width="60">
											<script>
				                                <!--
				                                var gender = '${user.gender}';
				                                if(gender=='0') { 
				                                   document.write('女');
				                                } else {
				                                	document.write('男');
				                                }
				                                //-->
			                            	</script>   
										</ec:column>
										<ec:column property="birthDate" title="出生日期" width="120" cell="date" format="yyyy-MM-dd"/>
										<ec:column property="tel" title="电话" width="70"/>
										<ec:column property="email" title="Email" width="120"/>
										<ec:column property="createTime" title="创建时间" width="150" cell="date" format="yyyy-MM-dd HH:mm:ss"/>
										<ec:column property="description" title="描述" width="200"/>
										<ec:column property="操作" style="text-align:center" filterable="false" width="*">
											<a href="${pageContext.request.contextPath}/initUpdateUserAction.action?username=${user.username}">
												<img src="${pageContext.request.contextPath}/images/ec/edit.gif" border="0" alt="修改">
											</a>
						                 </ec:column>
						             </ec:row>
								</ec:table>
							</td>
						</tr>
					</table>
		          </td>
		      </tr>
		    </table>
		</form>
		<table width="98%" align="center" border="0" cellpadding="4"
		cellspacing="1">
		<tr>
			<td><input type="button" name="back" value="返回"
				onclick="window.location.href='${pageContext.request.contextPath}/loginUserAction.action'" />
			</td>
		</tr>
	</table>
	</body>
</html>
