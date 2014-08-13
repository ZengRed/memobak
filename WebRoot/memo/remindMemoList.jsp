<%@ page language="java" pageEncoding="UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://www.extremecomponents.org" prefix="ec" %>
<html>
	<head>
		<title>备忘提醒信息列表</title>
		<link href="${pageContext.request.contextPath}/css/extremecomponents.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<h2 align="center">备忘提醒信息列表</h2>
		<form name="subForm" method="post" action="${pageContext.request.contextPath}/deleteMemoAction.action">
			<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1">
		        <tr> 
		          <td>
					    <ec:table
						items="memoList" 
						action="?"
						imagePath = "${pageContext.request.contextPath}/images/ec/*.gif"
					    cellpadding = "1" 
					    width = "100%" 
					    locale = "zh_CN"
					    sortable="false"
					    var = "memo"
					    filterable = "false"
					    form="subForm">
						<ec:row highlightRow="true">
			       			<ec:column property="memoId" title="ID" width="40"/>
			       			<ec:column property="name" title="备忘名称" width="100"/>
							<ec:column property="memoType.name" title="类型名称" width="100"/>
							<ec:column property="user.username" title="所属用户" width="120"/>
							<ec:column property="description" title="描述" width="120"/>
							<ec:column property="remindTime" title="提醒时间" width="150" cell="date" format="yyyy-MM-dd HH:mm:ss"/>
							<ec:column property="createTime" title="创建时间" width="150" cell="date" format="yyyy-MM-dd HH:mm:ss"/>
							<ec:column property="操作" style="text-align:center" filterable="false" width="*">
								<a href="${pageContext.request.contextPath}/updateStatusMemoAction.action?memoId=${memo.memoId}">
									<img src="${pageContext.request.contextPath}/images/ec/edit.gif" border="0" alt="不再提醒">
								</a>
			                 </ec:column>
			             </ec:row>
						</ec:table>
		          </td>
		      </tr>
		    </table>
		</form>
	</body>
</html>
