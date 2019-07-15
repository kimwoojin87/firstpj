package com.kitri.library.ui;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.kitri.library.controller.Controller;
import com.kitri.library.db.BookDao;
import com.kitri.library.db.BookDto;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.CardLayout;

public class BookInfo extends JFrame {

	public BookDao bookDao;
	public BookDto bookDto;
	
	public JPanel contentPane;
	public JTextField tfBookName;
	public JTextField tfBookWriter;
	public JTextField tfISBN;
	public JTextField tfBookPublisher;
	public JTextField tfBookPublishDate;
	public JTextField tfBookPosition;
	public JTextField tfImgPath;
	public JTable table;
	public JButton btn_close;
	public JButton btn_editConfirm;
	public JButton btn_edit;

	public JPanel panel_cardLayout;
	public CardLayout cardLayout;

	public Controller controller;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookInfo frame = new BookInfo(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public BookInfo(Controller controller) {
		this.controller = controller;
		bookDao = new BookDao();

		setTitle("\uB3C4\uC11C\uC0C1\uC138\uC815\uBCF4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfImgPath = new JTextField();
		tfImgPath.setEditable(false);
		tfImgPath.setBounds(14, 12, 95, 124);
		contentPane.add(tfImgPath);
		tfImgPath.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\uB3C4\uC11C\uBA85");
		lblNewLabel_1.setBounds(126, 10, 75, 28);
		contentPane.add(lblNewLabel_1);

		tfBookName = new JTextField();
		tfBookName.setEditable(false);
		tfBookName.setBounds(203, 12, 192, 28);
		contentPane.add(tfBookName);
		tfBookName.setColumns(10);

		JLabel label = new JLabel("\uC800\uC790");
		label.setBounds(126, 50, 75, 28);
		contentPane.add(label);

		tfBookWriter = new JTextField();
		tfBookWriter.setEditable(false);
		tfBookWriter.setColumns(10);
		tfBookWriter.setBounds(203, 52, 192, 28);
		contentPane.add(tfBookWriter);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(126, 90, 75, 28);
		contentPane.add(lblIsbn);

		tfISBN = new JTextField();
		tfISBN.setEditable(false);
		tfISBN.setColumns(10);
		tfISBN.setBounds(203, 92, 192, 28);
		contentPane.add(tfISBN);

		JLabel label_2 = new JLabel("\uCD9C\uD310\uC0AC");
		label_2.setBounds(126, 130, 75, 28);
		contentPane.add(label_2);

		tfBookPublisher = new JTextField();
		tfBookPublisher.setEditable(false);
		tfBookPublisher.setColumns(10);
		tfBookPublisher.setBounds(203, 132, 192, 28);
		contentPane.add(tfBookPublisher);

		JLabel label_3 = new JLabel("\uCD9C\uAC04\uC77C");
		label_3.setBounds(126, 170, 75, 28);
		contentPane.add(label_3);

		tfBookPublishDate = new JTextField();
		tfBookPublishDate.setEditable(false);
		tfBookPublishDate.setColumns(10);
		tfBookPublishDate.setBounds(203, 172, 192, 28);
		contentPane.add(tfBookPublishDate);

		JLabel label_4 = new JLabel("\uCCAD\uAD6C\uAE30\uD638");
		label_4.setBounds(126, 212, 75, 28);
		contentPane.add(label_4);

		tfBookPosition = new JTextField();
		tfBookPosition.setEditable(false);
		tfBookPosition.setColumns(10);
		tfBookPosition.setBounds(203, 212, 192, 28);
		contentPane.add(tfBookPosition);

		JLabel lblNewLabel = new JLabel("\uB300\uC5EC\uC5EC\uBD80");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lblNewLabel.setBounds(126, 278, 62, 18);
		contentPane.add(lblNewLabel);

		JLabel label_1 = new JLabel("\uB300\uC5EC\uC790");
		label_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		label_1.setBounds(126, 300, 62, 18);
		contentPane.add(label_1);

		JLabel label_5 = new JLabel("\uBC18\uB0A9\uC608\uC815\uC77C");
		label_5.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		label_5.setBounds(126, 322, 62, 18);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("New label");
		label_6.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		label_6.setBounds(203, 278, 192, 18);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("New label");
		label_7.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		label_7.setBounds(203, 300, 192, 18);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("New label");
		label_8.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		label_8.setBounds(203, 322, 192, 18);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("\uB3D9\uC77C\uB3C4\uC11C \uD604\uD669");
		label_9.setBounds(14, 344, 121, 28);
		contentPane.add(label_9);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 372, 381, 107);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		btn_close = new JButton("\uB2EB\uAE30");
		btn_close.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btn_close.setBounds(316, 489, 79, 27);
		contentPane.add(btn_close);

		// µµ¼­ »ó¼¼Á¤º¸ ºÒ·¯¿Í ÀÔ·ÂÇÏ±â
		tfBookName.setText("");
		tfBookWriter.setText("");
		tfISBN.setText("");
		tfBookPublisher.setText("");
		tfBookPublishDate.setText("");
		tfBookPosition.setText("");

		tfImgPath.setText("\uD3F4\uB354 \uC774\uBBF8\uC9C0 \uACBD\uB85C");

		btn_edit = new JButton("\uBCC0\uACBD\uD558\uAE30");
		btn_edit.setBounds(0, 0, 113, 27);
		btn_edit.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btn_editConfirm = new JButton("\uBCC0\uACBD\uC644\uB8CC");
		btn_editConfirm.setBounds(0, 0, 113, 27);

		// Ä«µå·¹ÀÌ¾Æ¿ô »ý¼º
		cardLayout = new CardLayout();

		panel_cardLayout = new JPanel(cardLayout);
		panel_cardLayout.setBounds(176, 489, 113, 27);
		panel_cardLayout.add(btn_edit, "btn_edit");
		panel_cardLayout.add(btn_editConfirm, "btn_editConfirm");
		contentPane.add(panel_cardLayout);

		// ¸®½º³Ê µî·Ï
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // Á¾·á ¸·±â
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		btn_close.addActionListener(controller);
		btn_edit.addActionListener(controller);
		btn_editConfirm.addActionListener(controller);
	}// end BookInfo

	public void setBookDto(BookDto beforeBook) {
		this.bookDto = beforeBook;
	}

	public void tfSetEditable(boolean b) {
		tfBookName.setEditable(b);
		tfBookPosition.setEditable(b);
		tfBookPublishDate.setEditable(b);
		tfBookPublisher.setEditable(b);
		tfBookWriter.setEditable(b);
		tfImgPath.setEditable(b);
		tfISBN.setEditable(b);
	}
}// end class BookInfo
