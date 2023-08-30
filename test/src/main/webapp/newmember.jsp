<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<hr>
<label>아이디 : <input type ="text" name ="user_id"></label><br>
<label>비밀번호 : <input type ="text" name ="user_pw"></label>
<h6>6~15자 영문과 숫자, 특수문자조합(특수문자중에서 ()는 제외)</h6>
<label>비밀번호 재입력 : <input type ="text" name ="user_pw2"></label><br>
<label>이름 입력 : <input type ="text" name ="user_name"></label><br>
<label>이메일 입력 : <input type ="email" name ="user_email"></label><br>
<label>전화번호 입력 : <input type ="tel" name ="user_tel"></label><br>
<label>휴대전화 입력 : <input type ="text" name ="user_phone"></label><br>
<label>우편번호 찾기 : <input type ="text" name ="user_address"></label><br>
<label>상세주소 입력 : <input type ="text" name ="user_address2"></label><br>
<label>생년월일 : <input type ="date" name ="user_date"></label><br>
<input type ="checkbox" name ="man">남자
<input type ="checkbox" name ="woman">여자<br>
<input type ="checkbox" name ="sns">sns 수신에 동의합니다.
<input type ="checkbox" name ="sms">email 수신에 동의합니다.
<h6>※동의시 이용약관, 개인정보 수집 및 이용에 동의 됨을 알려드립니다.</h6>
<input type ="checkbox" name ="sms">내용 확인 및 전체 동의<br>
<input type ="checkbox" name ="sms">서비스 이용약관 동의(필수)<br>
<input type ="checkbox" name ="sms">개인정보 수집 및 이용 동의(필수)<br>
<input type ="checkbox" name ="sms">만 14세 이상입니다.(필수)<br>
<hr>
<input type ="submit" value="회원가입">
<input type ="reset" value="취소">
</body>
</html>