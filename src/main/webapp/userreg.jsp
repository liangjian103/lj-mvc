<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>开放平台</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="开放平台">
<style type="text/css">
<!--
-->
</style>
<script type="text/javascript">
	function changeValidateCode(obj) {
		var currentTime = new Date().getTime();
		obj.src = "UserAction.do?method=authCode&d=" + currentTime;
	}
</script>

</head>
<body>

	<h1>开放平台——用户注册</h1>
<label style="color: red;">{msg}</label>
	<form id="f1" name="f1" action="UserAction.do?method=reg" method="post">
		用户名：<input type="text" name="username" value="" title="用户名" /><br /> 
		密 码：<input type="password" name="passwd" value="" title="密码" /><br /> 
		确认密码：<input type="password" name="repasswd" value="" title="确认密码" /><br /> 
		Email：<input type="text" name="email" value="" title="Email" /><br /> 
		验证码：<input name="yanzhengma" type="text" />
		<img src="UserAction.do?method=authCode" onclick="changeValidateCode(this)" /> <br /> 
		<input class="Bn" type="submit" value="注册" /> <a href="login.jsp">登录</a>
	</form>


</body>
</html>