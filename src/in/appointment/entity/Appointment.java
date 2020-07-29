package in.appointment.entity;

public class Appointment {
	private int appointment_ID;
	private String appt_Date;
	private String appt_Time;
	private String name;
	private int numb_People;
	private String phone;
	private String note;
	public int getAppointment_ID() {
		return appointment_ID;
	}
	public void setAppointment_ID(int appointment_ID) {
		this.appointment_ID = appointment_ID;
	}
	public String getAppt_Date() {
		return appt_Date;
	}
	public void setAppt_Date(String appt_Date) {
		this.appt_Date = appt_Date;
	}

	public String getAppt_Time() {
		return appt_Time;
	}
	public void setAppt_Time(String appt_Time) {
		this.appt_Time = appt_Time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumb_People() {
		return numb_People;
	}
	public void setNumb_People(int numb_People) {
		this.numb_People = numb_People;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Appointment [appointment_ID=" + appointment_ID + ", appt_Date=" + appt_Date + ", appt_Time=" + appt_Time
				+ ", name=" + name + ", numb_People=" + numb_People + ", phone=" + phone + ", note=" + note + "]";
	}
	
	
	
}
