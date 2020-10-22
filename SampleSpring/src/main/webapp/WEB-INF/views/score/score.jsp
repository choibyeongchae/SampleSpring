<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function () {
		$.ajax({
			type : "POST",
			url : "./getScore",
			cache : false,
			success : function(data) {
				$("table tbody").append(data.list);
			},
			error : function() {
				
			}
		});
	});
	
	function getTest() {
		$.ajax({
			type : "POST",
			url : "./getTest",
			cache : false,
			success : function(data) {
				alert(data.aaa);
			},
			error : function() {
				
			}
		});
	}
	
</script>
</head>
<body>
	<table>
		<tbody>
			
		</tbody>
	</table>
	<input type="button" value="${aaa }" onClick = "getTest(); return false;"/>
</body>
</html>