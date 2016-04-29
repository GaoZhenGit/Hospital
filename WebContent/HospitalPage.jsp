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
			<td>医院id：</td>
			<td><%=hospital.getId()%></td>
		</tr>
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
	<table border="1px" cellspacing="0px">
		<tr>
			<td>部门id</td>
			<td>部门名称</td>
			<td>部门介绍</td>
		</tr>
		<%
			for (Department department : hospital.getDepartments()) {
		%>
		<tr>
			<td><%=department.getId() %></td>
			<td><%=department.getName()%></td>
			<td><%=department.getDescription()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<br /> 修改医院属性：
	<form action="HospitalModify.html" method="post" charset="utf8">
		<table border="1px" cellspacing="0px">
			<tr>
				<td>医院名称：</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>医院登录账号：</td>
				<td><input type="text" name="account" /></td>
			</tr>
			<tr>
				<td>登录密码：</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td>描述：</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" name="address" /></td>
			</tr>
		</table>
		<input type="submit" value="确认修改" />
	</form>
	<br/>添加科室：
	<form action="Department.html" method="post" charset="utf8">
		<table border="1px" cellspacing="0px">
			<tr>
				<td>科室名称：</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>科室描述：</td>
				<td><input type="text" name="description" /></td>
			</tr>
		</table>
		<input type="submit" value="确认添加" />
		<input type="hidden" name="type" value="add"/>
	</form>
	<br/>修改科室：
	<form action="Department.html" method="post" charset="utf8">
		<table border="1px" cellspacing="0px">
			<tr>
				<td>科室id：</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>科室名称：</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>科室描述：</td>
				<td><input type="text" name="description" /></td>
			</tr>
		</table>
		<input type="submit" value="确认修改" />
		<input type="hidden" name="type" value="modify"/>
	</form>
	<br/>删除科室：
	<form action="Department.html" method="post" charset="utf8">
		<table border="1px" cellspacing="0px">
			<tr>
				<td>科室id：</td>
				<td><input type="text" name="id" /></td>
			</tr>
		</table>
		<input type="submit" value="确认删除" />
		<input type="hidden" name="type" value="delete"/>
	</form>
</body>
</html>