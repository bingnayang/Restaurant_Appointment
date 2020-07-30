package in.appointment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import in.appointment.entity.Appointment;
import in.appointment.util.DBConnectionUtil;

public class AppointmentDAOImplement implements AppointmentDAO {

	Connection conn = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	@Override
	public boolean save(Appointment appt) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO appointments (date,time,name,numb_people,phone,note) " + 
					"VALUES('"+appt.getAppt_Date()+"','"+appt.getAppt_Time()+"','"+appt.getName()+"',"+appt.getNumb_People()+",'"+appt.getPhone()+"','"+appt.getNote()+"')";
			conn = DBConnectionUtil.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Appointment get(int id) {
		Appointment appointment = null;
		try {
			appointment = new Appointment();
			String sql = "SELECT * FROM appointments WHERE appointment_ID ="+id;
			conn = DBConnectionUtil.openConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				appointment.setAppointment_ID(resultSet.getInt("appointment_ID"));
				appointment.setAppt_Date(resultSet.getString("date"));
				appointment.setAppt_Time(resultSet.getString("time"));
				appointment.setName(resultSet.getString("name"));
				appointment.setNumb_People(resultSet.getInt("numb_people"));
				appointment.setPhone(resultSet.getString("phone"));
				appointment.setNote(resultSet.getString("note"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return appointment;
	}

	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM appointments WHERE appointment_ID = "+id;
			conn = DBConnectionUtil.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
			
		}catch(SQLException e) {;
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public List<Appointment> getAllActive() {
		// Create reference variables
		List<Appointment> list = null;
		Appointment apptInfo = null;
		// Create a date object
		LocalDate currentDate = LocalDate.now();
		
		try {
			list = new ArrayList<Appointment>();
			// SQL
			String sql = "SELECT * FROM appointments where appointments.date >= '"+currentDate+"' ORDER BY date,time ASC";
			// Get the database connection
			conn = DBConnectionUtil.openConnection();
			// Create a statement
			statement = conn.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			// Process the resultSet
			while(resultSet.next()) {
				apptInfo = new Appointment();
				apptInfo.setAppointment_ID(resultSet.getInt("appointment_ID"));
				apptInfo.setAppt_Date(resultSet.getString("date"));
				apptInfo.setAppt_Time(resultSet.getString("time"));
				apptInfo.setName(resultSet.getString("name"));
				apptInfo.setNumb_People(resultSet.getInt("numb_people"));
				apptInfo.setPhone(resultSet.getString("phone"));
				apptInfo.setNote(resultSet.getString("note"));
				// Add book to list
				list.add(apptInfo);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Appointment> getCurrentList() {
		// Create reference variables
		List<Appointment> list = null;
		Appointment apptInfo = null;
		LocalDate localDate = LocalDate.now();

		try {
			list = new ArrayList<Appointment>();
			// SQL
			String sql = "SELECT * FROM appointments WHERE appointments.date = '"+localDate+"' ORDER BY time ASC";
			// Get the database connection
			conn = DBConnectionUtil.openConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
//			System.out.println(sql);
			// Process the resultSet
			while(resultSet.next()) {
				apptInfo = new Appointment();
				apptInfo.setAppointment_ID(resultSet.getInt("appointment_ID"));
				apptInfo.setAppt_Date(resultSet.getString("date"));
				apptInfo.setAppt_Time(resultSet.getString("time"));
				apptInfo.setName(resultSet.getString("name"));
				apptInfo.setNumb_People(resultSet.getInt("numb_people"));
				apptInfo.setPhone(resultSet.getString("phone"));
				apptInfo.setNote(resultSet.getString("note"));
				// Add book to list
				list.add(apptInfo);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Appointment> getPastList() {
		// Create reference variables
		List<Appointment> list = null;
		Appointment apptInfo = null;
		LocalDate localDate = LocalDate.now();

		try {
			list = new ArrayList<Appointment>();
			// SQL
			String sql = "SELECT * FROM appointments WHERE appointments.date < '"+localDate+"' ORDER BY date,time ASC";
			// Get the database connection
			conn = DBConnectionUtil.openConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
//			System.out.println(sql);
			// Process the resultSet
			while(resultSet.next()) {
				apptInfo = new Appointment();
				apptInfo.setAppointment_ID(resultSet.getInt("appointment_ID"));
				apptInfo.setAppt_Date(resultSet.getString("date"));
				apptInfo.setAppt_Time(resultSet.getString("time"));
				apptInfo.setName(resultSet.getString("name"));
				apptInfo.setNumb_People(resultSet.getInt("numb_people"));
				apptInfo.setPhone(resultSet.getString("phone"));
				apptInfo.setNote(resultSet.getString("note"));
				// Add book to list
				list.add(apptInfo);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
		
	}

}
