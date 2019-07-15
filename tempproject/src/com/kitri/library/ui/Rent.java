package com.kitri.library.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.library.controller.Controller;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Rent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private Controller controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rent frame = new Rent(null);
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
	public Rent(Controller controller) {
		this.controller = controller;
		setTitle("\uB300\uC5EC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(14, 12, 95, 124);
		contentPane.add(textField);
		
		JLabel label = new JLabel("\uD68C\uC6D0\uBC88\uD638");
		label.setBounds(126, 12, 75, 28);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(203, 12, 240, 28);
		contentPane.add(textField_1);
		
		JLabel label_1 = new JLabel("\uD68C\uC6D0\uBA85");
		label_1.setBounds(126, 52, 75, 28);
		contentPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(203, 52, 240, 28);
		contentPane.add(textField_2);
		
		JLabel label_2 = new JLabel("\uB3C4\uC11C\uBC88\uD638");
		label_2.setBounds(126, 92, 75, 28);
		contentPane.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(203, 92, 169, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(126, 132, 246, 28);
		contentPane.add(textField_4);
		
		JButton button_1 = new JButton("\uD655\uC778");
		button_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		button_1.setBounds(386, 92, 57, 27);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\uC120\uD0DD");
		button_2.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		button_2.setBounds(386, 133, 57, 27);
		contentPane.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 180, 429, 225);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 427, 223);
		panel.add(table);
		
		JButton button = new JButton("\uB300\uC5EC");
		button.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		button.setBounds(311, 421, 57, 27);
		contentPane.add(button);
		
		JButton button_3 = new JButton("\uCDE8\uC18C");
		button_3.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		button_3.setBounds(386, 421, 57, 27);
		contentPane.add(button_3);
		
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //Á¾·á ¸·±â
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

}
