package Member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Member.login.ImgPanel;

public class join {

	private MemberDAO memberdao;
	private MemberVo vo;

	String id = "", pw = "", pwch = "", name = "", phone = "";

	public join() {
		memberdao = new MemberDAO();
		JFrame frame = new JFrame("어니언 - 회원가입");
		
		frame.setBounds(100, 100, 409, 417);
		frame.setLocationRelativeTo(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
			}

		});
		frame.getContentPane().setLayout(null);
		Font f1 = new Font("함초롬바탕", Font.PLAIN, 12); 
		
		
		JLabel joinlb = new JLabel("JOIN MEMBER");
		joinlb.setFont(new Font("Arial Black", Font.PLAIN, 36));
		joinlb.setBounds(59, 23, 292, 52);
		frame.getContentPane().add(joinlb);

		JLabel idlb = new JLabel("ID");
		idlb.setFont(f1);
		idlb.setBounds(71, 102, 110, 29);
		frame.getContentPane().add(idlb);

		JLabel pwlb = new JLabel("PW");
		pwlb.setFont(f1);
		pwlb.setBounds(71, 140, 110, 29);
		frame.getContentPane().add(pwlb);
		
		JLabel pwlb_check = new JLabel("PW(CHECK)");
		pwlb_check.setFont(f1);
		pwlb_check.setBounds(71, 179, 110, 29);
		frame.getContentPane().add(pwlb_check);

		JLabel namelb = new JLabel("NAME");
		namelb.setFont(f1);
		namelb.setBounds(71, 218, 110, 29);
		frame.getContentPane().add(namelb);

		JLabel pnlb = new JLabel("PHONE NUMBER");
		pnlb.setFont(f1);
		pnlb.setBounds(69, 255, 110, 29);
		frame.getContentPane().add(pnlb);

		JTextField tfid = new JTextField();
		tfid.setBounds(205, 102, 132, 21);
		frame.getContentPane().add(tfid);
		tfid.setColumns(10);

		JTextField tfpw = new JPasswordField();
		tfpw.setBounds(205, 140, 132, 21);
		frame.getContentPane().add(tfpw);
		tfpw.setColumns(10);

		JTextField tfname = new JTextField();
		tfname.setBounds(205, 218, 132, 21);
		frame.getContentPane().add(tfname);
		tfname.setColumns(10);

		JTextField tfpn = new JTextField();
		tfpn.setBounds(203, 255, 132, 21);
		frame.getContentPane().add(tfpn);
		tfpn.setColumns(10);

		JTextField tfpwch = new JPasswordField();
		tfpwch.setColumns(10);
		tfpwch.setBounds(205, 179, 132, 21);
		frame.getContentPane().add(tfpwch);
		frame.setVisible(true);

		JButton joinBtn = new JButton("JOIN");
		joinBtn.setForeground(Color.BLACK);
		joinBtn.setBounds(154, 313, 97, 23);
		joinBtn.setBorderPainted(false);
//		joinBtn.setPreferredSize(new Dimension(100,56));
		joinBtn.setContentAreaFilled(false);
		joinBtn.setFocusPainted(false);
		frame.getContentPane().add(joinBtn);

		joinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean b = tfpw.getText().equals(tfpwch.getText());
				if (b == true) {
					vo = new MemberVo(tfid.getText(), tfpw.getText(), tfname.getText(), tfpn.getText());
					memberdao.insertMember(vo);
					new successAlert();
					frame.setVisible(false);
				} else {
					new failAlert();
				}
			}
		});
		
		ImgPanel imgPanel = new ImgPanel();
		imgPanel.setLayout(null);
		imgPanel.setBounds(0, 0, 393, 378);
		frame.getContentPane().add(imgPanel);

	}
	class ImgPanel extends JPanel {
		   private ImageIcon icon = new ImageIcon("E:\\work\\OnionProject\\src\\img\\회원가입창.PNG");
		   private Image img = icon.getImage(); // 이미지 객체

		   public void paintComponent(Graphics g) {
		      super.paintComponent(g);
		      g.drawImage(img, 0, 0, 409, 417, this);
		   }
		} 
}
