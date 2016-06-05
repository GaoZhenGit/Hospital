<%@page import="model.Department"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.*" import="hibernate.Dao"%>
<!DOCTYPE <!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="shortcut icon " href="images/hospital.png" type="image/png">
<title>医院信息修改</title>
<link rel="stylesheet" type="text/css"
	href="css/hospital_information.css">
<script type="text/javascript" src="js/jquery-2.0.0.js"></script>
<script type="text/javascript" src="js/hospital_information.js"></script>

</head>
<body>
	<%
		String hospitalId = (String) request.getSession(true).getAttribute("hospital");
		if (hospitalId == null) {
			response.sendRedirect(request.getContextPath() + "/Login.html");
			return;
		}
		Hospital hospital = Dao.getById(hospitalId, Hospital.class);
	%>
	<div id="top">
		<div id="picture">
			<img src="images/doctor.jpg">
		</div>
		<div>
			<label id="title1">预约挂号系统</label>
		</div>
		<div id="phone">
			<label>020-28823388</label>
		</div>
	</div>

	<div id="menu">
		<ul id="list">
			<li class="active"><a href="#"><i class="fa fa-home"></i><label>医院资料</label>
			</a></li>
			<hr />
			<li><a href="#"><i class="fa fa-home"></i><label>信息修改</label>
			</a></li>
			<hr />
			<li><a href="#"><i class="fa fa-home"></i><label>医院科室</label></a></li>
			<hr />
			<li><a href="#"><i class="fa fa-home"></i><label>密码修改</label></a></li>
		</ul>
	</div>
	<div class="total">
		<div id="first">
			<h2><%=hospital.getName()%></h2>
			<div>
				<section>
					等级：三级医院<br> 地址：<%=hospital.getAddress()%><br>
				</section>
				<section>
					<br> 预约开始时间：00:00<br> 预约截止时间：23:59
				</section>
				<p>
					简介：<br>
					<%=hospital.getDescription()%>
				</p>
			</div>
		</div>

		<div id="div">
			<h2>信息修改</h2>
			<form action="HospitalModify.html" method="post" charset="utf8">
				<ul style="list-style-type: none;">
					<li><label>医院名称</label> <input type="text" name="name"></input></li>
					<li><label>医院地址</label> <input type="text" name="address"></input></li>
					<li><label id="describe">医院描述</label> <textarea
							name="description" maxlength="200" cols="40" rows="4"></textarea></li>
				</ul>

				<div>
					<button type="submit">提交</button>
					<button type="reset">取消</button>
				</div>
			</form>
		</div>

		<div id="section">
			<h2>医院科室</h2>
			<form method="post" charset="utf8">
				<table id="sec">
					<tr>
						<td><h3>科室名称</h3></td>
						<td><h3>科室介绍</h3></td>
						<td><h3>操作</h3></td>
					</tr>
					<%
						for (Department department : hospital.getDepartments()) {
					%>
					<tr id="<%=department.getId()%>">
						<td><input disabled="disabled"
							value="<%=department.getName()%>"></input></td>
						<td><textarea disabled="disabled"><%=department.getDescription()%></textarea></td>
						<td><button onClick="removeRow(this)" value="<%=department.getId()%>">删除</button></td>
					</tr>
					<%
						}
					%>
				</table>
				<button type="button" style="margin-top: 15; margin-left: -70;"
					id="example">增加</button>
				<button type="submit">确认</button>

			</form>
			<button onclick="refresh()"
				style="margin-right: -135; margin-top: -56">取消</button>
		</div>

		<div id="password">
			<h2>密码修改</h2>
			<form onsubmit="return check()" action="HospitalModify.html"
				method="post">
				<ul>
					<li><label>旧密码&nbsp:</label> <input type="password"
						required="required"></input></li>
					<li><label>新密码&nbsp:</label> <input id="b1" type="password"
						required="required"></input></li>
					<li><label>确认密码:</label> <input id="b2" type="password"
						required="required" name="password"></input></li>
				</ul>
				<button type="submit">确认</button>
				<button type="reset">重填</button>
			</form>
		</div>



	</div>

	<div id="LoginBox">
		<form action="Department.html" method="post" charset="utf8">
			<div class="row1">
				添加医院科室窗口<a href="javascript:void(0)" title="关闭窗口" class="close_btn"
					id="closeBtn">×</a>
			</div>
			<div class="row">
				科室名称： <span class="inputBox"> <input type="text" id="txtName"
					required="required" placeholder="名称" name="name" />
				</span><a href="javascript:void(0)" title="提示" class="warning" id="warn"></a>
			</div>
			<div class="row">
				<label>&nbsp&nbsp科室描述：</label>
				<textarea required="required" placeholder="描述" name="description"></textarea>
				<input type="hidden" value="add" name="type" />
			</div>
			<div class="row">
				<button type="submit" id="loginbtn">确认</button>
				<button type="reset">取消</button>
			</div>

		</form>
	</div>

	<div id="LoginBox1">
		<form action="" method="post" charset="utf8">
			<div class="row1">
				添加医院部门窗口<a href="javascript:void(0)" title="关闭窗口" class="close_btn"
					id="closeBtn1">×</a>
			</div>
			<div class="row">
				部门名称： <span class="inputBox"> <input type="text"
					id="txtName1" required="required" placeholder="名称" name="name" />
				</span><a href="javascript:void(0)" title="提示" class="warning" id="warn1"></a>
			</div>
			<div class="row">
				<label> &nbsp&nbsp部门描述：</label>
				<textarea required="required" placeholder="描述" name="description"></textarea>
			</div>
			<div class="row">
				<button type="submit" id="loginbtn">确认</button>
				<button type="reset">取消</button>
			</div>

		</form>
	</div>
</body>
</html>