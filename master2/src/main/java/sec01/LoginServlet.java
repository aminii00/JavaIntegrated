package sec01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sesslogin1")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
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
       PrintWriter out = response.getWriter();
       String user_id = request.getParameter("user_id");
       String user_pwd = request.getParameter("user_pwd");
       MemberVO memberVO = new MemberVO();
       memberVO.setId(user_id);
       memberVO.setPwd(user_pwd);
       MemberDAO dao = new MemberDAO();
       boolean result = dao.isExisted(memberVO);
       if(result) {
    	   HttpSession session = request.getSession();
    	   session.setAttribute("isLogin", true);
    	   session.setAttribute("login.id", user_id);
    	   session.setAttribute("login.pwd", user_pwd);
    	   out.print("<html><body>");
  		   out.print("�ȳ��ϼ��� " +user_id+"��!!!<br>");
  		   out.print("<a href ='show'>ȸ������ ����</a>");
  		   out.print("</html></body>");
       }else {
    	   out.print("<html><body><center>ȸ�� ���̵� Ʋ���ϴ�.");
    	   out.print("<a href ='login3.html'>�ٽ� �α����ϱ�</a>");
    	   out.print("</html></body>");
       }
       
   
	}
	}
