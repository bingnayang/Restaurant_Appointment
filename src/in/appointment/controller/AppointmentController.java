package in.appointment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.appointment.dao.AppointmentDAO;
import in.appointment.dao.AppointmentDAOImplement;
import in.appointment.entity.Appointment;

public class AppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Create a reference variable for apptInfo DAO
	AppointmentDAO apptInfoDAO = null;
	// Create constructor and initaize apptInfo DAO
	public AppointmentController() {
		apptInfoDAO = new AppointmentDAOImplement();
	}    
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Call DAO method to get list of apptInfo
		List<Appointment> allAppointmentList = apptInfoDAO.get();		
		// Add the book to request object
		request.setAttribute("allAppointmentList",allAppointmentList);
		
		// Get the request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/appointment-list.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
