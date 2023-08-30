package pro04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;


public class MemberExample {

	private Scanner scanner = new Scanner(System.in);
	private Connection conn;
	
	public MemberExample() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servletex?useUnicode=true&characterEncoding=utf8",
					"root",
					"1234"
					);
		}catch(Exception e) {
			e.printStackTrace();
			exit();
		}
	}
	
	public void list() {
		System.out.println();
		System.out.println("[회원 목록]");
		System.out.println("--------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n","아이디","이름","email","가입일자");
		System.out.println("--------------------------------------------------");
		
		try {
			String sql = "select id, name, email, joinDate from t_member order by joindate desc";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				String id = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				member.setId(id);
				member.setName(name);
				member.setEmail(email);
				member.setJoinDate(joinDate);
				System.out.printf("%-6s%-12s%-16s%-40s\n", member.getId(),
						                                   member.getName(),
						                                   member.getEmail(),
						                                   member.getJoinDate());
			}
			rs.close();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
			exit();
		}
	}
		
	  public void mainMenu() {
			System.out.println();
			System.out.println("--------------------------------");
			System.out.println("메인메뉴 : 1.회원가입ㅣ2.회원보기ㅣ3.회원삭제ㅣ4.프로그램 종료");
			System.out.print("메뉴 선택");
			String menuNo = scanner.nextLine();
			System.out.println();
			
			switch(menuNo) {
			case "1" -> create();
			case "2" -> read();
			case "3" -> clear();
			case "4" -> exit();
			}
	  }
		
		public void create() {
			Member member = new Member();
			System.out.println("[회원가입]");
			System.out.print("아이디: ");
			member.setId(scanner.nextLine());
			System.out.print("비밀번호: ");
			member.setPwd(scanner.nextLine());
			System.out.print("이름: ");
			member.setName(scanner.nextLine());
			System.out.print("email: ");
			member.setEmail(scanner.nextLine());
			
			System.out.println("-------------------------------");
			System.out.println("가입하시겠습니까? : 1.Ok ㅣ 2.Cancel");
			System.out.println("메뉴 선택: ");
			String menuNo = scanner.nextLine();
			if (menuNo.equals("1")) {
				try {
					String sql = "" +
				                "insert into t_member (id, pwd, name, email, joinDate)" +
							    "values (?,?,?,?,now())";
					
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, member.getId());
					pstmt.setString(2, member.getPwd());
					pstmt.setString(3, member.getName());
					pstmt.setString(4, member.getEmail());
					pstmt.executeUpdate();
					pstmt.close();
				}catch (Exception e) {
					e.printStackTrace();
					exit();
				}
			}
			list();
		}
		
	   public void read() {
		   System.out.println("[회원 보기]");
		   System.out.print("아이디: ");
		   String _id = scanner.nextLine();
		   
		   try {
			   
			   String sql = "select id, name, email, joinDate from t_member where id = ?";
			   PreparedStatement pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, _id);
			   ResultSet rs = pstmt.executeQuery();
			   
			   if(rs.next()) {
				   Member member = new Member();
				   String id = rs.getString("id");
				   String name = rs.getString("name");
				   String email = rs.getString("email");
				   Date joinDate = rs.getDate("joinDate");
				   member.setId(id);
				   member.setName(name);
				   member.setEmail(email);
				   member.setJoinDate(joinDate);
				   System.out.println("#############");
				   System.out.println("아이디 : " +member.getId());
				   System.out.println("이름 : " +member.getName());
				   System.out.println("email : " +member.getEmail());
				   System.out.println("가입날짜 : " +member.getJoinDate());
				   System.out.println("-----------------------------------");
				   System.out.println("회원수정 : 1.Update ㅣ 2.Delete ㅣ 3.List");
				   System.out.println("메뉴 선택: ");
				   String menuNo = scanner.nextLine();
				   System.out.println();
				   
				   if(menuNo.equals("1")) {
					   Update(member);
				   }else if (menuNo.equals("2")) {
					   delete(member);
				   }
			   }
			   rs.close();
			   pstmt.close();
		   }catch (Exception e) {
			   e.printStackTrace();
			   exit();
		   }
		   list();
	   }
	   
	   public void Update (Member member) {
		   System.out.println("[수정 내용 입력]");
		   System.out.print("이름: ");
		   member.setName(scanner.nextLine());
		   System.out.print("비밀번호: ");
		   member.setPwd(scanner.nextLine());
		   System.out.print("email: ");
		   member.setEmail(scanner.nextLine());
		   
		   System.out.println("------------------------------");
		   System.out.println("수정하시겠습니까? 1.Ok 2.Cancel");
		   System.out.println("메뉴 선택: ");
		   String menuNo = scanner.nextLine();
		   if (menuNo.equals("1")) {
			   try {
				   String sql = "" +
			                    "update t_member set pwd=?, name=?, email=? where id=?";
				   PreparedStatement pstmt = conn.prepareStatement(sql);
				   pstmt.setString(1, member.getPwd());
				   pstmt.setString(2, member.getName());
				   pstmt.setString(3, member.getEmail());
				   pstmt.setString(4, member.getId());
				   pstmt.executeUpdate();
				   pstmt.close();
			   }catch(Exception e) {
				   e.printStackTrace();
				   exit();
			   }
		   }
		   list();
	   }
	   
	  public void delete (Member member) {
		  try {
			  String sql = "delete from t_member where id=?";
			  PreparedStatement pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, member.getId());
			  pstmt.executeUpdate();
			  exit();
		  }catch(Exception e ) {
			  e.printStackTrace();
			  exit();
		  }
		  list();
	}
	 public void clear() {
		 System.out.println("[회원 전체 삭제]");
		 System.out.println("----------------------------------");
		 System.out.println("회원 전체를 삭제하겠습니까?: 1.Ok 2.Cancel");
		 System.out.print("메뉴 선택: ");
		 String menuNo = scanner.nextLine();
		 if(menuNo.equals("1")) {
			 try {
				 String sql = "truncate table t_member";
				 PreparedStatement pstmt = conn.prepareStatement(sql);
				 pstmt.executeUpdate();
				 pstmt.close();
			 }catch(Exception e) {
				 e.printStackTrace();
				 exit();
			 }
		 }
		 list();
	 }
	 
	 public void exit() {
		 if(conn!=null) {
			 try {
				 conn.close();
			 }catch(SQLException e) {}
		 }
		 System.out.println("**회원 게시판 종료**");
		 System.exit(0);
	 }
	
	public static void main(String[] args) {
		MemberExample memberExam = new MemberExample();
		memberExam.list();
		memberExam.mainMenu();
	}

}
