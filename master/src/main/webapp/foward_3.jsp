<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import ="java.util.*" import = "sec01.ex01.*" %>
<%
  request.setCharacterEncoding("utf-8");
  List membersList = new ArrayList();
  MemberBean m1 = new MemberBean("lee" , "1234", "이순신", "lee@test.com");
  MemberBean m2 = new MemberBean("son" , "1234", "손흥민", "son@test.com");
  membersList.add(m1);
  membersList.add(m2);
  request.setAttribute("membersList", membersList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="forwards_3.jsp" />
</body>
</html>