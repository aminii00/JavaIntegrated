<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
  request.setCharacterEncoding("utf-8");
  String id = (String)request.getAttribute("id");
  // getParameter()메서드의 경우 String타입을 리턴하는반면, · getAttribute()는 Object 타입을 리턴
  String pwd = (String)request.getAttribute("pwd");
  String name = (String)session.getAttribute("name");
  String email = (String)application.getAttribute("email");
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
  </tr>
  <tr align ="center">
    <td><%= id %></td>
    <td><%= pwd %></td>
    <td><%= name %></td>
    <td><%= email %></td>
    <!-- .getAttribute로 값을 받아서 사용 -->
  </tr>
  <tr align="center">
    <td>${id}</td>
    <td>${pwd}</td>
    <td>${name}</td>
    <td>${email}</td>
    <!-- foward1.jsp값을 받아옴. -->
  </tr>
</table>
</body>
</html>