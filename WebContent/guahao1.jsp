<%@page import="model.*"%>
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
	<link rel="stylesheet" type="text/css" href="css/guahao1.css">
	<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js">
	</script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("div.kfyuks_yyksbox").hover(function(){
				$(this).css("background-color","yellow");},function(){
$(this).css("background-color","#DFF2FC");
});
			$('div.kfyuks_yyksbox').click(function(){
                $(this).css("background-color","pink");
                var name=$(this).children('div.kfyuks_yyksdl').children('label').html();
                //alert( $(this).children('div.kfyuks_yyksdl').children('label').html());
                $.post("/Hospital/SelectDactorServlet", {
        			name : name
        		},function(data, status) {
    				if (status == 'success') {
    					if (data == 'success') {
    						window.location.href = "/Hospital/guahao2.jsp"
    					} else {
    						window.location.href = "/Hospital/guahao1.jsp"
    					}
    				}
        		})
	
              });
  $("a.kfyuks_islogin").attr("href",'javascript:void(0);');
  
});
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
	<div id="top">
		<div class="top_left">
			<a href="/Hospital/guahao1.jsp">
			<img src="images/logo.jpg">
			<h2 class="top_h2">&nbsp;广州市预约挂号统一平台</h2>
			</a>
		</div>

		<div class="top_search">
		  <form method="post" name="search" action="SelectHospitalServlet" onsubmit="return checkwords();">
			<div class="optaion" id="wn_h_div">
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
		<div id="yiyuan_list">
			<div id="yiyuan_content">
				<div class="yiyuan_content_1">
					<dl class="yiyuan_co_dl">
						<dt class="yiyuan_co_dt">
							<a href="/Hospital/guahao1.jsp">
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

	        <div class="kfyuks_left">
	        	<div class="kfyuks_title">
	        		<p>开放预约科室</p>
	        	</div>
	        <%
	        Set<Department> departments=new HashSet<Department>();
	        departments=hospital.getDepartments();
	        for(Department de:departments){%>
	        <div class="kfyuks_yyksbox">
	        <div class="kfyuks_yyksdl">
	        <label><%=de.getName() %></label>
	        </div>
	        <div class="kfyuks_yyksxl">  
	        </div>
	        </div>
	        <%}%>
	        </div>

	        <div class="kfyuks_t_guize">
			<p class="kfyuks_t_g_dd_p">预约规则<span>（更新时间每日10:15更新）</span></p>
			<div class="kfyuks_t_g_dd_div">
				<dl>
					<dt>预约周期：</dt>
					<dd> 9天</dd>
        		</dl>
          		<dl><dt>放号时间：</dt><dd>10:15</dd></dl>
          		<dl><dt>停挂时间：</dt><dd>下午15:00停止次日预约挂号 (周五15:00后停挂至下周一)</dd></dl>
          		<dl><dt>退号时间：</dt><dd>就诊前一工作日15:00前取消</dd></dl>
          		<dl><dt>特殊规则：</dt><dd><br> ①&nbsp; 就诊人须小于18周岁。</dd></dl>
        	</div>
        </div>
		</div>

		
		
</body>
</html>