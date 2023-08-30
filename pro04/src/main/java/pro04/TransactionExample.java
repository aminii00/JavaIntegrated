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
			
			conn.setAutoCommit(false);  // �ڵ����� ����
			
			String sql1 = "update accounts set balance=balance-? where ano=?";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1,10000);
			pstmt1.setString(2,"111-111-1111");
			int row1 = pstmt1.executeUpdate();
			if(row1==0)throw new Exception("��ݵ��� �ʾ���");
			pstmt1.close();
			
			String sql2 = "update accounts set balance=balance+? where ano=?";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1,10000);
			pstmt2.setString(2,"222-222-2222");
			int row2 = pstmt2.executeUpdate();
			if(row2==0)throw new Exception("�Աݵ��� �ʾ���");
			pstmt2.close();
			
			//��� ����ó��
			conn.commit();
			System.out.println("������ü ����");
		}catch(Exception e) {
			try {
				//�ѹ� : ��� ����ó��
				conn.rollback();
				//�ڵ������� ��Ű
				conn.setAutoCommit(true);
			}catch(SQLException e1) {}
			System.out.println("������ü ����");
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					//������� �ڵ����� �ѱ�
					conn.setAutoCommit(true);
					conn.close();
				}catch(SQLException e) {}
			}
		}
	}

}
