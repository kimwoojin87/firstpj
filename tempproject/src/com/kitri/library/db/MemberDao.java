package com.kitri.library.db;

import java.sql.*;
import java.sql.Date;
import java.util.*;

//조회 추가 삭제... 조작
public class MemberDao extends DBConnector {
	private PreparedStatement pstmt;
	private ResultSet stmt;

	List<MemberDto> list = new ArrayList<MemberDto>();
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패");
			e.printStackTrace();
		}

	}// end static classload

	public MemberDao() {
		setAllList();
	}

	public MemberDao(String url, String id, String pass) {
		super(url, id, pass);
	}// End BookDao
		// {"book_id","book_name","writer","publisher","date","positon","image_path"};

	public void insert(MemberDto dto) {
		connect();
		String query = "insert into member values (?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.member_id);
			pstmt.setString(2, dto.member_name);
			pstmt.setString(3, dto.phone_number);
			pstmt.setString(4, dto.address);
			pstmt.setString(5, dto.gender);
			pstmt.setDate(6, dto.birthday);
			pstmt.executeUpdate();
			System.out.println("데이터베이스 입력 성공");
		} catch (SQLException e) {
			System.out.println("데이터베이스 입력 실패");
			e.printStackTrace();
		}
	}// end insert

	public void setAllList() {
		if (connect()) {
			String query = "select * from member";
			try {
				pstmt = conn.prepareStatement(query);
				stmt = pstmt.executeQuery(query);
				while (stmt.next()) {
					MemberDto memberDto = new MemberDto(stmt.getString(1), stmt.getString(2), stmt.getString(3),
							stmt.getString(4), stmt.getString(5), stmt.getDate(6));
					list.add(memberDto);
				} // end while

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();

	}// end selectListAll

	public void delete(String member_id) {
		String query = "delete from member where member_id = ?";
		try {
			if (connect()) {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, member_id);
				int n = pstmt.executeUpdate();
				if (n > 0) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패");
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
			System.out.println("연결 해제 실패");
			e.printStackTrace();
		}
	}

	public List<MemberDto> getList() {
		return list;
	}

}// end BookDao class
