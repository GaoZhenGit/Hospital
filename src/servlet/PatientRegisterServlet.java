package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamanage.PatientManage;

import model.Patient;

@WebServlet(name="PatientRegisterServlet",urlPatterns="/PatientRegisterServlet")
public class PatientRegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4693553661640688267L;
	private Patient patient;
	private String phone;
	private String password;
	private boolean isRegister = false;
	public PatientRegisterServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req);
		processResponse(resp);
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	public void processRequest(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
			phone = req.getParameter("phone");
			password = req.getParameter("password");
			if (null != phone && null != password) {
				if(PatientManage.checkRegister(phone)){
					patient = new Patient();
					patient.setAccount(phone);
					patient.setPassword(password);
					PatientManage.saveData(patient);
					isRegister = true;
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public void processResponse(HttpServletResponse resp) {
		try {
			if (isRegister) {
				resp.sendRedirect("Register.jsp");
//				resp.setCharacterEncoding("UTF-8");
//				resp.setContentType("text/html;charset=utf-8");
//				PrintWriter out=resp.getWriter();
//				out.append("注册成功！");
//				out.close();
			}else {
				resp.sendRedirect("PatientRegister.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
