package servlet;

import java.io.IOException;
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
@WebServlet(name="PatientLoginServlet",urlPatterns="/PatientLoginServlet")
public class PatientLoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3808441270759576973L;
	private String phone;
	private String password;
	private boolean isLogin=false;
	private Patient patient;
	private RequestDispatcher rd;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req);
		processPost(resp);
		if(isLogin){
			rd=getServletContext().getRequestDispatcher("/Register.jsp");
			rd.forward(req, resp);
		}else {
			rd=getServletContext().getRequestDispatcher("/PatientLogin.jsp");
			rd.forward(req, resp);
		}
	}
	public void processRequest(HttpServletRequest req){
		try {
			req.setCharacterEncoding("utf-8");
			password=req.getParameter("password");
			phone=req.getParameter("phone");
			if(null!=password&&null!=phone){
				if(null!=PatientManage.login(phone, password)){
					patient=PatientManage.login(phone, password);
					HttpSession session=req.getSession();
					session.setAttribute("id", patient.getId());
					isLogin=true;
				}else {
					req.setAttribute("err", "用户名或者密码错误！");
				}
			}else {
				req.setAttribute("err", "用户名或者密码不能为空！");
				
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void processPost(HttpServletResponse resp){
		
	}
}
