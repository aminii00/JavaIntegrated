package sec03.brd03;

import java.util.List;


public class BoardService {
	
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();      // BoardDAO형 생성자 생성
	}
	public int addArticle(ArticleVO article) {         // ArticleVO형 매개변수가 있는 메서드
		return boardDAO.insertNewArticle(article);     // 가져온 ArticleVO형 article매개변수 던져주며, BoardDAO에 있는 insertNewArticle 메서드 호출 하여 받은 값 return
	}
	public List<ArticleVO> listArticles(){                               // List 제네릭 ArticleVO형 listArticles 메서드
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();     // selectAllArticles메서드 호출하여 받은 값을 제네릭 ArticlVO List형 articlesList에 대입
		return articlesList;                                             // articlesList 리턴
	}
}
