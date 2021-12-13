<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- header include -->
	<jsp:include page="header.jsp" />
	
	<!-- 메인 화면 이미지 -->
	<div class="py-5 bg-image-full" style="background-image: url('${contextPath}/resources/images/main/main_bg.jpg');">
	    <h1>Servlet/JSP를 이용한<br>Semi Project</h1>
	</div>
	
	<!-- 내용 작성 부분 -->
	<section class="py-5">
	  <div class="container">
	    <h1>${ today }</h1>
	    <p class="lead">로그인한 회원 정보</p>
	    <p>
	    	아이디 : ${ loginMember.memberId } <br>
	    	이름 : ${loginMember.memberName } <br>
	    	전화번호 : ${loginMember.memberPhone } <br>
	    	이메일 : ${loginMember.memberEmail } <br>
	    	주소 : ${loginMember.memberAddress } <br>
	    </p>
	  </div>
	</section>
	
	<section class="py-5">
	  <div class="container">
	    <h1>아이디가 일치하는 회원정보 조회(AJAX)</h1>
	    <p class="lead">
			검색할 아이디 : <input type="text" id="searchId">
			<button type="button" id="idSearchBtn">아이디 검색</button>
		</p>
		
		<table>
			<tbody id="idSearchResult">
			</tbody>
		</table>
	  </div>
	</section>
	
	<!-- footer include -->
	<jsp:include page="footer.jsp" />
	
</body>
</html>