<%@page import="model.Department"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.*" import="hibernate.Dao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>医院主页</title>
</head>
<body>
	<%
		String hospitalId = (String) request.getSession(true).getAttribute("hospital");
		if (hospitalId == null) {
			response.sendRedirect(request.getContextPath() + "/HospitalLogin.jsp");
			return;
		}
		Hospital hospital = Dao.getById(hospitalId, Hospital.class);
	%>
	<table border="1px" cellspacing="0px">
		<tr>
			<td>医院名称：</td>
			<td><%=hospital.getName()%></td>
		</tr>
		<tr>
			<td>医院介绍：</td>
			<td><%=hospital.getDescription()%></td>
		</tr>
		<tr>
			<td>医院地址：</td>
			<td><%=hospital.getAddress()%></td>
		</tr>
	</table>
	<br /> 医院部门：
	<br />
	<table  border="1px" cellspacing="0px">
		<tr>
			<td>部门名称</td>
			<td>部门介绍</td>
		</tr>
		<%
			for (Department department : hospital.getDepartments()) {
		%>
		<tr>
			<td><%=department.getName()%></td>
			<td><%=department.getDescription()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>