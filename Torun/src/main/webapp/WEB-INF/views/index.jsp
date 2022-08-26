<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		<div>제목</div>
		<div><input type="text"></div>
		<div>작성시간</div>
		<div>${vo.board_init_date}</div>
		<div>글</div>
		<div><textarea></textarea></div>
		<div>조회수</div>
		<div>조회수</div>
		<div>작성자</div>
		<div><input type="text"></div>
	<button id="button">작성하기</button>
	</form>
<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
<script>
	$("#button").click(function(e){
		console.log(e);
		e.preventDefault();
		alert();
	});
</script>
</body>
</html>