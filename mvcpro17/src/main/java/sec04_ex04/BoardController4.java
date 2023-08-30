package sec04_ex04;

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

@WebServlet("/board5/*")
public class BoardController4 extends HttpServlet {
	BoardService boardService;        
	ArticleVO articleVO;
	private static String ARTICLE_IMAGE_REPO = "c:\\board\\article_image";

	public void init(ServletConfig config) throws ServletException {
		boardService = new BoardService();  // BoardService�� ������ ����
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
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = ""; //" "�����̽��� ġ�� ���߿� �����߻�Ȯ�� ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo(); //2��° ���� / ���ʿ��� ������ �׼��� ����
		System.out.println("action:"+action);
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>(); //�迭���»��ƴϰ� ����Ʈ�� ����Ϸ��� �ϴ°���
			if(action == null) { //1�� ���� �� 2�� ������ ���Ǵµ� 1�� ������ ������ Ŭ������ ����ȵ�
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board04/listArticles.jsp";
			}else if(action.equals("/listArticles.do")) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				//        �Ӽ�����          Ű                ��
				nextPage = "/board04/listArticles.jsp";
				// �ؽ�Ʈ�������� ����ó�� �Ѱ���(����Ʈ �ּҸ� �־ ������)

			}else if(action.equals("/articleForm.do")) { //���
				nextPage = "/board04/articleForm.jsp"; //�긦 ������

			}else if(action.equals("/addArticle.do")) {
				int articleNO = 0;
				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");

				articleVO.setParentNO(0);
				articleVO.setId("aminii"); //�� db�� �ִ� ������
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				articleNO = boardService.addArticle(articleVO); //����Ұ�ü�� ������ �� �� �ּҸ� �־ ȣ��
                 //9 /�ٷ� int�� �������� �̰��� ������ �� ���� ������ Service�� �־ �������°� ����
				if(imageFileName != null && imageFileName.length() !=0) {
					//temp
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
                                               //9
					destDir.mkdirs(); //articleNO�� �̰��� �� ���������� ���ϻ���
					FileUtils.moveFileToDirectory(srcFile, destDir, true); //temp�ȿ� �ִ� ������ articleNO ���Ϸ� �Ѿ
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + "alert('������ �߰��߽��ϴ�.');"
						+ " location.href='"
						+ request.getContextPath()
						+ "/board5/listArticles.do';" + "</script>");
				return;	
			
			}else if(action.equals("/viewArticle.do")){
				String articleNO = request.getParameter("articleNO");
				articleVO = boardService.viewArticle(Integer.parseInt(articleNO));
				request.setAttribute("article", articleVO);
				nextPage = "/board04/viewArticle.jsp";
				
			}else {
				nextPage = "/board04/listArticles.jsp";
			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); //������ �̵�(������)
			dispatch.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
										// ������Ʈ�� �޾Ƽ� ������Ʈ ��ü�� �� ����
		Map<String, String> articleMap = new HashMap<String, String>();
		//Map�� ��Ʈ��,��Ʈ�� ���׸���                                    
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		//���ϰ�ü�� ������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//setRepository ������ ����� ��� setSizeThreshold �ִ�뷮ó��->�ΰ� �޼ҵ� ����Ϸ��� DiskFileItemFactory ���
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			//ServletFileUpload�� parseRequest�޼ҵ� ȣ��
			//parseRequest�� �߶� ������ Ű�� ���� �迭���·� ������. ������ ����Ʈ��
			for(int i=0; i<items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i); //0�ε������� for�� ��
				//items�� request��ü �̹Ƿ� FileItem������ ĳ��Ʈ��ȯ
				if(fileItem.isFormField()) { //�ؽ�Ʈ���� ���
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
					//Map���� put���� ����         title                  temp
				}else {
					System.out.println("�Ķ�����̸�:"+fileItem.getFieldName()); //imagaFileName
					System.out.println("�����̸�:"+fileItem.getName()); //temp.jpg
					System.out.println("����ũ��:"+fileItem.getSize()+"bytes"); //���ϻ�����(40)
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						//C:\Users\Administrator\Desktop/temp.jpg �����ϱ� ������
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
							//C:\Users\Administrator\Desktop/temp.jpg /�տ� �ڸ��� temp.jpg�� ����
						}
						String fileName = fileItem.getName().substring(idx+1);
						articleMap.put(fileItem.getFieldName(), fileName);
			             //imageFileName, temp.jpg
						File uploadFile = new File((currentDirPath)+"\\temp\\"+fileName);
													//�̹��������� �־ ���ϰ�ü ����
						fileItem.write(uploadFile); //uploadFile �־ ���ֱ�
					} //end if
				} //end if
			} //end for
		}catch(Exception e) {
			e.printStackTrace();
		}
		return articleMap; //uploadȣ���� ������ ��ȯ
	}
}