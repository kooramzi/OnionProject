package Main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

public class OnionMain implements ActionListener {

	private static final Color WHITE = null;
	JFrame frame;
	public static JTable subTable;
	public static JTable livTable;
	private subscriptionDAO dao;
	private detailDAO dao1;

	private JLabel printTotal;
	private Panel yearmenu = null;
	private Panel daymenu = null;
	private Choice choice = null;
	private Choice choice1 = null;
	private Label label = null;
	private Label label1 = null;
	private Button[] bt2 = new Button[42];
	private int year = 0;
	private int month = 0;
	private ArrayList<subscriptionVo> list;
	private Vector<Object> vector;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	static String paydate;

	public static void main(String[] args) {
		new OnionMain();

	}

	public OnionMain() {
		dao = new subscriptionDAO();
		frame = new JFrame("어니언 - 메인화면");
		frame.getContentPane().setBackground(Color.WHITE);

		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel calPanel = new JPanel();
		calPanel.setBackground(Color.WHITE);
		calPanel.setBounds(12, 10, 363, 641);
		frame.getContentPane().add(calPanel);
		calPanel.setLayout(null);

		printTotal = new JLabel(Integer.toString(dao.totalFee(new subscriptionVo())));
		printTotal.setForeground(new Color(153, 204, 153));
		printTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		printTotal.setBounds(26, 92, 192, 56);
		printTotal.setVerticalTextPosition(0); // center
		printTotal.setHorizontalTextPosition(SwingConstants.RIGHT); // left
		printTotal.setFont(new Font("Arial", Font.PLAIN, 50));
		calPanel.add(printTotal);

		JButton show_bt = new JButton("금액숨기기");
		show_bt.setForeground(new Color(153, 204, 153));
		show_bt.setBorderPainted(false);
		show_bt.setContentAreaFilled(false);
		show_bt.setFocusPainted(false);

		show_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (show_bt.getText().equals("금액숨기기")) {
					printTotal.setVisible(false);
					show_bt.setText("금액보이기");
				} else if (show_bt.getText().equals("금액보이기")) {
					printTotal.setVisible(true);
					show_bt.setText("금액숨기기");
				}
			}
		});

		show_bt.setFont(new Font("함초롬바탕", Font.BOLD, 12));
		show_bt.setBounds(253, 143, 98, 32);
		calPanel.add(show_bt);

		JLabel callb = new JLabel("");
		callb.setIcon(new ImageIcon(OnionMain.class.getResource("/img/totalfee.PNG")));
		callb.setFont(new Font("함초롬바탕", Font.BOLD, 25));
		callb.setBounds(12, 10, 220, 75);
		calPanel.add(callb);

		JPanel calpane = new JPanel();
		calPanel.add(calpane);
		calpane.setLayout(new BorderLayout(0, 0));
		calpane.setBounds(12, 185, 339, 450);
		calpane.add(getYear(), BorderLayout.NORTH);
		calpane.add(getDay(), BorderLayout.CENTER);

		JLabel wonlb = new JLabel("\uC6D0 / ");
		wonlb.setForeground(new Color(153, 204, 153));
		wonlb.setHorizontalAlignment(SwingConstants.CENTER);
		wonlb.setFont(new Font("함초롬바탕", Font.BOLD, 16));
		wonlb.setBounds(223, 116, 47, 23);
		calPanel.add(wonlb);

		JLabel cntlb = new JLabel("\uAC74");
		cntlb.setForeground(new Color(153, 204, 153));
		cntlb.setHorizontalAlignment(SwingConstants.CENTER);
		cntlb.setFont(new Font("함초롬바탕", Font.BOLD, 16));
		cntlb.setBounds(312, 116, 25, 23);
		calPanel.add(cntlb);

		JLabel cnt = new JLabel(Integer.toString(dao.cnt(new subscriptionVo())));
		cnt.setForeground(new Color(153, 204, 153));
		cnt.setVerticalAlignment(SwingConstants.BOTTOM);
		cnt.setHorizontalAlignment(SwingConstants.RIGHT);
		cnt.setFont(new Font("함초롬바탕", Font.PLAIN, 22));
		cnt.setBounds(271, 103, 36, 40);
		calPanel.add(cnt);

		JPanel subPanel = new JPanel();
		subPanel.setBackground(Color.WHITE);
		subPanel.setBounds(387, 196, 485, 242);
		frame.getContentPane().add(subPanel);
		subPanel.setLayout(null);

		JLabel sublb = new JLabel("");
		sublb.setIcon(new ImageIcon(OnionMain.class.getResource("/img/sublb.PNG")));
		sublb.setFont(new Font("함초롬바탕", Font.BOLD, 25));
		sublb.setBounds(12, 10, 267, 47);
		subPanel.add(sublb);

		JScrollPane subScrollPane = new JScrollPane();
		subScrollPane.setBounds(12, 67, 461, 165);
		subPanel.add(subScrollPane);

		String[] sHeader = new String[] { "지출일", "항목", "요금" };
		Object[][] sContents = dao.selectSub(new subscriptionVo());
		subTable = new JTable(sContents, sHeader);
		subTable.setFont(new Font("함초롬바탕", Font.PLAIN, 13));

		model = new DefaultTableModel(sContents, sHeader) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		subTable.setModel(model);
		subTable.getRowCount();
		subTable.setSelectionBackground(new Color(153, 204, 102));
		subTable.setSelectionForeground(Color.white);
		subTable.setRowHeight(20);
		subTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JTable t = (JTable) e.getSource();
				if (e.getClickCount() == 2) {
					new dday((String) subTable.getValueAt(t.getSelectedRow(), 0));
				}
			}
		});

		subScrollPane.setViewportView(subTable);

		JPanel livPanel = new JPanel();
		livPanel.setBackground(Color.WHITE);
		livPanel.setBounds(387, 448, 485, 202);
		frame.getContentPane().add(livPanel);
		livPanel.setLayout(null);

		JLabel livlb = new JLabel("");
		livlb.setIcon(new ImageIcon(OnionMain.class.getResource("/img/livlb.PNG")));
		livlb.setBounds(12, 10, 267, 47);
		livPanel.add(livlb);
		livlb.setFont(new Font("함초롬바탕", Font.BOLD, 25));

		JScrollPane livScrollPane = new JScrollPane();
		livScrollPane.setBounds(12, 67, 461, 125);
		livPanel.add(livScrollPane);

		String[] lHeader = new String[] { "지출일", "항목", "요금" };
		Object[][] lContents = dao.selectLiv(new subscriptionVo());
		livTable = new JTable(lContents, lHeader);
		livTable.setFont(new Font("함초롬바탕", Font.PLAIN, 13));

		model1 = new DefaultTableModel(lContents, lHeader) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		livTable.setModel(model1);
		livTable.getRowCount();
		livTable.setSelectionBackground(new Color(153, 204, 102));
		livTable.setSelectionForeground(Color.white);
		livTable.setBackground(Color.white);
		livTable.setRowHeight(20);
		livTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JTable t = (JTable) e.getSource();
				if (e.getClickCount() == 2) {
					new dday((String) livTable.getValueAt(t.getSelectedRow(), 0));
				}
			}
		});

		

		livScrollPane.setViewportView(livTable);
		
		
		
		ImgPanel imgPanel = new ImgPanel();
		imgPanel.setBounds(0, 0, 884, 661);
		frame.getContentPane().add(imgPanel);
		frame.setVisible(true);

	}
	
	
	class ImgPanel extends JPanel {
		   private ImageIcon icon = new ImageIcon("E:\\work\\OnionProject\\src\\img\\mainbg.PNG");
		   private Image img = icon.getImage(); // 이미지 객체

		   public void paintComponent(Graphics g) {
		      super.paintComponent(g);
		      g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		   }
		} 
	

	private Panel getYear() {
		if (yearmenu == null) {
			label1 = new Label();
			label = new Label();
			label1.setText("년");
			label.setText("월");
			label1.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
			label.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
			yearmenu = new Panel();
			yearmenu.setBackground(Color.WHITE);
			yearmenu.setLayout(new FlowLayout());
			yearmenu.add(getChoice(), null);
			yearmenu.add(label1, null);
			yearmenu.add(getChoice1(), null);
			yearmenu.add(label, null);
		}
		return yearmenu;
	}

	private Panel getDay() {
		if (daymenu == null) {
			daymenu = new Panel();
			daymenu.setBackground(Color.WHITE);
			daymenu.setLayout(new GridLayout(7, 7));
			JLabel[] bt1 = new JLabel[7];
			String[] day = { "일", "월", "화", "수", "목", "금", "토" };
			for (int i = 0; i < 7; i++) {
				bt1[i] = new JLabel(day[i]);
				bt1[i].setHorizontalAlignment(SwingConstants.CENTER);
				bt1[i].setFont(new Font("함초롬바탕", Font.PLAIN, 15));
				daymenu.add(bt1[i]);

			}

			bt2 = new Button[42];

			for (int i = 0; i < 42; i++) {
				bt2[i] = new Button("");
				daymenu.add(bt2[i]);
				bt2[i].addActionListener(this);
				bt2[i].setFont(new Font("함초롬바탕", Font.PLAIN, 15));
				bt2[i].setBackground(Color.WHITE);
				bt2[i].setFocusable(false);

			}

			year = Integer.parseInt(choice.getSelectedItem());
			month = Integer.parseInt(choice1.getSelectedItem());

			int startDay = 0;
			int endDay = 0;

			java.util.Calendar sDay = java.util.Calendar.getInstance();
			java.util.Calendar eDay = java.util.Calendar.getInstance();

			sDay.set(year, month - 1, 1);
			eDay.set(year, month, 1);
			eDay.add(java.util.Calendar.DATE, -1);

			startDay = sDay.get(java.util.Calendar.DAY_OF_WEEK);
			endDay = eDay.get(java.util.Calendar.DATE);

			for (int i = 1; i <= endDay; i++) {
				bt2[i + startDay - 2].setLabel(i + "");
			}
		}
		return daymenu;
	}

	private Choice getChoice() {
		if (choice == null) {
			choice = new Choice();
			choice.add("2024");
			choice.add("2022");
			choice.add("2023");

			choice.select(1);
		}
		return choice;
	}

	@SuppressWarnings("deprecation")
	private Choice getChoice1() {
		if (choice1 == null) {
			choice1 = new Choice();

			choice1.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {

					for (int i = 0; i < 42; i++) {
						bt2[i].setLabel("");
					}

					year = Integer.parseInt(choice.getSelectedItem());
					month = Integer.parseInt(choice1.getSelectedItem());

					int startDay = 0;
					int endDay = 0;

					java.util.Calendar sDay = java.util.Calendar.getInstance();
					java.util.Calendar eDay = java.util.Calendar.getInstance();

					sDay.set(year, month - 1, 1);
					eDay.set(year, month, 1);
					eDay.add(java.util.Calendar.DATE, -1);

					startDay = sDay.get(java.util.Calendar.DAY_OF_WEEK);
					endDay = eDay.get(java.util.Calendar.DATE);

					for (int i = 1; i <= endDay; i++) {
						bt2[i + startDay - 2].setLabel(i + "");
					}
				}
			});
			choice1.add("1");
			choice1.add("2");
			choice1.add("3");
			choice1.add("4");
			choice1.add("5");
			choice1.add("6");
			choice1.add("7");
			choice1.add("8");
			choice1.add("9");
			choice1.add("10");
			choice1.add("11");
			choice1.add("12");

			choice1.select(6);

		}
		return choice1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < bt2.length; i++) {
			boolean b = true;
			if (b == true) {
				if (e.getSource() == bt2[i]) {
					paydate = year + "-" + month + "-" + bt2[i].getLabel();
					Date a = null;
					try {
						a = new SimpleDateFormat("yyyy-M-d").parse(paydate);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					dao1 = new detailDAO();
					String day[] = dao1.date();
					for (i = 0; i < day.length; i++) {
						if (paydate.equals(day[i])) {
							new detail();
							break;
						} else {
							b = false;
						}
					}
					break;
				}
			}
		}
	}
}
