<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://www.extremecomponents.org" prefix="ec"%>
<html>
<head>
<title>备忘信息列表</title>
<%
	String user = (String)session.getAttribute("username");
%>
<script type='text/javascript' src='/sshmemo/dwr/engine.js'></script>
<script type='text/javascript' src='/sshmemo/dwr/util.js'></script>
<script type='text/javascript' src='/sshmemo/dwr/interface/DWRHelper.js'></script>
<link
	href="${pageContext.request.contextPath}/css/extremecomponents.css"
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/select.js"></script>
<script type='text/javascript'>
	function doSubmit() {
		if (!hasChecked(subForm.memoId)) {
			alert("请选择需要删除的备忘信息!");
			return false;
		} else {
			if (!confirm("您确定要删除吗?")) {
				return false;
			} else {
				subForm.submit();
			}
		}
	}
</script>

<script type="text/javascript">
        function sendMessage() {
        	alert("send sendMessage!");
        	alert(dwr.engine.getActiveReverseAjax());
        	
            DWRHelper.addMessage(user);   
        }   
        
        function clientFunction(data){
        	alert("data:"+data);
        }
        
        function a(){
        	alert("a");
        }
        
        function b(){
        	alert("b");
        }
</script>
</head>
<body onload="a();b();dwr.engine.setActiveReverseAjax(true);sendMessage();">
	<h2 align="center">备忘信息列表</h2>
	<form name="subForm" method="post"
		action="${pageContext.request.contextPath}/deleteMemoAction.action">
		<table width="98%" align="center" border="0" cellpadding="4"
			cellspacing="1">
			<tr>
				<td><input type="button" name="addUser" value="添加"
					onclick="window.location.href='${pageContext.request.contextPath}/initSaveMemoAction.action'" />
					&nbsp;&nbsp; <input type="checkbox" name="checkbox2"
					onclick="checkboxselect(document.subForm.memoId, document.subForm.checkbox2.checked)"
					style="border: 0px" /> 全选 <input type="button" name="delall"
					value="删除所选" onclick='doSubmit();' /></td>
			</tr>
			<tr>
				<td height="74">
					<table width="100%" border="0">
						<tr>
							<td><ec:table items="memoList" action="?"
									imagePath="${pageContext.request.contextPath}/images/ec/*.gif"
									cellpadding="1" width="100%" locale="zh_CN" sortable="false"
									var="memo" filterable="false" form="subForm">
									<ec:row highlightRow="true">
										<ec:column property="checkbox" title="选择" width="30"
											sortable="false">
											<input type="checkbox" name="memoId" value="${memo.memoId}"
												style="border: 0px" />
										</ec:column>
										<ec:column property="memoId" title="ID" width="40" />
										<ec:column property="name" title="备忘名称" width="100" />
										<ec:column property="memoType.name" title="类型名称" width="100" />
										<ec:column property="user.username" title="所属用户" width="120" />
										<ec:column property="description" title="描述" width="120" />
										<ec:column property="remindTime" title="提醒时间" width="150"
											cell="date" format="yyyy-MM-dd HH:mm:ss" />
										<ec:column property="createTime" title="创建时间" width="150"
											cell="date" format="yyyy-MM-dd HH:mm:ss" />
										<ec:column property="操作" style="text-align:center"
											filterable="false" width="*">
											<a
												href="${pageContext.request.contextPath}/initUpdateMemoAction.action?memoId=${memo.memoId}">
												<img
												src="${pageContext.request.contextPath}/images/ec/edit.gif"
												border="0" alt="修改">
											</a>
										</ec:column>
									</ec:row>
								</ec:table></td>
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
