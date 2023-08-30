package pro04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDeleteExample {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection (
					"jdbc:mysql://localhost:3306/servletex?useUnicode=true&characterEncording=utf-8",
				    "root",
				    "1234"  );
			String sql = "delete from boards where bwriter=?";  // boards테이블 bwirter를 삭제
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "winter");  // bwriter열에 winter를 삭제

			
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
