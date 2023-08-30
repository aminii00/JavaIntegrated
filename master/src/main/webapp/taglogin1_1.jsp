<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test ="${empty param.id}" >
  아이디를 입력하세요 <br>
  <a href = "taglogin1.jsp">로그인창</a>
</c:if>
<c:if test="${not empty param.id}">
<h1>관리자로 로그인 했습니다.</h1>
<form>
  <input type ="button" value ="회원정보 삭제하기" />
  <input type ="button" value ="회원정보 수정하기" />
</form>
</c:if>
<c:if test="${param.id != 'admin'}">
<h1>환영합니다.
<c:out value="${param.id}" />님!!</h1>
</c:if>

</body>
</html>