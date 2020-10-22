<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
<!-- 테이블 테두리 css -->
table {
	border : 1px solid black;
}

table th, td {
	border : 1px solid black;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

</head>
<body>
	<!-- controller에서 설정한 str변수 -->
	<input type="text">
	<input type="button" value = "찾기" onclick="searchUser();">
	<table>
	<thead>
	<tr>
		<th>아이디</th>
		<th>유저이메일</th>
		<th>가입일시</th>
	</tr>
	</thead>
	<tbody>
		<tr>
			${list }
		</tr>
	</tbody>
	</table>
</body>
<script>
	$(function(){
		$.ajax({
			type : "POST",
			url : "./testPost", 
			cache : false,
			success : function(data) {
				$("table tbody").append(data.list);
			},
			error : function() {
				alert_modal("데이터 호출이 실패하였습니다");
			}
		});
		
	})
	
	function searchUser() {
		
		if ($("input[type=text]").val() == "") {
			$.ajax({
				type : "POST",
				url : "./testPost",
				cache : false,
				success : function(data) {
						$("table > tbody").empty();
						$("table > tbody").append(data.list);
					
				},
				error : function() {
					alert_modal("데이터 호출이 실패하였습니다");
				}
			});
		} else {
			$.ajax({
				type : "POST",
				url : "./searchUser",
				data : {user_id : $("input[type=text]").val()},
				cache : false,
				success : function(data) {
				
					if (data.result == "null") {
						alert("가입되어 있지 않은 아이디 입니다.");
					} else {
						$("table > tbody").empty();
						$("table > tbody").append(data.result);
					}
				},
				error : function() {
					alert_modal("데이터 호출이 실패하였습니다");
				}
			});
		}
	}
</script>
</html>