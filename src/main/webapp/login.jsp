<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>开放平台</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="开放平台">
<title>Insert title here</title>
<script type="text/javascript">
	function changeValidateCode(obj) {
		var currentTime = new Date().getTime();
		obj.src = "UserAction.do?method=authCode&d=" + currentTime;
	}
</script>
</head>

<body>
	Hello!~${message}

	<br /> 测试地址： http://localhost:8080/lj-mvc/demo.do?method=login

	<h1 style="color: green;">开放平台——用户登录</h1>
	<label style="color: red;">{msg}</label>
	<form id="f1" name="f1" action="UserAction.do?method=login" method="post">
		<table width="100%">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" value=""
					title="用户名" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="passwd" value=""
					title="密码" /></td>
			</tr>
			<tr>
				<td>验证码</td>
				<td><input name="yanzhengma" type="text" /><img
					src="UserAction.do?method=authCode" onclick="changeValidateCode(this)" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="Bn" type="submit" value="登录" /> <a
					href="userreg.jsp">注册</a></td>
			</tr>
		</table>
	</form>

</body>
</html>
