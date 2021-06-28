package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

public class Announce_detail { // 검진 세부사항 알려줌(추가검진에 대한 정보들)

	private JFrame frame;
	private DTO_PEOPLE dto_people;

	public Announce_detail(String chk_name, String script, DTO_PEOPLE dto_people, String[] list) {
		initialize(chk_name, script, dto_people, list);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private void initialize(String chk_name, String script, DTO_PEOPLE dto_people, String[] list) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 240));
		frame.setBounds(100, 100, 498, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uCD94\uAC00\uAC80\uC9C4 \uC548\uB0B4\uC0AC\uD56D");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(127, 29, 211, 47);
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
		btn_home.setBounds(196, 410, 66, 25);
		frame.getContentPane().add(btn_home);

		JLabel lblNewLabel_1 = new JLabel("\uAC80\uC9C4\uC774\uB984 : ");
		lblNewLabel_1.setBackground(new Color(240, 248, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		lblNewLabel_1.setBounds(25, 100, 102, 36);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("\uC548\uB0B4\uC0AC\uD56D : ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(25, 146, 102, 36);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lbl_chkname = new JLabel("label");
		lbl_chkname.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_chkname.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl_chkname.setBounds(115, 104, 102, 36);
		frame.getContentPane().add(lbl_chkname);
		lbl_chkname.setText(chk_name);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(115, 166, 355, 219);
		frame.getContentPane().add(scrollPane);
		

		JLabel lbl_guide = new JLabel("New label");
		lbl_guide.setBounds(115, 166, 353, 219);
		lbl_guide.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		if (chk_name.equals("대장검사")) {
			lbl_guide.setPreferredSize(new Dimension(327, 850)); // 라벨의 차원을 지정해주는 (넓이 높이)
		}
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(lbl_guide);
		lbl_guide.setText("<html><body>" + script + "</body></html>");
		
		/*
		 * JLabel lbl_guide = new JLabel("New label"); lbl_guide.setFont(new
		 * Font("맑은 고딕", Font.PLAIN, 15)); for (int i = 0; i < list.length; i++) { if
		 * (chk_name.equals()) { lbl_guide.setPreferredSize(new Dimension(327, 850)); //
		 * 라벨의 차원을 지정해주는 (넓이 높이) scrollPane.setHorizontalScrollBarPolicy(JScrollPane.
		 * HORIZONTAL_SCROLLBAR_NEVER); scrollPane.setViewportView(lbl_guide);
		 * lbl_guide.setText("<html><body>" + script + "</body></html>"); } }
		 */

	}
}
