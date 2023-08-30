<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored= "false"%>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<c:set var="title1" value=" hello world! " />
<c:set var="title2" value="쇼핑몰 중심 JSP입니다." />
<c:set var ="title3" value = "hello, world" />
<c:set var="str1" value="중심" />
title1  ="hello world!"
title2 = "쇼핑몰 중심 JSP입니다."
title3 = "hello, world"
str1 ="중심"
<br>
fn:length(title1) = ${fn:length(title1)} <br>   <!-- 길이 -->
fn:toUpperCase(title1) = ${fn:toUpperCase(title1)} <br> <!-- 대문자로 -->
fn:toLowerCase(title1) = ${fn:toLowerCase(title1)} <br><br><!-- 소문자로  -->

fn:substring(title1,3,6) = ${fn:substring(title1,3,6)} <br> <!-- 3인덱스부터 5인덱스까지 리턴 -->
fn:trim(title1) = ${fn:trim(title1)} <br> <!-- 문자열 앞 뒤 공백제거  -->
fn:replace(title1," ", "/") = ${fn:replace(title1," ", "/")} <br><br> <!-- 공백을 /로 대체하기  -->

fn:indexOf(title2,str1)= ${ fn:indexOf(title2,str1)} <br> <!--  str1이 title1에 몇번째 인덱스에 포함돼있는지 -->
fn:contains(title1,str1)=${ fn:contains(title1,str1)}<br> <!--str1이 title1에 포함돼있는지 t/f -->
fn:contains(title2, str1) =${fn:contains(title2, str1) }<br><!--str1이 title2에 포함돼있는지 t/f  -->

fn:split(title3, ",")[0] = ${fn:split(title3, ",")[0]} <br> <!-- split을 이용해 ,기준으로 잘라내고 배열에 저장 -->
fn:split(title3, ",")[1] = ${fn:split(title3, ",")[1]} <br> 

</body>
</html>