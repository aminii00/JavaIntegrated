package pro04;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardSelectExample {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servletex?useUnicode=true&characterEnciding=utf8",
					"root",
					"1234"
					);
			
			String sql = "" +
			             "select bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata " +
					     "from boards " +
			             "where bwriter=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "winter");
			
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();  // db�ʵ�� ������ �ʵ�� ������ �����ؾ��ϰ�, �����Ҽ����� private
				board.setBno(rs.getInt("bno"));  // board.setBno(�ٽ��ѹ� ����ȯ(db�� bno�� ����ִ� ��!));  
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));
				System.out.println(board);  // toString �޼���� �������� ���� ���
				
				Blob blob = board.getBfiledata();  //���ϵ����� �о�ͼ� ����
				if(blob != null) {
					InputStream is = blob.getBinaryStream();
					OutputStream os = new FileOutputStream("C:/Temp/" + board.getBfilename());
					is.transferTo(os);
					os.flush();
					os.close();
					is.close();
				}
			}
			
			rs.close();
			pstmt.close();
			
		}catch (Exception e) {
			e.printStackTrace(); 
		
    	}finally {
    		
		     if(conn!=null) {
			           try {
				               conn.close();
			           }catch(SQLException e) {}
		}
	}
}
}

