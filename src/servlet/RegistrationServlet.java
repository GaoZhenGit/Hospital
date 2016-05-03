package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.Dao;
import model.Doctor;
import model.Patient;
import model.Registration;
import model.TimeQuantum;

@WebServlet("/Registration.html")
public class RegistrationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
	}

	@Override
	protected void back(HttpServletResponse response) {

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

		String doctorId = request.getParameter("doctor");
		String timeId = request.getParameter("time");
		if (isEmpty(doctorId, timeId)) {
			back(response);
			return;
		}
		Doctor doctor = Dao.getById(doctorId, Doctor.class);
		TimeQuantum timeQuantum = Dao.getById(timeId, TimeQuantum.class);
		if (isNull(doctor, timeQuantum)) {
			back(response);
		}

		try {
			List<Registration> registrations = Dao.getRegistrations(doctor, patient, timeQuantum);
			if (registrations.size() >= doctor.getPreTimePatient()) {
				back(response);
				return;
			}

			Registration registration = new Registration();
			registration.setDoctor(doctor);
			registration.setPatient(patient);
			registration.setTimeQuantum(timeQuantum);
			Dao.save(registration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
