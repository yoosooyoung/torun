<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
	<form id ="theForm">
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
	</form>
	<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
	<script>
    $(document).ready(function() {

	});
    $("#button").click(function(e){
    	e.preventDefault();
    	location.href = "/write?board_seq="+ $("#board_seq").val();
    });
    
	  
    $("#del_button").click(function(e){
    	e.preventDefault();
        $.ajax({
            url: "/board/delete", // 목적지
            type: "POST", // HTTP Method
            data: $("#theForm").serialize(), // 전송 데이터
            dataType: 'json', // 전송 데이터 형식
            success: function(res){ // 성공 시 실행
            	console.log(res);
               location.href="/";
            },
            error:function(er){ //실패 시 실행
                console.log("실패 원인 : " + er);
            }
        });
      });     
</script>
</body>
</html>