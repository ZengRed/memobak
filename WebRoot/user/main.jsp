<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>主界面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type='text/javascript' src='/sshmemo/dwr/engine.js'></script>
<script type='text/javascript' src='/sshmemo/dwr/util.js'></script>
<script type='text/javascript' src='/sshmemo/dwr/interface/DWRHelper.js'></script>
<%
String user = (String)session.getAttribute("username");
%>
<script type="text/javascript">
	function checkUser() {
		alert("check");
		var user = '${user.username}';
		if("admin"==user){
			document.getElementById("ad").style.display="block";
		}
	}
	
</script>

<script type="text/javascript">
        function sendMessage() {
        	alert("send sendMessage!");
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
        function c(){
        	alert("c");
        }
</script>
</head>
<body onload="dwr.engine.setActiveReverseAjax(true);c();sendMessage();">
	<h2 align="center">主界面</h2>
	<div align="center">
	<div id="ad" style="display: none;">
	<a href="${pageContext.request.contextPath}/listUserAction.action">用户管理</a>
	</div>
	<a href="${pageContext.request.contextPath}/listMemoTypeAction.action">备忘类型管理</a>
	<br>
	<a href="${pageContext.request.contextPath}/listMemoAction.action">备忘信息管理</a>
	</div>
</body>
</html>