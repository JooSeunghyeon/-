package user;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class Announce_setting { // 검진 항목들 알려줌

	private JFrame frame;
	private DAO dao = new DAO();
	private DTO_CHECK dto_check = null;
	private DTO_PEOPLE dto_people;
	private JTable table;
	private JTable table_1;

	public Announce_setting(String gender, String age, ArrayList<DTO_DISEASE> arr, DTO_PEOPLE dto_people, String[] list) {
		initialize(gender, age, arr, dto_people, list);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private void initialize(String gender, String age, ArrayList<DTO_DISEASE> arr, DTO_PEOPLE dto_people, String[] list) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 240));
		frame.setBounds(100, 100, 498, 669);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uAE30\uBCF8 \uAC80\uC9C4 \uD56D\uBAA9");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 36, 154, 43);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(31, 89, 416, 199);
		frame.getContentPane().add(scrollPane);

		JLabel lblNewLabel_1 = new JLabel("\uCD94\uAC00 \uAC80\uC9C4 \uD56D\uBAA9");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(150, 314, 154, 43);
		frame.getContentPane().add(lblNewLabel_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(255, 255, 255));
		
		scrollPane_1.setBounds(31, 394, 416, 189);
		frame.getContentPane().add(scrollPane_1);

		ArrayList<DTO_CHECK> base = dao.DAO_base();
		ArrayList<DTO_CHECK> plus = dao.DAO_plus();
		ArrayList<DTO_CHECK> check = dao.DAO_check(arr);

		String[] col = { "검진번호", "검진이름", "비용" };
		Object[][] data1 = new Object[25][col.length];
		Object[][] data2 = new Object[check.size()][col.length];

		table = new JTable();
		scrollPane.setViewportView(table);
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel btn_home = new JLabel("\uD648\uC73C\uB85C");
		btn_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main_window main = new Main_window(null);
				frame.dispose();
			}
		});
		btn_home.setHorizontalAlignment(SwingConstants.CENTER);
		btn_home.setForeground(Color.BLUE);
		btn_home.setBounds(199, 595, 66, 25);
		frame.getContentPane().add(btn_home);
		
		JLabel lbl_e = new JLabel("\uFF0A\uAC80\uC9C4\uD56D\uBAA9\uC744 \uD074\uB9AD\uD558\uC5EC \uC138\uBD80\uC0AC\uD56D\uC744 \uD655\uC778\uD558\uC138\uC694.");
		lbl_e.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_e.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lbl_e.setBounds(31, 363, 277, 21);
		frame.getContentPane().add(lbl_e);
		
		if (age.equals("0 ~ 39세")) {
			for (int i = 0; i < base.size(); i++) {
				data1[i][0] = base.get(i).getCheck_number();
				data1[i][1] = base.get(i).getCheck_name();
				data1[i][2] = base.get(i).getCost();
			}

			for (int i = 0; i < check.size(); i++) {
				data2[i][0] = check.get(i).getCheck_number();
				data2[i][1] = check.get(i).getCheck_name();
				data2[i][2] = check.get(i).getCost();

			}

			// 25 27 31 기초항목으로
		} else if (age.equals("40 ~ 49세")) {
			for (int i = 0; i < base.size(); i++) {
				data1[i][0] = base.get(i).getCheck_number();
				data1[i][1] = base.get(i).getCheck_name();
				data1[i][2] = base.get(i).getCost();
			}

			data1[20][0] = plus.get(4).getCheck_number();
			data1[20][1] = plus.get(4).getCheck_name();
			data1[20][2] = plus.get(4).getCost();
			data1[21][0] = plus.get(6).getCheck_number();
			data1[21][1] = plus.get(6).getCheck_name();
			data1[21][2] = plus.get(6).getCost();
			data1[23][0] = plus.get(10).getCheck_number();
			data1[23][1] = plus.get(10).getCheck_name();
			data1[23][2] = plus.get(10).getCost();

			for (int i = 0; i < check.size(); i++) {
				data2[i][0] = check.get(i).getCheck_number();
				data2[i][1] = check.get(i).getCheck_name();
				data2[i][2] = check.get(i).getCost();
			}
			DefaultTableModel model1 = new DefaultTableModel(data1, col);
			table.setModel(model1);
			DefaultTableModel model2 = new DefaultTableModel(data2, col);
			table_1.setModel(model2);

		} else if (age.equals("50 ~ 59세") && gender.equals("남자")) {
			for (int i = 0; i < base.size(); i++) {
				data1[i][0] = base.get(i).getCheck_number();
				data1[i][1] = base.get(i).getCheck_name();
				data1[i][2] = base.get(i).getCost();
			}

			data1[20][0] = plus.get(4).getCheck_number();
			data1[20][1] = plus.get(4).getCheck_name();
			data1[20][2] = plus.get(4).getCost();
			data1[21][0] = plus.get(6).getCheck_number();
			data1[21][1] = plus.get(6).getCheck_name();
			data1[21][2] = plus.get(6).getCost();
			data1[23][0] = plus.get(10).getCheck_number();
			data1[23][1] = plus.get(10).getCheck_name();
			data1[23][2] = plus.get(10).getCost();
			data1[24][0] = plus.get(4).getCheck_number();
			data1[24][1] = plus.get(4).getCheck_name();
			data1[24][2] = plus.get(4).getCost();
			
			for (int i = 0; i < check.size(); i++) {
				data2[i][0] = check.get(i).getCheck_number();
				data2[i][1] = check.get(i).getCheck_name();
				data2[i][2] = check.get(i).getCost();
			}

			DefaultTableModel model1 = new DefaultTableModel(data1, col);
			table.setModel(model1);
			DefaultTableModel model2 = new DefaultTableModel(data2, col);
			table_1.setModel(model2);
		} else if (age.equals("50 ~ 59세") && gender.equals("여자")) {
			for (int i = 0; i < base.size(); i++) {
				data1[i][0] = base.get(i).getCheck_number();
				data1[i][1] = base.get(i).getCheck_name();
				data1[i][2] = base.get(i).getCost();
			}

			data1[20][0] = plus.get(4).getCheck_number();
			data1[20][1] = plus.get(4).getCheck_name();
			data1[20][2] = plus.get(4).getCost();
			data1[21][0] = plus.get(6).getCheck_number();
			data1[21][1] = plus.get(6).getCheck_name();
			data1[21][2] = plus.get(6).getCost();
			data1[23][0] = plus.get(10).getCheck_number();
			data1[23][1] = plus.get(10).getCheck_name();
			data1[23][2] = plus.get(10).getCost();
			data1[24][0] = plus.get(4).getCheck_number();
			data1[24][1] = plus.get(4).getCheck_name();
			data1[24][2] = plus.get(4).getCost();
			
			for (int i = 0; i < check.size(); i++) {
				data2[i][0] = check.get(i).getCheck_number();
				data2[i][1] = check.get(i).getCheck_name();
				data2[i][2] = check.get(i).getCost();
			}

			DefaultTableModel model1 = new DefaultTableModel(data1, col);
			table.setModel(model1);
			DefaultTableModel model2 = new DefaultTableModel(data2, col);
			table_1.setModel(model2);

		}
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object chk_number = table_1.getValueAt(table_1.getSelectedRow(), 0);
				String chk_name = dao.DAO_guide(chk_number).getCheck_name();
				String script = dao.DAO_guide(chk_number).getScript();
				Announce_detail detail = new Announce_detail(chk_name, script, dto_people,list);
				frame.dispose();
			}
		});
	}
}