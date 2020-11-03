package in.appointment.controller;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.appointment.dao.AppointmentDAO;
import in.appointment.dao.AppointmentDAOImplement;
import in.appointment.dao.LoginDAO;
import in.appointment.dao.LoginDAOImplement;
import in.appointment.entity.Appointment;

public class AppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	AppointmentDAO apptInfoDAO = null;
	LoginDAO loginDAO = new LoginDAOImplement();
	
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
			case "LIST_TODAY":
				listTodayAppointment(request,response);
				break;
			case "LIST_PAST":
				listPastAppointment(request,response);
				break;
			case "SEARCH":
				searchAppointment(request,response);
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
		String apptID = request.getParameter("id");
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
//		System.out.println("Id: "+apptID);		
//		System.out.println("Date: "+apptDate);
//		System.out.println("Time: "+apptTime);
//		System.out.println("Name: "+name);
//		System.out.println("Number of People: "+numberPeople);
//		System.out.println("Phone: "+phone);
//		System.out.println("Note: "+note);
		
		
		if(apptID.isEmpty() || apptID == null) {
			// Insert new appointment
			if(apptInfoDAO.save(appt)) {
				request.setAttribute("message","Appointment Book");
			}
		}else {
			// Update an appointment
			appt.setAppointment_ID(Integer.parseInt(apptID));
			if(apptInfoDAO.update(appt)) {
				request.setAttribute("message","Appointment Update");
			}
		}
		// Redirect back to appointment list page
		listAppointment(request,response);
	}
	
	public void listAppointment(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// Call DAO method to get list of apptInfo
		List<Appointment> allAppointmentList = apptInfoDAO.getAllActive();		
		// Add the book to request object
		request.setAttribute("allAppointmentList",allAppointmentList);
		// Get the request dispatcher
		dispatcher = request.getRequestDispatcher("/views/appointment-list.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
	}
	public void listTodayAppointment(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// Call DAO method to get list of apptInfo
		List<Appointment> appointmentList = apptInfoDAO.getCurrentList();		
		// Add the book to request object
		request.setAttribute("allAppointmentList",appointmentList);
		// Get the request dispatcher
		dispatcher = request.getRequestDispatcher("/views/appointment-list.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
	}
	public void listPastAppointment(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// Call DAO method to get list of apptInfo
		List<Appointment> pastApptmentList = apptInfoDAO.getPastList();		
		// Add the book to request object
		request.setAttribute("allAppointmentList",pastApptmentList);
		request.setAttribute("appointmentType","past_appt");
		// Get the request dispatcher
		dispatcher = request.getRequestDispatcher("/views/appointment-list.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
	}
	public void getSingleAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		Appointment appointment = apptInfoDAO.get(Integer.parseInt(id));
		String getTime = appointment.getAppt_Time();
		String timeFormat = LocalTime.parse(getTime, DateTimeFormatter.ofPattern("hh:mm a")).format(DateTimeFormatter.ofPattern("HH:mm"));
		appointment.setAppt_Time(timeFormat);
		
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
	public void searchAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String requestUrl = request.getRequestURI();
		String name = requestUrl.substring("/AppointmentController?phoneNumber=".length());
		System.out.println("Test: "+name);
		
		String phoneNumb = request.getParameter("phoneNumber");
		System.out.println("Phone Number:"+phoneNumb);
		List<Appointment> searchApptmentList = apptInfoDAO.getAppointmentByPhone(phoneNumb);
		// Add the book to request object
		request.setAttribute("allAppointmentList",searchApptmentList);
		// Get the request dispatcher
		dispatcher = request.getRequestDispatcher("/views/appointment-list.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
	}
}
