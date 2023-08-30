package pro04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			
			//�����ϱ�
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servletex",  
					"root",                                   
					"1234"
					);
			System.out.println("���� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("���� ����");
				}catch (SQLException e) {}
			}
		}
	}
}
