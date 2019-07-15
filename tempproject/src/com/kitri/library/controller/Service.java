package com.kitri.library.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.kitri.library.db.*;
import com.kitri.library.main.UiManager;
import com.kitri.library.ui.BookInfo;

public class Service {
	Controller controller;
	UiManager uiManager;
	private MenagerDao menagerDao = new MenagerDao();

	public Service(UiManager mUiManager) {
		super();
		this.uiManager = mUiManager;
	}

	// ---------------------------------로그인 로그아웃 전환
	public void logOut() {
		System.out.println("logOut service");
		uiManager.cardLayout.show(uiManager.panel_cardLayout, "login");
		uiManager.pMain.setVisible(false);
		uiManager.pLogin.initTF();
	}

	public void loginIn(String id, String pass) {
		List<MenagerDto> menagerList = menagerDao.getList();
		int len = menagerList.size();
		for (int i = 0; i < len; i++) {
			String menager_id = menagerList.get(i).getId();
			String menager_pass = menagerList.get(i).getPassword();
			System.out.println(id + " " + pass + " ");
			if (menager_id.equals(id) && menager_pass.equals(pass)) {
				System.out.println("로그인 성공");
				uiManager.pLogin.idTF.setText("");
				uiManager.pLogin.pwTF.setText("");
				uiManager.cardLayout.show(uiManager.panel_cardLayout, "main");
				uiManager.pMain.setVisible(true);
				uiManager.pLogin.setVisible(false);
				System.out.println("a");
				return;
			}
		} // end for
		String[] buttons = { "확인" };
		JOptionPane.showOptionDialog(null, "로그인에 실패 하였습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE, 0, null, buttons,
				buttons[0]);

	}// end loginIn

	// -----------------------------------도서관리
	// 도서 검색
	public void bookSearchBookMng(String searchMethodStr, String searchStr) {
		Vector<BookDto> list = uiManager.pBookMng.bookDao.getList(searchMethodStr, searchStr);

		// 새로 추가할 데이터
		Vector<Vector<String>> vecList = new Vector<Vector<String>>();
		int len = list.size();
		for (int i = 0; i < len; i++) {
			Vector<String> vec = new Vector<String>();
			vec.add(list.get(i).getName());
			vec.add(list.get(i).getWriter());
			vec.add(list.get(i).getIsbn());
			vec.add(list.get(i).getPosition());
			vec.add(list.get(i).getPublish_dateStr());
			vec.add(list.get(i).getPublisher());
			vecList.add(vec);
		}
		Vector<String> colVec = new Vector<String>();
		len = uiManager.pBookMng.colArr.length;
		for (int i = 0; i < len; i++) {
			colVec.add(uiManager.pBookMng.colArr[i]);
		}
		// 갱신하려면 model을 추가해야한다.
		DefaultTableModel model = new DefaultTableModel(vecList, colVec);
		uiManager.pBookMng.book_table.setModel(model);
	}

	// 도서관리 열기
	public void openBookMng() {
		uiManager.pBookMng.setVisible(true);
	}// end openBookMng()

	// 도서관리자 도서정보 삭제
	public void pBookMngDeleteBook() {
		// 테이블 선택된 값 리턴
		int row = uiManager.pBookMng.book_table.getSelectedRow();
		if (row != -1) {
			String isbn = (String) uiManager.pBookMng.book_table.getValueAt(row, 2);
			uiManager.pBookMng.bookDao.delete(isbn);
		} else {
			JOptionPane.showMessageDialog(uiManager.pBookMng, "삭제할 값을 선택해주세요", "선택 에러", JOptionPane.ERROR_MESSAGE);
		}
		updateTable();
	}// end pBookMngDeleteBook

	// 도서관리자 도서 정보 갱신

	// -----------------------------------도서대여
	public void openRent() {
		uiManager.pRent.setVisible(true);
	}

	public void openStatic() {
		// uiManager.pS
	}

	public void openMemMng() {
		uiManager.pMemberMng.setVisible(true);
	}

	public void openReturn() {
		uiManager.pReturn.setVisible(true);
	}

	// 도서검색 (main)
	public void searchBookPMain(String searchMethodStr, String searchStr) {
		// searchMethodStr = 도서명
		// searchStr = 검색어
		Vector<BookDto> list = uiManager.pMain.bookDao.getList(searchMethodStr, searchStr);

		// 새로 추가할 데이터
		Vector<Vector<String>> vecList = new Vector<Vector<String>>();
		int len = list.size();
		for (int i = 0; i < len; i++) {
			Vector<String> vec = new Vector<String>();
			vec.add(list.get(i).getName());
			vec.add(list.get(i).getWriter());
			vec.add(list.get(i).getIsbn());
			vec.add(list.get(i).getPosition());
			vec.add(list.get(i).getPublish_dateStr());
			vec.add(list.get(i).getPublisher());
			vecList.add(vec);
		}
		Vector<String> colVec = new Vector<String>();
		len = uiManager.pMain.colArr.length;
		for (int i = 0; i < len; i++) {
			colVec.add(uiManager.pMain.colArr[i]);
		}
		// 갱신하려면 model을 추가해야한다.
		DefaultTableModel model = new DefaultTableModel(vecList, colVec);
		uiManager.pMain.main_table.setModel(model);
	}// end searchBook

