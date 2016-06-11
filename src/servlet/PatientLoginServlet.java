package servlet;

import hibernate.Dao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datamanage.PatientManage;

import model.Hospital;
import model.Patient;
@WebServlet(name="PatientLoginServlet",urlPatterns="/PatientLoginServlet")
public class PatientLoginServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3808441270759576973L;
	private String phone;
	private String password;
	private boolean isLogin=false;
	private Patient patient;
	private RequestDispatcher rd;
	private static final String returnPage = "/Login.html";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		password=req.getParameter("password");
		phone=req.getParameter("phone");
		if(isEmpty(phone,password)){
			resp.sendRedirect(req.getContextPath() + returnPage);
		}
		Map<String, String> param = new HashMap<>();
		param.put("name",phone);
		param.put("password", password);
		List<Patient> list = Dao.queryByMulti(param, Patient.class);
		if (list.size() == 1) {
			HttpSession session = req.getSession(true);
			session.setMaxInactiveInterval(30000);
			session.setAttribute("patient", list.get(0).getId());
//			response.sendRedirect(request.getContextPath() + "/HospitalPage.jsp");
			resp.getWriter().append("success");
		} else {
//			RequestDispatcher rd = request.getRequestDispatcher(returnPage);
//			request.setAttribute("err", "医院账号或密码错误");
//			rd.forward(request, response);
			resp.getWriter().append("fail");
		}
	}
	
}
