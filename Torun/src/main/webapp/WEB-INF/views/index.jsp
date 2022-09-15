<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<style>
  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    border-left: 1px solid #444444;
    padding: 10px;
  }
  th:first-child, td:first-child {
    border-left: none;
  }
</style>
<body>
	<h1>게시판</h1>
	<table>
	<tr>
	    <th>글번호</th>
		<th>제목</th>
		<th>글</th>
		<th>작성자</th>
		<th>작성시간</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="item" items="${list}">
	<tr>
		<td>${item.BOARD_SEQ}</td>
		<td><a href="/board/view?board_seq=${item.BOARD_SEQ}">${item.BOARD_TITLE}</a></td>
		<td><a href="/board/view?board_seq=${item.BOARD_SEQ}">${item.BOARD_CONTENT}</a></td>
		<td>${item.WRITER}</td>
		<td>${item.BOARD_INIT_DATE}</td>
		<td>${item.BOARD_VIEWS}</td>
	</tr>
	</c:forEach>
	</table>
	<div><a href="/write">글쓰기</a></div>
	<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
	<script>

	</script>
</body>
</html>