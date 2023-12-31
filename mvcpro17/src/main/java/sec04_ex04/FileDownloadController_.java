package sec04_ex04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download1.do")
public class FileDownloadController_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardService boardService;        
	ArticleVO articleVO;
	private static String ARTICLE_IMAGE_REPO = "c:\\board\\article_image";

	public void init(ServletConfig config) throws ServletException {
		boardService = new BoardService();  // BoardService莫 持失切 持失
		articleVO = new ArticleVO();  
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doHandle(request,response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");    
		response.setContentType("text/html;charset=utf-8"); 
		String imageFileName = (String) request.getParameter("imageFileName");
		String articleNO = request.getParameter("articleNO");
		System.out.println("imageFileName=" + imageFileName);
		OutputStream out = response.getOutputStream();
	
		String path = ARTICLE_IMAGE_REPO + "\\" + articleNO + "\\" + imageFileName;
		File imageFile = new File(path);
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition" , "attachment;fileName=" + imageFileName);
		FileInputStream in = new FileInputStream(imageFile);
		byte[] buffer = new byte[1027*8];
		while (true) {
			int count = in.read(buffer);
			if (count == -1) break;
			out.write(buffer,0,count);
		}
		in.close();
		out.close();
	}
	
}
