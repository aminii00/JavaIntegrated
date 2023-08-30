<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix ="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value = "${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 .cls1 {
      text-decoration : none;
 }
 .cls2{
      font-size:15px;
      text-align:center;
      color:purple;
 }
 
</style>
</head>
<body>
<table align="center" border="1" width ="80%"> 
<tr height="10" align="center" bgcolor="pink">
 <td width="7%"><b>글번호</b></td>
 <td width="7%"><b>작성자</b></td>
 <td width="7%"><b>제목</b></td>
 <td width="7%"><b>작성일</b></td>
</tr>
<c:choose>
  <c:when test="${empty articlesList }">
    <tr height="10">
      <td colspan="4">
        <p align ="center">
         <b><span style = "font-size:9px;">등록된 글이 없습니다.</span></b>
         
        </p>
      </td>
    </tr>
  </c:when>
  <c:when test="${!empty articlesList}">
    <c:forEach var = "article" items ="${articlesList }" varStatus="articleNum">
      <tr align="center">
        <td width="5%">${articleNum.count}</td>
        <td width="10%">${article.id}</td>
        <td align ="left" width="35%">
         <span style ="padding-right:30px"></span>
        <c:choose>
          <c:when test ='${article.level > 1}'>
            <c:forEach begin="1" end ="${article.level}" step="1">
             <span style ="padding-left:20px"></span>
            </c:forEach>
            <span style ="font-size:12px;">답변</span>
            <a class="cls1" href="${contextPath}/board5/viewArticle.do?articleNO=${article.articleNO}">${article.title}</a>
            </c:when>
            <c:otherwise>
             <a class ="cls1" href="${contextPath}/board5/viewArticle.do?articleNO=${article.articleNO}">${article.title}</a>
            </c:otherwise>
            </c:choose>
            </td>
            <td width="10%">
              <fmt:formatDate value="${article.writeDate}" />
            </td>
           </tr>
           </c:forEach>
           </c:when>
           </c:choose>
           
</table>
<a class ="cls1" href="${contextPath}/board5/articleForm.do"><p class="cls2">글쓰기</p></a>
</body>
</html>