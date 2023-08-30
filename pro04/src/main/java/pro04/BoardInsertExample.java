package pro04;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoardInsertExample {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
			       "jdbc:mysql://localhost:3306/servletex?useUnicode=true&characterEncording=utf-8",
			       "root",
			       "1234"  );
			
			String sql = "" + "insert into boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata)"
			             + "values(?, ?, ?, now(), ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, "최민아");
			pstmt.setString(2, "함박눈이 내려요.");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "snow.jpg");
			pstmt.setBlob(5, new FileInputStream("../Pro03/src/main/webapp/images/green_dot.JPG"));

			
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수 : "+ rows);
			
			if (rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys(); //ResultSet은 SELECT문의 결과를 저장하는 객체
				if (rs.next()) { // 다음 값이 있니?
					int bno = rs.getInt(1); // +1 !
					System.out.println("저장된 bno: " + bno);
				}
				rs.close();
			}
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {}
			}
		}
	}

}
