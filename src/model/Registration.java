package model;

public class Registration {
	
	private String id;
	private int year;
	private int month;
	private boolean hasPay;
	private Doctor doctor;
	private Patient patient;
	private TimeQuantum timeQuantum;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public TimeQuantum getTimeQuantum() {
		return timeQuantum;
	}
	public void setTimeQuantum(TimeQuantum timeQuantum) {
		this.timeQuantum = timeQuantum;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public boolean isHasPay() {
		return hasPay;
	}
	public void setHasPay(boolean hasPay) {
		this.hasPay = hasPay;
	}
}
