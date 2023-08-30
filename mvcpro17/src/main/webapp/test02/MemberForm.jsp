<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix ="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value ="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입창</title>
<script type ="text/javascript">
function idCheck(){
	if(form.id.value == "abcd"){
		alert('중복된 아이디입니다.');
	}
	else{
		alert('사용 가능한 아이디입니다.');
	}
} 
function check(){
	/* 아이디 유효성 검사 */
	if(form.id.value.length == 0){ // myform.id.value == "" 이것도 가능
		alert("아이디가 누락됐습니다.");
	
		 form.id.focus(); // 포커스를 이동시켜 바로 아이디를 입력할 수 있게
		 return false;
	}

	/* 비밀번호 유효성 검사 */
	if(form.pwd.value.length == 0){
		alert("비밀번호가 누락됐습니다.");
		 form.pwd.focus(); // 포커스를 이동시켜 바로 비밀번호를 입력할 수 있게
		 return false;
	}else if(form.pwd.value.length < 9) {
		alert("비밀번호는 10자 이상");
		form.pwd.focus(); // 포커스를 이동시켜 바로 비밀번호를 입력할 수 있게
		 return false;
	}

	/* 이름 유효성 검사 */
	if(form.name.value.length == 0){
		alert("이름이 누락됐습니다.");
		 form.name.focus(); 
		 return false;
	}
	/*이메일 유효성 검사*/
	if(myform.email.value.length == 0){
		alert("이메일이 누락됐습니다.");
		myform.email.focus(); 
		return false;
	}
}

</script>
</head>
<body>
<form name = "form" method ="post" action ="${contextPath}/Member151/addMember.do">
<h1 style ="text-align:center">회원가입창</h1>
<table align ="center">
  <tr>
    <td width="200"><p align ="right">아이디</td>
    <td width="400"><input type ="text" name ="id" > 
    <input type ="button" value ="중복체크" onclick="idCheck()"></td>
  </tr>
  <tr>
    <td width="200"><p align ="right">비밀번호</td>
    <td width="400"><input type ="password" name ="pwd"></td>
  </tr>
  <tr>
    <td width="200"><p align ="right">이름</td>
    <td width="400"><input type ="text" name ="name" ></td>
  </tr>
  <tr>
    <td width="200"><p align ="right">이메일</td>
    <td width="400"><input type ="email" name ="email"></td>
  </tr>
  <tr>
    <td width="200"><p>&nbsp;</p></td>
    <td width="400"><input type ="submit" value="가입하기" onclick="return check()">
    <input type ="reset" value="다시입력">
    </td>
  </tr>
</table>
</form>
</body>
</html>