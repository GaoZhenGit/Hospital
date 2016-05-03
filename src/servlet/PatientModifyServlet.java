package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.Dao;
import model.Patient;
import model.Person;

@WebServlet("/PatientModifyServlet")
public class PatientModifyServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public PatientModifyServlet() {
		super();
	}

	@Override
	protected void back(HttpServletResponse response) {
		super.back(response);
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
		Patient patient = (Patient) request.getSession(true).getAttribute("patient");

		if (patient == null) {
			back(response);
			return;
		}

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String bankAccount = request.getParameter("bankaccount");

		if (!isEmpty(name)) {
			patient.setName(name);
		}
		if (!isEmpty(age)) {
			try {
				patient.setAge(Integer.parseInt(age));
			} catch (Exception exception) {

			}
		}
		if (!isEmpty(sex)) {
			try {
				patient.setSex(Integer.parseInt(sex) == Person.MALE ? Person.MALE : Person.FEMALE);
			} catch (Exception exception) {

			}
		}
		if(!isEmpty(account)){
			patient.setAccount(account);
		}
		if(!isEmpty(password)){
			patient.setPassword(password);
		}
		if(!isEmpty(bankAccount)){
			patient.setBankAccount(bankAccount);;
		}
		
		try {
			Dao.update(patient);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
