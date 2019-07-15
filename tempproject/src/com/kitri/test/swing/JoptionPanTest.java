package com.kitri.test.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class JoptionPanTest extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn_alert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoptionPanTest frame = new JoptionPanTest();
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
	public JoptionPanTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btn_alert = new JButton("\uC54C\uB9BC\uD14C\uC2A4\uD2B8");
		contentPane.add(btn_alert, BorderLayout.CENTER);
		btn_alert.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "알림", "제목", JOptionPane.ERROR_MESSAGE);
	}

}
