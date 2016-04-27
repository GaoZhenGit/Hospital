<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (request.getSession(true).getAttribute("id") == null
				&& request.getSession(true).getAttribute("hospital") == null) {
			if (request.getSession(true).getAttribute("id") == null) {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
				return;
			}
			if (request.getSession(true).getAttribute("hospital") == null) {
				response.sendRedirect(request.getContextPath() + "/hospitalLogin.jsp");
				return;
			}
		}
	%>
	登录成功！
</body>
</html>