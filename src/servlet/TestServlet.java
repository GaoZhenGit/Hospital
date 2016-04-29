package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.Restrictions;

import hibernate.Dao;
import model.Doctor;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet.html")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TestServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Doctor doctor = Dao.getAll(Doctor.class).get(0);
		try {
			response.getWriter().append(Dao.getRegistrations(doctor, null, null).size()+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
