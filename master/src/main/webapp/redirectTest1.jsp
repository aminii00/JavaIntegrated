<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:redirect url ="../master/redirect1.jsp">
 <c:param name="id" value ="${'choi'}"></c:param>
 <c:param name="pwd" value ="${'1234'}"></c:param>
 <c:param name="name" value ="${'최민아'}"></c:param>
 <c:param name="email" value ="${'choi@test.com'}"></c:param>
</c:redirect>
</body>
</html>