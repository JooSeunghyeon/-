package user;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Login { // 맨 처음에 실행되는 창 - 로그인

	private JFrame frame;
	private JTextField txt_id;
	private JPasswordField txt_pw;
	private DAO dao = new DAO();
	private DTO_PEOPLE dto_people;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setForeground(Color.WHITE);
		frame.setTitle("\uAC74\uAC15\uAC80\uC9C4 \uC0AC\uC774\uD2B8");
		frame.setBounds(100, 100, 1100, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txt_id = new JTextField();
		txt_id.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_id.setText("");
				txt_id.setForeground(Color.black);
			}
		});
		txt_id.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		txt_id.setHorizontalAlignment(SwingConstants.LEFT);
		txt_id.setForeground(Color.LIGHT_GRAY);
		txt_id.setText("회원번호 입력");
		txt_id.setBounds(712, 132, 302, 45);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);

		txt_pw = new JPasswordField();
		txt_pw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_pw.setText("");
				txt_pw.setForeground(Color.black);
			}
		});
		txt_pw.setEchoChar('*');
		txt_pw.setBackground(Color.WHITE);
		txt_pw.setBounds(712, 188, 302, 39);
		frame.getContentPane().add(txt_pw);

		JLabel btn_login = new JLabel("");
		btn_login.setHorizontalAlignment(SwingConstants.CENTER);
		btn_login.setFont(new Font("굴림", Font.BOLD, 25));
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				dto_people = dao.DAO_people(Integer.parseInt(txt_id.getText()), txt_pw.getText());
				
				if (dto_people != null) {
					System.out.println("로그인 성공");
					JOptionPane.showMessageDialog(null, "로그인 성공하셨습니다.", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
					Main_window main = new Main_window(dto_people);
					frame.dispose();
				} else {
					System.out.println("로그인 실패");
				}

			}
		});
		btn_login.setBounds(712, 266, 302, 39);
		frame.getContentPane().add(btn_login);

		JLabel btn_join = new JLabel("");
		btn_join.setHorizontalAlignment(SwingConstants.CENTER);
		btn_join.setFont(new Font("굴림", Font.BOLD, 25));
		btn_join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Join join = new Join();
				frame.dispose();
			}
		});
		btn_join.setBounds(714, 323, 302, 39);
		frame.getContentPane().add(btn_join);

		// 여기서부터 이미지
		String path = getClass().getResource("").getPath();
		System.out.println(path);
		Image img = new ImageIcon(path + "img/abc.jpg").getImage();
		img = img.getScaledInstance(1100, 580, Image.SCALE_SMOOTH);

		ImageIcon icon = new ImageIcon(img);

		JLabel back = new JLabel("");
		back.setBounds(0, 0, 1084, 541);
		back.setIcon(icon); // 완성!
		frame.getContentPane().add(back);

	}
}
