package pro04_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberSelect {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection (
					"jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncording=utf-8",
				    "root",
				    "1234"  );
			
			String sql = "" + 
		   "select userid , userpw , userpw_2 , userName , userBirth , usernum , useremail , useradress " +
	       " from t_member " + 
		   " where userid=? ";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "ehtm");
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Member member = new Member();
				member.setUserId(rs.getString("userid"));
				member.setUserPw(rs.getString("userpw"));
				member.setUserPw_2(rs.getString("userpw_2"));
				member.setUserName(rs.getString("username"));
				member.setUserBirth(rs.getString("userbirth"));
				member.setUsernum(rs.getString("usernum"));
				member.setUserEmail(rs.getString("useremail"));
				member.setUserAdress(rs.getString("useradress"));
				System.out.println(member);
			}else {
				System.out.println("사용자 아이디가 존재하지 않음");
			}
			rs.close();
			
			pstmt.close();
		}catch(Exception e) {
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




