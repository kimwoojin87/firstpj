package com.kitri.library.controller;

import java.awt.event.*;
import java.util.List;

import javax.swing.JOptionPane;

import com.kitri.library.db.MenagerDao;
import com.kitri.library.db.MenagerDto;
import com.kitri.library.main.UiManager;
import com.kitri.library.ui.*;

public class Controller implements ActionListener {

	private UiManager uiManager;
	private Service service;
	// Main pMain;
	LoginFailedDialog loginFailedDialog = new LoginFailedDialog();

	public Controller(UiManager mUiManager) {
		this.uiManager = mUiManager;
		// pMain= mUiManager.pMain;
		service = new Service(uiManager);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// -----------------------메인화면--------------------------
		if (obj == uiManager.pMain.btn_pLogOut) {// 로그아웃
			service.logOut();
		} else if (obj == uiManager.pLogin.btn_logIn) {// 로그인
			service.loginIn(uiManager.pLogin.idTF.getText(), uiManager.pLogin.pwTF.getText());
		} // end loginBt
		else if (obj == uiManager.pMain.btn_pRent) {// 대여
			service.openRent();
		} // end loginBt
		else if (obj == uiManager.pMain.btn_pBookRet) { // 반납
			service.openReturn();
		} else if (obj == uiManager.pMain.btn_pMembers) { // 회원관리
			service.openMemMng();
		} else if (obj == uiManager.pMain.btn_pBookmang) { // 도서관리
			service.openBookMng();
		} else if (obj == uiManager.pMain.btn_bookSearch) {// 도서 검색
			String searchStr = uiManager.pMain.tf_searchBook.getText().trim();
			String searchMethodStr = (String) uiManager.pMain.comboSerarchBookMenu.getSelectedItem();
			service.searchBookPMain(searchMethodStr, searchStr);
			// searchMethodStr

		}
		// else if (obj == uiManager.pMain.btn_statistic) { // 통계
		// service.openStatic();
		// }

		// -----------------------도서관리페이지--------------------------
		// 도서추가버튼
		if (obj == uiManager.pBookMng.btnAdd) {
			//
			service.viewBookAdd();
		}
		// 도서추가삭제버튼
		else if (obj == uiManager.pBookMng.btnDelete) {
			service.pBookMngDeleteBook();
		}
		// 종료 버튼 ->메인화면으로
		else if (obj == uiManager.pBookMng.btnCancel) {

		}
		// 도서 검색 버튼
		else if (obj == uiManager.pBookMng.btnSearch) {
			String searchStr = uiManager.pBookMng.tfSearch.getText().trim();
			String searchMethodStr = (String) uiManager.pBookMng.comboBoxMenu.getSelectedItem();
			service.bookSearchBookMng(searchMethodStr, searchStr);
		}

		// 도서 상세 화면 열기
		else if (obj == uiManager.pBookMng.btn_Update) {
			service.openBookInfo();
		}

		// -----------------------도서상세정보--------------------------
		// 도서 상세 화면 닫기
		else if (obj == uiManager.pBookInfo.btn_close) {
			uiManager.pBookInfo.dispose();
		}
		// 도서 변경 완료
		else if (obj == uiManager.pBookInfo.btn_editConfirm) {
			service.pBookEditConfirm();
		}
		// 도서 상세정보 수정하기
		else if (obj == uiManager.pBookInfo.btn_edit) {
			service.editBookProcess();
		}
		// 도서 추가버튼
		else if(obj == uiManager.pBookAdd.btOk) {
			service.addBook();
			uiManager.pBookAdd.setVisible(false);
			
		}
		// 도서 이미지 불러오기
		else if (obj == uiManager.pBookAdd.btImg) {
			service.addImg();
			
		}
		// controller

		// btn_LogOut.addActionListener(controller);
		// btn_rent.addActionListener(controller);
		// btn_returns.addActionListener(controller);
		// btn_members.addActionListener(controller);
		// btn_bookmang.addActionListener(controller);
		// btn_statis.addActionListener(controller);

	}// end actionPerformed

}
