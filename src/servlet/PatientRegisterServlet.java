package servlet;

import hibernate.Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datamanage.PatientManage;

import model.Patient;

@WebServlet(name = "PatientRegisterServlet", urlPatterns = "/PatientRegisterServlet")
public class PatientRegisterServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final String returnPage = "/register.html";
	private static final long serialVersionUID = -4693553661640688267L;

	public PatientRegisterServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		age = age.replaceAll(" ", "");
		String password = req.getParameter("password");
		String sex = req.getParameter("sex");
		System.out.print("hah1");
		if (isEmpty(name, password, age, sex)) {
			resp.sendRedirect(req.getContextPath() + returnPage);
			System.out.print("hah2");
		} else {
			System.out.print("hah3");
			Patient patient = new Patient();
			patient.setName(name);
//			patient.setAge(Integer.parseInt(age));
			if (sex.equals("man")) {
				patient.setSex(1);
			} else {
				patient.setSex(0);
			}
			patient.setPassword(password);
			try {
				Dao.save(patient);
				System.out.println("success");
//				HttpSession session = req.getSession(true);
//				session.setMaxInactiveInterval(30000);
//				session.setAttribute("patient",
//						Dao.getByName(name, Patient.class).getId());
				// response.sendRedirect(request.getContextPath() +
				// "/HospitalPage.jsp");
				resp.getWriter().append("success");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("fail");
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
