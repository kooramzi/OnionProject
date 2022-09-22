package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class detailDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	String title;
	String paydate;
	int fee;
	String term;
	String card_name;
	String bank_name;


	public void detail(String day) {

		String sql = "select s.title, p.paydate, s.fee, p.term, p.card_name, p.bank_name "
				+ "from PAYMENT p, SUBSCRIPTION s where p.sid = s.sid AND PAYDATE = "
				+ "'" + day + "'";
		try {
			connDB();

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				title = rs.getString("title");
				paydate = rs.getString("paydate");
				fee = rs.getInt(3);// 컬럼 순번
				term = rs.getString("term");
				card_name = rs.getString("card_name");
				bank_name = rs.getString("bank_name");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	public String[] date() {
		String day[]= new String[9];
		String sql =null;
		String pd = null;
		int i =0;
		
		try {
			connDB();

			sql = "select paydate from payment";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				pd = rs.getString("paydate");
				day[i] = pd;
				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return day;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
//			pstmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
