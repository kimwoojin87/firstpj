package com.kitri.test.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import com.kitri.library.db.BookDao;
import com.kitri.library.db.BookDto;

public class JTableTestUpdate extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;

	BookDao bookDao = new BookDao();
	public JButton btn_Update;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableTestUpdate frame = new JTableTestUpdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JTableTestUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 42, 410, 210);
		contentPane.add(scrollPane);

//		setTable();
//		setTable_VectorDto();
//		setTable();
		setDtoTable();
		
		scrollPane.setViewportView(table);

		btn_Update = new JButton("\uBCC0\uACBD");
		btn_Update.setBounds(12, 10, 97, 23);
		contentPane.add(btn_Update);

		btn_Update.addActionListener(this);
	}// 생성자

	private void setTable() {
		// 값 추가
		List<BookDto> list = bookDao.getList();
		Vector<Vector<String>> vecList = new Vector<Vector<String>>();

		int len = list.size();
		for (int i = 0; i < len; i++) {
			Vector<String> vec = new Vector<String>();
			vec.add(list.get(i).getName());
			vec.add(list.get(i).getIsbn());
			vec.add(list.get(i).getPosition());
			vecList.add(vec);
		}
		Vector<String> colVec = new Vector<String>();
		colVec.add("이름");
		colVec.add("isbn");
		colVec.add("위치");

		DefaultTableModel model = new DefaultTableModel(vecList, colVec);
		table = new JTable(model);
//		tabel= new Jtable()
//		table = new JTable(vecList, colVec);
	}

	private void setDtoTable() {
		//값 추가
		List<BookDto> list = bookDao.getList();
		Vector<Vector<BookDto>> vecList = new Vector<Vector<BookDto>>();
		
		int len = list.size();
		Vector<BookDto> vec = new Vector<BookDto>();
		for (int i = 0; i < len; i++) {
			vec.add(list.get(i));
		}
		vecList.add(vec);
		
		Vector<String> colVec = new Vector<String>();
		colVec.add("이름");
		colVec.add("isbn");
		colVec.add("위치");
		colVec.add("위치");
		colVec.add("위치");
		colVec.add("위치");
		colVec.add("위치");
		
		
//		DefaultTableModel model = new DefaultTableModel(vecList, colVec);
//		table = new JTable(model);
//		tabel= new Jtable()
//		table = new JTable(, colVec);
	}

	// 버튼 클릭
	@Override
	public void actionPerformed(ActionEvent e) {
		// 새로 추가할 데이터
		Vector<Vector<String>> vecList = new Vector<Vector<String>>();
		Vector<String> vec = new Vector<String>();
		vec.add("값변경1");
		vec.add("값변경2");
		vec.add("값변경3");
		vecList.add(vec);

		Vector<String> colVec = new Vector<String>();
		colVec.add("1");
		colVec.add("2");
		colVec.add("3");

		// 갱신하려면 model을 추가해야한다.
		DefaultTableModel model = new DefaultTableModel(vecList, colVec);
		table.setModel(model);
		System.out.println("변경된다.");
	}

}

//TableModel modelRow = new DefaultTableModel();
//TableColumnModel modelCol = new DefaultTableColumnModel();
//TableColumn aColumn = new TableColumn();
//modelCol.addColumn(aColumn);
//table = new JTable(modelRow, modelCol);