	// 도서상세정보열기
	public void openBookInfo() {
		int row = uiManager.pBookMng.book_table.getSelectedRow();
		if (row != -1) {
			String isbn = (String) uiManager.pBookMng.book_table.getValueAt(row, 2);
			uiManager.pBookInfo.setVisible(true);
			BookDto book = uiManager.pBookInfo.bookDao.getBook(isbn);
			uiManager.pBookInfo.tfBookName.setText(book.getName());
			uiManager.pBookInfo.tfBookPosition.setText(book.getPosition());
			String dateStr = book.getPublish_date().toString();
			uiManager.pBookInfo.tfBookPublishDate.setText(dateStr);
			uiManager.pBookInfo.tfBookPublisher.setText(book.getPublisher());
			uiManager.pBookInfo.tfBookWriter.setText(book.getWriter());
			uiManager.pBookInfo.tfISBN.setText(book.getIsbn());
			uiManager.pBookInfo.tfImgPath.setText(book.getImage_path());
		} else {
			JOptionPane.showMessageDialog(uiManager.pBookInfo, "도서를 선택해주세요", "도서선택", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}// end openBookInfo()

	// 도서정보 변경 열기
	public void editBookProcess() {
		uiManager.pBookInfo.cardLayout.show(uiManager.pBookInfo.panel_cardLayout, "btn_editConfirm");
		String isbn = uiManager.pBookInfo.tfISBN.getText();
		BookDto beforeBook = uiManager.pBookInfo.bookDao.getBook(isbn);
		uiManager.pBookInfo.setBookDto(beforeBook);
		uiManager.pBookInfo.tfSetEditable(true);
	}// end editBookProcess

	// 도서정보 변경 완료
	public void pBookEditConfirm() {
		BookInfo bookinfo = uiManager.pBookInfo;
		String isbn = bookinfo.tfISBN.getText();
		// System.out.println(isbn);
		String str = uiManager.pBookInfo.tfBookPublishDate.getText();
		Date sqlDate = java.sql.Date.valueOf(str);

		BookDto bookDto = new BookDto(bookinfo.tfISBN.getText().trim(), bookinfo.tfBookName.getText().trim(),
				bookinfo.tfBookWriter.getText().trim(), bookinfo.tfImgPath.getText().trim(),
				bookinfo.bookDto.getGenre(), bookinfo.tfBookPublisher.getText().trim(),
				bookinfo.bookDto.getPosition().trim(), sqlDate);
		uiManager.pBookInfo.bookDao.upDateBook(isbn, bookDto);
		updateTable();
		uiManager.pBookInfo.tfSetEditable(false);
		uiManager.pBookInfo.setVisible(false);
		uiManager.pBookInfo.cardLayout.show(uiManager.pBookInfo.panel_cardLayout, "btn_edit");
	}
	// 도서정보 변경 막기

	// 도서 추가 열기.
	public void viewBookAdd() {
		uiManager.pBookAdd.setVisible(true);
	}// end viewBookAdd()

	public void addBook() {
		String str = uiManager.pBookAdd.tfPubDate.getText();
		Date sqlDate = java.sql.Date.valueOf(str);
		// TODO 날짜입력형식 예외처리 필요
		BookDto bookDto = new BookDto(uiManager.pBookAdd.tfIsbn.getText(), uiManager.pBookAdd.tfBookName.getText(),
				uiManager.pBookAdd.tfAuthor.getText(), uiManager.pBookAdd.tfImgPath.getText(),
				uiManager.pBookAdd.tfGenre.getText(), uiManager.pBookAdd.tfBookPub.getText(),
				uiManager.pBookAdd.tfCall.getText(), sqlDate);

		uiManager.pBookAdd.bookDao.insert(bookDto);
		uiManager.pBookAdd.tfSetText("");
		updateTable();
	} // end addBook()

	// 테이블 갱신
	private void updateTable() {
		uiManager.pBookMng.tableModelUpdate();
		uiManager.pMain.tableModelUpdate();
	}
	// 이미지 파일 주소를 tfImgPath에 저장하기.
	//1. 바탕화면의 이미지 파일 주소경로의 이미지 데이터 읽기  (이미지 불러오기 버튼)
	//2. 읽은 이미지를 화면에 띄우기 (이미지 불러오기 버튼확인시)
	//3. 이미지 저장폴더 생성하기(저장 확인 버튼)
	//4. 읽어온 이미지 데이터를 이미지 저장폴더에 저장하기 (저장 확인 버튼) 
	
	public void addImg() {
		JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File("D:\\javadata\\workspace\\javase\\tempproject\\src\\img"));
		jfc.setSize(600, 400);
		jfc.showOpenDialog(uiManager.pBookAdd);
		//파일이 선택 되었을 시 주소를 저장하자.
		File file = jfc.getSelectedFile();
		String url = file.getPath();
		System.out.println(url);
		String path = url.substring(url.indexOf("tempproject")+15, url.length());
		
		URL temp = Service.class.getResource("/img/img1.jpg");
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(temp);
			JLabel lable = uiManager.pBookAdd.lbImg;
			ImageIcon image = new ImageIcon(bufferedImage.getScaledInstance(lable.getWidth(), lable.getHeight(), Image.SCALE_FAST));
			uiManager.pBookAdd.lbImg.setIcon(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		12 10 95 124
		
		System.out.println(path);
		
//		addimg - >파일 경로를 가져옴.
//		이 경로를 이용해서 애드북에 넣어야함.
//		
	}

}
