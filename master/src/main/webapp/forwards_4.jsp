<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import ="java.util.*" import = "sec01.ex01.*" %>
<%
  session.setAttribute("address","수원시 팔달구");
%>
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
    <td width="7%">주소</td>
  </tr>
  <tr align="center">
    <td>${id}</td>
    <td>${pwd}</td>
    <td>${name}</td>
    <td>${email}</td>
    <td>${address}</td>
  </tr>
</table>
</body>
</html>