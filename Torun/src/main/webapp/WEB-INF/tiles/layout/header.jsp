<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <title>Daliy Note</title>
        <style type="text/css">
			
			ul {
			    list-style: none;
			}
			
			a {
			    text-decoration: none;
			    outline: none;
			}
			
			.page {
			    width: 1440px;
			    margin: 0 auto;
			}
			
			header {
			    width: 100;
			    height: 80px;
			    display: flex;
			    align-items: center;
			    justify-content: space-between;
			}
			
			header > h2 {
				margin-left:20px;
			}
			
			header > nav {
				width:600px;
				height:100%;
			}
			
			header ul {
				width:100%;
				height: 100%;
				display: flex;
				justify-content: space-between;
			}
			
			header ul > li {
				font-size:20px;
				height: 100%;
				display: flex;
				align-items: center;
			}
			        
        </style>
      <link href="${pageContext.request.contextPath}/resources/static/css/sb-admin-2.min.css" rel="stylesheet" type="text/css">
      <link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css">        
    </head>
    <body>
        <div class="col-md-12 text-right my-3">
        <input type="hidden" id="user_id" value="${member.user_id}"/>
        	<c:if test="${member == null}">
	        <a href="/signup">회원가입</a>
	        <a href="/signin">로그인</a>
	        </c:if>
        	<c:if test="${member != null}">
	        <a href="/">${member.user_name}님</a>
	        <a href="/signout">로그아웃</a>
	        </c:if>
        </div>
        <div class="page">
            <header>
                <h2 onclick="goMain();">Daliy Note</h2>
                <nav>
                    <ul>
                        <li><a href="#" onclick="checkLogin('board');">Board</a></li>
                        <li><a href="">빈칸</a></li>
                        <li><a href="">빈칸</a></li>
                        <li><a href="">빈칸</a></li>
                    </ul>
                </nav>
            </header>
        </div>
 
    </body>
    <script>
	    function goMain() {
	    	location.href="/";
	    }
	    function checkLogin(type) {
	    	if($('#user_id').val() != ''){
		    	if(type == 'board'){
		    		location.href="/board/list";
		    	}
		    	 return true;
	    	}else{
	    		alert('로그인을 해주세요.')
	    		return false;
	    	}

	    }
	    
    </script>
    <script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
</html>