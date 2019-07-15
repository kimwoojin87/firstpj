package com.kitri.library.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenagerDao extends DBConnector {
	private PreparedStatement pstmt;
	private ResultSet stmt;
	List<MenagerDto> list = new ArrayList<MenagerDto>();

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� �ε� ����");
			e.printStackTrace();
		}

	}// end static classload

	public MenagerDao() {
		setAllList();
	}

	public MenagerDao(String url, String id, String pass) {
		super(url, id, pass);
	}// End BookDao
	// {"book_id","book_name","writer","publisher","date","positon","image_path"};

	//db���� �Է��ϱ����..
	public void insert(MenagerDto dto) {
		if (connect()) {
			String query = "insert into member values (?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, dto.employee_id);
				pstmt.setString(2, dto.name);
				pstmt.setString(3, dto.id);
				pstmt.setString(4, dto.password);
				pstmt.executeUpdate();
				System.out.println("�����ͺ��̽� �Է� ����");
			} catch (SQLException e) {
				System.out.println("�����ͺ��̽� �Է� ����");
				e.printStackTrace();
			}
		}
		close();
	}// end insert

	public void setAllList() {
		if (connect()) {
			try {
				String query = "select * from manager";
				pstmt = conn.prepareStatement(query);
				stmt = pstmt.executeQuery(query);
				while (stmt.next()) {
					MenagerDto menagerDto = new MenagerDto(stmt.getInt(1), stmt.getString(2), stmt.getString(3),
							stmt.getString(4));
					list.add(menagerDto);
				} // end while

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();

	}// end selectListAll

	public void delete(String str) {
		String query = "delete from manager where manager_id = ?";
		try {
			if (connect()) {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, str);
				int n = pstmt.executeUpdate();
				if (n > 0) {
					System.out.println("���� �Ϸ�");
				} else {
					System.out.println("���� ����");
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
	}// end delete

	private void close() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("���� ���� ����");
			e.printStackTrace();
		}
	}//end close

	public List<MenagerDto> getList() {
		return list;
	}//end getList
}
