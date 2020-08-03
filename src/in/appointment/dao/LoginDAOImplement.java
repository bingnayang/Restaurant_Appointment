package in.appointment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.sqlite.jdbc4.JDBC4PreparedStatement;

import in.appointment.entity.Login;
import in.appointment.util.DBConnectionUtil;

public class LoginDAOImplement implements LoginDAO{

	@Override
	public String authenticate(Login login) {
		String sql = "SELECT * FROM login WHERE userEmail = ? AND userPassword = ?";
		try {
			Connection conn = DBConnectionUtil.openConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,login.getUserEmail());
			ps.setString(2,login.getPassWord());
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				return "true";
			}else {
				return "false";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

}
