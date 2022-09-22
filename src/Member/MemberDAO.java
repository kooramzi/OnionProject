package Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
//	DAO)자바 프로그램에서 데이터베이스 작업만 수행하는 클래스
//	자바 프로그램의 다른 기능을 하는 클래스와 구분하여 작업

	private JdbcConnectionUtil util;

	public MemberDAO() {
		util = JdbcConnectionUtil.getInstance();
	}

	public void insertMember(MemberVo vo) {
		Connection con = null; // db연결
		PreparedStatement pstmt = null; // 쿼리문 수행
		ResultSet rs = null; // 검색결과 레코드 저장
		String sql = null;

		try {

			con = util.getConnection();

			sql = "insert into member(id, password, name, phoneNumber)";
			sql += " values (?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPnum());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
