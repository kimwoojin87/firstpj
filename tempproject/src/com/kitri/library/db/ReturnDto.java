package com.kitri.library.db;

import java.sql.Date;

public class ReturnDto {
	int return_id;
	String isbn_id;
	String memger_id;
	Date return_date;
	public ReturnDto(int return_id, String isbn_id, String memger_id, Date return_date) {
		super();
		this.return_id = return_id;
		this.isbn_id = isbn_id;
		this.memger_id = memger_id;
		this.return_date = return_date;
	}
	public int getReturn_id() {
		return return_id;
	}
	public void setReturn_id(int return_id) {
		this.return_id = return_id;
	}
	public String getIsbn_id() {
		return isbn_id;
	}
	public void setIsbn_id(String isbn_id) {
		this.isbn_id = isbn_id;
	}
	public String getMemger_id() {
		return memger_id;
	}
	public void setMemger_id(String memger_id) {
		this.memger_id = memger_id;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	
}
