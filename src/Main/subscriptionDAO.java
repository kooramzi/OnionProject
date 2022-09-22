package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Member.JdbcConnectionUtil;

public class subscriptionDAO {
	private JdbcConnectionUtil util;
	private Connection con = null;
	private PreparedStatement pstmt = null; // 쿼리문사용을위한
	private ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
	String sql = null;

	public subscriptionDAO() {
		util = JdbcConnectionUtil.getInstance();
	}

	public Object[][] selectSub(subscriptionVo subVo) {

		List<subscriptionVo> result = new ArrayList<>();
		Object[][] sContents = null;

		try {
			con = util.getConnection();

			sql = "select b.PAYDATE, a.TITLE, a.FEE FROM SUBSCRIPTION a, PAYMENT b WHERE a.SID=b.SID AND a.CATEGORY=1";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				subVo = new subscriptionVo(rs.getString("PAYDATE"), rs.getString("TITLE"), rs.getInt("FEE"));
				result.add(subVo);
			}

			sContents = new Object[result.size()][3];
			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 3; j++) {
					sContents[i][j] = result.get(i).getPaydate();
					sContents[i][++j] = result.get(i).getTitle();
					sContents[i][++j] = result.get(i).getFee();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sContents;

	}

	public Object[][] selectLiv(subscriptionVo subVo) {

		List<subscriptionVo> result = new ArrayList<>();
		Object[][] lContents = null;

		try {
			con = util.getConnection();

			sql = "select b.PAYDATE, a.TITLE, a.FEE FROM SUBSCRIPTION a, PAYMENT b WHERE a.SID=b.SID AND a.CATEGORY=2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				subVo = new subscriptionVo(rs.getString("PAYDATE"), rs.getString("TITLE"), rs.getInt("FEE"));
				result.add(subVo);
			}

			lContents = new Object[result.size()][3];
			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 3; j++) {
					lContents[i][j] = result.get(i).getPaydate();
					lContents[i][++j] = result.get(i).getTitle();
					lContents[i][++j] = result.get(i).getFee();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lContents;

	}

	public int totalFee(subscriptionVo subVo) {
		int totalFee = 0;

		try {
			con = util.getConnection();
			sql = "SELECT SUM(FEE) AS TOTALFEE FROM SPENDING";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			if (rs.next()) {
				subVo = new subscriptionVo(rs.getInt("TOTALFEE")); // FEE로 했더니 부적합한 열 이름
				totalFee += subVo.getFee();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalFee;
	}

	public int cnt(subscriptionVo subVo) {

		int cnt = 0;
		try {
			con = util.getConnection();
			sql = "SELECT count(*) AS cnt FROM SPENDING";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			if (rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
