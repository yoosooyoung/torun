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
	<form id ="theForm" class="col-md-18 my-3" action="/join" method="post">
		<div>아이디</div>
		<input type="text" name="user_id" class="form form-control">
		<div>패스워드</div>
		<div><input type="password" name="user_pw" class="form form-control"></div>

		<div>이름</div>
		<div><input type="text" name="user_name" class="form form-control"></div>

		<div>이메일</div>
		<div><input type="text" name="user_email" class="form form-control"></div>
		<div class="col-md-12 bg-light text-right my-3">	
			<button id="sign_btn" type ="submit" class="btn btn-primary">회원가입</button>
			<button id="list_button" type ="button" class="btn btn-success">메인</button>
		</div>

	</form>
</div>
	<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
	<script src="/resources/js/member.js"></script>
</body>
</html>