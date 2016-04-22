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

import model.Department;
import model.Hospital;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		SessionFactory sessionFactory = hibernate.Factory.get();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
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
		
		
		session.save(hospital);
		session.save(hospital2);
		session.save(department1);
		session.save(department2);
		
		transaction.commit();
		session.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
