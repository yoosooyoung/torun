<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
	<form id ="theForm">
		<h4>게시판</h4>
		<input type="hidden" id="board_seq" name="board_seq" value="${selectBoard.BOARD_SEQ}">
		<div>제목</div>
		<div>${selectBoard.BOARD_TITLE}</div>

		<div>글</div>
		<div>${selectBoard.BOARD_CONTENT}</div>

		<div>작성자</div>
		<div>${selectBoard.WRITER}</div>
		<div>조회수</div>
		<div>${selectBoard.BOARD_VIEWS}</div>
	<button id="button">수정하기</button>
	<button id="del_button">삭제하기</button>
	<button id="list_button">목록가기</button>
	</form>
	<form id ="comment">
		<h4>댓글</h4>
		<!-- 글내용 -->
		<input type="text" name="content" >
		<!-- 작성자 -->
		<input type="text" name="writer">
		<input type="hidden" name="board_seq" value="${selectBoard.BOARD_SEQ}">
		<button id="comment_button">작성하기</button>
	</form>	
	<div><table id ="commentList" border = "1"></table></div>  
		
	<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
	<script src="/resources/js/board-view.js"></script>
</body>
</html>