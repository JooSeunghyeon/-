package user;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class Reserve_check { // 예약하는 창 - 날짜, 시간 선택가능

	private JFrame frame;
	private JTextField txt_memberid;
	private JTextField txt_date;
	private JTextField txt_time;
	private String[] list = new String[10];
	private DAO dao = new DAO();

	public Reserve_check(DTO_PEOPLE dto_people) {
		initialize(dto_people);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private void initialize(DTO_PEOPLE dto_people) {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("굴림", Font.PLAIN, 20));
		frame.setBounds(100, 100, 498, 654);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC608\uC57D");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(186, 31, 94, 34);
		frame.getContentPane().add(lblNewLabel);

		JLabel btn_back = new JLabel("\uB4A4\uB85C\uAC00\uAE30");
		btn_back.setForeground(Color.BLUE);
		btn_back.setHorizontalAlignment(SwingConstants.CENTER);
		btn_back.setFont(new Font("굴림", Font.PLAIN, 12));
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main_window main = new Main_window(dto_people);
				frame.dispose();
			}
		});
		btn_back.setBounds(87, 551, 86, 34);
		frame.getContentPane().add(btn_back);

		JLabel lblNewLabel_1 = new JLabel("\uC608\uC57D \uB0A0\uC9DC");
		lblNewLabel_1.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(36, 90, 94, 34);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("\uC608\uC57D \uC2DC\uAC04");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(36, 170, 94, 34);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("\uD68C\uC6D0\uBC88\uD638");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(36, 248, 94, 34);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		txt_memberid = new JTextField();
		txt_memberid.setBounds(135, 249, 262, 34);
		frame.getContentPane().add(txt_memberid);
		txt_memberid.setColumns(10);

		txt_date = new JTextField();
		txt_date.setColumns(10);
		txt_date.setBounds(135, 90, 262, 34);
		frame.getContentPane().add(txt_date);

		txt_time = new JTextField();
		txt_time.setColumns(10);
		txt_time.setBounds(135, 170, 262, 34);
		frame.getContentPane().add(txt_time);

		JLabel lblNewLabel_2 = new JLabel("\uB144/\uC6D4/\uC77C  -  \uC608\uC2DC) 96/05/27");
		lblNewLabel_2.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(135, 134, 176, 15);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("\uC2DC/\uBD84/\uCD08  -  \uC608\uC2DC) 15/45/00");
		lblNewLabel_2_1.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setBounds(135, 214, 195, 15);
		frame.getContentPane().add(lblNewLabel_2_1);

		JCheckBox cb0 = new JCheckBox("\uACE8\uBC00\uB3C4\uAC80\uC0AC");
		cb0.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb0.setContentAreaFilled(false);
		cb0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[0] = cb0.getText();
			}
		});
		cb0.setBounds(58, 388, 115, 23);
		frame.getContentPane().add(cb0);

		JCheckBox cb1 = new JCheckBox("CT\uAC80\uC0AC");
		cb1.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb1.setContentAreaFilled(false);
		cb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[1] = cb1.getText();
			}
		});
		cb1.setBounds(177, 388, 115, 23);
		frame.getContentPane().add(cb1);

		JCheckBox cb3 = new JCheckBox("\uC548\uACFC\uAC80\uC0AC");
		cb3.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb3.setContentAreaFilled(false);
		cb3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[3] = cb3.getText();
			}
		});
		cb3.setBounds(58, 423, 115, 23);
		frame.getContentPane().add(cb3);

		JCheckBox cb4 = new JCheckBox("\uB1CC/\uC2EC\uD608");
		cb4.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb4.setContentAreaFilled(false);
		cb4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[4] = cb4.getText();
			}
		});
		cb4.setBounds(177, 423, 115, 23);
		frame.getContentPane().add(cb4);

		JCheckBox cb2 = new JCheckBox("\uBE44\uD0C0\uBBFC\uAC80\uC0AC");
		cb2.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb2.setContentAreaFilled(false);
		cb2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[2] = cb2.getText();
			}
		});
		cb2.setBounds(296, 388, 115, 23);
		frame.getContentPane().add(cb2);

		JCheckBox cb5 = new JCheckBox("\uB3D9\uB9E5\uACBD\uD654");
		cb5.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb5.setContentAreaFilled(false);
		cb5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[5] = cb5.getText();
			}
		});
		cb5.setBounds(296, 423, 115, 23);
		frame.getContentPane().add(cb5);

		JCheckBox cb6 = new JCheckBox("\uBCF5\uBD80\uB0B4\uC7A5");
		cb6.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb6.setContentAreaFilled(false);
		cb6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[6] = cb6.getText();
			}
		});
		cb6.setBounds(58, 455, 115, 23);
		frame.getContentPane().add(cb6);

		JCheckBox cb7 = new JCheckBox("HRV");
		cb7.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb7.setContentAreaFilled(false);
		cb7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[7] = cb7.getText();
			}
		});
		cb7.setBounds(177, 455, 115, 23);
		frame.getContentPane().add(cb7);

		JCheckBox cb8 = new JCheckBox("\uD638\uD761\uAE30\uB2A5");
		cb8.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb8.setContentAreaFilled(false);
		cb8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[8] = cb8.getText();
			}
		});
		cb8.setBounds(296, 455, 115, 23);
		frame.getContentPane().add(cb8);

		JCheckBox cb9 = new JCheckBox("\uB300\uC7A5\uAC80\uC0AC");
		cb9.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb9.setContentAreaFilled(false);
		cb9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[9] = cb9.getText();
			}
		});
		cb9.setBounds(58, 489, 115, 23);
		frame.getContentPane().add(cb9);

		JLabel lblNewLabel_3 = new JLabel("\uCD94\uAC00 \uD76C\uB9DD\uAC80\uC9C4 \uD56D\uBAA9 \uCCB4\uD06C");
		lblNewLabel_3.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		lblNewLabel_3.setBounds(36, 342, 244, 34);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel btn_booking = new JLabel("\uC608\uC57D\uD558\uAE30");
		btn_booking.setForeground(Color.BLUE);
		btn_booking.setHorizontalAlignment(SwingConstants.CENTER);
		btn_booking.setFont(new Font("굴림", Font.PLAIN, 12));
		btn_booking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String date = txt_date.getText();
				String time = txt_time.getText();
				int memberid = Integer.parseInt(txt_memberid.getText());

				int resv = dao.DAO_rsr(date, time, memberid);
				if(resv>0) {
					System.out.println("예약성공");
				}else {
					System.out.println("예약실패");
					JOptionPane.showMessageDialog(null, "예약 실패하셨습니다.", "예약 실패", JOptionPane.WARNING_MESSAGE);
				}

				Reserve_result result = new Reserve_result(dto_people, list);
				frame.dispose();

			}
		});
		btn_booking.setBounds(275, 551, 86, 34);
		frame.getContentPane().add(btn_booking);

		// 이미지
		JLabel back = new JLabel("New label");
		back.setBounds(0, -19, 600, 600);
		String path = getClass().getResource("").getPath();
		System.out.println(path);
		Image img = new ImageIcon(path + "img/6.jpg").getImage();
		img = img.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		back.setIcon(icon);

		back.setBounds(0, 0, 600, 600);
		frame.getContentPane().add(back);
	}
}
