<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
���˵�¼
<br/>
<form action="PatientLoginServlet" method="post">
�˺�:<input type="text" name="phone"/>
<br/>
����:<input type="password" name="password"/>
<span style="color:red;font-wight:bold"/>
<%
if(null!=request.getAttribute("err")){
	out.print(request.getAttribute("err"));
}
%>
</span>
<br/>
<input type="submit" value="��¼"/>
</form>
</body>
</html>