package in.appointment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.appointment.dao.LoginDAO;
import in.appointment.dao.LoginDAOImplement;
import in.appointment.entity.Appointment;
import in.appointment.entity.Login;

public class LoginController extends HttpServlet{
	LoginDAO loginDAO = null;
	
	public LoginController() {
		loginDAO = new LoginDAOImplement();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Login login = new Login();
		String userEmail = req.getParameter("email");
		String userPassword = req.getParameter("password");
		
		login.setUserEmail(userEmail);
		login.setPassWord(userPassword);
		
//		System.out.println("Email: "+userEmail);
//		System.out.println("Password: "+userPassword);
		String status = loginDAO.authenticate(login);
		
		System.out.println("Status: "+status);
		if(status.equals("true")) {
			session.setAttribute("email",login.getUserEmail());
			resp.sendRedirect("AppointmentController?action=LIST");
		}
		if(status.equals("false")) {
			resp.sendRedirect("index.jsp?status=false");
		}
		if(status.equals("error")) {
			resp.sendRedirect("index.jsp?status=error");
		}
	}
	
	
}
