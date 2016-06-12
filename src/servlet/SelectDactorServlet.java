package servlet;

import hibernate.Dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Department;

import datamanage.HispitalManage;
@WebServlet(name="SelectDactorServlet",urlPatterns="/SelectDactorServlet")
public class SelectDactorServlet extends BaseServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); 
		String name=req.getParameter("name");
		Department department=new Department();
		if(null!=name){
			department=Dao.getByName(name, Department.class);
		}
		HttpSession session = req.getSession(true);
		session.setMaxInactiveInterval(30000);
		session.setAttribute("department", department);
		resp.getWriter().append("success");
	}	

}
