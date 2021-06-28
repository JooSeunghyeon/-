package manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Component;

public class Main { // °ü¸®ÀÚÃ¢ ¸ÞÀÎ

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
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

		JLabel lblNewLabel = new JLabel("\uAD00\uB9AC\uC790\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 82, 294, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btn_register = new JButton("\uC608\uC57D\uC790 \uAD00\uB9AC");
		btn_register.setBorderPainted(false);
		btn_register.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn_register.setBackground(new Color(176, 196, 222));
		btn_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register register = new Register();
				frame.dispose();
			}
		});
		btn_register.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 23));
		btn_register.setBounds(89, 239, 382, 53);
		frame.getContentPane().add(btn_register);
		
		JButton btn_result = new JButton("\uAC80\uC9C4 \uACB0\uACFC \uC785\uB825");
		btn_result.setBorder(null);
		btn_result.setBorderPainted(false);
		btn_result.setBackground(new Color(176, 196, 222));
		btn_result.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Result_input result = new Result_input();
				frame.dispose();
			}
		});
		btn_result.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 23));
		btn_result.setBounds(89, 331, 382, 53);
		frame.getContentPane().add(btn_result);
		
		JButton btn_result_1 = new JButton("\uAC80\uC9C4 \uACB0\uACFC\uD45C");
		btn_result_1.setBorder(null);
		btn_result_1.setBorderPainted(false);
		btn_result_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Result_view view = new Result_view();
				frame.dispose();
			}
		});
		btn_result_1.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 23));
		btn_result_1.setBackground(new Color(176, 196, 222));
		btn_result_1.setBounds(89, 423, 382, 53);
		frame.getContentPane().add(btn_result_1);
	}

}
