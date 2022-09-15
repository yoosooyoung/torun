<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/static/css/sb-admin-2.min.css" rel="stylesheet" type="text/css">
    
</head>
<body>
<div class="container my-5">
	<form id ="theForm" class="col-md-12 my-3">
		<h4>게시글 상세보기</h4>
		<input type="hidden" id="board_seq" name="board_seq" value="${selectBoard.BOARD_SEQ}">
		<table class="table-bordered">
			<tr>
				<th>제목</th>
				<td>${selectBoard.BOARD_TITLE}</td>
			</tr>
			<tr style="height: 500px">
				<th>글</th>
				<td>${selectBoard.BOARD_CONTENT}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${selectBoard.WRITER}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${selectBoard.BOARD_VIEWS}</td>
			</tr>
		</table>
		<div class="col-md-12 bg-light text-right my-3"">	
			<button id="button" class="btn btn-primary">수정하기</button>
			<button id="del_button" class="btn btn-danger">삭제하기</button>
			<button id="list_button" class="btn btn-success">목록가기</button>
		</div>
	</form>
	<form id ="comment" class="col-md-8 my-3">
		<table class="table-bordered">
			<tr>
				<th>작성자</th>
				<th>댓글</th>
				<th></th>
			</tr>
			<tr>
				<td><input type="text" name="writer" id="writer" class="form-control"></td>
				<td><input type="text" name="content" id="content" class="form-control"></td>
				<td><button id="comment_button" class="btn btn-primary">작성하기</button></td>
			</tr>
		</table>
		<input type="hidden" name="board_seq" value="${selectBoard.BOARD_SEQ}">
	</form>
	<div class="col-md-8 my-3">
		<table id ="commentList" class="table-bordered table-hover">

		</table>
	</div>  
</div>		
	<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
	<script src="/resources/js/board-view.js"></script>
</body>
</html>