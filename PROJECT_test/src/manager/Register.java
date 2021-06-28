package manager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register {

	private JFrame frame;
	private JTable table;
	private JLabel lbl_back;
	private JLabel lblNewLabel_2;
	private JTextField txt_bookingnum;
	private M_DAO m_dao = new M_DAO();
	private M_DTO_RGS m_dto_rgs = null;
	private JButton btn_rgs;

	public Register() {
		initialize();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 570, 607);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBackground(new Color(245, 255, 250));
		scrollPane.setBounds(66, 236, 430, 285);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		lbl_back = new JLabel("\uB4A4\uB85C");
		lbl_back.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lbl_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main main = new Main();
				frame.dispose();
			}
		});
		lbl_back.setForeground(Color.BLUE);
		lbl_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_back.setBounds(485, 543, 57, 15);
		frame.getContentPane().add(lbl_back);

		JLabel lbl_rgs = new JLabel("\uC811\uC218 \uB9AC\uC2A4\uD2B8");
		lbl_rgs.setFont(new Font("±¼¸²", Font.BOLD, 25));
		lbl_rgs.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_rgs.setBounds(194, 40, 157, 39);
		frame.getContentPane().add(lbl_rgs);

		lblNewLabel_2 = new JLabel("\uC608\uC57D\uBC88\uD638 : ");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(52, 121, 108, 39);
		frame.getContentPane().add(lblNewLabel_2);

		txt_bookingnum = new JTextField();
		txt_bookingnum.setBounds(155, 125, 235, 33);
		frame.getContentPane().add(txt_bookingnum);
		txt_bookingnum.setColumns(10);

		JButton btn_del = new JButton("\uC0AD\uC81C");
		btn_del.setBorderPainted(false);
		btn_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_del.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		btn_del.setForeground(Color.BLACK);
		btn_del.setBackground(new Color(176, 196, 222));
		btn_del.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				m_dao.M_DAO_Del(Integer.parseInt(txt_bookingnum.getText()));
				txt_bookingnum.setText("");
				
			}
		});
		btn_del.setBounds(402, 127, 66, 27);
		frame.getContentPane().add(btn_del);

		btn_rgs = new JButton("\uACB0\uACFC \uBCF4\uAE30");
		btn_rgs.setBorderPainted(false);
		btn_rgs.setBackground(new Color(176, 196, 222));
		btn_rgs.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		btn_rgs.setForeground(Color.BLACK);
		btn_rgs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<M_DTO_RGS> arr_rgs = m_dao.M_DAO_RGS();

				String[] col = { "³¯Â¥", "½Ã°£", "È¸¿ø¹øÈ£", "¿¹¾à¹øÈ£" };
				Object[][] data = new Object[arr_rgs.size()][col.length];

				for (int i = 0; i < arr_rgs.size(); i++) {
					data[i][0] = arr_rgs.get(i).getDate();
					data[i][1] = arr_rgs.get(i).getTime();
					data[i][2] = arr_rgs.get(i).getMember_id();
					data[i][3] = arr_rgs.get(i).getBooking_number();
				}

				DefaultTableModel model = new DefaultTableModel(data, col);
				table.setModel(model);
				scrollPane.setViewportView(table);

			}
		});
		btn_rgs.setBounds(66, 194, 108, 33);
		frame.getContentPane().add(btn_rgs);
	}
}
