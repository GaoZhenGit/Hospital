<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>医院登录</title>
</head>
<body>
<form method="post" action="HospitalLogin.html" charset="utf8">
		医院账号：<input type="text" name="account" />
		<span style="color:red;font-weight:bold">
		<%
			if (request.getAttribute("err") != null) {
				out.println(request.getAttribute("err"));
			}
		%><br/>
		</span>
		密码：<input type="text" name="password" /><br /> 
		<input type="submit" value="确定" /><br />
	</form>
</body>
</html>