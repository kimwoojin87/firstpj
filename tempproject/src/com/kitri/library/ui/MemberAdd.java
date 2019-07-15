package com.kitri.library.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.Font;

public class MemberAdd extends JFrame {

	private JPanel contentPane;
	private JTextField img;
	private JTextField tfNum;
	private JTextField tfName;
	private JTextField tfAge;
	private JTextField tfPhone;
	private JTextField tfEmail;
	private ButtonGroup group = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberAdd frame = new MemberAdd();
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
	public MemberAdd() {
		setTitle("\uD68C\uC6D0\uCD94\uAC00");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		img = new JTextField();
		img.setColumns(10);
		img.setBounds(12, 10, 95, 124);
		contentPane.add(img);
		
		JLabel lbNum = new JLabel("\uD68C\uC6D0\uBC88\uD638");
		lbNum.setBounds(126, 10, 75, 28);
		contentPane.add(lbNum);
		
		tfNum = new JTextField();
		tfNum.setColumns(10);
		tfNum.setBounds(203, 10, 192, 28);
		contentPane.add(tfNum);
		
		JLabel lbName = new JLabel("\uC774\uB984");
		lbName.setBounds(126, 50, 75, 28);
		contentPane.add(lbName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(203, 50, 192, 28);
		contentPane.add(tfName);
		
		JLabel lbAge = new JLabel("\uB098\uC774");
		lbAge.setBounds(126, 90, 75, 28);
		contentPane.add(lbAge);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(203, 90, 192, 28);
		contentPane.add(tfAge);
		
		JLabel lbGender = new JLabel("\uC131\uBCC4");
		lbGender.setBounds(126, 130, 75, 28);
		contentPane.add(lbGender);
		
		JRadioButton rbMale = new JRadioButton("\uB0A8\uC131");
		rbMale.setBounds(203, 130, 96, 28);
		contentPane.add(rbMale);
		
		group.add(rbMale);
		
		JRadioButton rbFemale = new JRadioButton("\uC5EC\uC131");
		rbFemale.setBounds(299, 130, 96, 28);
		contentPane.add(rbFemale);
		group.add(rbFemale);
		
		JLabel lbPhone = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638");
		lbPhone.setBounds(126, 170, 75, 28);
		contentPane.add(lbPhone);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(203, 170, 192, 28);
		contentPane.add(tfPhone);
		
		JLabel lbEmail = new JLabel("\uC774\uBA54\uC77C");
		lbEmail.setBounds(126, 210, 75, 28);
		contentPane.add(lbEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(203, 210, 192, 28);
		contentPane.add(tfEmail);
		
		JButton button = new JButton("\uD655\uC778");
		button.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		button.setBounds(340, 248, 57, 27);
		contentPane.add(button);
	}
}
