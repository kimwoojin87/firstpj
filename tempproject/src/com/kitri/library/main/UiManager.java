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
//	public Statistic= new Statistic(controller); //메인화면 -> 통계화면
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
		pLogin = new Login(controller); // 로그인화면 -> 메인화면
		pMain = new Main(controller); // 메인화면
		pBookMng = new BookMng(controller); // 메인화면 -> 도서관리화면
		pRent = new Rent(controller); // 메인화면 -> 도서관리화면
		pReturn = new BookRet(controller); // 메인화면 -> 도서관리화면
		pMemberMng = new MemberMng(controller); // 메인화면 -> 멤버관리화면
		pBookInfo = new BookInfo(controller); //메인화면 -> 도서 상세화면
		pBookAdd = new BookAdd(controller); // 도서상세 -> 도서추가.
		
		
		//Dao 생성
		
		setTitle("\uD0A4\uD2B8\uB9AC \uB3C4\uC11C\uAD00");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		setBounds(0, 0, 800, 800);
		setLocationRelativeTo(null); // 프레임을 화면 정가운데 위치
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_cardLayout = new JPanel();
		panel_cardLayout.setBounds(0, 0, 800, 800);

		panel_cardLayout.setLayout(cardLayout);

		// 순서를 바꾸면 로그인창부터 실행 가능
		panel_cardLayout.add(pLogin, "pLogin");
		panel_cardLayout.add(pMain, "pMain");

		contentPane.add(panel_cardLayout);
		
		
	}// end CardLayoutTest

}// end class
