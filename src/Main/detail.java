package Main;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class detail {
	private JFrame frame;
	private detailDAO dao;

	public detail() {
		dao = new detailDAO();
		dao.detail(OnionMain.paydate);

		frame = new JFrame("어니언 - 지출 세부사항");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 339, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		JLabel titlelb = new JLabel(dao.title);
		titlelb.setFont(new Font("함초롬바탕", Font.BOLD, 20));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(108, 152, 116, 25);
		frame.getContentPane().add(titlelb);

		JLabel paydatelb = new JLabel(dao.paydate);
		paydatelb.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		paydatelb.setBounds(155, 200, 117, 25);
		frame.getContentPane().add(paydatelb);

		JLabel feelb = new JLabel(Integer.toString(dao.fee));
		feelb.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		feelb.setBounds(155, 235, 117, 25);
		frame.getContentPane().add(feelb);

		JLabel termlb = new JLabel(dao.term);
		termlb.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		termlb.setBounds(155, 270, 117, 25);
		frame.getContentPane().add(termlb);

		JLabel cardlb = new JLabel(dao.card_name);
		cardlb.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		cardlb.setBounds(152, 313, 117, 25);
		frame.getContentPane().add(cardlb);

		JLabel banklb = new JLabel(dao.bank_name);
		banklb.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		banklb.setBounds(155, 314, 117, 25);
		frame.getContentPane().add(banklb);

		JButton closebt = new JButton("창닫기");
		closebt.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		closebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		closebt.setBounds(118, 408, 97, 23);
		closebt.setBorderPainted(false);
		closebt.setContentAreaFilled(false);
		closebt.setFocusPainted(false);

		frame.getContentPane().add(closebt);
		
		JLabel lblNewLabel = new JLabel("\uACB0\uC81C\uC77C");
		lblNewLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lblNewLabel.setBounds(71, 200, 72, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC694\uAE08");
		lblNewLabel_1.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(71, 235, 72, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uACB0\uC81C\uC8FC\uAE30");
		lblNewLabel_1_1.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(71, 270, 72, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uACB0\uC81C\uC218\uB2E8");
		lblNewLabel_1_1_1.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(71, 305, 72, 25);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("(\uCE74\uB4DC/\uACC4\uC88C)");
		lblNewLabel_1_1_1_1.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(71, 325, 72, 25);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
		if(titlelb.getText().equals("넷플릭스")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/넷플릭스.png");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("유튜브프리미엄")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/유투브프리미엄.jpeg");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("티빙")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/티빙.jpeg");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("밀리의 서재")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/밀리의서재.png");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("프레시코드")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/프레시코드.png");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("교통비")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/교통비.png");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("관리비")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/관리비.PNG");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("통신비")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/휴대폰비.png");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("적금")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/적금.png");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} 

	}
}
