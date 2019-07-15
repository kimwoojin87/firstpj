package com.kitri.library.db;

public class MenagerDto {
	int employee_id;
	String name;
	String id;
	String password;
	
	public MenagerDto(int employee_id, String name, String id, String password) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.id = id;
		this.password = password;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
