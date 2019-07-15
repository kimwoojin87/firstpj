package com.kitri.library.ui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoginFailedDialog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFailedDialog frame = new LoginFailedDialog();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFailedDialog() {
		setTitle("\uB85C\uADF8\uC778\uC2E4\uD328!");
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
		
		JLabel lbWarn = new JLabel("\uB85C\uADF8\uC778 \uC2E4\uD328\uD558\uC600\uC2B5\uB2C8\uB2E4.");
		lbWarn.setHorizontalAlignment(SwingConstants.CENTER);
		lbWarn.setBounds(12, 22, 228, 55);
		panel.add(lbWarn);
	}
}
