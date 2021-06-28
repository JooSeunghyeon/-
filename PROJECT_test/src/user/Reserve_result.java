package user;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import java.awt.Font;

public class Reserve_result { // 예약이 완료되면 사전주의사항 보여주는 창

	private JFrame frame;
	private DAO dao = new DAO();
	private String script = "";

	public Reserve_result(DTO_PEOPLE dto_people, String[] list) {
		initialize(dto_people, list);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private void initialize(DTO_PEOPLE dto_people, String[] list) {
		frame = new JFrame();
		frame.setBounds(100, 100, 498, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC608\uC57D\uC774 \uC644\uB8CC\uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(139, 43, 230, 29);
		frame.getContentPane().add(lblNewLabel);

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
		btn_home.setBounds(193, 394, 99, 29);
		frame.getContentPane().add(btn_home);

		JLabel lblNewLabel_1 = new JLabel("\u25B6 \uAC80\uC9C4 \uC2DC \uC720\uC758\uC0AC\uD56D");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(43, 97, 196, 29);
		frame.getContentPane().add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 136, 379, 232);
		frame.getContentPane().add(scrollPane);

		JLabel lbl_ann = new JLabel("New label");

		for (int i = 0; i < list.length; i++) {

			if (list[i] != null) {
				if (dto_people.getAge() >= 0 && dto_people.getAge() <= 39) {
					script += dao.DAO_select(list[i]).getScript();
					lbl_ann.setPreferredSize(new Dimension(327, 530)); // 라벨의 차원을 지정해주는 (넓이 높이)
				} else {
					continue;
				}
			}
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setViewportView(lbl_ann);
			lbl_ann.setText("<html><body>" + script + "</body><html>");
		}

		// 이미지
		JLabel back = new JLabel("New label");
		back.setFont(new Font("맑은 고딕", Font.PLAIN, 50));
		back.setBounds(0, -19, 600, 600);
		String path = getClass().getResource("").getPath();
		System.out.println(path);
		Image img = new ImageIcon(path + "img/600.jpg").getImage();
		img = img.getScaledInstance(600, 600, Image.SCALE_SMOOTH);

		ImageIcon icon = new ImageIcon(img);
		back.setIcon(icon);

		back.setBounds(0, 0, 600, 600);
		frame.getContentPane().add(back);
	}
}
