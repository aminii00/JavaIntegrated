package sec03.brd01;

import java.util.List;

public class BoardService {

	BoardDAO boardDAO;
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	public void addArticle(ArticleVO article) {
		System.out.println("¾È³ç¾È³ç¾Æ¿¬¤·");
		boardDAO.insertNewArticle(article);
	}
	public List<ArticleVO> listArticles(){
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
}
