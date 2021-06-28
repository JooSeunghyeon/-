package user;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Rescheck_waiting { // 본인 예약현황과 대기순번 보여줌

	private JFrame frame;
	private DAO dao = new DAO();

	public Rescheck_waiting(DTO_PEOPLE dto_people) {
		initialize(dto_people);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private void initialize(DTO_PEOPLE dto_people) {

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel btn_home = new JLabel("\uD648\uC73C\uB85C");
		btn_home.setForeground(Color.BLUE);
		btn_home.setHorizontalAlignment(SwingConstants.CENTER);
		btn_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main_window main = new Main_window(dto_people);
				frame.dispose();
			}
		});
		btn_home.setBounds(350, 513, 89, 38);
		frame.getContentPane().add(btn_home);

		JLabel lbl_m = new JLabel("\uD68C\uC6D0\uBC88\uD638 : ");
		lbl_m.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		lbl_m.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_m.setForeground(Color.BLACK);
		lbl_m.setBounds(101, 242, 91, 32);
		frame.getContentPane().add(lbl_m);

		JLabel lbl_n = new JLabel("\uC608\uC57D\uBC88\uD638 : ");
		lbl_n.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		lbl_n.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_n.setForeground(Color.BLACK);
		lbl_n.setBounds(101, 293, 91, 32);
		frame.getContentPane().add(lbl_n);

		JLabel lbl_num = new JLabel("\uBC88");
		lbl_num.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		lbl_num.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_num.setForeground(Color.BLACK);
		lbl_num.setBounds(624, 312, 51, 32);
		frame.getContentPane().add(lbl_num);

		JLabel lbl_d = new JLabel("\uC608\uC57D\uB0A0\uC9DC : ");
		lbl_d.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		lbl_d.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_d.setForeground(Color.BLACK);
		lbl_d.setBounds(100, 346, 91, 32);
		frame.getContentPane().add(lbl_d);

		JLabel lbl_t = new JLabel("\uC608\uC57D\uC2DC\uAC04 : ");
		lbl_t.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		lbl_t.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_t.setForeground(Color.BLACK);
		lbl_t.setBounds(101, 395, 91, 32);
		frame.getContentPane().add(lbl_t);

		JLabel lbl_memberid = new JLabel("New label");
		lbl_memberid.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		lbl_memberid.setBounds(197, 242, 64, 32);
		frame.getContentPane().add(lbl_memberid);

		JLabel lbl_bookingnum = new JLabel("New label");
		lbl_bookingnum.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		lbl_bookingnum.setBounds(197, 293, 64, 32);
		frame.getContentPane().add(lbl_bookingnum);

		JLabel lbl_date = new JLabel("New label");
		lbl_date.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_date.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		lbl_date.setBounds(197, 351, 147, 27);
		frame.getContentPane().add(lbl_date);

		JLabel lbl_time = new JLabel("New label");
		lbl_time.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_time.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		lbl_time.setBounds(197, 395, 106, 32);
		frame.getContentPane().add(lbl_time);

		// 예약현황
		DTO_RSRSTT dto_rsrstt = dao.DAO_rsrStt(dto_people.getMember_id());

		lbl_date.setText(dto_rsrstt.getDate() + "");
		lbl_time.setText(dto_rsrstt.getTime() + "");
		lbl_memberid.setText(dto_rsrstt.getMember_id() + "");
		lbl_bookingnum.setText(dto_rsrstt.getBooking_number() + "");

		// 예약취소
		JButton btn_del = new JButton("\uC608\uC57D \uCDE8\uC18C");
		btn_del.setBorderPainted(false);
		btn_del.setBackground(new Color(176, 196, 222));
		btn_del.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dao.DAO_rsrDel(dto_people.getMember_id());
				JOptionPane.showMessageDialog(null, "예약이 취소되었습니다.", "예약 취소", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btn_del.setBounds(133, 456, 97, 32);
		frame.getContentPane().add(btn_del);

		// 대기순번
		JLabel lbl_waitnum = new JLabel("?");
		lbl_waitnum.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		lbl_waitnum.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_waitnum.setForeground(Color.BLACK);
		lbl_waitnum.setBounds(538, 316, 74, 32);
		frame.getContentPane().add(lbl_waitnum);

		int wait_cnt = dao.DAO_wait(dto_rsrstt.getDate(), dto_rsrstt.getTime());
		lbl_waitnum.setText(wait_cnt + "");

		// 이미지
		JLabel back = new JLabel("New label");
		String path = getClass().getResource("").getPath();
		System.out.println(path);
		Image img = new ImageIcon(path + "img/800600.jpg").getImage();
		img = img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		back.setIcon(icon);

		back.setBounds(-10, -28, 888, 657);
		frame.getContentPane().add(back);
	}
}
