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

import model.Department;
import model.Doctor;
@WebServlet(name="GetDepartmentServlet",urlPatterns="/GetDepartmentServlet")
public class GetDepartmentServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6015528793966256150L;
	private String id;
	private Department department;
	private Set<Doctor> doctors;
	private RequestDispatcher rd;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		id=req.getParameter("id");
		department=Dao.getById(id, Department.class);
		doctors=department.getDoctors();
		req.setAttribute("doctors", doctors);
		rd=getServletContext().getRequestDispatcher("/Register.jsp");
		rd.forward(req, resp);
	}
	
}
