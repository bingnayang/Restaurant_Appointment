package in.appointment.dao;

import java.util.List;

import in.appointment.entity.Appointment;

public interface AppointmentDAO {
	// Get all appointments from database
	List<Appointment> getAllActive();
	// Get current day appointments
	List<Appointment> getCurrentList();
	// Get past day appointments
	List<Appointment> getPastList();
	// Save an appointment to database
	boolean save(Appointment appt);
	// Delete an appointment from database
	boolean delete(int id);
	// Get an appointment from database by ID
	Appointment get(int id);
	
}
