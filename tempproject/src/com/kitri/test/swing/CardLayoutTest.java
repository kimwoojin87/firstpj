package com.kitri.test.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CardLayoutTest extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel layout;
	CardLayout cardLayout =new CardLayout();

	Login mLogin = new Login();
	Main mMain = new Main();
	Container c = new Container();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardLayoutTest frame = new CardLayoutTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}// end main

	/**
	 * Create the frame.
	 */

	
	public CardLayoutTest() {
		setTitle("\uD0A4\uD2B8\uB9AC \uB3C4\uC11C\uAD00");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layout = new JPanel();
		layout.setBounds(0, 0, 800, 800);
		
		layout.setLayout(cardLayout);
//		c.add(mMain, "main");
//		c.add(mMain, "main");
		layout.add(mLogin,"login" );
		layout.add(mMain,"main" );
		
		contentPane.add(layout);
		mLogin.btn_logIn.addActionListener(this);
//		mMain.logoutBt.addActionListener(this);
	}// end CardLayoutTest

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == mLogin.btn_logIn) {
			cardLayout.show(layout,"main");
		}
	}//end actionPerformed

}// end class
