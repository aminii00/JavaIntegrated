package com.spring.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.ex01.MemberVO;

@WebServlet("/mem2.do")
public class MemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
 
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		String pwd =dao.selectPwd();
		PrintWriter pw = response.getWriter();
		pw.write("<script>");
		pw.write("alert('��й�ȣ : " + pwd +"');");
		pw.write("</script>");
	}
}
