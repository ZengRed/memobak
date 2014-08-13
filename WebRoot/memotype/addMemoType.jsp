<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>新增备忘类型</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	</head>
	<body>
		<h2 align="center">新增备忘类型</h2>
		<s:form action="saveMemoTypeAction">
			<s:textfield name="name" label="类型名称"></s:textfield>
			<s:submit></s:submit>
		</s:form>
	</body>
</html>