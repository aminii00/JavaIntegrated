<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*, sec01.ex01.*" isELIgnored="false"%>
<%@ taglib prefix ="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 .cls1 {
      font-size:40px;
      text-align:center;
 }
 .cls2{
      font-size:20px;
      text-align:center;
 }
</style>
</head>
<body>
<table align="center" border=1>
<tr align="center" bgcolor="pink">
 <td width="7%"><b>아이디</b></td>
 <td width="7%"><b>비밀번호</b></td>
 <td width="7%"><b>이름</b></td>
 <td width="7%"><b>이메일</b></td>
 <td width="7%"><b>가입일</b></td>
</tr>
<c:choose>
  <c:when test="${empty membersList}" >
    <tr>
      <td colspan=5 align ="center">
        <b>등록된 회원이 없습니다.</b>
      </td>
    </tr>
  </c:when>
  <c:when test="${!empty membersList}" >
    <c:forEach var="men" items="${membersList}">
      <tr align ="center">
        <td>${mem.id}</td>
        <td>${mem.pwd}</td>
        <td>${mem.name}</td>
        <td>${mem.email}</td>
        <td>${mem.joinDate}</td>
    </c:forEach>
  </c:when>
</c:choose>
</table>
<a href = "#">
<p class = "cls2">회원가입하기</p>
</a>
</body>
</html>