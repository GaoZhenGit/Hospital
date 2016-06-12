package servlet;

import hibernate.Dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Doctor;
import model.Patient;
import model.Registration;
import model.TimeQuantum;
@WebServlet(name = "GuaHaoServlet", urlPatterns = "/GuaHaoServlet")
public class GuaHaoServlet extends BaseServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String doctor=(String)req.getParameter("doctor");
		String time=(String)req.getParameter("time");
		System.out.println("time"+time+".");
		Doctor d=new Doctor();
		d=Dao.getByName(doctor, Doctor.class);
		Patient patient=Dao.getById((String)req.getSession().getAttribute("patient"),Patient.class);
		TimeQuantum timeQuantum=Dao.getTime(time);
		try {
			if(Dao.getRegistrations(d, null, timeQuantum).size()<d.getPreTimePatient()){
				//resp.getWriter().append("success");		
				resp.sendRedirect("perchuse.html");
				Registration registration=new Registration();
				registration.setDoctor(d);
				registration.setPatient(patient);
				registration.setTimeQuantum(timeQuantum);
				Dao.save(registration);	
				
			}else{
				resp.getWriter().append("fail");
			}
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
