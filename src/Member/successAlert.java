package Member;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class successAlert {

	private JFrame frame;

	public successAlert() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 308, 174);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel joinSuccess = new JLabel("\uD68C\uC6D0\uAC00\uC785 \uC131\uACF5!");
		joinSuccess.setFont(new Font("«‘√ ∑“πŸ≈¡", Font.PLAIN, 16));
		joinSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		joinSuccess.setBounds(64, 31, 170, 29);
		frame.getContentPane().add(joinSuccess);
		
		JButton closeBtn = new JButton("\uB2EB\uAE30");
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				}
		});
		closeBtn.setFont(new Font("«‘√ ∑“πŸ≈¡", Font.PLAIN, 12));
		closeBtn.setBounds(99, 70, 97, 23);
		frame.getContentPane().add(closeBtn);
		frame.setVisible(true);
	}
}

