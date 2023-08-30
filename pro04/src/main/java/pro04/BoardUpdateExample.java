package pro04;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdateExample {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			//jdbc driver ���
			Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(
			       "jdbc:mysql://localhost:3306/servletex?useUnicode=true&characterEncording=utf-8",
			       "root",
			       "1234"  );
		
		String sql = new StringBuilder()
				.append("UPDATE boards SET ") // boards���̺� ����
				.append("btitle=?,")
				.append("bcontent=?,")
				.append("bfilename=?,")
				.append("bwriter=?,")
				.append("bfiledata=?")
				.append("where bno=?")       // bno ?��°�� ����
				.toString();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "�����");
		pstmt.setString(2, "������ ���� ���.");
		pstmt.setString(3, "snow.jpg");
		pstmt.setString(4, "temp");
		pstmt.setBlob(5, new FileInputStream("../Pro03/src/main/webapp/images/green_dot.JPG"));
		pstmt.setInt(6,1);

		int rows = pstmt.executeUpdate();
		System.out.println("������ �� �� : "+ rows);
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
