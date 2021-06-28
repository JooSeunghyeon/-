package user;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class Join { // 회원가입창

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_pw;
	private JTextField txt_gender;
	private JTextField txt_name;
	private JTextField txt_contact;
	private JTextField txt_age;

	private DAO dao = new DAO();

	public Join() {
		initialize();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 608, 1066);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel btn_back = new JLabel("");
		btn_back.setBounds(21, 28, 61, 32);
		btn_back.setForeground(Color.WHITE);
		btn_back.setHorizontalAlignment(SwingConstants.CENTER);
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);

		txt_id = new JTextField();
		txt_id.setBorder(null);

		txt_id.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_id.setText(null);
				txt_id.setForeground(Color.BLACK);
			}
		});

		txt_id.setBackground(Color.WHITE);
		txt_id.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		txt_id.setForeground(Color.LIGHT_GRAY);
		txt_id.setText("\uC544\uC774\uB514(\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.)");
		txt_id.setBounds(23, 152, 383, 42);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);

		txt_pw = new JTextField();
		txt_pw.setBorder(null);
		txt_pw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txt_pw.setText(null);
				txt_pw.setForeground(Color.BLACK);
			}
		});
		txt_pw.setBackground(Color.WHITE);
		txt_pw.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		txt_pw.setForeground(Color.LIGHT_GRAY);
		txt_pw.setText("\uBE44\uBC00\uBC88\uD638");
		txt_pw.setBounds(23, 234, 557, 42);
		txt_pw.setColumns(10);
		frame.getContentPane().add(txt_pw);

		txt_gender = new JTextField();
		txt_gender.setBorder(null);
		txt_gender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txt_gender.setText(null);
				txt_gender.setForeground(Color.black);
			}
		});
		txt_gender.setBackground(Color.WHITE);
		txt_gender.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		txt_gender.setForeground(Color.LIGHT_GRAY);
		txt_gender.setText("\uC131\uBCC4\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694 (\uC608 man , woman)");
		txt_gender.setBounds(23, 318, 557, 42);
		txt_gender.setColumns(10);
		frame.getContentPane().add(txt_gender);

		txt_name = new JTextField();
		txt_name.setBorder(null);
		txt_name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txt_name.setText(null);
				txt_name.setForeground(Color.black);
			}
		});
		txt_name.setBackground(Color.WHITE);
		txt_name.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		txt_name.setForeground(Color.LIGHT_GRAY);
		txt_name.setText("\uC774\uB984(\uC2E4\uBA85 \uC785\uB825)");
		txt_name.setBounds(23, 402, 557, 42);
		txt_name.setColumns(10);
		frame.getContentPane().add(txt_name);

		JLabel lblNewLabel_1_4 = new JLabel("\uC5F0\uB77D\uCC98");
		lblNewLabel_1_4.setBounds(149, 1105, 86, 27);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("돋움체", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_1_4);

		txt_contact = new JTextField();
		txt_contact.setBorder(null);
		txt_contact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txt_contact.setText(null);
				txt_contact.setForeground(Color.black);
			}
		});
		txt_contact.setBackground(Color.WHITE);
		txt_contact.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		txt_contact.setForeground(Color.LIGHT_GRAY);
		txt_contact.setText("\uD734\uB300\uC804\uD654\uBC88\uD638('-' \uD3EC\uD568)");
		txt_contact.setBounds(27, 485, 553, 42);
		txt_contact.setColumns(10);
		frame.getContentPane().add(txt_contact);

		txt_age = new JTextField();
		txt_age.setBorder(null);
		txt_age.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_age.setText(null);
				txt_age.setForeground(Color.black);
			}
		});
		txt_age.setBackground(Color.WHITE);
		txt_age.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		txt_age.setForeground(Color.LIGHT_GRAY);
		txt_age.setText("\uB098\uC774 (\uC2E4\uC81C \uB098\uC774\uB85C \uC785\uB825\uD574\uC8FC\uC138\uC694)");
		txt_age.setBounds(27, 565, 553, 42);
		txt_age.setColumns(10);
		frame.getContentPane().add(txt_age);

		JLabel btn_join = new JLabel("");
		btn_join.setBounds(27, 913, 541, 83);
		btn_join.setForeground(Color.WHITE);
		btn_join.setHorizontalAlignment(SwingConstants.CENTER);
		btn_join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String member_id = txt_id.getText();
				String name = txt_name.getText();
				String age = txt_age.getText();
				String gender = txt_gender.getText();
				String contact = txt_contact.getText();
				String password = txt_pw.getText();

				int cnt = dao.DAO_join(Integer.parseInt(member_id), name, Integer.parseInt(age), gender, contact,
						password);

				if (cnt > 0) {
					System.out.println("회원가입 성공");
					JOptionPane.showMessageDialog(null, "회원가입 성공하셨습니다.", "회원가입 성공", JOptionPane.INFORMATION_MESSAGE);
				} else {
					System.out.println("회원가입 실패");
					JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
				}


				txt_id.setText("");
				txt_name.setText("");
				txt_age.setText("");
				txt_gender.setText("");
				txt_contact.setText("");
				txt_pw.setText("");

				Login login = new Login();
				frame.dispose();

			}
		});
		frame.getContentPane().add(btn_join);
		
		// 이미지
		JLabel lblNewLabel_2 = new JLabel("New label");
		String path = getClass().getResource("").getPath();
		Image img = new ImageIcon(path + "img/def.jpg").getImage();
		lblNewLabel_2.setBounds(0, 0, 1064, 1061);
		ImageIcon icon = new ImageIcon(img);
		lblNewLabel_2.setIcon(icon);
		frame.getContentPane().add(lblNewLabel_2);
		

	}
}
