<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>c:forEach 향상된 for문 결과</title>
</head>
<body>

	EL을 이용하여 같은 name이 여러개인 파라미터 얻어오기 <br>
	${param.lang } <br>
	<!-- 
		?lang=java&lang=sql&lang=jdbc
		같은 name이 여러개인 경우 param을 이용하면 첫 번째 값만 얻어옴
	 -->
	
	${paramValues.lang } <br>
	
	${paramValues.lang[0] }
	${paramValues.lang[1] }
	${paramValues.lang[2] }
	
	<hr>
	
	<!-- 
		paramValues.lang 배열을 반복 접근
		이때 현재 반복 상태를 나타내줄 varStatus를 선언하고 vs라고 부르기로 함
	 -->
	<c:forEach var="item" items="${paramValues.lang }" varStatus="vs">
		item : ${item } <br>
		현재 값 : ${vs.current } <br>
		현재 인덱스 : ${vs.index } <br>
		현재 반복 횟수 : ${vs.count } <br>
		첫 번째 반복인가? : ${vs.first } <br>
		마지막 반복인가? : ${vs.last } <br>
	</c:forEach>
	
</body>
</html>