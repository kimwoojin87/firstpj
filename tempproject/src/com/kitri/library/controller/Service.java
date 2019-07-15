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

	// ---------------------------------�α��� �α׾ƿ� ��ȯ
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
				System.out.println("�α��� ����");
				uiManager.pLogin.idTF.setText("");
				uiManager.pLogin.pwTF.setText("");
				uiManager.cardLayout.show(uiManager.panel_cardLayout, "main");
				uiManager.pMain.setVisible(true);
				uiManager.pLogin.setVisible(false);
				System.out.println("a");
				return;
			}
		} // end for
		String[] buttons = { "Ȯ��" };
		JOptionPane.showOptionDialog(null, "�α��ο� ���� �Ͽ����ϴ�.", "�α��� ����", JOptionPane.WARNING_MESSAGE, 0, null, buttons,
				buttons[0]);

	}// end loginIn

	// -----------------------------------��������
	// ���� �˻�
	public void bookSearchBookMng(String searchMethodStr, String searchStr) {
		Vector<BookDto> list = uiManager.pBookMng.bookDao.getList(searchMethodStr, searchStr);

		// ���� �߰��� ������
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
		// �����Ϸ��� model�� �߰��ؾ��Ѵ�.
		DefaultTableModel model = new DefaultTableModel(vecList, colVec);
		uiManager.pBookMng.book_table.setModel(model);
	}

	// �������� ����
	public void openBookMng() {
		uiManager.pBookMng.setVisible(true);
	}// end openBookMng()

	// ���������� �������� ����
	public void pBookMngDeleteBook() {
		// ���̺� ���õ� �� ����
		int row = uiManager.pBookMng.book_table.getSelectedRow();
		if (row != -1) {
			String isbn = (String) uiManager.pBookMng.book_table.getValueAt(row, 2);
			uiManager.pBookMng.bookDao.delete(isbn);
		} else {
			JOptionPane.showMessageDialog(uiManager.pBookMng, "������ ���� �������ּ���", "���� ����", JOptionPane.ERROR_MESSAGE);
		}
		updateTable();
	}// end pBookMngDeleteBook

	// ���������� ���� ���� ����

	// -----------------------------------�����뿩
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

	// �����˻� (main)
	public void searchBookPMain(String searchMethodStr, String searchStr) {
		// searchMethodStr = ������
		// searchStr = �˻���
		Vector<BookDto> list = uiManager.pMain.bookDao.getList(searchMethodStr, searchStr);

		// ���� �߰��� ������
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
		// �����Ϸ��� model�� �߰��ؾ��Ѵ�.
		DefaultTableModel model = new DefaultTableModel(vecList, colVec);
		uiManager.pMain.main_table.setModel(model);
	}// end searchBook

	// ��������������
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
			JOptionPane.showMessageDialog(uiManager.pBookInfo, "������ �������ּ���", "��������", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}// end openBookInfo()

	// �������� ���� ����
	public void editBookProcess() {
		uiManager.pBookInfo.cardLayout.show(uiManager.pBookInfo.panel_cardLayout, "btn_editConfirm");
		String isbn = uiManager.pBookInfo.tfISBN.getText();
		BookDto beforeBook = uiManager.pBookInfo.bookDao.getBook(isbn);
		uiManager.pBookInfo.setBookDto(beforeBook);
		uiManager.pBookInfo.tfSetEditable(true);
	}// end editBookProcess

	// �������� ���� �Ϸ�
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
	// �������� ���� ����

	// ���� �߰� ����.
	public void viewBookAdd() {
		uiManager.pBookAdd.setVisible(true);
	}// end viewBookAdd()

	public void addBook() {
		String str = uiManager.pBookAdd.tfPubDate.getText();
		Date sqlDate = java.sql.Date.valueOf(str);
		// TODO ��¥�Է����� ����ó�� �ʿ�
		BookDto bookDto = new BookDto(uiManager.pBookAdd.tfIsbn.getText(), uiManager.pBookAdd.tfBookName.getText(),
				uiManager.pBookAdd.tfAuthor.getText(), uiManager.pBookAdd.tfImgPath.getText(),
				uiManager.pBookAdd.tfGenre.getText(), uiManager.pBookAdd.tfBookPub.getText(),
				uiManager.pBookAdd.tfCall.getText(), sqlDate);

		uiManager.pBookAdd.bookDao.insert(bookDto);
		uiManager.pBookAdd.tfSetText("");
		updateTable();
	} // end addBook()

	// ���̺� ����
	private void updateTable() {
		uiManager.pBookMng.tableModelUpdate();
		uiManager.pMain.tableModelUpdate();
	}
	// �̹��� ���� �ּҸ� tfImgPath�� �����ϱ�.
	//1. ����ȭ���� �̹��� ���� �ּҰ���� �̹��� ������ �б�  (�̹��� �ҷ����� ��ư)
	//2. ���� �̹����� ȭ�鿡 ���� (�̹��� �ҷ����� ��ưȮ�ν�)
	//3. �̹��� �������� �����ϱ�(���� Ȯ�� ��ư)
	//4. �о�� �̹��� �����͸� �̹��� ���������� �����ϱ� (���� Ȯ�� ��ư) 
	
	public void addImg() {
		JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File("D:\\javadata\\workspace\\javase\\tempproject\\src\\img"));
		jfc.setSize(600, 400);
		jfc.showOpenDialog(uiManager.pBookAdd);
		//������ ���� �Ǿ��� �� �ּҸ� ��������.
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
		
//		addimg - >���� ��θ� ������.
//		�� ��θ� �̿��ؼ� �ֵ�Ͽ� �־����.
//		
	}

}
