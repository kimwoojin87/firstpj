package com.kitri.library.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class Memberinfo extends JFrame {

	private JPanel contentPane;
	private JTextField img;
	private JTextField tfNum;
	private JTextField tfName;
	private JTextField tfAge;
	private JTextField tfPhone;
	private JTextField textField_6;
	private JTable table;
	private JTextField tfGender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Memberinfo frame = new Memberinfo();
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
	public Memberinfo() {
		setTitle("\uD68C\uC6D0\uC0C1\uC138\uC815\uBCF4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\uD68C\uC6D0\uBC88\uD638");
		label.setBounds(126, 10, 75, 28);
		contentPane.add(label);
		
		img = new JTextField();
		img.setColumns(10);
		img.setBounds(14, 12, 95, 124);
		contentPane.add(img);
		
		tfNum = new JTextField();
		tfNum.setColumns(10);
		tfNum.setBounds(203, 10, 192, 28);
		contentPane.add(tfNum);
		
		JLabel label_1 = new JLabel("\uC774\uB984");
		label_1.setBounds(126, 50, 75, 28);
		contentPane.add(label_1);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(203, 50, 192, 28);
		contentPane.add(tfName);
		
		JLabel label_2 = new JLabel("\uB098\uC774");
		label_2.setBounds(126, 90, 75, 28);
		contentPane.add(label_2);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(203, 90, 192, 28);
		contentPane.add(tfAge);
		
		JLabel label_3 = new JLabel("\uC131\uBCC4");
		label_3.setBounds(126, 130, 75, 28);
		contentPane.add(label_3);
		
		tfGender = new JTextField();
		tfGender.setColumns(10);
		tfGender.setBounds(203, 128, 192, 28);
		contentPane.add(tfGender);
		
		JLabel label_4 = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638");
		label_4.setBounds(126, 170, 75, 28);
		contentPane.add(label_4);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(203, 170, 192, 28);
		contentPane.add(tfPhone);
		
		JLabel label_5 = new JLabel("\uC774\uBA54\uC77C");
		label_5.setBounds(126, 210, 75, 28);
		contentPane.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(203, 210, 192, 28);
		contentPane.add(textField_6);
		
		JLabel label_6 = new JLabel("\uB300\uC5EC\uC911\uC778 \uB3C4\uC11C");
		label_6.setBounds(14, 303, 121, 28);
		contentPane.add(label_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 341, 383, 153);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btModify = new JButton("\uC218\uC815");
		btModify.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btModify.setBounds(269, 504, 57, 27);
		contentPane.add(btModify);
		
		JButton btOk = new JButton("\uD655\uC778");
		btOk.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btOk.setBounds(338, 504, 57, 27);
		contentPane.add(btOk);
	}
}
