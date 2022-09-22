package Member;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginDAO {
	// DAO 데이터 베이스 작업만 수행하는 클래스
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public boolean list(loginVo p) {
		try {
			connDB();

			String query = "SELECT * FROM member WHERE id='" + p.getId() + "' AND password='" + p.getPassword() + "'";
			rs = stmt.executeQuery(query);
			rs.last();

			if (rs.getRow() == 0) {
			} else {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}