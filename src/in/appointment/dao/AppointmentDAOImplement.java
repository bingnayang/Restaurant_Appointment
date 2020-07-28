package in.appointment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public List<Appointment> get() {
		// Create reference variables
		List<Appointment> list = null;
		Appointment apptInfo = null;
		
		try {
			list = new ArrayList<Appointment>();
			// SQL
			String sql = "SELECT * FROM appointments";
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

}
