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
	<form id ="theForm" class="col-md-18 my-3">
		<div>아이디</div>
		<input type="text" name="user_id" class="form form-control" id="user_id" onkeyup='idCheck()' placeholder="영문과 숫자 조합한 5자 이상입력해주세요.">
		<div id="id_content"></div>
		<div>패스워드</div>
		<div><input type="password" name="user_pw" class="form form-control" id="password" onkeyup='pwCheck()' placeholder="영문,숫자, 특수문자를 혼합하여 입력해주세요."></div>
		<div id="pw_content"></div>
		<div>이름</div>
		<div><input type="text" name="user_name" class="form form-control"></div>

		<div>이메일</div>
		<div><input type="text" name="user_email" class="form form-control" id="email" onkeyup='emailCheck()'></div>
		<div id="email_content"></div>
		<div class="col-md-12 bg-light text-right my-3">	
			<button id="sign_btn" type ="button" class="btn btn-primary">회원가입</button>
			<button id="list_button" type ="button" class="btn btn-success">메인</button>
		</div>

	</form>
</div>
	<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
	<script src="/resources/js/member.js"></script>
</body>
</html>