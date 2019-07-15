package com.kitri.test.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Main extends JPanel {

	private JTextField maintf;
	private JTable table;

	String header[] = { "회원번호", "이름", "나이", "생년월일", "성별", "핸드폰번호", "대여도서개수" };
	String contents[][] = { { "123", "김두한", "100", "1918년 5월 15일", "남자", "0104561234", "0" },
			{ "124", "호날두", "34", "1985년 2월 5일", "남자", "0101234567", "3" },
			{ "125", "손흥민", "27", "1992년 7월 8일", "남자", "0109873246", "2" },
			{ "126", "박지성", "38", "1981년 2월 25일", "남자", "0106547321", "1" },
			{ "127", "김연아", "27", "1990년 9월 5일", "여자", "0106241487", "1" }

	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Main frame = new Main();
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
	public Main() {
//		setTitle("\uB3C4\uC11C\uAD00\uB9AC\uC2DC\uC2A4\uD15C");
		setBounds(new Rectangle(0, 0, 800, 1000));
		setBounds(380, 40, 800, 800);
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 800, 1000));
		setBorder(null);
		setLayout(null);

		JComboBox maincomboBox = new JComboBox();
		maincomboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		maincomboBox.setBounds(58, 117, 110, 30);
		add(maincomboBox);

		maintf = new JTextField();
		maintf.setBorder(new LineBorder(Color.BLACK));
		maintf.setBounds(203, 117, 419, 30);
		add(maintf);
		maintf.setColumns(10);

		JButton mainsearch = new JButton("\uAC80\uC0C9");
		mainsearch.setBackground(Color.LIGHT_GRAY);
		mainsearch.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		mainsearch.setForeground(new Color(0, 0, 0));
		mainsearch.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		mainsearch.setBounds(677, 117, 76, 30);
		add(mainsearch);

		JButton rent = new JButton("\uB300\uC5EC");
		rent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rent.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		rent.setBackground(Color.LIGHT_GRAY);
		rent.setForeground(Color.BLACK);
		rent.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		rent.setBounds(25, 32, 93, 30);
		add(rent);

		JButton returns = new JButton("\uBC18\uB0A9");
		returns.setBackground(Color.LIGHT_GRAY);
		returns.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		returns.setForeground(new Color(0, 0, 0));
		returns.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		returns.setBounds(175, 32, 93, 30);
		add(returns);

		JButton members = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		members.setBackground(Color.LIGHT_GRAY);
		members.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		members.setForeground(new Color(0, 0, 0));
		members.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		members.setBounds(330, 32, 103, 30);
		add(members);

		JButton bookmang = new JButton("\uB3C4\uC11C\uAD00\uB9AC");
		bookmang.setBackground(Color.LIGHT_GRAY);
		bookmang.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		bookmang.setForeground(new Color(0, 0, 0));
		bookmang.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		bookmang.setBounds(497, 32, 103, 30);
		add(bookmang);

		JButton statis = new JButton("\uD1B5\uACC4");
		statis.setBackground(Color.LIGHT_GRAY);
		statis.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		statis.setForeground(new Color(0, 0, 0));
		statis.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		statis.setBounds(667, 32, 93, 30);
		add(statis);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 196, 736, 537);
		add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		table = new JTable(contents, header);
		table.setBounds(12, 549, 710, -548);
		scrollPane.setViewportView(table);

	}
}
