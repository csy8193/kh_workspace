<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 
*** (요구사항6) ***
웹브라우저에서 회원가입창을 띄우게 한 후 데이터베이스의 NOT NULL 컬럼에 입력될 아이디와 성명을 입력하지 않고 가입할 경우나
 SQL구문에 오류가 있을시 SQLException 이 발생하는데 SQLException 발생시 
 에러페이지로 이동할 수 있도록 page 지시자의 isErrorPage 속성을 이용한 /WEB-INF/ncstestMember/error.jsp 를 생성하시오.
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
</head>
<body>
	<h2>에러 : ${ errorMessage }</h2>
	<a href="${pageContext.servletContext.contextPath}/ncstest/memberRegister.do">입력페이지로 돌아가기</a>
</body>
</html>