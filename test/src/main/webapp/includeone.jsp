<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<jsp:include page="total_image.jsp" flush="true" >
<jsp:param name= "name" value="강아지" />
<jsp:param name="imgName" value="dog.jpg" />
</jsp:include>
</body>
</html>