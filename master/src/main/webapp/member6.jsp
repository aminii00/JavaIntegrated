<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.*,sec01.ex01.*"%>
<%
  request.setCharacterEncoding("UTF-8");
 %>
 
 <jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" />
 <jsp:setProperty name ="m" property ="*" />
 <%
   MemberDAOO memberDAO = new MemberDAOO();
   memberDAO.addMember(m);
   List membersList = memberDAO.listMembers();
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>