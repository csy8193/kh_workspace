<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
</head>
<body>
	${ errorMessage } <br>
	${ e }
	<a href="${ pageContext.servletContext.contextPath }/ncstest/bookRegister.do">책 등록 페이지로 이동</a>
	<a href="${ header.referer }">뒤로가기</a>
</body>
</html>