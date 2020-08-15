package in.appointment.entity;

public class Login {
	private int login_ID;
	private String userEmail;
	private String passWord;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLogin_ID() {
		return login_ID;
	}
	public void setLogin_ID(int login_ID) {
		this.login_ID = login_ID;
	}

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
