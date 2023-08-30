package sec04_ex04;

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

public ArticleVO viewArticle(int articleNO) {
	ArticleVO article = null;
	article = boardDAO.selectArticle(articleNO);
	return article;
}
}