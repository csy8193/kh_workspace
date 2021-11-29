<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	int total = (int)request.getAttribute("total"); 
	
	String method = request.getMethod(); // get, post같은 요청 방식을 얻어옴
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 결과</title>
</head>
<body>
	<h1> <%=method %>방식 요청 결과</h1>
	상품명 : <%= request.getParameter("pName") %> <br>
	가격 : <%= request.getParameter("price") %>원 <br>
	수량 : <%= request.getParameter("amount") %>개<br>
	총 가격 : <%= total %>원<br>
	
	<button onclick="history.back();">이전 페이지로</button>
</body>
</html>