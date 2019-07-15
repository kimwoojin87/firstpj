package com.kitri.test.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import com.kitri.library.db.BookDao;
import com.kitri.library.db.BookDto;

public class JTableTest extends JFrame {

	private JPanel contentPane;
	private JTable table;

	BookDao bookDao = new BookDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableTest frame = new JTableTest();
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
	public JTableTest() {
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
		setTable_DefaultModel();

		scrollPane.setViewportView(table);

	}

	private void setTable_DefaultModel() {
//		TableModel modelRow = new DefaultTableModel();
//		TableColumnModel modelCol = new DefaultTableColumnModel();
//		TableColumn aColumn = new TableColumn();
//		modelCol.addColumn(aColumn);
//		table = new JTable(modelRow, modelCol);

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
		Vector<String> colVec= new Vector<String>();
		colVec.add("이름");
		colVec.add("isbn");
		colVec.add("위치");
		DefaultTableModel model = new DefaultTableModel(vecList, colVec);
		table= new JTable(model);
	}

	private void setTable_VectorDto() {

		Vector<String> colVec = new Vector<String>();
		colVec.add("isbn");
		colVec.add("name");
		colVec.add("writer");
		Vector<Vector<String>> vec = new Vector<Vector<String>>();
		Vector<String> vecStr = new Vector<String>();
		vecStr.addElement("1");
		vecStr.addElement("1");
		vecStr.addElement("2");
		vec.add(vecStr);
		vecStr = new Vector<String>();
		vecStr.addElement("4");
		vecStr.addElement("5");
		vecStr.addElement("6");

		vec.addElement(vecStr);
		table = new JTable(vec, colVec);

	}

	private void setTable() {
		Vector<String> columnNames;
		DefaultTableModel defaultTableModel;
		columnNames = new Vector<String>();
		columnNames.addAll(Arrays.asList(new String[] { "", "도서명", "저자", "ISBN", "청구기호", "발행년도", "출판사" }));
		defaultTableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(defaultTableModel);
		// 테이블 컬럼의 이동을 방지한다. 이거 안쓰면 마우스로 드로그 앤 드롭으로 엉망진창이 될수 있다.
		table.getTableHeader().setReorderingAllowed(false);
		// 테이블 컬럼의 사이즈를 고정시킨다. 이걸 사용하면 컬럼 사이즈가 변하지 않는다.
		table.getTableHeader().setResizingAllowed(false);
		// 테이블 로우를 한개만 선택가능하게 한다. 이걸 사용하면 오직 한개의 로우만 선택할 수 있다.
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// 테이블의 값 변경을 막는다. 어떤 생성자에도 아래와 같이 중괄호로 묶을 수 있다.
		defaultTableModel = new DefaultTableModel(columnNames, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};

		// 특정위치 값 가져오기
//		int row = table.getSelectedRow();
//		int col = table.getSelectedColumn();
//		String isbn= (String) table.getValueAt(row, 2);
//		System.out.println(isbn);

		// bookDao.selectListALL();
		// Vector<BookDto> list = bookDao.getList();
		// int len = list.size();
		//
		// for (int i = 0; i < len; i++) {
		// System.out.println(list.get(0));
		// defaultTableModel.addRow(list.get(0));

		// }

	}// end setTableData()

}
