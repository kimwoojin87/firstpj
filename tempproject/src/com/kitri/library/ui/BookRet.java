package com.kitri.library.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.library.controller.Controller;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BookRet extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private Controller controller;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookRet frame = new BookRet(null);
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
	public BookRet(Controller controller) {
		
		this.controller= controller;
		
		setTitle("\uBC18\uB0A9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\uB3C4\uC11C\uBC88\uD638");
		label.setBounds(14, 12, 75, 28);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(91, 12, 240, 28);
		contentPane.add(textField);
		
		JButton button = new JButton("\uD655\uC778");
		button.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		button.setBounds(345, 13, 57, 27);
		contentPane.add(button);
		
		table = new JTable();
		table.setBounds(14, 52, 389, 56);
		contentPane.add(table);
		
		JButton button_1 = new JButton("\uBC18\uB0A9");
		button_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		button_1.setBounds(183, 120, 57, 27);
		contentPane.add(button_1);
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //Á¾·á ¸·±â
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

}
