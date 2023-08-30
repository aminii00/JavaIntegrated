package pro04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {

	public static void main(String[] args) {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/thisisjava?useUnicode=true&characterEncording=utf-8\"",
					"root",
					"1234"
					);
			
			conn.setAutoCommit(false);  // 자동저장 끄기
			
			String sql1 = "update accounts set balance=balance-? where ano=?";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1,10000);
			pstmt1.setString(2,"111-111-1111");
			int row1 = pstmt1.executeUpdate();
			if(row1==0)throw new Exception("출금되지 않았음");
			pstmt1.close();
			
			String sql2 = "update accounts set balance=balance+? where ano=?";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1,10000);
			pstmt2.setString(2,"222-222-2222");
			int row2 = pstmt2.executeUpdate();
			if(row2==0)throw new Exception("입금되지 않았음");
			pstmt2.close();
			
			//모두 성공처리
			conn.commit();
			System.out.println("계좌이체 성공");
		}catch(Exception e) {
			try {
				//롤백 : 모두 실패처리
				conn.rollback();
				//자동저장기능 켜키
				conn.setAutoCommit(true);
			}catch(SQLException e1) {}
			System.out.println("계좌이체 실패");
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					//원래대로 자동저장 켜기
					conn.setAutoCommit(true);
					conn.close();
				}catch(SQLException e) {}
			}
		}
	}

}
