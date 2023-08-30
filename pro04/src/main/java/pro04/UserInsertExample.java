package pro04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsertExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/servletex?useUnicode=true&characterEncording=utf-8",
			"root",
			"1234"    );
			String sql = ""+
			             "insert into users (userid, username, userpassword, userage, useremail)" 
					       +
			             "values (?, ?, ?, ?, ?)";  //매개변수화
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			// 자바에서 데이터베이스로 쿼리문을 전송할 때, 사용할 수 있는 인터페이스는 2가지가 존재 
			// (Statement와 PreparedStatement) 
			//PreparedStatement 메소드는 인수로 SQL문을 담은 String 객체가 필요하다.
			pstmt.setString(1, "winter");
			pstmt.setString(2, "한겨울");
			pstmt.setString(3, "12345");
			pstmt.setInt(4, 25);
			pstmt.setString(5, "writer@mycompany.com");
			
			int rows = pstmt.executeUpdate();  
			// executeUpdate: 수행결과로 Int 타입의 값을 반환합니다.
			System.out.println("저장된 행 수 : " +rows);
			
			pstmt.close();  // 닫아주기 필수
		}catch (ClassNotFoundException e) {  //순서 중요!
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
