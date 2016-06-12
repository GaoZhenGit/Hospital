package servlet;

import hibernate.Dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Patient;
@WebServlet(name = "SelectDepartmentSevlet", urlPatterns = "/SelectDepartmentSevlet")
public class SelectDepartmentSevlet extends BaseServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=req.getParameter("hospitalId");
		HttpSession session = req.getSession(true);
		session.setMaxInactiveInterval(30000);
		session.setAttribute("hospitalId", id);
		resp.getWriter().append("success");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
