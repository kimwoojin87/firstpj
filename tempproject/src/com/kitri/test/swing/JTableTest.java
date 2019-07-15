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
		colVec.add("�̸�");
		colVec.add("isbn");
		colVec.add("��ġ");
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
		columnNames.addAll(Arrays.asList(new String[] { "", "������", "����", "ISBN", "û����ȣ", "����⵵", "���ǻ�" }));
		defaultTableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(defaultTableModel);
		// ���̺� �÷��� �̵��� �����Ѵ�. �̰� �Ⱦ��� ���콺�� ��α� �� ������� ������â�� �ɼ� �ִ�.
		table.getTableHeader().setReorderingAllowed(false);
		// ���̺� �÷��� ����� ������Ų��. �̰� ����ϸ� �÷� ����� ������ �ʴ´�.
		table.getTableHeader().setResizingAllowed(false);
		// ���̺� �ο츦 �Ѱ��� ���ð����ϰ� �Ѵ�. �̰� ����ϸ� ���� �Ѱ��� �ο츸 ������ �� �ִ�.
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// ���̺��� �� ������ ���´�. � �����ڿ��� �Ʒ��� ���� �߰�ȣ�� ���� �� �ִ�.
		defaultTableModel = new DefaultTableModel(columnNames, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};

		// Ư����ġ �� ��������
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
