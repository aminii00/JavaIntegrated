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
		System.out.println("init �޼��� ȣ��");
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
	   
	   System.out.println("���̵� : " +id);
	   System.out.println("��й�ȣ : " + pw);
	   
	   if(id != null && (id.length() != 0) && pw != null && (pw.length() != 0) ) {
		   out.print("<html>");
		   out.print("<body>");
		   out.print(id + "��!! �α��� �ϼ̽��ϴ�.");
		   out.print("</html>");
		   out.print("</body>");
	   }else {
		   if (id != null && (id.length() != 0)) {
		   out.print("<html>");
		   out.print("<body>");
		   out.print("��й�ȣ�� �Է��ϼ���!!");
		   out.print("<a href = 'http://localhost:8080/master/logintest_.html'>�α���â���� �̵�</a>");
		   out.print("</html>");
		   out.print("</body>");
		   }else if (pw != null && (pw.length() != 0)){
			   out.print("<html>");
			   out.print("<body>");
			   out.print("���̵� �Է��ϼ���!!");
			   out.print("<a href = 'http://localhost:8080/master/logintest_.html'>�α���â���� �̵�</a>");
			   out.print("</html>");
			   out.print("</body>");
		   }else {
			   out.print("<html>");
			   out.print("<body>");
			   out.print("���̵�� ��й�ȣ�� �Է��ϼ���!!");
			   out.print("<a href = 'http://localhost:8080/master/logintest_.html'>�α���â���� �̵�</a>");
			   out.print("</html>");
			   out.print("</body>");
		   }
		   
	   }
	}
	
	public void destroy() {
		System.out.println("destory �޼��� ȣ��");
	}

}
