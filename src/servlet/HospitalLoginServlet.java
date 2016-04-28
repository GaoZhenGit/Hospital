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
@WebServlet("/HospitalLogin.html")
public class HospitalLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HospitalLoginServlet() {
        super();
    } 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/hospitalLogin.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		if(session.getAttribute("hospital")!=null){
//			response.sendRedirect("/loginSussess.jsp");
//		}
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		Map<String, String> param = new HashMap<>();
		param.put("account", account);
		param.put("password", password);
		
		List<Hospital> list = Dao.queryByMulti(param, Hospital.class);
		if(list.size()==1){
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(30000);
			session.setAttribute("hospital", list.get(0).getId());
			response.sendRedirect(request.getContextPath() + "/HospitalPage.jsp");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/HospitalLogin.jsp");
			request.setAttribute("err", "医院账号或密码错误");
			rd.forward(request, response);
		}
		
	}

}
