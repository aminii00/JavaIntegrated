package sec04_ex04;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class BoardDAO {

	private DataSource dataFactory;
	Connection conn;
	PreparedStatement pstmt;
	
	public BoardDAO() {
		try {  //db����
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/servletex");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List selectAllArticles() { //��ȯ���� ����Ʈ��
		List articlesList = new ArrayList();
		try {
			conn= dataFactory.getConnection();
			String query =  /*"select * from t_board";*/
					 "select case when level -1 > 0 then concat(concat(repeat(' ', level -1), '<'), board.title ) else board.title end as title, board.articleNO, board.parentNO, result.level, board.content, board.id, board.writeDate "
					     //������ 0���� ũ�� (2�̻��϶� �ڽ�) �հ� �ڸ� concat���� ������   repeat�� �ݺ����ڿ�                                                                                   ������ ������ ���̱⶧���� result�� ����
					 + " from" +
					 " (select function_hierarchical() as articleNO, @level as level " +
					   //                                            @�� ��뿵���� ������
					 " from (select @start_with:=0, @articleNO:=@start_with, @level:=0) tbl join t_board) result "
					 + " join t_board board on board.articleNO = result.articleNO";
					 
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int level = rs.getInt("level");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				ArticleVO article = new ArticleVO();
				article.setLevel(level);
				article.setArticleNO(articleNO);
				article.setParentNO(parentNO);
				article.setTitle(title);
				article.setContent(content);
				article.setId(id);
				article.setWriteDate(writeDate);
				articlesList.add(article); //�ε����� �߰�
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return articlesList;
	}
	
	private int getNewArticleNO() {
		try {
			conn= dataFactory.getConnection(); //Ŀ�ؼ�����������(���ؽ�Ʈ�� �ִ� ���� ���ҽ� ������ ������)
			String query = "select max(articleNO) from t_board ";
			                 //t_board�� articleNO �ִ밪�� ������
			System.out.println(query);
			pstmt = conn.prepareStatement(query); //sql��ɾ ������Ű�� ��ü�� �����ؼ� �־���
			ResultSet rs = pstmt.executeQuery(query); //prepareSttement���� �������ִ� executeQuery�� �����Ŵ
			//    Ŀ��������ġ         ������ ó�� ����
			if(rs.next())
				return(rs.getInt(1)+1); 
			              //ù��°���� articleNO�� 8�̸�+1�ؼ� 9���� 9�� ����(db�� 0�ε����� ����)
			              //articleNO�� int����
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int insertNewArticle(ArticleVO article) { //db�� ������ �� crud �������� ó��
		int articleNO = getNewArticleNO(); //9�� ����
		try {
			conn= dataFactory.getConnection();
			int parentNO = article.getParentNO();
			                          //0
			String title = article.getTitle();
			String content = article.getContent();
			String id = article.getId();
			                    //lee
			String imageFileName = article.getImageFileName();
			String query = "insert into t_board (articleNO, parentNO, title, content, imageFileName, id) "+"  values(?,?,?,?,?,?)";
			                                   //   9                                                                �������� ?�� �̿��ؼ� ��������
			System.out.println(query);
			pstmt=conn.prepareStatement(query); //Statement��� �߰��Ű�ü�� �ִ°��� ���⿡ �־��ٰ� �ٽ� db�� �־���
			pstmt.setInt(1, articleNO);
			pstmt.setInt(2, parentNO);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, imageFileName);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return articleNO; //9�� ����
	}
	
	public ArticleVO selectArticle(int articleNO) {
		ArticleVO article = new ArticleVO();
		try {
			conn= dataFactory.getConnection();
			String query = "select articleNO,parentNO,title,content,ifnull(imageFileName, 'null') as imageFileName,id,writeDate"
							+ " from t_board"
							+ " where articleNO=?";		                                                                                                
			System.out.println(query);
			pstmt=conn.prepareStatement(query); //Statement��� �߰��Ű�ü�� �ִ°��� ���⿡ �־��ٰ� �ٽ� db�� �־���
			pstmt.setInt(1, articleNO);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int _articleNO = rs.getInt("articleNO");
			int parentNO = rs.getInt("parentNO");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String imageFileName = URLEncoder.encode(rs.getString("imageFileName"), "UTF-8");
			if(imageFileName.equals("null")) {
				imageFileName = null;
			}
			String id = rs.getString("id");
			Date writeDate = rs.getDate("writeDate");
			article.setArticleNO(_articleNO);
			article.setParentNO(parentNO);
			article.setTitle(title);
			article.setContent(content);
			article.setImageFileName(imageFileName);
			article.setId(id);
			article.setWriteDate(writeDate);
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return article;
	}
}