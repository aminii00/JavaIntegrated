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
		System.out.println("[ȸ�� ���]");
		System.out.println("--------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n","���̵�","�̸�","email","��������");
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
			System.out.println("���θ޴� : 1.ȸ�����Ԥ�2.ȸ�������3.ȸ��������4.���α׷� ����");
			System.out.print("�޴� ����");
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
			System.out.println("[ȸ������]");
			System.out.print("���̵�: ");
			member.setId(scanner.nextLine());
			System.out.print("��й�ȣ: ");
			member.setPwd(scanner.nextLine());
			System.out.print("�̸�: ");
			member.setName(scanner.nextLine());
			System.out.print("email: ");
			member.setEmail(scanner.nextLine());
			
			System.out.println("-------------------------------");
			System.out.println("�����Ͻðڽ��ϱ�? : 1.Ok �� 2.Cancel");
			System.out.println("�޴� ����: ");
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
		   System.out.println("[ȸ�� ����]");
		   System.out.print("���̵�: ");
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
				   System.out.println("���̵� : " +member.getId());
				   System.out.println("�̸� : " +member.getName());
				   System.out.println("email : " +member.getEmail());
				   System.out.println("���Գ�¥ : " +member.getJoinDate());
				   System.out.println("-----------------------------------");
				   System.out.println("ȸ������ : 1.Update �� 2.Delete �� 3.List");
				   System.out.println("�޴� ����: ");
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
		   System.out.println("[���� ���� �Է�]");
		   System.out.print("�̸�: ");
		   member.setName(scanner.nextLine());
		   System.out.print("��й�ȣ: ");
		   member.setPwd(scanner.nextLine());
		   System.out.print("email: ");
		   member.setEmail(scanner.nextLine());
		   
		   System.out.println("------------------------------");
		   System.out.println("�����Ͻðڽ��ϱ�? 1.Ok 2.Cancel");
		   System.out.println("�޴� ����: ");
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
		 System.out.println("[ȸ�� ��ü ����]");
		 System.out.println("----------------------------------");
		 System.out.println("ȸ�� ��ü�� �����ϰڽ��ϱ�?: 1.Ok 2.Cancel");
		 System.out.print("�޴� ����: ");
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
		 System.out.println("**ȸ�� �Խ��� ����**");
		 System.exit(0);
	 }
	
	public static void main(String[] args) {
		MemberExample memberExam = new MemberExample();
		memberExam.list();
		memberExam.mainMenu();
	}

}
