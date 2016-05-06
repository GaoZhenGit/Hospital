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
import model.Hospital;

/**
 * Servlet implementation class HospitalLoginServlet
 */
@WebServlet("/HospitalLogin")
public class HospitalLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public HospitalLoginServlet() {
		super();
	}

	private static final String returnPage = "/Login.html";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + returnPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HttpSession session = request.getSession();
		// if(session.getAttribute("hospital")!=null){
		// response.sendRedirect("/loginSussess.jsp");
		// }
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(isEmpty(account,password)){
			response.sendRedirect(request.getContextPath() + returnPage);
		}

		Map<String, String> param = new HashMap<>();
		param.put("account", account);
		param.put("password", password);

		List<Hospital> list = Dao.queryByMulti(param, Hospital.class);
		if (list.size() == 1) {
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(30000);
			session.setAttribute("hospital", list.get(0).getId());
//			response.sendRedirect(request.getContextPath() + "/HospitalPage.jsp");
			response.getWriter().append("success");
		} else {
//			RequestDispatcher rd = request.getRequestDispatcher(returnPage);
//			request.setAttribute("err", "医院账号或密码错误");
//			rd.forward(request, response);
			response.getWriter().append("fail");
		}

	}

}
