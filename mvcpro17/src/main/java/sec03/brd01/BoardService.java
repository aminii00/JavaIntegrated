package sec03.brd01;

import java.util.List;

public class BoardService {

	BoardDAO boardDAO;
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	public void addArticle(ArticleVO article) {
		System.out.println("�ȳ�ȳ�ƿ���");
		boardDAO.insertNewArticle(article);
	}
	public List<ArticleVO> listArticles(){
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
}
