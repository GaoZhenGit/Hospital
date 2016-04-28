package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.Dao;
import model.Hospital;

/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/Department")
public class DepartmentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public DepartmentServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/HospitalPage.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String hospitalId = (String) request.getSession(true).getAttribute("hospital");
		if (hospitalId == null) {
			response.sendRedirect(request.getContextPath() + "/HospitalLogin.jsp");
			return;
		}
		Hospital hospital = Dao.getById(hospitalId, Hospital.class);
		
		String type = request.getParameter("type");
		if(type == null || type.length() == 0){
			response.sendRedirect(request.getContextPath() + "/HospitalLogin.jsp");
			return;
		}
		
		if(type.equals("add")){
			
		}else if(type.equals("modify")){
			
		}
	}

}
