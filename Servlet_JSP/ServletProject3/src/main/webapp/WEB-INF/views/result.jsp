<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 결과</title>
</head>
<body>
    <h1><%=request.getParameter("memberName")%>님 가입을 환영합니다.</h1>

    <p>
        ID : <%=request.getParameter("memberId")%> <br>
        PW : <%=request.getParameter("memberPw") %> <br>
        Email : <%=request.getParameter("memberEmail") %>
    </p>

</body>
</html>