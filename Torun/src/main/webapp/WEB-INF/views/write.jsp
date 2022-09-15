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
	<form id ="theForm">
		<input type="hidden" name="board_seq" value="${selectBoard.BOARD_SEQ}">
		<div>제목</div>
		<div><input type="text" name="board_title" value="${selectBoard.BOARD_TITLE}"></div>

		<div>글</div>
		<div><textarea name="board_content">${selectBoard.BOARD_CONTENT}</textarea></div>

		<div>작성자</div>
		<div><input type="text" name="writer" value="${selectBoard.WRITER}"></div>
		<c:if test="${selectBoard.BOARD_SEQ == null}">		
			<button id="button" class="btn btn-primary">작성하기</button>
		</c:if>
		<c:if test="${selectBoard.BOARD_SEQ != null}">
			<button id="mod_button" class="btn btn-danger">수정하기</button>
		</c:if>
	</form>
	<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
	<script>
    $(document).ready(function() {

	});

    //수정하기
    $("#mod_button").click(function(e){
    	e.preventDefault();
        $.ajax({
            url: "/board/update", // 목적지
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
    
    //작성하기
    $("#button").click(function(e){
    	e.preventDefault();
        $.ajax({
            url: "/board/insert", // 목적지
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