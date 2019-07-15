package com.kitri.test.jdbc;

import java.sql.*;

public class JdbcStatementTest {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "kitri";
			String pass = "kitri";
			conn = DriverManager.getConnection(url, id, pass);
			Statement stmt = conn.createStatement();
			String query = "select * from emp_all";
			ResultSet rest = stmt.executeQuery(query);
			while (rest.next()) {
				System.out.println(rest.getString(1) + "\t" + rest.getString(2) + "\t" + rest.getString(3));
			}			
			query= "INSERT INTO student (num, name) VALUES (2,\'ȫ�浿\');";
			stmt.executeQuery(query);
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//end finally

		
	}// end main

}
