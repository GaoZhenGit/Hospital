<%@page import="model.TimeQuantum"%>
<%@page import="model.Doctor"%>
<%@page import="javax.print.Doc"%>
<%@page import="model.Department"%>
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
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/guahao.css">
	<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>
	<link rel="stylesheet" type="text/css" href="css/guahao1.css">
	<link rel="stylesheet" type="text/css" href="css/guahao2.css">
	<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
	<script src="js/jquery.datetimepicker.js"></script>
	<script type="text/javascript" src="js/guahao2.js"> </script>
	<link href="css/jquery.searchableSelect.css" rel="stylesheet" type="text/css">
    <script src="js/jquery.searchableSelect.js"></script>
    <script type="text/javascript">
    function funs() {
    	//alert("hah");
	var ok=$("#time option:selected").text();        
	var ok1=$("#doctor option:selected").text();
	$.post("/Hospital/GuaHaoServlet", {
		doctor : ok1,
		time : ok
	},function(data, status) {
		console.log(data);
		if (status == 'success') {
			if (data == 'success') {
				console.log("挂号成功");
				//window.location.href = "/Hospital/guahao.jsp"
			} else {
				//window.location.href = "/Hospital/guahao2.jsp"
				console.log("该时间段人数已满");
			}
		}
	})
    }
	</script>

</head>
<body>
	<div id="main">
		<div class="div">
			<img src="images/dbnav.png">
			<span>010-114/116114电话预约</span>
		</div>
		<div id="div"> 
			<p class="dbnav_context_right" id="isLogin">欢迎<% if(request.getSession(true).getAttribute("patient") != null){%><a href="/Hospital/perchuse.jsp"><%Patient patient=Dao.getById((String)request.getSession(true).getAttribute("patient"),Patient.class);out.print(patient.getName()); }else{}%></a>来到北京市预约挂号统一平台<% if(request.getSession(true).getAttribute("patient") == null){%>
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
<div>
	<div id="top">
		<div class="top_left">
			<a href="/Hospital/guahao2.jsp">
			<img src="images/logo.jpg">
			<h2 class="top_h2">&nbsp;广州市预约挂号统一平台</h2>
			</a>
		</div>

		<div class="top_search">
		  <form method="post" name="search" action="SelectHospitalServlet" onsubmit="return checkwords();">
			<div class="option" id="wn_h_div">
				<span id="wn_h">医院</span>
			</div>
			<div class="sbox">
				<input onblur="javascript:if(this.value=='')this.value='请输入搜索内容';" onfocus="javascript:if(this.value=='请输入搜索内容')this.value='';" value="请输入搜索内容" maxlength="30" name="words" type="text" id="words" autocomplete="off" class="ac_input">
			</div>
			<div class="sbtn">
				<input type="submit" value="" style="letter-spacing: -1px;">
			</div>
		  </form>
		</div>

	</div>
	<%Hospital hospital=Dao.getById((String)request.getSession().getAttribute("hospitalId"), Hospital.class); %>
	<div>
		<div id="yiyuan_list">
			<div id="yiyuan_content">
				<div class="yiyuan_content_1">
					<dl class="yiyuan_co_dl">
						<dt class="yiyuan_co_dt">
							<a href="/Hospital/guahao2.jsp">
								<img src="images/pic.jpg" width="200px" height="150px">
							</a>
						</dt>
						<dd class="yiyuan_co_dd">
							<p class="yiyuan_co_titl">
								<b ><%=hospital.getName() %></b>
								<span class="yiyuan_co_ddsp"><%=hospital.getDescription() %></span>
							</p>
							<div class="yiyuan_co_dd_div">
								<p><b class="yiyuan_telico"></b>400-686-8861</p>
								<p><b class="yiyuan_telico1"></b><%=hospital.getAddress() %></p>
							</div>
						</dd>
					</dl>
				</div>
			</div>
			<div class="ksorder_c_right">
	                	<h4 >相关医院推荐</h4>
	                	<ul>
	                		<li><a href="http://www.bjguahao.gov.cn/hp/appoint/154.htm">首都医科大学附属复兴医院（门诊部）</a></li>
	                    	<li><a href="http://www.bjguahao.gov.cn/hp/appoint/157.htm">解放军306医院</a></li>
	                    	<li><a href="http://www.bjguahao.gov.cn/hp/appoint/166.htm">航空总医院</a></li>
	                    	<li><a href="http://www.bjguahao.gov.cn/hp/appoint/189.htm">北京市房山区良乡医院</a></li>
	                    	<li><a href="http://www.bjguahao.gov.cn/hp/appoint/204.htm">北京市上地医院</a></li>
	                    </ul>
	          </div>
	</div>
<%Department department=(Department)request.getSession().getAttribute("department"); %>
	<div id="cooless">
		<div id="showdd">
		<form>
		<div >
			<div >
				<h3 style="display:inline">已预约科室：</h3>
				<label ><%=department.getName() %></label>
				<input type="button" value="重选科室" onclick="funsdw()">
			</div>
			<div id="dfsfss">
				<div id="dsffs">
					<h3>选择预约医生：</h3>
					<select id="doctor" name="doctor">
					<%Set<Doctor> doctors=new HashSet<Doctor>();
					doctors=department.getDoctors();
					for(Doctor d:doctors){%>
      					<option value=<%=d.getName()%>><%=d.getName() %></option>
      				<%} %>
      
    </select>
				</div>
<%List<TimeQuantum> time=new ArrayList<TimeQuantum>();
time=Dao.getAll(TimeQuantum.class);%>
				<div id="haosf">
					<h3>选择预约日期：</h3>
				<select id="time" name="time">
				<%
				for(TimeQuantum t:time){ %>
      					<option value=<%=t.toString() %>><%=t.toString()%> </option>
      					<%} %>
      
    </select>
				<script type="text/javascript">
				
			$('select').searchableSelect();
		
				  $('#datetimepicker4').datetimepicker();
					$('#open').click(function(){
				$('#datetimepicker4').datetimepicker('show');
				});
				$('#close').click(function(){
				$('#datetimepicker4').datetimepicker('hide');
				});
				$('#reset').click(function(){
				$('#datetimepicker4').datetimepicker('reset');
				});
			</script>
			<!-- <input type="" name="" id="cool"> -->
					</div>
				<div id="haonim">
					<h3>已确认信息</h3>
				<input id="ewr" class="were" onclick="return funs()" type="submit" value="确认">
				</div> 
				
				</div>
			</div>
			
		</form>
	 </div>
	</div>
</div>






<script>
	$('#datetimepicker3').datetimepicker({
	inline:true
});
</script>
</body>
</html>