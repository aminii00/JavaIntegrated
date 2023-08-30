package pro04_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Memberinsert {
	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncording=utf-8",
					"root",
					"1234"    );
			
			String sql = "" + "insert into t_member (userId, userpw, userpw_2, userName, "
					+ "userBirth, usernum, useremail, userAdress) "
			             + "values(?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "temp");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "1234");
			pstmt.setString(4, "temp");
			pstmt.setString(5, "20001220");
			pstmt.setString(6, "010-0000-1234");
			pstmt.setString(7, "member_temp@naver.com");
			pstmt.setString(8, "대전 서구 둔산동");
			
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수 : " +rows);
			
			pstmt.close();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
				
				try {
					conn.close();
				}catch(SQLException e){}
			}
		}
	}
}


