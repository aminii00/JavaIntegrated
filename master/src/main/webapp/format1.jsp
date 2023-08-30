<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" isELIgnored ="false" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>format - Date</h2>
<c:set var ="now" value ="<%=new Date() %>" />
<fmt:formatDate value ="${now}" type ="date" dateStyle ="full" /><br>
<fmt:formatDate value ="${now}" type ="date" dateStyle ="short"  /><br>
<fmt:formatDate value ="${now}" type ="time"/><br>
<fmt:formatDate value ="${now}" type ="both" dateStyle ="full" timeStyle="full" /><br>
<fmt:formatDate value ="${now}" pattern="YYYY-MM-dd :hh:mm:ss"  /><br>

<br><br>
한국 현재 시간:
<fmt:formatDate value="${now}" type ="both" dateStyle="full" timeStyle="full" /><br><br>

<fmt:timeZone value ="America/New York">
뉴욕 현재시간 : 
<fmt:formatDate value="${now}" type ="both" dateStyle="full" timeStyle="full" /><br><br>
</fmt:timeZone>
</body>
</html>
