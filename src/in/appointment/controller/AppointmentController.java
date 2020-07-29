package in.appointment.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
	
	RequestDispatcher dispatcher = null;
	// Create a reference variable for apptInfo DAO
	AppointmentDAO apptInfoDAO = null;
	// Create constructor and initaize apptInfo DAO
	public AppointmentController() {
		apptInfoDAO = new AppointmentDAOImplement();
	}    
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action == null) {
			action = "LIST";
		}
		switch(action) {
			case "LIST":
				listAppointment(request,response);
				break;
			case "EDIT":
				getSingleAppointment(request,response);
				break;
			case "DELETE":
				deleteAppointment(request,response);
				break;
			default:
				listAppointment(request,response);
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String apptDate = request.getParameter("date");
		String apptTime = LocalTime.parse(request.getParameter("time"), DateTimeFormatter.ofPattern("HH:mm")).format(DateTimeFormatter.ofPattern("hh:mm a"));
		String name = request.getParameter("name");
		int numberPeople = Integer.parseInt(request.getParameter("people"));
		String phone = request.getParameter("phone");
		String note = request.getParameter("note");
		
		Appointment appt = new Appointment();
		appt.setAppt_Date(apptDate);
		appt.setAppt_Time(apptTime);
		appt.setName(name);
		appt.setNumb_People(numberPeople);
		appt.setPhone(phone);
		appt.setNote(note);
		
		// Test if form get the data and print out
//		System.out.println("Date: "+apptDate);
//		System.out.println("Time: "+apptTime);
//		System.out.println("Name: "+name);
//		System.out.println("Number of People: "+numberPeople);
//		System.out.println("Phone: "+phone);
//		System.out.println("Note: "+note);
		
		
		if(apptInfoDAO.save(appt)) {
			request.setAttribute("message","Table Reserved");
		}
		listAppointment(request,response);
	}
	
	public void listAppointment(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// Call DAO method to get list of apptInfo
		List<Appointment> allAppointmentList = apptInfoDAO.get();		
		// Add the book to request object
		request.setAttribute("allAppointmentList",allAppointmentList);
		
		// Get the request dispatcher
		dispatcher = request.getRequestDispatcher("/views/appointment-list.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
	}
	public void getSingleAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		Appointment appointment = apptInfoDAO.get(Integer.parseInt(id));
		request.setAttribute("appointment",appointment);
		// Get the request dispatcher
		dispatcher = request.getRequestDispatcher("/views/appointment-add.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
	}
	public void deleteAppointment(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		String id = request.getParameter("id");
		if(apptInfoDAO.delete(Integer.parseInt(id))){
			request.setAttribute("message","Appointment has been deleted");
		}
		listAppointment(request,response);
	}

}
