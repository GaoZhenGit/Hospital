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
if(request.getSession(true).getAttribute("id")==null){
	RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
	rd.forward(request, response);
}
%>
登录成功！
</body>
</html>