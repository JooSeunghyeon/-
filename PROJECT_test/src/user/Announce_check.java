package user;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Announce_check { // 검진안내 창 - 성별, 연령별, 질환별 추천 검진 항목을 알려줌

	private JFrame frame;
	private ButtonGroup bg;
	private String[] list = new String[9];
	private DAO dao = new DAO();
	private DTO_PEOPLE dto_people;
	private String gender;
	private String age;

	public Announce_check(DTO_PEOPLE dto_people) {
		initialize(dto_people);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private void initialize(DTO_PEOPLE dto_people) {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uAC80\uC9C4 \uCCB4\uD06C\uB9AC\uC2A4\uD2B8");
		lblNewLabel.setBounds(280, 10, 211, 55);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);

		JRadioButton rad_man = new JRadioButton("\uB0A8\uC790");
		rad_man.setContentAreaFilled(false);
		rad_man.setAlignmentX(Component.CENTER_ALIGNMENT);
		rad_man.setBounds(273, 110, 76, 23);
		rad_man.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gender = rad_man.getText();
			}
		});
		rad_man.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		rad_man.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(rad_man);

		JRadioButton rad_woman = new JRadioButton("\uC5EC\uC790");
		rad_woman.setContentAreaFilled(false);
		rad_woman.setAlignmentX(Component.CENTER_ALIGNMENT);
		rad_woman.setBounds(355, 110, 83, 23);
		rad_woman.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gender = rad_woman.getText();
			}
		});
		rad_woman.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		rad_woman.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(rad_woman);

		// =================라디오버튼 두개를 하나의 그룹으로 묶어주는 코드===================
		bg = new ButtonGroup();
		bg.add(rad_man);
		bg.add(rad_woman);
		// =====================중복 선택이 불가능하게 만들기 위함========================

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				age = (String) comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(280, 151, 251, 28);
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "0 ~ 39\uC138", "40 ~ 49\uC138", "50 ~ 59\uC138", "60\uC138 \uC774\uC0C1" }));
		comboBox.setToolTipText("");
		frame.getContentPane().add(comboBox);

		JCheckBox cb0 = new JCheckBox("\uACE0\uD608\uC555");
		cb0.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb0.setContentAreaFilled(false);
		cb0.setAlignmentX(Component.CENTER_ALIGNMENT);
		cb0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[0] = cb0.getText();
			}
		});
		cb0.setBounds(219, 236, 115, 23);
		frame.getContentPane().add(cb0);

		JCheckBox cb1 = new JCheckBox("\uACE8\uB2E4\uACF5\uC99D");
		cb1.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb1.setContentAreaFilled(false);
		cb1.setAlignmentX(Component.CENTER_ALIGNMENT);
		cb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[1] = cb1.getText();
			}
		});
		cb1.setBounds(338, 236, 115, 23);
		frame.getContentPane().add(cb1);

		JCheckBox cb3 = new JCheckBox("\uAD6C\uB8E8\uBCD1");
		cb3.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb3.setContentAreaFilled(false);
		cb3.setAlignmentX(Component.CENTER_ALIGNMENT);
		cb3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[3] = cb3.getText();
			}
		});
		cb3.setBounds(219, 271, 115, 23);
		frame.getContentPane().add(cb3);

		JCheckBox cb4 = new JCheckBox("\uB2F9\uB1E8\uBCD1");
		cb4.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb4.setContentAreaFilled(false);
		cb4.setAlignmentX(Component.CENTER_ALIGNMENT);
		cb4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[4] = cb4.getText();
			}
		});
		cb4.setBounds(338, 271, 115, 23);
		frame.getContentPane().add(cb4);

		JCheckBox cb2 = new JCheckBox("\uD5C8\uB9AC\uB514\uC2A4\uD06C");
		cb2.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb2.setContentAreaFilled(false);
		cb2.setAlignmentX(Component.CENTER_ALIGNMENT);
		cb2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[2] = cb2.getText();
			}
		});
		cb2.setBounds(457, 236, 115, 23);
		frame.getContentPane().add(cb2);

		JCheckBox cb5 = new JCheckBox("\uBE44\uB9CC");
		cb5.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb5.setContentAreaFilled(false);
		cb5.setAlignmentX(Component.CENTER_ALIGNMENT);
		cb5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[5] = cb5.getText();
			}
		});
		cb5.setBounds(457, 271, 115, 23);
		frame.getContentPane().add(cb5);

		JCheckBox cb6 = new JCheckBox("\uCC9C\uC2DD");
		cb6.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb6.setContentAreaFilled(false);
		cb6.setAlignmentX(Component.CENTER_ALIGNMENT);
		cb6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[6] = cb6.getText();
			}
		});
		cb6.setBounds(219, 303, 115, 23);
		frame.getContentPane().add(cb6);

		JCheckBox cb7 = new JCheckBox("\uB300\uC7A5\uC554");
		cb7.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb7.setContentAreaFilled(false);
		cb7.setAlignmentX(Component.CENTER_ALIGNMENT);
		cb7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[7] = cb7.getText();
			}
		});
		cb7.setBounds(338, 303, 115, 23);
		frame.getContentPane().add(cb7);

		JCheckBox cb8 = new JCheckBox("\uAC04\uC9C8\uD658");
		cb8.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		cb8.setContentAreaFilled(false);
		cb8.setAlignmentX(Component.CENTER_ALIGNMENT);
		cb8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list[8] = cb8.getText();
			}
		});
		cb8.setBounds(457, 303, 115, 23);
		frame.getContentPane().add(cb8);

		JLabel lbl_exe_1 = new JLabel(
				"\uFF0A\uC138\uBD80 \uAC80\uC0AC\uB97C \uCD94\uCC9C\uD574 \uB4DC\uB9BD\uB2C8\uB2E4.");
		lbl_exe_1.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lbl_exe_1.setBounds(219, 66, 246, 21);
		lbl_exe_1.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(lbl_exe_1);

		JLabel lbl_age_2 = new JLabel("\uC131\uBCC4");
		lbl_age_2.setBounds(208, 110, 57, 28);
		lbl_age_2.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		lbl_age_2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl_age_2);

		JLabel lbl_age_2_1 = new JLabel("\uC5F0\uB839");
		lbl_age_2_1.setBounds(208, 148, 57, 28);
		lbl_age_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_age_2_1.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		frame.getContentPane().add(lbl_age_2_1);

		JLabel lbl_age_2_1_1 = new JLabel("\uAE30\uC800\uC9C8\uD658 (\uC911\uBCF5\uAC00\uB2A5)");
		lbl_age_2_1_1.setBounds(219, 202, 160, 28);
		lbl_age_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_age_2_1_1.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		frame.getContentPane().add(lbl_age_2_1_1);

		JLabel btn_back = new JLabel("\uB4A4\uB85C");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main_window main = new Main_window(dto_people);
				frame.dispose();
			}
		});
		btn_back.setHorizontalAlignment(SwingConstants.CENTER);
		btn_back.setForeground(Color.BLUE);
		btn_back.setBounds(280, 350, 57, 23);
		frame.getContentPane().add(btn_back);

		JLabel btn_next = new JLabel("\uB2E4\uC74C");
		btn_next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<DTO_DISEASE> arr = dao.DAO_disease(list);

				Announce_setting setting = new Announce_setting(gender, age, arr, dto_people,list);
				frame.dispose();
			}
		});
		btn_next.setHorizontalAlignment(SwingConstants.CENTER);
		btn_next.setForeground(Color.BLUE);
		btn_next.setBounds(411, 340, 46, 42);
		frame.getContentPane().add(btn_next);

		// 여기서부터 이미지
		JLabel back = new JLabel("New label");
		back.setBounds(0, -19, 750, 416);
		String path = getClass().getResource("").getPath();
		System.out.println(path);
		Image img = new ImageIcon(path + "img/750416.jpg").getImage();
		img = img.getScaledInstance(750, 416, Image.SCALE_SMOOTH);

		ImageIcon icon = new ImageIcon(img);
		back.setIcon(icon);

		back.setBounds(0, 0, 734, 377);
		frame.getContentPane().add(back);

	}
}
