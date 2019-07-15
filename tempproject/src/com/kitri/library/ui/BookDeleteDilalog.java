package com.kitri.library.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BookDeleteDilalog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookDeleteDilalog frame = new BookDeleteDilalog();
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
	public BookDeleteDilalog() {
		setTitle("\uB3C4\uC11C\uC0AD\uC81C\uACBD\uACE0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 254, 132);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btOk = new JButton("\uD655\uC778");
		btOk.setBounds(12, 87, 108, 37);
		panel.add(btOk);
		
		JButton btCancel = new JButton("\uCDE8\uC18C");
		btCancel.setBounds(132, 87, 108, 37);
		panel.add(btCancel);
		
		JLabel lbWarn = new JLabel("\uC815\uB9D0\uB85C '\uB3C4\uC11C'\uB97C \uC0AD\uC81C\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		lbWarn.setHorizontalAlignment(SwingConstants.CENTER);
		lbWarn.setBounds(12, 22, 228, 55);
		panel.add(lbWarn);
	}
}
