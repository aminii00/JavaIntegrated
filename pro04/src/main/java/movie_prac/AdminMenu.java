package movie_prac;

import java.util.List;

public class AdminMenu extends AbstractMenu {
	MoviesDao moviesDao = new MoviesDao();
	private static final AdminMenu instance = new AdminMenu(null);
	private static final String ADMIN_MENU_TEXT = 
			"1: 영화 등록하기\n" +
		    "2: 영화 목록보기\n" +
		    "3: 영화 삭제하기\n" +
		    "b: 메인 메뉴로 이동\n\n" +
		    "메뉴를 선택하세요: ";

	public AdminMenu(Menu prevMenu) {
		super(ADMIN_MENU_TEXT, prevMenu);
	}
	
	public static AdminMenu getInstance() {
		return instance;
	}
	
	public Menu next() {
		switch (scanner.nextLine()) {
		case "1" :
			createMovie();
			return this;
		case "2" :
			printAllMovies();
			return this;
		case "3" :
			deleteMovie();
			return this;
		case "b" :
			return prevmenu;
	    default : 
	    	return this;
		}
	}

	
	private void createMovie() {
		System.out.print("제목: ");
		String title = scanner.nextLine();
		System.out.print("장르: ");
		String genre = scanner.nextLine();
        Movie movie = new Movie(title,genre);
        try {
        	int _id = moviesDao.save(movie);
        	System.out.println(">> 등록되었습니다. 영화 발급 번호는 : " + _id + "입니다.");
        }catch(Exception e) {
        	System.out.println(">> 실패하였습니다.");
        }
	}
	private void printAllMovies() {
		try {
			List<Movie> list = moviesDao.printAllMovies();
			for (int i = 0; i<list.size(); i++) {
				Movie movie = (Movie) list.get(i);
				System.out.println("ㄴ영화발급번호: " + movie.getId()+ ", 영화제목: " + movie.getTitle() +
						", 영화 장르: " + movie.getGenre());
			}
		}catch(Exception e) {
			System.out.println("데이터 접근에 실패하였습니다.");
		}
	}
	private void deleteMovie() {
		printAllMovies();  //모든 영화 출력
		System.out.println("삭제할 영화발급번호를 입력하세요.: ");
		int movieid = Integer.parseInt(scanner.nextLine());
		try {
			boolean result = moviesDao.deleteMovie(movieid);
			System.out.println(">> 영화 발급번호 : " + movieid + "삭제되었습니다.");
		}catch(Exception e) {
			System.out.println("삭제에 실패하였습니다.");
		}
	}
}
