package manager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Result_input {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JButton btn_input;
	private M_DAO m_dao = new M_DAO();
	private M_DTO_RESULT m_dto_result = null;
	private JLabel lblNewLabel;
	private JTextField txt_memberid;
	private JLabel lblNewLabel_2;
	private JTextField txt_gohyulap;
	private JLabel lblNewLabel_3;
	private JTextField txt_biman;
	private JLabel lblNewLabel_4;
	private JTextField txt_am;
	private JLabel lblNewLabel_5;
	private JTextField txt_dangnyo;
	private JLabel lblNewLabel_6;
	private JTextField txt_chunsik;
	private JLabel lblNewLabel_7;
	private JTextField txt_gangyunghwa;
	
	public Result_input() {
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
		
		JLabel lbl_result = new JLabel("\uAC80\uC9C4\uACB0\uACFC \uC785\uB825");
		lbl_result.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_result.setFont(new Font("±¼¸²", Font.BOLD, 25));
		lbl_result.setBounds(157, 44, 217, 52);
		frame.getContentPane().add(lbl_result);
		
		lblNewLabel_1 = new JLabel("\uB4A4\uB85C");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main main = new Main();
				frame.dispose();
			}
		});
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(485, 537, 57, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		lblNewLabel = new JLabel("\uD68C\uC6D0\uBC88\uD638 : ");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(64, 115, 104, 33);
		frame.getContentPane().add(lblNewLabel);
		
		txt_memberid = new JTextField();
		txt_memberid.setBounds(180, 115, 280, 33);
		frame.getContentPane().add(txt_memberid);
		txt_memberid.setColumns(10);
		
		lblNewLabel_2 = new JLabel("\uACE0\uD608\uC555 : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(64, 168, 104, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		txt_gohyulap = new JTextField();
		txt_gohyulap.setColumns(10);
		txt_gohyulap.setBounds(180, 168, 280, 33);
		frame.getContentPane().add(txt_gohyulap);
		
		lblNewLabel_3 = new JLabel("\uBE44\uB9CC : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(64, 222, 104, 33);
		frame.getContentPane().add(lblNewLabel_3);
		
		txt_biman = new JTextField();
		txt_biman.setColumns(10);
		txt_biman.setBounds(180, 222, 280, 33);
		frame.getContentPane().add(txt_biman);
		
		lblNewLabel_4 = new JLabel("\uC554 : ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(64, 277, 104, 33);
		frame.getContentPane().add(lblNewLabel_4);
		
		txt_am = new JTextField();
		txt_am.setColumns(10);
		txt_am.setBounds(180, 277, 280, 33);
		frame.getContentPane().add(txt_am);
		
		lblNewLabel_5 = new JLabel("\uB2F9\uB1E8 : ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(64, 331, 104, 33);
		frame.getContentPane().add(lblNewLabel_5);
		
		txt_dangnyo = new JTextField();
		txt_dangnyo.setColumns(10);
		txt_dangnyo.setBounds(180, 331, 280, 33);
		frame.getContentPane().add(txt_dangnyo);
		
		lblNewLabel_6 = new JLabel("\uCC9C\uC2DD : ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(64, 382, 104, 33);
		frame.getContentPane().add(lblNewLabel_6);
		
		txt_chunsik = new JTextField();
		txt_chunsik.setColumns(10);
		txt_chunsik.setBounds(180, 382, 280, 33);
		frame.getContentPane().add(txt_chunsik);
		
		lblNewLabel_7 = new JLabel("\uAC04\uACBD\uD654 : ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(64, 437, 104, 33);
		frame.getContentPane().add(lblNewLabel_7);
		
		txt_gangyunghwa = new JTextField();
		txt_gangyunghwa.setColumns(10);
		txt_gangyunghwa.setBounds(180, 437, 280, 33);
		frame.getContentPane().add(txt_gangyunghwa);
		
		btn_input = new JButton("\uC785\uB825\uC644\uB8CC");
		btn_input.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		btn_input.setBorderPainted(false);
		btn_input.setBackground(new Color(176, 196, 222));
		btn_input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_input.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int id = Integer.parseInt(txt_memberid.getText()) ;
				String gohyulap = txt_gohyulap.getText() ;
				String biman = txt_biman.getText() ;
				String am = txt_am.getText() ;
				String dangnyo = txt_dangnyo.getText() ;
				String chunsik = txt_chunsik.getText() ;
				String gangyunghwa = txt_gangyunghwa.getText() ;
				
				m_dao.M_DAO_RESULT_INPUT(id, gohyulap, biman, am, dangnyo, chunsik, gangyunghwa);
				JOptionPane.showMessageDialog(null, "°á°ú°¡ ÀÔ·ÂµÇ¾ú½À´Ï´Ù.", "°á°úµ¥ÀÌÅÍ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btn_input.setBounds(195, 492, 149, 33);
		frame.getContentPane().add(btn_input);
		
	}

}
