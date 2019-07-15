package com.kitri.library.main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kitri.library.controller.Controller;
import com.kitri.library.ui.*;

public class UiManager extends JFrame {

	private JPanel contentPane;
	public JPanel panel_cardLayout;
	public CardLayout cardLayout = new CardLayout();

	Controller controller;
	public Login pLogin;
	public Main pMain;
	public BookMng pBookMng;
	public BookInfo pBookInfo;
	public BookRet pReturn;
	public Rent pRent;
	public BookAdd pBookAdd;
	
	public MemberMng pMemberMng;
//	public Statistic= new Statistic(controller); //����ȭ�� -> ���ȭ��
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiManager frame = new UiManager();
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

	public UiManager() {
		controller = new Controller(this);
		pLogin = new Login(controller); // �α���ȭ�� -> ����ȭ��
		pMain = new Main(controller); // ����ȭ��
		pBookMng = new BookMng(controller); // ����ȭ�� -> ��������ȭ��
		pRent = new Rent(controller); // ����ȭ�� -> ��������ȭ��
		pReturn = new BookRet(controller); // ����ȭ�� -> ��������ȭ��
		pMemberMng = new MemberMng(controller); // ����ȭ�� -> �������ȭ��
		pBookInfo = new BookInfo(controller); //����ȭ�� -> ���� ��ȭ��
		pBookAdd = new BookAdd(controller); // ������ -> �����߰�.
		
		
		//Dao ����
		
		setTitle("\uD0A4\uD2B8\uB9AC \uB3C4\uC11C\uAD00");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		setBounds(0, 0, 800, 800);
		setLocationRelativeTo(null); // �������� ȭ�� ����� ��ġ
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_cardLayout = new JPanel();
		panel_cardLayout.setBounds(0, 0, 800, 800);

		panel_cardLayout.setLayout(cardLayout);

		// ������ �ٲٸ� �α���â���� ���� ����
		panel_cardLayout.add(pLogin, "pLogin");
		panel_cardLayout.add(pMain, "pMain");

		contentPane.add(panel_cardLayout);
		
		
	}// end CardLayoutTest

}// end class