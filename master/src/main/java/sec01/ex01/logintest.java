package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logintest")
public class logintest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("utf-8");
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
	   String id = request.getParameter("user_id");
	   String pw = request.getParameter("user_pw");
	   
	   System.out.println("아이디 : " +id);
	   System.out.println("비밀번호 : " + pw);
	   
	   if(id != null && (id.length() != 0) && pw != null && (pw.length() != 0) ) {
		   out.print("<html>");
		   out.print("<body>");
		   out.print(id + "님!! 로그인 하셨습니다.");
		   out.print("</html>");
		   out.print("</body>");
	   }else {
		   if (id != null && (id.length() != 0)) {
		   out.print("<html>");
		   out.print("<body>");
		   out.print("비밀번호를 입력하세요!!");
		   out.print("<a href = 'http://localhost:8080/master/logintest_.html'>로그인창으로 이동</a>");
		   out.print("</html>");
		   out.print("</body>");
		   }else if (pw != null && (pw.length() != 0)){
			   out.print("<html>");
			   out.print("<body>");
			   out.print("아이디를 입력하세요!!");
			   out.print("<a href = 'http://localhost:8080/master/logintest_.html'>로그인창으로 이동</a>");
			   out.print("</html>");
			   out.print("</body>");
		   }else {
			   out.print("<html>");
			   out.print("<body>");
			   out.print("아이디와 비밀번호를 입력하세요!!");
			   out.print("<a href = 'http://localhost:8080/master/logintest_.html'>로그인창으로 이동</a>");
			   out.print("</html>");
			   out.print("</body>");
		   }
		   
	   }
	}
	
	public void destroy() {
		System.out.println("destory 메서드 호출");
	}

}
