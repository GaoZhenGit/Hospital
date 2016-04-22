package model;

public class Doctor extends Person{
	
	private Department department;
	private int workAge;
	private String description;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getWorkAge() {
		return workAge;
	}
	public void setWorkAge(int workAge) {
		this.workAge = workAge;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
