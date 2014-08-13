<%@ page language="java" pageEncoding="UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://www.extremecomponents.org" prefix="ec" %>
<html>
	<head>
		<title>备忘类型列表</title>
		<link href="${pageContext.request.contextPath}/css/extremecomponents.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/js/select.js"></script> 
		<script language="javascript">
			function doSubmit() {
				if(!hasChecked(subForm.type)) {
					alert("请选择需要删除的备忘类型!");
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
		<h2 align="center">备忘类型列表</h2>
		<form name="subForm" method="post" action="${pageContext.request.contextPath}/deleteMemoTypeAction.action">
			<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1">
		        <tr>
		   			<td>
		   				<input type="button" name="addUser" value="添加" 
		   					onclick="window.location.href='${pageContext.request.contextPath}/memotype/addMemoType.jsp'"/>
		                &nbsp;&nbsp;
		                <input type="checkbox" name="checkbox2" 
		                	onclick="checkboxselect(document.subForm.type, document.subForm.checkbox2.checked)" style="border:0px"/>
		                   全选
		                <input type="button" name="delall" value="删除所选" onclick='doSubmit()'/>
		   			</td>
		   		</tr>
		        <tr> 
		          <td height="74">
		          	<table width="100%"  border="0">
		          		<tr>
		          			<td>
							    <ec:table
								items="memoTypeList" 
								action="?"
								imagePath = "${pageContext.request.contextPath}/images/ec/*.gif"
							    cellpadding = "1" 
							    width = "100%" 
							    locale = "zh_CN"
							    sortable="false"
							    var = "memoType"
							    filterable = "false"
							    form="subForm">
								<ec:row highlightRow="true">
									<ec:column property="checkbox" title="选择" width="30" sortable="false">
					           			<input type="checkbox" name="type" value="${memoType.type}" style="border:0px"/>
					       			</ec:column>
					       			<ec:column property="type" title="类型ID" width="100"/>
									<ec:column property="name" title="类型名称" width="100"/>
									<ec:column property="user.username" title="创建人" width="120"/>
									<ec:column property="createTime" title="创建时间" width="150" cell="date" format="yyyy-MM-dd HH:mm:ss"/>
									<ec:column property="操作" style="text-align:center" filterable="false" width="*">
										<a href="${pageContext.request.contextPath}/initUpdateMemoTypeAction.action?type=${memoType.type}">
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
