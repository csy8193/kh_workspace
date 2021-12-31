<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>사용자 목록</title>
</head>
<body>
	
	<h3>사용자 목록</h3>
	
	<table>
		<thead>
			<tr>
				<th>번호</th>			
				<th>이름</th>			
				<th>가입일</th>			
			</tr>
		</thead>
		
		<tbody id="userListView">
			<tr>
			</tr>
		</tbody>
	
	</table>
	
	
	<hr>
	
	<form action="#" name="insertForm">
		<h3>사용자 등록</h3>
		<input type="text" id="userName" name="userName">
		<button type="button" id="btn">사용자 등록하기</button>
	</form>
	
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	
	<script type="text/javascript">
		func_selectUserList();
	
		$("#btn").on("click", function(){
			
			// serialize() : form태그 내부 input요소를 모두 쿼리스트링으로 반환
			const qs = $("form[name='insertForm']").serialize();
			
			$.ajax({
				url : "user/insertUser.do",
				type : "post",
				data : qs,
				success : function(){
					console.log("성공");
					
					
					func_selectUserList();
					$("#userName").val("").focus();
				},
				error: function(){
					console.log("에러");
				}
				
			})
			
			
		});
		
		
		// 사용자 목록 조회
		function func_selectUserList(){
			$.ajax({
				url : "user/selectUserList.do",
				type : "get",
				dataType : "json",
				success : function(result){
					
					let html = "";
					
					// List 형태인 result를 순서대로 반복 접근
					$.each(result, function(index, item){
						
						console.log(item.userNo);
						console.log(item.userName);
						console.log(item.enrollDate);
						html += '<tr>' 
									+ '<td>'+item.userNo+'</td>'
									+ '<td>'+item.userName+'</td>'
									+ '<td>'+item.enrollDate+'</td>'
								+ '</tr>';
					});
					
					$("#userListView").append(html);
				},
				error : function(){
					console.log("에러");
				}
			});
		}
		
	</script>
	
</body>
</html>