<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>board</title>
    <style>
        table {
            width : 1000px;
            border: 1px solid black;
        }
        
        table th:first-child {
            width: 50px;
        }
        
        table th:nth-child(3){
            width: 200px;
        }
        
        table th:nth-child(4){
            width: 200px;
        }
        
        table th:last-child{
            width: 50px;
        }
        
        table th, td {
            border: 1px solid black;
            text-align: center;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script type="text/javascript">
    	$(function(){
    		
    		$.ajax({
    			type : "POST",
    			url : "./boardList", 
    			cache : false,
    			success : function(data) {
    				$("table tbody").append(data.list);
    			},
    			error : function() {
    				alert_modal("데이터 호출이 실패하였습니다");
    			}
    		});
    		
    	})
    </script>
</head>
<body>
<table>
	<thead>
	<tr>
        <th>글번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
	</tr>
	</thead>
	<tbody>
		<tr>
			${list }
		</tr>
	</tbody>
	</table>
	<br>
	<div id = "pagingDiv">
		<c:if test="${paging.prev }">
			<a href="${paing.startPage - 1 }">이전</a>
		</c:if>
		<c:forEach var="num" begin="${paging.startPage }" end = "${paging.endPage }">
			&nbsp;<a href="${num }">${num }</a>&nbsp;
		</c:forEach>
		<c:if test="${paging.next }">
			<a id="next" href="${paging.endPage + 1 }">다음</a>
		</c:if>
	</div>
</body>
    
</html>