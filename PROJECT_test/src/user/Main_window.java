package user;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

public class Main_window { // 로그인하고 나면 뜨는 메인창

	private JFrame frame;
	private DAO dao = new DAO();
	private DTO_PEOPLE dto_people;

	public Main_window(DTO_PEOPLE dto_people) {
		initialize(dto_people);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private void initialize(DTO_PEOPLE dto_people) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1110, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel btn_reserve = new JLabel("");
		btn_reserve.setBounds(556, 354, 177, 104);
		btn_reserve.setBackground(SystemColor.info);
		btn_reserve.setFont(new Font("돋움체", Font.BOLD, 20));
		btn_reserve.setHorizontalAlignment(SwingConstants.CENTER);
		btn_reserve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Reserve_check check = new Reserve_check(dto_people);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_reserve);

		JLabel btn_announce = new JLabel("");
		btn_announce.setBounds(374, 354, 177, 104);
		btn_announce.setBackground(SystemColor.info);
		btn_announce.setFont(new Font("돋움체", Font.BOLD, 20));
		btn_announce.setHorizontalAlignment(SwingConstants.CENTER);
		btn_announce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Announce_check check = new Announce_check(dto_people);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_announce);

		JLabel btn_mypage = new JLabel("");
		btn_mypage.setBounds(914, 354, 180, 104);
		btn_mypage.setBackground(SystemColor.info);
		btn_mypage.setFont(new Font("돋움체", Font.BOLD, 20));
		btn_mypage.setHorizontalAlignment(SwingConstants.CENTER);
		btn_mypage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mypage page = new Mypage(dto_people);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_mypage);

		JLabel btn_check = new JLabel("");
		btn_check.setBounds(739, 354, 177, 104);
		btn_check.setBackground(SystemColor.info);
		btn_check.setFont(new Font("돋움체", Font.BOLD, 17));
		btn_check.setHorizontalAlignment(SwingConstants.CENTER);
		btn_check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (dao.DAO_rsrStt(dto_people.getMember_id()) == null) {
					JOptionPane.showMessageDialog(null, "예약 내역이 없습니다.", "예약", JOptionPane.INFORMATION_MESSAGE);
				} else {
					Rescheck_waiting wait = new Rescheck_waiting(dto_people);
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btn_check);
		JLabel back = new JLabel("New label");
		// 여기서부터 이미지
		back.setBounds(0, -19, 1166, 604);
		String path = getClass().getResource("").getPath();
		Image img = new ImageIcon(path + "img/mainpage.jpg").getImage();
		img = img.getScaledInstance(1100, 580, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		back.setIcon(icon);

		frame.getContentPane().add(back);
	}

}
