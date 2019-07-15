package com.kitri.test.jdbc;

import java.sql.Date;
import java.util.*;

import com.kitri.library.db.*;


public class DBTest {
	static BookDao bookDao = new BookDao();
	static MemberDao memberDao = new MemberDao();
	static ReturnDao returnDao = new ReturnDao();

	public static void main(String[] args) {

		
		// ======================================================================================
		// testBookInsert();
		// testBookSelect();
		// testBookDelete();

		// testMemberSelect();
		

		// testReturnInsert();
		// testReturnSelect();
	}// end main

	public static void testBookInsert() {
		BookDao bookDao = new BookDao();
		// 현재 시간 입력
		Date sqlDate = new Date(Calendar.getInstance().getTime().getTime());// sql date로 사용해야한다.
//		BookDto bookDto = new BookDto("isbn2", "아프니까 청춘이다", "김난도", "isbn1", sqlDate, "김난도", "김난도");
//		bookDto = new BookDto("isbn5", "아프니까 청춘이다", "김난도", "isbn1", sqlDate, "김난도");
//		bookDao.insert(bookDto);
	}// end testBookInsert

	public static void testBookSelect() {
		List<BookDto> listBook = bookDao.getList();
		for (int i = 0; i < listBook.size(); i++) {
			System.out.println(listBook.get(i).getIsbn() + " " + listBook.get(i).getName());
		}
	}// end testBookSelect

	public static void testBookDelete() {
		bookDao.delete("isbn2");
	}

	public static void testMember() {
		Calendar cal = Calendar.getInstance();
		cal.set(1993, 1, 11);// (year + 1900, month, date, hrs, min
		Date sqlDate = new Date(cal.getTimeInMillis());// sql date로 사용해야한다.
		MemberDto memberDto = new MemberDto("멤버아이디", "멤버이름", "전화번호", "주소", "성별", sqlDate);
		memberDao.insert(memberDto);

	}// end testMember

	private static void testMemberSelect() {
		List<MemberDto> listMember = memberDao.getList();
		for (int i = 0; i < listMember.size(); i++) {
			System.out.println(listMember.get(i).getMember_id() + " " + listMember.get(i).getBirthday());
		}
	}

	private static void testReturnInsert() {
		Date culDate = new Date(Calendar.getInstance().getTime().getTime());// sql date로 사용해야한다.
		ReturnDto returnDto = new ReturnDto(2, "isbn2", "멤버아이디", culDate);
		returnDao.insert(returnDto);
	}

	public static void testReturnSelect() {

		List<ReturnDto> listDto = returnDao.getList();
		for (int i = 0; i < listDto.size(); i++) {
			System.out.println(listDto.get(i).getReturn_id() + " " + listDto.get(i).getIsbn_id() + " "
					+ listDto.get(i).getMemger_id() + " " + listDto.get(i).getReturn_date() + " ");
		}
	}// end testReturn

}
