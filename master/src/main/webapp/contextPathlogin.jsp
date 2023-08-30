<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = result.jsp>
아이디: <input type ="text" name="id" /><br>
비밀번호:<input type ="password" name="pwd" /><br>
<input type ="submit" value="로그인" />
<input type ="reset" value ="다시입력" />
<br><br>
<a href ="http://localhost:8080/master/memberForm.jsp">회원가입하기</a>
<a href ="<%=request.getContextPath()%>/master/memberForm.jsp">회원가입하기</a>
</form>
</body>
</html>