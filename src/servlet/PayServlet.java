package servlet;

import hibernate.Dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Doctor;
import model.Patient;
import model.Registration;
import model.TimeQuantum;

@WebServlet(name = "PayServlet", urlPatterns = "/PayServlet")
public class PayServlet extends BaseServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String account=(String)req.getParameter("account");
		String password=(String)req.getParameter("password");
		String id=(String)req.getParameter("id");
		System.out.println("id:"+id);
		Registration registration=Dao.getById(id, Registration.class);
		Patient patient=Dao.getById((String)req.getSession().getAttribute("patient"),Patient.class);
		if(account.equals(patient.getBankAccount())){
			registration.setHasPay(true);
			resp.getWriter().append("success");	
		}else{
			registration.setHasPay(false);
			
		}
		try {
			Dao.update(registration);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
