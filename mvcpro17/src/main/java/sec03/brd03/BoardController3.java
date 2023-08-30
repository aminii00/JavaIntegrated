package sec03.brd03;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;


@WebServlet("/board3/*")
public class BoardController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardService boardService;        
	ArticleVO articleVO;
	private static String ARTICLE_IMAGE_REPO = "c:\\board\\article_image";      // String������ ��� ���� (���)
	
	public void init(ServletConfig config) throws ServletException {
		boardService = new BoardService();  // BoardService�� ������ ����
		articleVO = new ArticleVO();        // ArticleVO�� ������ ����
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
		String nextPage="";     // " "�����ϸ� XX 
		request.setCharacterEncoding("utf-8");    
		response.setContentType("text/html;charset=utf-8"); 
		String action = request.getPathInfo();   // ���� *�� �ϱ����� ȣ���Ͽ� action�� ����
		System.out.println("action : " + action);
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();       //articlesList ���� ArrayList��
			if (action == null) {                                            // action�� null�϶�,
				articlesList = boardService.listArticles();                  // �Ű����� ���� listArticlesȣ��
				request.setAttribute("articlesList", articlesList);          // request�� ����
				nextPage = "/board3/listArticles.jsp";                      //nextPage�� ���� �� ���ǹ� ��������
			}else if(action.equals("/listArticles.do")) {             
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board3/listArticles.jsp";
			}else if(action.equals("/articleForm.do")) {
				nextPage = "/board3/articleForm.jsp";
			}else if(action.equals("/addArticle.do")) {
				
				int articleNO = 0;
				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				System.out.println("����~~~~~~~~~~~~~~~~~~~~~ : " +title);
				String content = articleMap.get("content");
				String imageFileName =articleMap.get("imageFileName");
				articleVO.setParentNO(0);
				articleVO.setId("aminii");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				boardService.addArticle(articleVO);
				articleNO = boardService.addArticle(articleVO);
				if (imageFileName != null && imageFileName.length() != 0) {
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\temp\\" + imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
					destDir.mkdirs();  // ��
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
				PrintWriter pw = response.getWriter();
				pw.print(("<script>" + " alert('�� ���� �߰��߽��ϴ�.');" 
				          + " location.href ='" + request.getContextPath() 
				          + "/board3/listArticles.do';" + "</script>"));
				
				return;
			

			}else {
				nextPage = "/board3/listArticles.jsp";
			}
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);    // �޾ƿ� nextPage�� ���� forward������ �̵�
			dispatch.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request���� ��ü(�ּ�)�� ������ ����
		Map<String, String> articleMap = new HashMap<String, String>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			// title 0�ε��� content 1�ε��� imageFilename�� 2�ε����� ����
			for (int i=0; i <items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if(fileItem.isFormField()) {
					// text��?
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
					// title�� key temp(title.value)�� value�� map���·� ����, title�� content�� ��
				}else {
					System.out.println("�Ķ�����̸�: " + fileItem.getFieldName());
					System.out.println("�����̸�: " + fileItem.getName());
					System.out.println("����ũ��: " + fileItem.getSize() + "bytes");
					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						String fileName = fileItem.getName().substring(idx+1);
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						articleMap.put(fileItem.getFieldName(), fileName);
						
						System.out.println(uploadFile);
						fileItem.write(uploadFile);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return articleMap;
	}
}
