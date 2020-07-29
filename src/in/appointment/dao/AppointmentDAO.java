package in.appointment.dao;

import java.util.List;

import in.appointment.entity.Appointment;

public interface AppointmentDAO {
	List<Appointment> get();
	boolean save(Appointment appt);
	boolean delete(int id);
	Appointment get(int id);
	
}
