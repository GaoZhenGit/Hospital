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

@WebServlet("/init.html")
public class TestInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestInitServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("<br/>");

		Hospital hospital = new Hospital();
		hospital.setName("协和医院");
		hospital.setAddress("莆田系");
		hospital.setDescription("专治不孕不育");
		hospital.setAccount("xiehe");
		hospital.setPassword("654321");

		Hospital hospital2 = new Hospital();
		hospital2.setName("仁爱医院");
		hospital2.setAddress("又是莆田系");
		hospital2.setDescription("还是治不孕不育");
		hospital2.setAccount("renai");
		hospital2.setPassword("123456");

		Department department1 = new Department();
		department1.setName("外科");
		department1.setHospital(hospital);
		department1.setDescription("临床外科门诊");

		Department department2 = new Department();
		department2.setName("内科");
		department2.setHospital(hospital);
		department2.setDescription("病毒学内科");
 
		Title title1 = new Title();
		title1.setId("1");
		title1.setFee(50);
		title1.setName("主任医师");
		
		Title title2 = new Title();
		title2.setId("2");
		title2.setFee(30);
		title2.setName("副主任医师");

		Doctor doctor1 = new Doctor();
		doctor1.setAge(50);
		doctor1.setName("李时珍");
		doctor1.setSex(Person.MALE);
		doctor1.setDepartment(department1);
		doctor1.setTitle(title1);
		doctor1.setDescription("中医专治十余年");
		doctor1.setWorkAge(12);
		
		Doctor doctor2 = new Doctor();
		doctor2.setAge(45);
		doctor2.setName("终南山");
		doctor2.setSex(Person.MALE);
		doctor2.setDepartment(department2);
		doctor2.setTitle(title2);
		doctor2.setDescription("抗击非典英雄");
		doctor2.setWorkAge(20);

		Patient patient = new Patient();
		patient.setAccount("lidong");
		patient.setName("LiDong");
		patient.setPassword("123456");
		patient.setAge(23);
		patient.setSex(Person.MALE);

		TimeQuantum timeQuantum = new TimeQuantum(15, 00);
		timeQuantum.setId("1");

		Registration registration = new Registration();
		registration.setDoctor(doctor1);
		registration.setTimeQuantum(timeQuantum);
		registration.setPatient(patient);

		try {
			Dao.save(hospital, hospital2, department1, department2, title1, doctor1, patient, timeQuantum,
					registration);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Hospital hospital3 = Dao.getByName("协和医院", Hospital.class);
		response.getWriter().append(hospital3.getId()).append(hospital3.getName()).append("<br/>");
		for (Department d : hospital3.getDepartments()) {
			response.getWriter().append(d.getName()).append(":<br/>");
			for (Doctor doctor : d.getDoctors()) {
				response.getWriter().append(doctor.getName()).append("职称：" + doctor.getTitle().getName())
						.append("<br/>");
			}
		}
		hospital3.setAddress("深圳市莆田系");
		try {
			Dao.update(hospital3);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
