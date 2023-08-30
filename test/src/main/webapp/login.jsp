<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#all {
  border:0;
  margin:0;
  weight:auto;
  height:auto;
}
#naver{
   font-size :20px;
   background-color:#00e600;
   color : white;
 }
 #kakao{
   background-color:#ffff00;
   color : white;
   font-size :20px;
 }
 #apple{
   background-color:black;
   color : white;
   font-size :20px;
 }
</style>
</head>
<body>
<form id ="all">
<h2>로그인</h2>
<hr>
<label>아이디 : <input type ="text" name ="user_id"></label><br>
<label>비밀번호 : <input type ="password" name ="user_pw"></label>
<br>
<br>
<input type ="submit" value ="로그인"> <br>
<a href = "www.">회원가입 ㅣ</a>
<a href = "www.">아이디찾기 ㅣ </a>
<a href = "www.">회원가입</a> <br>
<h6>다른정보로 로그인하기</h6>
</form>
<form id ="naver">
네이버 로그인
</form>
<form id ="kakao">
카카오톡 로그인
</form>
<form id ="apple">
애플 로그인
</form>
</body>
</html>