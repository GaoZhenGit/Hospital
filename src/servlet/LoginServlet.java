package servlet;

import java.io.IOException;
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

import hibernate.Dao;
import model.Patient;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login.html")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		Map <String,String> param = new HashMap<>();
		param.put("account", account);
		param.put("password", password);
		List<Patient> patients = Dao.queryByMulti(param, Patient.class);
//		response.getWriter().append(patients.size()+"");
		if(patients.size()==1){
			HttpSession session = request.getSession(true);
			session.setAttribute("id", patients.get(0).getId());
			
			RequestDispatcher rd = request.getRequestDispatcher("/personal.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("err", "账号或密码错误");
			rd.forward(request, response);
		}
		response.getWriter().flush();
	}

}
