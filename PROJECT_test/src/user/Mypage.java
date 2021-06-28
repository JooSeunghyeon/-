package user;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import manager.M_DTO_RESULT;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Mypage { // 마이페이지 - 개인정보와 검진결과 확인가능

	private JFrame frame;
	private JTable table_result;
	private DAO dao = new DAO();
	private DTO_RESULT dto_result;

	public Mypage(DTO_PEOPLE dto_people) {
		initialize(dto_people);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private void initialize(DTO_PEOPLE dto_people) {
		frame = new JFrame();
		frame.setBounds(100, 100, 418, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel btn_home_1 = new JLabel("");
		btn_home_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main_window main = new Main_window(dto_people);
				frame.dispose();
			}
		});
		btn_home_1.setHorizontalAlignment(SwingConstants.CENTER);
		btn_home_1.setForeground(Color.BLUE);
		btn_home_1.setBounds(162, 660, 81, 51);
		frame.getContentPane().add(btn_home_1);

		JLabel lblNewLabel = new JLabel("\uB2D8");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(162, 114, 57, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lbl_gender = new JLabel("");
		lbl_gender.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_gender.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		lbl_gender.setBounds(303, 111, 69, 28);
		frame.getContentPane().add(lbl_gender);
		lbl_gender.setText(dto_people.getGender());

		JLabel lbl_name = new JLabel("\uC774\uB984 : ");
		lbl_name.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		lbl_name.setBounds(73, 104, 125, 43);
		frame.getContentPane().add(lbl_name);
		lbl_name.setText(dto_people.getMember_name());

		JLabel lbl_id = new JLabel("New label");
		lbl_id.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setBounds(12, 211, 103, 71);
		frame.getContentPane().add(lbl_id);
		lbl_id.setText(dto_people.getMember_id()+"");

		JLabel lbl_pw = new JLabel("New label");
		lbl_pw.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lbl_pw.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_pw.setBounds(143, 211, 115, 71);
		frame.getContentPane().add(lbl_pw);
		lbl_pw.setText(dto_people.getPass());

		JLabel lbl_pon = new JLabel("New label");
		lbl_pon.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lbl_pon.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_pon.setBounds(270, 211, 120, 71);
		frame.getContentPane().add(lbl_pon);
		lbl_pon.setText(dto_people.getTel());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 386, 378, 233);
		frame.getContentPane().add(scrollPane);

		// 결과데이터보기
		table_result = new JTable();
		ArrayList<DTO_RESULT> arr_result = dao.DAO_RESULT_VIEW(dto_people.getMember_id());

		String[] col = { "회원번호", "고혈압", "비만", "암", "당뇨", "천식", "간경화" };
		Object[][] data = new Object[arr_result.size()][col.length];

		for (int i = 0; i < arr_result.size(); i++) {
			data[i][0] = arr_result.get(i).getMember_id();
			data[i][1] = arr_result.get(i).getGohyulap();
			data[i][2] = arr_result.get(i).getBiman();
			data[i][3] = arr_result.get(i).getAm();
			data[i][4] = arr_result.get(i).getDangnyo();
			data[i][5] = arr_result.get(i).getChunsik();
			data[i][6] = arr_result.get(i).getGankyungha();

		}

		DefaultTableModel model = new DefaultTableModel(data, col);
		table_result.setModel(model);
		scrollPane.setViewportView(table_result);

		// 이미지
		JLabel back = new JLabel("New label");
		back.setBounds(0, 0, 400, 711);
		frame.getContentPane().add(back);
		String path = getClass().getResource("").getPath();
		Image img = new ImageIcon(path + "img/400711.jpg").getImage();
		img = img.getScaledInstance(400, 711, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		back.setIcon(icon);
		

	}
}
