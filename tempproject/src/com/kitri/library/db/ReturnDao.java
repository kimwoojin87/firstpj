package com.kitri.library.db;

import java.sql.*;
import java.util.*;

//조회 추가 삭제... 조작
public class ReturnDao extends DBConnector {
	private PreparedStatement pstmt;
	private ResultSet stmt;
	List<ReturnDto> list = new ArrayList<ReturnDto>();
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패");
			e.printStackTrace();
		}
	}// end static classload

	public ReturnDao() {
		setAllList();
	}

	public ReturnDao(String url, String id, String pass) {
		super(url, id, pass);
	}// End BookDao

	public void insert(ReturnDto dto) {
		connect();
		String query = "insert into return values (?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dto.return_id);
			pstmt.setString(2, dto.isbn_id);
			pstmt.setString(3, dto.memger_id);
			pstmt.setDate(4, dto.return_date);
			pstmt.executeUpdate();
			System.out.println("데이터베이스 입력 성공");
		} catch (SQLException e) {
			System.out.println("데이터베이스 입력 실패");
			e.printStackTrace();
		}
		close();
	}// end insert

	public void setAllList() {
		connect();
		String query = "select * from return";
		try {
			
			pstmt = conn.prepareStatement(query);
			stmt = pstmt.executeQuery(query);
			while (stmt.next()) {
				ReturnDto returnDto = new ReturnDto(stmt.getInt(1), stmt.getString(2), stmt.getString(3),
						stmt.getDate(4));
				list.add(returnDto);
			} // end while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	}// end selectListAll

	public void delete(String member_id) {
		String query = "delete from return where member_id = ?";

		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member_id);
			int n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("삭제 실패");
				return;
			}

		} catch (SQLException e) {
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
			System.out.println("연결 해제 실패");
			e.printStackTrace();
		}
	}

	public List<ReturnDto> getList() {
		return list;
	}

}// end BookDao class
