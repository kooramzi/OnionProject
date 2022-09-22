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

		frame = new JFrame("��Ͼ� - ���� ���λ���");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 339, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		JLabel titlelb = new JLabel(dao.title);
		titlelb.setFont(new Font("���ʷҹ���", Font.BOLD, 20));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(108, 152, 116, 25);
		frame.getContentPane().add(titlelb);

		JLabel paydatelb = new JLabel(dao.paydate);
		paydatelb.setFont(new Font("���ʷҹ���", Font.PLAIN, 12));
		paydatelb.setBounds(155, 200, 117, 25);
		frame.getContentPane().add(paydatelb);

		JLabel feelb = new JLabel(Integer.toString(dao.fee));
		feelb.setFont(new Font("���ʷҹ���", Font.PLAIN, 12));
		feelb.setBounds(155, 235, 117, 25);
		frame.getContentPane().add(feelb);

		JLabel termlb = new JLabel(dao.term);
		termlb.setFont(new Font("���ʷҹ���", Font.PLAIN, 12));
		termlb.setBounds(155, 270, 117, 25);
		frame.getContentPane().add(termlb);

		JLabel cardlb = new JLabel(dao.card_name);
		cardlb.setFont(new Font("���ʷҹ���", Font.PLAIN, 12));
		cardlb.setBounds(152, 313, 117, 25);
		frame.getContentPane().add(cardlb);

		JLabel banklb = new JLabel(dao.bank_name);
		banklb.setFont(new Font("���ʷҹ���", Font.PLAIN, 12));
		banklb.setBounds(155, 314, 117, 25);
		frame.getContentPane().add(banklb);

		JButton closebt = new JButton("â�ݱ�");
		closebt.setFont(new Font("���ʷҹ���", Font.PLAIN, 12));
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
		lblNewLabel.setFont(new Font("���ʷҹ���", Font.PLAIN, 12));
		lblNewLabel.setBounds(71, 200, 72, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC694\uAE08");
		lblNewLabel_1.setFont(new Font("���ʷҹ���", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(71, 235, 72, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uACB0\uC81C\uC8FC\uAE30");
		lblNewLabel_1_1.setFont(new Font("���ʷҹ���", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(71, 270, 72, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uACB0\uC81C\uC218\uB2E8");
		lblNewLabel_1_1_1.setFont(new Font("���ʷҹ���", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(71, 305, 72, 25);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("(\uCE74\uB4DC/\uACC4\uC88C)");
		lblNewLabel_1_1_1_1.setFont(new Font("���ʷҹ���", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(71, 325, 72, 25);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
		if(titlelb.getText().equals("���ø���")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/���ø���.png");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("��Ʃ�������̾�")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/�����������̾�.jpeg");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("Ƽ��")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/Ƽ��.jpeg");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("�и��� ����")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/�и��Ǽ���.png");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("�������ڵ�")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/�������ڵ�.png");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("�����")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/�����.png");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("������")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/������.PNG");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("��ź�")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/�޴�����.png");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} else if(titlelb.getText().equals("����")) {
			ImageIcon img = new ImageIcon("../OnionProject/src/img/����.png");
			JLabel logo = new JLabel(img);
			logo.setBounds(108, 26, 116, 116);
			frame.getContentPane().add(logo);
		} 

	}
}
