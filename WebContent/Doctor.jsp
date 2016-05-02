<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*" import="model.*"
	import="hibernate.Dao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>医生测试页面</title>
</head>
<body>
	<table border="1px" cellspacing="0px">
	<%
		String hosptalId = (String) request.getSession(true).getAttribute("hospital");
		if (hosptalId != null) {
			List<Doctor> list = Dao.getAll(Doctor.class);
			Iterator<Doctor> iterator = list.iterator();
			while (iterator.hasNext()) {
				Doctor d = iterator.next();
				if (!d.getDepartment().getHospital().getId().equals(hosptalId)) {
					iterator.remove();
				}
			}
			for (Doctor d : list) {
	%>
	<tr><td><%=d.getId() %></td><td><%=d.getName() %></td><td><%=d.getDescription() %></td></tr>
	<%
			}
		}
	%>
	</table>
	<form action="Doctor.html" method="post" charset="utf8">
		<table border="1px" cellspacing="0px">
			<tr>
				<td>医生名称：</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>医生描述：</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>医生年龄：</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>医生工龄：</td>
				<td><input type="text" name="workage" /></td>
			</tr>
			<tr>
				<td>医生性别：</td>
				<td><input type="text" name="sex" /></td>
			</tr>
			<tr>
				<td>医生所属科室id：</td>
				<td><input type="text" name="department" /></td>
			</tr>
			<tr>
				<td>医生职称：</td>
				<td><input type="text" name="title" /></td>
			</tr>
		</table>
		<input type="submit" value="确认" /> <input type="hidden" name="type"
			value="add" />
	</form>
	<form action="Doctor.html" method="post" charset="utf8">
		<table border="1px" cellspacing="0px">
			<tr>
				<td>医生id：</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>医生名称：</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>医生描述：</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>医生年龄：</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>医生工龄：</td>
				<td><input type="text" name="workage" /></td>
			</tr>
			<tr>
				<td>医生性别：</td>
				<td><input type="text" name="sex" /></td>
			</tr>
			<tr>
				<td>医生所属科室id：</td>
				<td><input type="text" name="department" /></td>
			</tr>
			<tr>
				<td>医生职称：</td>
				<td><input type="text" name="title" /></td>
			</tr>
		</table>
		<input type="hidden" name="type" value="modify" /> <input
			type="submit" value="确认" />
	</form>
	<form action="Doctor.html" method="post" charset="utf8">
		<table border="1px" cellspacing="0px">
			<tr>
				<td>医生id：</td>
				<td><input type="text" name="id" /></td>
			</tr>
		</table>
		<input type="hidden" name="type" value="delete" /> <input
			type="submit" value="确认" />
	</form>
</body>
</html>