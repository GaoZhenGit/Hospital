package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.Dao;
import model.Department;
import model.Hospital;

/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/Department.html")
public class DepartmentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final String HospitalPages = "/HospitalPages.jsp";

	public DepartmentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + HospitalPages);
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

		String type = request.getParameter("type");
		if (type == null || type.length() == 0) {
			response.sendRedirect(request.getContextPath() + HospitalPages);
			return;
		}

		if (type.equals("add")) {
			addDepartment(request, response, hospital);
		} else if (type.equals("modify")) {
			modifyDepartment(request, response);
		} else if (type.equals("delete")) {
			deleteDepartment(request, response);
		}

		response.sendRedirect(request.getContextPath() + HospitalPages);
	}

	private void addDepartment(HttpServletRequest request, HttpServletResponse response, Hospital hospital) {
		String name = request.getParameter("name");
		String description = request.getParameter("description");

		if (name == null || name.length() == 0 || description == null || description.length() == 0) {
			return;
		}

		Department department = new Department();
		department.setDescription(description);
		department.setName(name);
		department.setHospital(hospital);

		try {
			Dao.save(department);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void modifyDepartment(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		Department department = Dao.getById(id, Department.class);
		if(department==null){
			return;
		}
		
		if(name != null && name.length() != 0) {
			department.setName(name);
		}
		
		if(description != null && description.length() != 0){
			department.setDescription(description);
		}
		
		try {
			Dao.update(department);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void deleteDepartment(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		Department department = Dao.getById(id, Department.class);
		if(department==null){
			return;
		}
		try {
			Dao.delete(department);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
