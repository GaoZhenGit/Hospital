<%@page import="model.Patient"%>
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE <!DOCTYPE html>
<html>
<head>
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;"
	name="viewport" />
<meta charset="utf-8">
<link rel="shortcut icon " href="images/hospital.png" type="image/png">
<link rel="stylesheet" type="text/css" href="css/register.css">
<title>个人资料修改</title>
<script language="JavaScript" src="js/jquery-2.0.0.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<%
		Patient patient = (Patient) session.getAttribute("patient");
		if (patient == null) {
			response.sendRedirect("/Hospital/Login.html");
			return;
		}
	%>
	<div class="picture">
		<img src="images/title.jpg"> <img class="image"
			src="images/hourse.jpg" alt="picture of a hospital">

	</div>
	<div id="title">
		<h1 id="subtitle">挂号预约系统</h1>
	</div>
	<form action="/Hospital/PatientModifyServlet" method="post">
		<div id="register">
			<ul>
				<li><label>用户名：</label><input name="account" type="text"
					autofocus="autofocus" maxlength="20"
					value="<%=patient.getAccount()%>"></input></li>
				<li><label>性别：</label> <select name="sex" id="select">
						<option value="1" <% if(patient.getSex()==1) out.print("selected=\"selected\""); %>>男</option>
						<option value="0" <% if(patient.getSex()==0) out.print("selected=\"selected\""); %>>女</option>
				</select></li>
				<li><label>年龄</label> <input type="number" name="age" min="0"
					max="200" value="<%=patient.getAge()%>"></input></li>
				<li><label>姓名:</label> <input type="text" id="p1" name="name" value="<%=patient.getName()%>"></input></li>
				<li><label>登录密码:</label> <input type="password" id="p1"
					name="password"></input></li>
				<li><label>银行卡号:</label> <input type="text" id="p1"
					name="bankaccount" value="<%=patient.getBankAccount()%>"></input></li>
			</ul>
			<input type="submit" id="submit" value="修改"></input>
		</div>
	</form>

</body>
</html>