package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamanage.HispitalManage;

import model.Hospital;
@WebServlet(name="SelectHospitalServlet",urlPatterns="/SelectHospitalServlet")
public class SelectHospitalServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7967337651235830853L;

	private String name;
	private List<Hospital> hospitals;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); 
		name=req.getParameter("name");
		if(null!=name){
			hospitals=HispitalManage.getHospitalByName(name);
		}
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/Register.jsp");
		req.setAttribute("hospitals", hospitals);
		rd.forward(req, resp);
	}	
	
}
