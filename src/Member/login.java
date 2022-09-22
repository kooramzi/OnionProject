package Member;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Main.OnionMain;

public class login implements ActionListener  {

	private loginVo vo;
	private loginDAO dao;
	private TextField id,pw;

	public login() {
		dao = new loginDAO();
		JFrame f = new JFrame("어니언 - 로그인");
		f.setSize(900, 700);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font f1 = new Font("함초롬바탕", Font.PLAIN, 15); 
		UIManager.put("OptionPane.messageFont", f1);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ImgPanel panel_1 = new ImgPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 884, 661);
		f.getContentPane().add(panel_1);
		
		id = new TextField(10);
		id.setBounds(429, 512, 145, 23);
		panel_1.add(id);
		
		pw = new TextField(10);
		pw.setEchoChar('*');
		pw.setBounds(429, 541, 145, 23);
		panel_1.add(pw);
		
		ImageIcon img = new ImageIcon("E:\\work\\OnionProject\\src\\img\\로그인버튼1.png");
		JButton loginb = new JButton(img);
		loginb.setBorderPainted(false);
		loginb.setPreferredSize(new Dimension(100,56));
		loginb.setContentAreaFilled(false);
		loginb.setFocusPainted(false);
		loginb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 정확히 입력하세요.", "", JOptionPane.INFORMATION_MESSAGE);
				} else if(pw.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 정확히 입력하세요.", "", JOptionPane.INFORMATION_MESSAGE);
				} else {
					vo = new loginVo(id.getText(),pw.getText());
					boolean b = dao.list(vo);
					if(b==true) {
						new OnionMain();
						f.setVisible(false);
					}else 
						JOptionPane.showMessageDialog(null, "로그인 실패! 회원정보가 없습니다.", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		loginb.setBounds(360, 570, 100, 56);
		panel_1.add(loginb);
		
		
		ImageIcon img1 = new ImageIcon("E:/work/OnionProject/src/img/회원가입버튼1.PNG");
		JButton joinb = new JButton(img1);
		joinb.setBorderPainted(false);
		joinb.setPreferredSize(new Dimension(117,56));
		joinb.setContentAreaFilled(false);
		joinb.setFocusPainted(false);
		joinb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new join();
			}
		});
		joinb.setBounds(465, 570, 117, 56);
		panel_1.add(joinb);
		
		f.setVisible(true);
		f.getContentPane().add(panel_1);
	
	}
	
	class ImgPanel extends JPanel {
		   private ImageIcon icon = new ImageIcon("E:\\work\\OnionProject\\src\\img\\onionlogin.png");
		   private Image img = icon.getImage(); // 이미지 객체

		   public void paintComponent(Graphics g) {
		      super.paintComponent(g);
		      g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		   }
		} 
	
	

	public static void main(String[] args) {
		new login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
