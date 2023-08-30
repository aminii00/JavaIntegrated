package pro04_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDelete {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection (
					"jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncording=utf-8",
				    "root",
				    "1234"  );
			String sql = "delete from t_member where userid=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "temp");

			
			int rows = pstmt.executeUpdate();
			System.out.println("삭제된 행 수 : " + rows);
			
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (conn!= null) {
				try {
					conn.close();
				}catch (SQLException e) {}
			}
		}
	}

}
