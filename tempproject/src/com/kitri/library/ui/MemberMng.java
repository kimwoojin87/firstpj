package com.kitri.library.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.kitri.library.controller.Controller;

import java.awt.SystemColor;
import java.awt.Font;

public class MemberMng extends JFrame {

	private JPanel contentPane;
	private JTextField tfSearch;
	private JTable table;
	private Controller controller;
	
	String person[] = {"회원번호","이름","생년월일"};
	String header[] = {"회원번호","이름","나이","생년월일","성별","핸드폰번호","대여도서개수"};
	String contents[][] = {
			{"123","김두한","100","1918년 5월 15일","남자","0104561234","0"},
			{"124","호날두","34","1985년 2월 5일","남자","0101234567","3"},
			{"125","손흥민","27","1992년 7월 8일","남자","0109873246","2"},
			{"126","박지성","38","1981년 2월 25일","남자","0106547321","1"},
			{"127","김연아","27","1990년 9월 5일","여자","0106241487","1"}
			
	};

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMng frame = new MemberMng(null);
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
	public MemberMng(Controller controller) {
		this.controller= controller;
		setTitle("\uD68C\uC6D0\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 430);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(person);
		comboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		comboBox.setForeground(SystemColor.inactiveCaptionText);
		
		comboBox.setToolTipText("\uD68C\uC6D0\uC544\uC774\uB514");
		comboBox.setBounds(14, 12, 105, 24);
		contentPane.add(comboBox);
		
		tfSearch = new JTextField();
		tfSearch.setText("\uB0B4\uC6A9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		tfSearch.setBounds(154, 12, 385, 24);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btSearch = new JButton("\uAC80\uC0C9");
		btSearch.setForeground(SystemColor.inactiveCaptionText);
		btSearch.setFont(new Font("굴림", Font.PLAIN, 12));
		btSearch.setBackground(Color.LIGHT_GRAY);
		btSearch.setBounds(552, 12, 105, 28);
		contentPane.add(btSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 48, 640, 290);
		contentPane.add(scrollPane);
		
		table = new JTable(contents,header);
		scrollPane.setViewportView(table);
		
		JButton btAdd = new JButton("\uCD94\uAC00");
		btAdd.setForeground(SystemColor.inactiveCaptionText);
		btAdd.setFont(new Font("굴림", Font.PLAIN, 12));
		btAdd.setBounds(14, 352, 97, 23);
		contentPane.add(btAdd);
		
		JButton btDelete = new JButton("\uC0AD\uC81C");
		btDelete.setForeground(SystemColor.inactiveCaptionText);
		btDelete.setFont(new Font("굴림", Font.PLAIN, 12));
		btDelete.setBounds(133, 352, 97, 23);
		contentPane.add(btDelete);
		
		JButton btCancel = new JButton("\uCDE8\uC18C");
		btCancel.setForeground(SystemColor.inactiveCaptionText);
		btCancel.setFont(new Font("굴림", Font.PLAIN, 12));
		btCancel.setBounds(552, 352, 97, 23);
		contentPane.add(btCancel);
		
		
	}
}
