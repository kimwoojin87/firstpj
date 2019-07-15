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

		// -----------------------����ȭ��--------------------------
		if (obj == uiManager.pMain.btn_pLogOut) {// �α׾ƿ�
			service.logOut();
		} else if (obj == uiManager.pLogin.btn_logIn) {// �α���
			service.loginIn(uiManager.pLogin.idTF.getText(), uiManager.pLogin.pwTF.getText());
		} // end loginBt
		else if (obj == uiManager.pMain.btn_pRent) {// �뿩
			service.openRent();
		} // end loginBt
		else if (obj == uiManager.pMain.btn_pBookRet) { // �ݳ�
			service.openReturn();
		} else if (obj == uiManager.pMain.btn_pMembers) { // ȸ������
			service.openMemMng();
		} else if (obj == uiManager.pMain.btn_pBookmang) { // ��������
			service.openBookMng();
		} else if (obj == uiManager.pMain.btn_bookSearch) {// ���� �˻�
			String searchStr = uiManager.pMain.tf_searchBook.getText().trim();
			String searchMethodStr = (String) uiManager.pMain.comboSerarchBookMenu.getSelectedItem();
			service.searchBookPMain(searchMethodStr, searchStr);
			// searchMethodStr

		}
		// else if (obj == uiManager.pMain.btn_statistic) { // ���
		// service.openStatic();
		// }

		// -----------------------��������������--------------------------
		// �����߰���ư
		if (obj == uiManager.pBookMng.btnAdd) {
			//
			service.viewBookAdd();
		}
		// �����߰�������ư
		else if (obj == uiManager.pBookMng.btnDelete) {
			service.pBookMngDeleteBook();
		}
		// ���� ��ư ->����ȭ������
		else if (obj == uiManager.pBookMng.btnCancel) {

		}
		// ���� �˻� ��ư
		else if (obj == uiManager.pBookMng.btnSearch) {
			String searchStr = uiManager.pBookMng.tfSearch.getText().trim();
			String searchMethodStr = (String) uiManager.pBookMng.comboBoxMenu.getSelectedItem();
			service.bookSearchBookMng(searchMethodStr, searchStr);
		}

		// ���� �� ȭ�� ����
		else if (obj == uiManager.pBookMng.btn_Update) {
			service.openBookInfo();
		}

		// -----------------------����������--------------------------
		// ���� �� ȭ�� �ݱ�
		else if (obj == uiManager.pBookInfo.btn_close) {
			uiManager.pBookInfo.dispose();
		}
		// ���� ���� �Ϸ�
		else if (obj == uiManager.pBookInfo.btn_editConfirm) {
			service.pBookEditConfirm();
		}
		// ���� ������ �����ϱ�
		else if (obj == uiManager.pBookInfo.btn_edit) {
			service.editBookProcess();
		}
		// ���� �߰���ư
		else if(obj == uiManager.pBookAdd.btOk) {
			service.addBook();
			uiManager.pBookAdd.setVisible(false);
			
		}
		// ���� �̹��� �ҷ�����
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
