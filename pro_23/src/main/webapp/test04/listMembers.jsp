<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	
	isELIgnored="false"	%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력창</title>
</head>
<body>
<table align ="center" width="80%" border="1">
<tr align=center bgcolor="pink">
<td><b>아이디</b></td>
<td><b>비밀번호</b></td>
<td><b>이름</b></td>
<td><b>이메일</b></td>
<td><b>가입일</b></td>
<td><b>수정</b></td>
<td><b>삭제</b></td>
</tr>

<c:forEach var = "member" items="${membersList}">
<tr align ="center">
<td>${member.id}</td>
<td>${member.pwd}</td>
<td>${member.name}</td>
<td>${member.email}</td>
<td>${member.joinDate}</td>
<td><a href="${contextPath}/mem4.do?action=updateForm&id=${member.id}">수정</a></td>
<td><a href="${contextPath}/mem4.do?action=deleteMember&id=${member.id}">삭제</a></td>
</tr>
</c:forEach>
</table>
<a href="test04/memberForm.jsp"><h1 style="text-align:center">회원가입</h1></a>
</body>
</html>