<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctxPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>memberRegister.jsp</title>
	<style type="text/css">
		.layer {
			width: 60%;
			margin: 0 auto;
		}
		
		ul {
			list-style-type: none;
		}
		
		li {
			margin: 20px 0 0 0;
		}
		
		button#btnOK {
			margin: 0 0 0 50px;
			padding: 5px 10px 5px 10px;
			font-size: 12pt;
			font-weight: bolder;
		}
	</style>
	
	<script type="text/javascript">
		function goRegister() {
			var frm = document.registerFrm;
			frm.action = "<%=ctxPath%>/ncstest/memberRegister.do";
			frm.method = "POST";
			frm.submit();
		}
	</script>
</head>
<body>
	<div class="layer">
		<h2>회원가입</h2>
		<%-- *** (요구사항1) JSP 입력폼 페이지를 작성 하시오. *** --%>
		
	</div>
</body>
</html>