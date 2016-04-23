package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.Dao;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;
import model.Person;
import model.Registration;
import model.TimeQuantum;
import model.Title;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n");
//		SessionFactory sessionFactory = hibernate.Factory.get();
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
		
		Hospital hospital = new Hospital();
		hospital.setName("协和医院");
		hospital.setAddress("莆田系");
		
		Hospital hospital2 = new Hospital();
		hospital2.setName("仁爱医院");
		hospital2.setAddress("又是莆田系");
		
		Department department1 = new Department();
		department1.setName("外科");
		department1.setHospital(hospital);
		
		Department department2 = new Department();
		department2.setName("内科");
		department2.setHospital(hospital);
		
		Title title1 = new Title();
		title1.setId("1");
		title1.setFee(20);
		title1.setName("教授");
		
		Doctor doctor1 = new Doctor();
		doctor1.setAge(50);
		doctor1.setName("李时珍");
		doctor1.setSex(Person.MALE);
		doctor1.setDepartment(department1);
		doctor1.setTitle(title1);
		
		Patient patient = new Patient();
		patient.setAccout("lidong");
		patient.setName("LiDong");
		patient.setAge(23);
		patient.setSex(Person.MALE);
		
		TimeQuantum timeQuantum = new TimeQuantum(15, 00);
		timeQuantum.setId("1");
		
		Registration registration = new Registration();
		registration.setDoctor(doctor1);
		registration.setTimeQuantum(timeQuantum);
		registration.setPatient(patient);
		
		
		try {
			Dao.save(hospital,
					hospital2,
					department1,
					department2,
					title1,
					doctor1,
					patient,
					timeQuantum,
					registration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Hospital hospital3 = Dao.getByName("协和医院", Hospital.class);
		response.getWriter().append(hospital3.getId()).append(hospital3.getName());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
