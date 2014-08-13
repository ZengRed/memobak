<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src='/sshmemo/dwr/engine.js'></script>
<script type='text/javascript' src='/sshmemo/dwr/util.js'></script>
<script type='text/javascript' src='/sshmemo/dwr/interface/DWRHelper.js'></script>

<title>用户登录</title>
<script type="text/javascript">
	function fc() {
		document.getElementById("username").focus();
	}
	
	 function sendMessage() {
     	alert("send sendMessage!");
     	
         DWRHelper.addMessage("AAA");   
     }   
     
     function clientFunction(data){
     	alert("data:"+data);
     }
</script>

</head>
<body onload="fc();dwr.engine.setActiveReverseAjax(true);sendMessage();">
	<h2 align="center">用户登录</h2>
	<font color="Red">${message}</font>
	<s:form action="loginUserAction" method="POST">
		<s:textfield name="user.username" id="username" label="用户名" />
		<s:password name="user.password" label="密码" />
		<s:submit value="提交"/>
	</s:form>
</body>
</html>