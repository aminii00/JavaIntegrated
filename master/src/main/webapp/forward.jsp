<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 request.setCharacterEncoding("utf-8");
 request.setAttribute("address", "서울시 강남구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = private.jsp>
아이디: <input type ="text" name="id"><br>
비밀번호:<input type ="password" name="pwd"><br>
이름:<input type ="text" name="name"><br>
이메일:<input type ="text" name="email"><br>
<input type ="submit" value="가입하기">
<input type ="reset" value ="다시입력">
</form>
</body>
</html>