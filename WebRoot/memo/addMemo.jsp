<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>新增备忘信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	</head>
	<body>
		<h2 align="center">新增备忘信息</h2>
		<s:form action="saveMemoAction">
			<s:textfield name="memo.name" label="备忘名称"></s:textfield>
			<s:select label="备忘类型" name="memo.type" 
				list="memoTypes" 
				listKey="type" 
				listValue="name"/>
			<s:textfield name="memo.description" label="描述"></s:textfield>
			<s:textfield name="memo.remindTime" label="提醒时间"></s:textfield>
			<s:submit/>
		</s:form>
	</body>
</html>