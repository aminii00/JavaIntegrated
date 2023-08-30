<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 request.setCharacterEncoding("utf-8");
 request.setAttribute("id","hong");
 request.setAttribute("pwd", "1234");
 session.setAttribute("name","홍길동");
 application.setAttribute("eamil","hong@test.com");
 request.setAttribute("address","서울시 강남구"); //우선순위가 더 높음
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="forwards_4.jsp" />
</body>
</html>