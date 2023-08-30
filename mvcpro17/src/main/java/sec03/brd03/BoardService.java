package sec03.brd03;

import java.util.List;


public class BoardService {
	
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();      // BoardDAO�� ������ ����
	}
	public int addArticle(ArticleVO article) {         // ArticleVO�� �Ű������� �ִ� �޼���
		return boardDAO.insertNewArticle(article);     // ������ ArticleVO�� article�Ű����� �����ָ�, BoardDAO�� �ִ� insertNewArticle �޼��� ȣ�� �Ͽ� ���� �� return
	}
	public List<ArticleVO> listArticles(){                               // List ���׸� ArticleVO�� listArticles �޼���
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();     // selectAllArticles�޼��� ȣ���Ͽ� ���� ���� ���׸� ArticlVO List�� articlesList�� ����
		return articlesList;                                             // articlesList ����
	}
}
