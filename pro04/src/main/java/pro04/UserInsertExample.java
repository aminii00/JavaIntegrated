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
			             "values (?, ?, ?, ?, ?)";  //�Ű�����ȭ
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			// �ڹٿ��� �����ͺ��̽��� �������� ������ ��, ����� �� �ִ� �������̽��� 2������ ���� 
			// (Statement�� PreparedStatement) 
			//PreparedStatement �޼ҵ�� �μ��� SQL���� ���� String ��ü�� �ʿ��ϴ�.
			pstmt.setString(1, "winter");
			pstmt.setString(2, "�Ѱܿ�");
			pstmt.setString(3, "12345");
			pstmt.setInt(4, 25);
			pstmt.setString(5, "writer@mycompany.com");
			
			int rows = pstmt.executeUpdate();  
			// executeUpdate: �������� Int Ÿ���� ���� ��ȯ�մϴ�.
			System.out.println("����� �� �� : " +rows);
			
			pstmt.close();  // �ݾ��ֱ� �ʼ�
		}catch (ClassNotFoundException e) {  //���� �߿�!
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
