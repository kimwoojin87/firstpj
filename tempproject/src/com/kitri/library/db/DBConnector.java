package com.kitri.library.db;

import java.sql.*;

public class DBConnector {
	protected Connection conn;

	protected String url;
	protected String id;
	protected String pass;

	protected DBConnector() {
		super();
		url = "jdbc:oracle:thin:@192.168.14.34:1521:orcl";
		//프로토콜 jdbc :oracle :thin
		//@오라클만의 특징
		id = "kitri";
		pass = "kitri";
	}

	protected synchronized boolean connect() {
		try {
			conn = DriverManager.getConnection(url, id, pass);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public DBConnector(String url, String id, String pass) {
		super();
		this.url = url;
		this.id = id;
		this.pass = pass;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = DriverManager.getConnection(url, "Kyou", "1234");
		return conn;
	}

}
