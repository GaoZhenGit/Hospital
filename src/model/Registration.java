package model;

public class Registration {
	
	private String id;
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
}
