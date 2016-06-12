<%@page import="model.Hospital"%>
<%@ page import="model.Patient"%>
<%@ page import="hibernate.Dao"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>hospital register</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/guahao.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/guahao.js">
	
</script>
</head>
<body>
	<div id="main">
		<div class="div">
			<img src="images/dbnav.png"> <span>010-114/116114电话预约</span>
		</div>
		<div id="div">
			<p class="dbnav_context_right" id="isLogin">
				欢迎<% if(request.getSession(true).getAttribute("patient") != null){%><a href="/Hospital/perchuse.jsp"><%Patient patient=Dao.getById((String)request.getSession(true).getAttribute("patient"),Patient.class);
				out.print(patient.getName()); }else{}%></a>来到北京市预约挂号统一平台<% if(request.getSession(true).getAttribute("patient") == null){%>
				<a href="/Hospital/Login.html">登录</a> 
				<a href="/Hospital/register.html" target="_blank">注册</a>
				<%}else{
					%>
				<a href="/Hospital/Login.html">注销</a>
				<%}%>	
			</p>
		</div>
		<div class="div1">
			<a id="touch" href="/help.htm" target="_blank">帮助中心</a>
		</div>
		<div id="box" class="hidden_box">
			<ul>
				<li>关于我们</li>
				<li>产品信息</li>
				<li>关于我们</li>
			</ul>
		</div>
	</div>
	<div id="top">
		<div class="top_left">
			<a href="/Hospital/guahao.jsp"> <img src="images/logo.jpg">
				<h2 class="top_h2">&nbsp;广州市预约挂号统一平台</h2>
			</a>
		</div>
<% List<Hospital> hospitals=new ArrayList<Hospital>();
hospitals=Dao.getAll(Hospital.class);
%>
		<div class="top_search">
			<form method="post" name="search" action="SelectHospitalServlet"
				onsubmit="return checkwords();">
				<div class="option" id="wn_h_div">
					<span id="wn_h">医院</span>
				</div>
				<div class="sbox">
					<input onblur="javascript:if(this.value=='')this.value='请输入搜索内容';"
						onfocus="javascript:if(this.value=='请输入搜索内容')this.value='';"
						value="请输入搜索内容" maxlength="30" name="words" type="text" id="words"
						autocomplete="off" class="ac_input">
				</div>
				<div class="sbtn">
					<input type="submit" value="" style="letter-spacing: -1px;">
				</div>
			</form>
		</div>

	</div>


	<ul>
	<%
	if(request.getAttribute("hospitals")!=null){
		hospitals.clear();
		hospitals=(List<Hospital>)request.getAttribute("hospitals");
	}
int length=hospitals.size();
for(int i=0;i<length;i++){%>
		<li>
			<div id="yiyuan_list">
				<div id="yiyuan_content">
					<div class="yiyuan_content_1">
						<dl class="yiyuan_co_dl">
							<dt class="yiyuan_co_dt">
								<b > <img src="images/pic.jpg"
									width="200px" height="150px">
								</b>
							</dt>
							<dd class="yiyuan_co_dd">
								<p class="yiyuan_co_titl">
									<b class="yiyuan_co_titl"></b><%=hospitals.get(i).getName() %>
									<span class="yiyuan_co_ddsp"><%=hospitals.get(i).getDescription() %></span>
								</p>
								<div class="yiyuan_co_dd_div">
									<p>
										<b class="yiyuan_telico"></b>400-686-8861
									</p>
									<p>
										<b class="yiyuan_telico1"></b><%=hospitals.get(i).getAddress() %>
									</p>
								</div>
							</dd>
						</dl>
						
						<div class="yi_c_span_w" id="b1"  hospitalId="<%=hospitals.get(i).getId() %>" >
							<span class="yi_c_span"> 
							<b class="yiyuan_co_xzyy"></b>
							</span>
						</div>
					</div>
				</div>
			</div>
		</li>
		<%} %>
	</ul>

</body>
</html>