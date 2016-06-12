package servlet;

import hibernate.Dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Doctor;
import model.Patient;
import model.Registration;
import model.TimeQuantum;

@WebServlet(name = "DelectServlet", urlPatterns = "/DelectServlet")
public class DelectServlet extends BaseServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=(String)req.getParameter("id");
		Registration registration=Dao.getById(id, Registration.class);
		try {
			resp.getWriter().append("success");	
			System.out.println("删除");
			Dao.delete(registration);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
