<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>표현 언어로 여러가지 데이터 출력하기</h1>
\${"안녕하세요"} : ${"안녕하세요"}<br><br>
<%-- \${"100 div 9"} : ${100 div 9}<br><br> --%>
\${"100 mod 9"} : ${100 mod 9}<br><br>
\${"hello" == "hello"} : ${"hello" == "hello"}<br>
<%-- \${"hello" ne "hello"} : ${"hello" ne "hello"}<br><br> --%>
\${10 lt 10} : ${10 lt 10}<br>
\${10 le 10} : ${10 le 10}<br>
\${10 ge 10} :${10 ge 10}<br><br>
\${(10 == 10) && (20 == 20)} :${(10 == 10) && (20 == 20)}<br>
\${(10 == 10) and (20 == 20)} :${(10 == 10) and (20 == 20)}<br><br>

\${(10 == 10) || (20 == 20)} :${(10 == 10) || (20 == 20)}<br>
\${(10 == 10) or (20 == 20)} :${(10 == 10) or (20 == 20)}<br><br>

\${!(20==10)} : ${!(20==10)} <br>
\${not(20==10)} : ${not(20==10)} <br><br>

\${!(20!=10)} : ${!(20!=10)} <br>
\${not(20!=10)} : ${not(20!=10)} <br><br>
</body>
</html>