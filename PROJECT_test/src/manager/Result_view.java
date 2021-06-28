package manager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;

public class Result_view {

	private JFrame frame;
	private JTable table;
	private JLabel lbl_back;
	private M_DAO m_dao = new M_DAO();
	private M_DTO_RESULT m_dto_result = null;
	private JButton btn_result;
	
	public Result_view() {
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
				
		
		JLabel lbl_result = new JLabel("\uAC80\uC9C4\uACB0\uACFC\uD45C");
		lbl_result.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_result.setFont(new Font("±¼¸²", Font.BOLD, 25));
		lbl_result.setBounds(182, 36, 181, 66);
		frame.getContentPane().add(lbl_result);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(245, 255, 250));
		scrollPane.setBounds(51, 172, 452, 338);
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
		lbl_back.setBounds(485, 531, 57, 27);
		frame.getContentPane().add(lbl_back);
		
		btn_result = new JButton("\uACB0\uACFC \uBCF4\uAE30");
		btn_result.setBorderPainted(false);
		btn_result.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		btn_result.setBackground(new Color(176, 196, 222));
		btn_result.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<M_DTO_RESULT> arr_result = m_dao.M_DAO_RESULT_VIEW();

				String[] col = {"È¸¿ø¹øÈ£","°íÇ÷¾Ð","ºñ¸¸","¾Ï","´ç´¢","Ãµ½Ä","°£°æÈ­" };
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
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
		});
		btn_result.setBounds(51, 121, 99, 33);
		frame.getContentPane().add(btn_result);
	}

}
