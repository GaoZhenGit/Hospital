<%@page import="java.util.Iterator"%>
<%@page import="model.Hospital"%>
<%@page import="java.util.List"%>
<%@page import="model.Patient"%>
<%@page import="java.util.Set"%>
<%@page import="model.Department"%>
<%@page import="model.Doctor"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>病人挂号页面</title>
</head>
<body>
病人挂号
<br/>
<%
HttpSession s=request.getSession();
if(null==s.getAttribute("patient")){
%>
<a href="PatientLogin.jsp"><Button type="button">登录</button></a>
<a href="PatientRegister.jsp"><Button type="button">注册</Button></a>
<br/>
<%}else{ %>
<a href="PatientLogin.jsp"><Button type="button">注销</button></a>
<br/>

<span>

<%
if(null!=s.getAttribute("patient")){
	Patient p=(Patient)s.getAttribute("patient");
	out.print(p.getAccount()+"，欢迎使用超哥挂号系统@。@");
}
%>
<br/>
</span>
<jsp:include page="SelectHospital.jsp"/>
<%} %>
<%
List<Hospital> hospitals;
if(null!=request.getAttribute("hospitals")){
	hospitals=(List<Hospital>)request.getAttribute("hospitals");
	int length=hospitals.size();
	for(int i=0;i<length;i++){%>
<a href="GetHospitalServlet?id=<%=hospitals.get(i).getId()%>"  ><%=hospitals.get(i).getName()%></a>
<%}}%>
<%
Set<Department> departments;
if(null!=request.getAttribute("departments")){%>
选择科室：
	<%departments=(Set<Department>)request.getAttribute("departments");
	int length=departments.size();
	Iterator it=departments.iterator();
	while(it.hasNext()){
	Department de=(Department)it.next();%>
<a href="GetDepartmentServlet?id=<%=de.getId()%>"><%=de.getName()%></a>
<%}}%>
<%
Set<Doctor> doctors;
if(null!=request.getAttribute("doctors")){%>
选择医生：
	<%doctors=(Set<Doctor>)request.getAttribute("doctors");
	int length=doctors.size();
	Iterator it=doctors.iterator();
	while(it.hasNext()){
	Doctor doc=(Doctor)it.next();%>
<a href="GetDoctorServlet?id=<%=doc.getId()%>"><%=doc.getName() %></a>
<%}} %>
</body>
</html>