package Member;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class failAlert {
	private JFrame frame;

	public failAlert() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 308, 174);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel joinSuccess = new JLabel("비밀번호가 다릅니다!!");
		joinSuccess.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		joinSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		joinSuccess.setBounds(64, 31, 170, 29);
		frame.getContentPane().add(joinSuccess);
		
		JButton closeBtn = new JButton("돌아가기");
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				}
		});
		closeBtn.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		closeBtn.setBounds(99, 70, 97, 23);
		frame.getContentPane().add(closeBtn);
		frame.setVisible(true);
	}
}
