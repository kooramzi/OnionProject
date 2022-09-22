package Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
//	DAO)�ڹ� ���α׷����� �����ͺ��̽� �۾��� �����ϴ� Ŭ����
//	�ڹ� ���α׷��� �ٸ� ����� �ϴ� Ŭ������ �����Ͽ� �۾�

	private JdbcConnectionUtil util;

	public MemberDAO() {
		util = JdbcConnectionUtil.getInstance();
	}

	public void insertMember(MemberVo vo) {
		Connection con = null; // db����
		PreparedStatement pstmt = null; // ������ ����
		ResultSet rs = null; // �˻���� ���ڵ� ����
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
