package servlet;

import hibernate.Dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Doctor;
@WebServlet(name="GetDoctorServlet",urlPatterns="/GetDoctorServlet")
public class GetDoctorServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7848103773217904980L;
	private String id;
	private Doctor doctor;
	private RequestDispatcher rd;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		req.setCharacterEncoding("utf-8");
		id=req.getParameter("id");
		doctor=Dao.getById(id, Doctor.class);
		HttpSession session=req.getSession();
		session.setAttribute("doctor", doctor);
		rd=getServletContext().getRequestDispatcher("/Register.jsp");
		rd.forward(req, resp);
	}

}
