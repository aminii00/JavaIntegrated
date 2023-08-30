<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");
String email = request.getParameter("email");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" border=1>
<tr align="center" bgcolor="pink">
 <td width="7%"><b>아이디</b></td>
 <td width="7%"><b>비밀번호</b></td>
 <td width="7%"><b>이름</b></td>
 <td width="7%"><b>이메일</b></td>
</tr>
 <tr align="center">
   <td><%=id%></td>
   <td><%=pwd%></td>
   <td><%=name%></td>
   <td><%=email%></td>
 </tr>  
 <tr align="center">
   <td>${param.id}</td>
   <td>${param.pwd}</td>
   <td>${param.name}</td>
   <td>${param.email}</td>
 </tr>  
 </table>
</body>
</html>