package in.appointment.dao;

import in.appointment.entity.Login;

public interface LoginDAO {
	String authenticate(Login login);
}
