<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>病人登录页面</title>
</head>
<body>
病人注册
<br/>
<form action="PatientRegisterServlet" method="post">
账号:<input type="text" name="phone"/>
<br/>
密码:<input type="password" name="password"/>
<br/>
<input type="submit" value="注册"/>
</form>
</body>
</html>