<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.*,sec01.ex01.*"%>
<%
  request.setCharacterEncoding("UTF-8");
 %>
 <jsp:useBean id ="m" class = "sec01.ex01.MemberBean" scope="page" />
 <jsp:setProperty name ="m" property="id" value ='<%= request.getParameter("id") %>' />
 <jsp:setProperty name ="m" property="pwd" value ='<%= request.getParameter("pwd") %>' />
 <jsp:setProperty name ="m" property="name" value ='<%= request.getParameter("name") %>' />
 <jsp:setProperty name ="m" property="email" value ='<%= request.getParameter("email") %>' />
<%   MemberDAOO memberDAO = new MemberDAOO();
  memberDAO.addMember(m);
  List membersList = memberDAO.listMembers();
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록창</title>
</head>
<body>

</body>
</html>