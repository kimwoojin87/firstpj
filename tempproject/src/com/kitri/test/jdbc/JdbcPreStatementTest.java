package com.kitri.test.jdbc;

import java.sql.*;

public class JdbcPreStatementTest {

	public static void main(String[] args) {
		Connection conn = null;
		JdbcPreStatementTest jdb1 = new JdbcPreStatementTest();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "kitri";
			String pass = "kitri";
			conn = DriverManager.getConnection(url, id, pass);
			System.out.println("db ���� �Ϸ�");

			// select�� =>statement�� ����
			String query = "select * from emp_all";
			PreparedStatement pstmt = conn.prepareStatement(query);
			jdb1.select(query, pstmt);

			// insert delete update�� =>state���� �ٸ�
			query = "select * from emp_all";
			jdb1.insert(query, pstmt);

//			Driver dr= DriverManager.getDriver(url);
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
		} // end finally
	}// end main

	//�Է±��
	private void insert(String query, PreparedStatement pstmt) {
		query = "insert into emp_50 (eid, name, sal, dname) values(?, ?, ?, ?)";
		try {
			pstmt.setInt(1, 123);
			pstmt.setString(2, "������");
			pstmt.setInt(3, 500);
			pstmt.setString(4, "����");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//end insert

	//�˻�
	public void select(String query, PreparedStatement pstmt) {
		ResultSet stmt;
		try {
			stmt = pstmt.executeQuery(query);
			while (stmt.next()) {
				System.out.println(stmt.getString(1) + "\t" + stmt.getString(2) + "\t" + stmt.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//end select
}//end mainClass 
