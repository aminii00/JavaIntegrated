<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" border=1 >
  <tr align ="center" bgcolor="pink">
    <td width="7%">아이디</td>
    <td width="7%">비밀번호</td>
    <td width="7%">이름</td>
    <td width="7%">이메일</td>
  </tr>
  <tr align="center">
    <td>${member.id}</td>
    <td>${member.pwd}</td>
    <td>${member.name}</td>
    <td>${member.email}</td>
  </tr>
</table>
</body>
</html>