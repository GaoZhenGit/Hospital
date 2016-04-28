package servlet;

import hibernate.Dao;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Department;
import model.Hospital;
@WebServlet(name="GetHospitalServlet",urlPatterns="/GetHospitalServlet")
public class GetHospitalServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5934881641055663592L;
	private Hospital hospital;
	private String id;
	private RequestDispatcher rd;
	private Set<Department> departments;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		req.setCharacterEncoding("UTF-8");
		id=req.getParameter("id");
		hospital=Dao.getById(id, Hospital.class);
		rd=getServletContext().getRequestDispatcher("/Register.jsp");
		departments=hospital.getDepartments();
		req.setAttribute("departments", departments);
		rd.forward(req, resp);
		
	}
	
}
