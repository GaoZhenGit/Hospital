package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.Dao;
import model.Hospital;

@WebServlet("/HospitalModify.html")
public class HospitalModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HospitalModifyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/HospitalPage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String hospitalId = (String) request.getSession(true).getAttribute("hospital");
		if (hospitalId == null) {
			response.sendRedirect(request.getContextPath() + "/HospitalLogin.jsp");
			return;
		}
		Hospital hospital = Dao.getById(hospitalId, Hospital.class);

		// 判断修改动作：修改医院属性
		// if(request.getParameter("operation").equals("modifyHospital")){
		modifyHospital(request, response, hospital);
		// }

		response.sendRedirect(request.getContextPath() + "/HospitalPage.jsp");
	}

	private void modifyHospital(HttpServletRequest request, HttpServletResponse response, Hospital hospital) {
		String account = request.getParameter("account");
		if (account != null && account.length() != 0) {
			hospital.setAccount(request.getParameter("account"));
		}
		String password = request.getParameter("password");
		if (password != null && password.length() != 0) {
			hospital.setPassword(request.getParameter("password"));
		}
		String description = request.getParameter("description");
		if (description != null && description.length() != 0) {
			hospital.setDescription(request.getParameter("description"));
		}
		String address = request.getParameter("address");
		if (address != null && address.length() != 0) {
			hospital.setAddress(request.getParameter("address"));
		}
		String name = request.getParameter("name");
		if (name != null && name.length() != 0) {
			hospital.setName(request.getParameter("name"));
		}
		try {
			Dao.update(hospital);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
