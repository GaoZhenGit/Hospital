package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.Dao;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Person;
import model.Title;

/**
 * Servlet implementation class DoctorServlet
 */
@WebServlet("/Doctor.html")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String HospitalPages = "/HospitalPages.jsp";

	public DoctorServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String hospitalId = (String) request.getSession(true).getAttribute("hospital");
		if (hospitalId == null) {
			response.sendRedirect(request.getContextPath() + "/Login.html");
			return;
		}
		Hospital hospital = Dao.getById(hospitalId, Hospital.class);

		String type = request.getParameter("type");
		if (type != null) {
			if (type.equals("add")) {
				Department department = null;
				String departmentId = request.getParameter("department");
				for (Department d : hospital.getDepartments()) {
					if (d.getId().equals(departmentId)) {
						department = d;
						break;
					}
				}
				if (department != null) {
					addDoctor(request, response, department);
				}
			} else if (type.equals("modify")) {
				modifyDoctor(request, response);
			} else if (type.equals("delete")) {
				deleteDoctor(request, response);
			}
		}
		response.sendRedirect(request.getContextPath() + HospitalPages);
	}

	private void addDoctor(HttpServletRequest request, HttpServletResponse response, Department department) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String workAge = request.getParameter("workage");
		String description = request.getParameter("description");
		String titleName = request.getParameter("title");

		if (isEmpty(name) || isEmpty(age) || isEmpty(workAge) || isEmpty(description) || isEmpty(titleName)
				|| isEmpty(sex)) {
			System.err.println("empty");
			System.err.println(isEmpty(name));
			System.err.println(isEmpty(age));
			System.err.println(isEmpty(workAge));
			System.err.println(isEmpty(description));
			System.err.println(isEmpty(titleName));
			System.err.println(isEmpty(sex));
			return;
		}

		Title title = Dao.getByName(titleName, Title.class);
		if (title == null) {
			System.err.println("no title");
			return;
		}
		try {
			Doctor doctor = new Doctor();
			doctor.setName(name);
			doctor.setAge(Integer.parseInt(age));
			doctor.setSex(Integer.parseInt(sex) == Person.MALE ? Person.MALE : Person.FEMALE);
			doctor.setTitle(title);
			doctor.setWorkAge(Integer.parseInt(workAge));
			doctor.setDepartment(department);
			doctor.setDescription(description);
			Dao.save(doctor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void modifyDoctor(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("modify");
		String id = request.getParameter("id");
		Doctor doctor = Dao.getById(id, Doctor.class);
		if (doctor == null) {
			System.out.println("doctor empty");
			return;
		}
		String name = request.getParameter("name");
		if (!isEmpty(name)) {
			doctor.setName(name);
		}
		String age = request.getParameter("age");
		if (!isEmpty(age)) {
			try {
				doctor.setAge(Integer.parseInt(age));
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		String sex = request.getParameter("sex");
		if (!isEmpty(sex)) {
			try {
				doctor.setSex(Integer.parseInt(age) == Person.MALE ? Person.MALE : Person.FEMALE);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		String workAge = request.getParameter("workage");
		if (!isEmpty(workAge)) {
			try {
				doctor.setWorkAge(Integer.parseInt(workAge));
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		String description = request.getParameter("descropition");
		if (!isEmpty(description)) {
			doctor.setDescription(description);
		}
		String titleName = request.getParameter("title");
		if (!isEmpty(titleName)) {
			Title title = Dao.getByName(titleName, Title.class);
			if (title == null)
				return;
			doctor.setTitle(title);
		}
		try {
			Dao.update(doctor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteDoctor(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Doctor doctor = Dao.getById(id, Doctor.class);
		if (doctor != null) {
			try {
				Dao.delete(doctor);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static boolean isEmpty(String s) {
		if (s == null || s.length() == 0)
			return true;
		return false;
	}

}
