package Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class dday extends JFrame {
	private Font f1 = new Font("함초롬바탕", Font.PLAIN, 20);
	private Font f2 = new Font("함초롬바탕", Font.PLAIN, 15);
	private JTextField tf1;
	private String t2;
	static Calendar now = Calendar.getInstance();
	static Calendar d_day = Calendar.getInstance();
//	static String day;
//	static long l_now;
//	static long l_dday;

//	public static int getDday(int year, int month, int day) {
//		try {
//			// 날짜 셋팅
//			d_day.set(year, month, Integer.valueOf(dday.day));
//
//			long l_now = now.getTimeInMillis() / (24 * 60 * 60 * 1000);
//			long l_dday = d_day.getTimeInMillis() / (24 * 60 * 60 * 1000);
//			long substract = l_now - l_dday;
//			System.out.println(l_now);
//			System.out.println(l_dday);
//
//			return (int) substract;
//			
//			
//			
//		} catch (Exception e) {
//			return -1;
//		}
//	}

	public static int getDday(Date day) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(day);
			DateFormat df = new SimpleDateFormat("yyyy-M-d");
//		        System.out.println("current: " + df.format(cal.getTime()));
			cal.add(Calendar.MONTH, 1); // 다음 결제일(1달뒤)을 얻는다
//		        System.out.println("after: " + df.format(cal.getTime()));
			long diff = (now.getTimeInMillis() / (24 * 60 * 60 * 1000))
					- (cal.getTimeInMillis() / (24 * 60 * 60 * 1000));
//			System.out.println(diff);

			return (int) diff;

		} catch (Exception e) {
			return -1;
		}
	}

//	public static int getDday(Date day) {
//		try {
//			
//			 l_now = now.getTimeInMillis();
//			 l_dday = day.getTime();
//			
//			//long->date
//			l_dday = l_dday*1000;
//			Date d = new Date(l_dday);
//			d.setDate();
//			d.setMonth(7);  //8월로 세팅
//			d.setYear(122); //2022년으로 세팅
//			System.out.println(d+"ㅋㅋ");
//			
//			//date->long
//			long l_dday2 = d.getTime()/1000;
//			long diff = l_now - l_dday2 ;
//
//		
//			return (int) diff;
//			
//			int dif = Long.valueOf(diff).intValue();
//			return dif;
//
//		} catch (Exception e) {
//			return -1;
//		}
//	}

	public dday(String day) {
		getContentPane().setBackground(new Color(255, 255, 255));

		try {
			t2 = " 다음 결제일이 " + getDday(new SimpleDateFormat("yyyy-M-d").parse(day)) + "일 남았습니다.";

		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JLabel lb1 = new JLabel();
		lb1.setBounds(58, 38, 300, 40);
		lb1.setFont(f1);
		String t1 = "오늘은 " + now.get(Calendar.YEAR) + " 년 " + (now.get(Calendar.MONTH) + 1) + " 월 "
				+ now.get(Calendar.DAY_OF_MONTH) + " 일 입니다.";
		lb1.setText(t1);

		tf1 = new JTextField();
		tf1.setFont(f1);
		tf1.setText(t2);
		tf1.setBounds(58, 88, 300, 40);

		JButton bt1 = new JButton("close");
		bt1.setBounds(155, 156, 97, 23);
		bt1.setFont(f2);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bt1.setBorderPainted(false);
		bt1.setContentAreaFilled(false);
		bt1.setFocusPainted(false);

		getContentPane().add(lb1);
		getContentPane().add(tf1);
		getContentPane().add(bt1);
		setTitle("결제일 D-DAY");
		setSize(426, 249);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);
	}

}
