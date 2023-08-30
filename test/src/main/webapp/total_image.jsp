<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 request.setCharacterEncoding("utf-8");
 String name = request.getParameter("name");
 String imgName = request.getParameter("imgName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
안녕하세요. 쇼핑몰 중심 JSP 시작입니다!!!<br><br>

<h2>이름은 <%=name %>입니다.</h2><br><br>
<img src = 'images/<%=imgName %>' ><br>

안녕하세요. 쇼핑몰 중심 JSP 끝 부분 입니다.!!!
</body>
</html>