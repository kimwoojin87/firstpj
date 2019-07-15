package com.kitri.library.ui;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.kitri.library.controller.Controller;
import com.kitri.library.db.BookDao;
import com.kitri.library.db.BookDto;

public class Main extends JPanel {

	public JTable main_table;
	Controller controller;

	public BookDao bookDao;
	public BookDto bookDto;

	// String header[] = { "ȸ����ȣ", "�̸�", "����", "�������", "����", "�ڵ�����ȣ", "�뿩��������" };
	// String contents[][] = { { "123", "�����", "100", "1918�� 5�� 15��", "����",
	// "0104561234", "0" },
	// { "124", "ȣ����", "34", "1985�� 2�� 5��", "����", "0101234567", "3" },
	// { "125", "�����", "27", "1992�� 7�� 8��", "����", "0109873246", "2" },
	// { "126", "������", "38", "1981�� 2�� 25��", "����", "0106547321", "1" },
	// { "127", "�迬��", "27", "1990�� 9�� 5��", "����", "0106241487", "1" } };

	public JButton btn_pLogOut;
	public JButton btn_bookSearch;
	public JButton btn_pRent;
	public JButton btn_pBookRet;
	public JButton btn_pMembers;
	public JButton btn_pBookmang;
	public JButton btn_pStatis;
	public JTextField tf_searchBook;
	public JComboBox comboSerarchBookMenu;
	public String[] colArr = { "������", "����", "ISBN", "û����ȣ", "����⵵", "���ǻ�" };;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFrame frame = new JFrame("a");
//					frame.setBounds(0, 0, 800, 800);
//					frame.getContentPane().setLayout(null);
//					frame.getContentPane().add(new Main(null));
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}// end main

	/**
	 * Create the frame.
	 */
	public Main(Controller controller) {
		this.controller = controller;
		setBounds(new Rectangle(0, 0, 800, 1000));
		setBounds(380, 40, 800, 800);
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 800, 1000));
		setBorder(null);
		setLayout(null);
		tf_searchBook = new JTextField();
		tf_searchBook.setBorder(new LineBorder(Color.BLACK));
		tf_searchBook.setBounds(203, 117, 419, 30);
		add(tf_searchBook);
		tf_searchBook.setColumns(10);

		btn_bookSearch = new JButton("\uAC80\uC0C9");
		btn_bookSearch.setBackground(Color.LIGHT_GRAY);
		btn_bookSearch.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_bookSearch.setForeground(new Color(0, 0, 0));
		btn_bookSearch.setFont(new Font("HY������M", Font.PLAIN, 12));
		btn_bookSearch.setBounds(677, 117, 76, 30);
		add(btn_bookSearch);

		btn_pRent = new JButton("\uB300\uC5EC");
		btn_pRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_pRent.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_pRent.setBackground(Color.LIGHT_GRAY);
		btn_pRent.setForeground(Color.BLACK);
		btn_pRent.setFont(new Font("HY������M", Font.PLAIN, 12));
		btn_pRent.setBounds(24, 60, 93, 30);
		add(btn_pRent);

		btn_pBookRet = new JButton("\uBC18\uB0A9");
		btn_pBookRet.setBackground(Color.LIGHT_GRAY);
		btn_pBookRet.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_pBookRet.setForeground(new Color(0, 0, 0));
		btn_pBookRet.setFont(new Font("HY������M", Font.PLAIN, 12));
		btn_pBookRet.setBounds(174, 60, 93, 30);
		add(btn_pBookRet);

		btn_pMembers = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		btn_pMembers.setBackground(Color.LIGHT_GRAY);
		btn_pMembers.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_pMembers.setForeground(new Color(0, 0, 0));
		btn_pMembers.setFont(new Font("HY������M", Font.PLAIN, 12));
		btn_pMembers.setBounds(329, 60, 103, 30);
		add(btn_pMembers);

		btn_pBookmang = new JButton("\uB3C4\uC11C\uAD00\uB9AC");
		btn_pBookmang.setBackground(Color.LIGHT_GRAY);
		btn_pBookmang.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_pBookmang.setForeground(new Color(0, 0, 0));
		btn_pBookmang.setFont(new Font("HY������M", Font.PLAIN, 12));
		btn_pBookmang.setBounds(496, 60, 103, 30);
		add(btn_pBookmang);

		btn_pStatis = new JButton("\uD1B5\uACC4");
		btn_pStatis.setBackground(Color.LIGHT_GRAY);
		btn_pStatis.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_pStatis.setForeground(new Color(0, 0, 0));
		btn_pStatis.setFont(new Font("HY������M", Font.PLAIN, 12));
		btn_pStatis.setBounds(666, 60, 93, 30);
		add(btn_pStatis);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 196, 736, 537);
		add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		btn_pLogOut = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_pLogOut.setForeground(Color.BLACK);
		btn_pLogOut.setFont(new Font("HY������M", Font.PLAIN, 12));
		btn_pLogOut.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_pLogOut.setBackground(Color.LIGHT_GRAY);
		btn_pLogOut.setBounds(677, 10, 76, 30);
		add(btn_pLogOut);
		// ======================���̺�===================
		Object[][] bookContentsArr;
		Object[] header;
		header = new String[] { "������", "����", "ISBN", "û����ȣ", "����⵵", "���ǻ�" };
		int len = header.length;
		bookDao = new BookDao();
		
		List<BookDto> lists = bookDao.getList();
		len = lists.size();
//		System.out.println(lists.size());
//		System.out.println(lists.get(8));
		//�������� null�̸� ����
		bookContentsArr = new String[len][header.length];
		for (int i = 0; i < len; i++) {

			String[] contentsArr = new String[]{ lists.get(i).getName(), lists.get(i).getWriter(), lists.get(i).getIsbn(),lists.get(i).getPosition(),lists.get(i).getPublish_dateStr(),lists.get(i).getPublisher() };
			bookContentsArr[i] = contentsArr;
			// System.out.println(Arrays.deepToString(contentsArr));
		}
		// ���̺��� �� ������ ���´�.
		main_table = new JTable(bookContentsArr, header) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// ������ü�� �Ұ����ϰ��Ѵ�.
		main_table.setEnabled(false);
		// ���̺� �ο츦 �Ѱ��� ���ð����ϰ� �Ѵ�. �̰� ����ϸ� ���� �Ѱ��� �ο츸 ������ �� �ִ�.
		main_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		main_table.setBounds(12, 549, 710, 548);
		scrollPane.setViewportView(main_table);
		// �޺��ڽ�
		comboSerarchBookMenu = new JComboBox(new String[] { "������", "����" });
		comboSerarchBookMenu.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboSerarchBookMenu.setBounds(58, 117, 110, 30);
		add(comboSerarchBookMenu);

		// ���� ������
		btn_pLogOut.addActionListener(controller);
		btn_pRent.addActionListener(controller);
		btn_pBookRet.addActionListener(controller);
		btn_pMembers.addActionListener(controller);
		btn_pBookmang.addActionListener(controller);
		btn_pStatis.addActionListener(controller);

		btn_bookSearch.addActionListener(controller);

	}// end main
	public void tableModelUpdate() {
		bookDao.setAllList();
		Vector<BookDto> list = bookDao.getList();
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
		len = colArr.length;
		for (int i = 0; i < len; i++) {
			colVec.add(colArr[i]);
		}
		// �����Ϸ��� model�� �߰��ؾ��Ѵ�.
		DefaultTableModel model = new DefaultTableModel(vecList, colVec);
		main_table.setModel(model);
	}//end tableModelUpdate
	
}// end MainClass
