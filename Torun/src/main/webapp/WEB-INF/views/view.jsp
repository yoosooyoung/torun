<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath}/resources/static/css/sb-admin-2.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css">
    
</head>
<body>
<div class="container my-5">
	<form id ="theForm" class="col-md-12 my-3 wrapper">
		<h4>게시글 상세보기</h4>
		<input type="hidden" id="board_seq" name="board_seq" value="${selectBoard.board_seq}">
		<table class="basic-table">
			<colgroup>
				<col width="100px;">
				<col width="*;">
			</colgroup>
			<tr>
				<th>제목</th>
				<td>${selectBoard.board_title}</td>
			</tr>
			<tr style="height: 500px">
				<th>글</th>
				<td>${selectBoard.board_content}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${selectBoard.writer}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${selectBoard.board_views}</td>
			</tr>
		</table>
		<div class="col-md-12 bg-light text-right my-3">	
			<c:if test="${selectBoard.writer == member.user_id}">
				<button id="button" class="btn btn-primary">수정하기</button>
				<button id="del_button" class="btn btn-danger">삭제하기</button>
			</c:if>
				<button id="list_button" class="btn btn-success">목록가기</button>
		</div>
	</form>
	<div class="col-md-8 my-3">
		<table id ="commentList" class="table-bordered table-hover">

		</table>
	</div>
	<form id ="comment" class="col-md-8 my-3">
		<table class="table-bordered">
			<tr>
				<th>작성자</th>
				<th>댓글</th>
				<th></th>
			</tr>
			<tr>
				<td><input type="text"  class="form-control" value="${member.user_name}" disabled="true">
					<input type="hidden" name="writer" id="writer" class="form-control" value="${member.user_id}">
				</td>
				<td><input type="text" name="content" id="content" class="form-control"></td>
				<td><button id="comment_button" class="btn btn-primary">작성하기</button></td>
			</tr>
		</table>
		<input type="hidden" name="board_seq" value="${selectBoard.board_seq}">
	</form>	
</div>		
	<script src="/resources/js/board-view.js"></script>
</body>
</html>