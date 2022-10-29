<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
      <link href="${pageContext.request.contextPath}/resources/static/css/sb-admin-2.min.css" rel="stylesheet" type="text/css">
      <link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container my-5 wrapper">
		<h1>게시판</h1>
		<table>
		<tr>
		    <th class="text-center">글번호</th>
			<th class="text-center">제목</th>
			<th class="text-center">작성자</th>
			<th class="text-center">작성시간</th>
			<th class="text-center">조회수</th>
			<th class="text-center">좋아요수</th>
			<th class="text-center">좋아요</th>
		</tr>
		<c:if test="${fn:length(Alllist) > 0}">
			<c:forEach var="item" items="${Alllist}">
			<tr>
				<td class="text-center">${item.board_seq}</td>
				<td><a href="/board/view/${item.board_seq}">${item.board_title}</a></td>
				<td>${item.writer}</td>
				<td class="text-center">${item.board_init_date}</td>
				<td class="text-center">${item.board_views}</td>
				<td class="text-center">${item.board_views}</td>
				<td class="text-center">
					<img src="/resources/img/non_like.png" 
					     class="like_img"
					     id="like_img${item.board_seq}" 
					     onClick="toggleLike(${item.board_seq})">
				</td>
			</tr>
			</c:forEach>
		</c:if>
		<c:if test="${fn:length(Alllist) == 0}">
			<td colspan="6" class="text-center">글이 없습니다.</td>
		</c:if>
		</table>
	<div class="col-md-12 bg-light text-right my-3"><a href="/write" class="btn btn-primary">글쓰기</a></div>
	</div>
   <!--paginate -->
    <div class="paginate">
        <div class="paging">
            <a class="direction prev" href="javascript:void(0);"
                onclick="movePage(1,${pagination.cntPerPage},${pagination.pageSize});">
                &lt;&lt; </a> <a class="direction prev" href="javascript:void(0);"
                onclick="movePage(${pagination.currentPage}<c:if test="${pagination.hasPreviousPage == true}">-1</c:if>,${pagination.cntPerPage},${pagination.pageSize});">
                &lt; </a>
 
            <c:forEach begin="${pagination.firstPage}"
                end="${pagination.lastPage}" var="idx">
                <a
                    style="color:<c:out value="${pagination.currentPage == idx ? '#cc0000; font-weight:700; margin-bottom: 2px;' : ''}"/> "
                    href="javascript:void(0);"
                    onclick="movePage(${idx},${pagination.cntPerPage},${pagination.pageSize});"><c:out
                        value="${idx}" /></a>
            </c:forEach>
            <a class="direction next" href="javascript:void(0);"
                onclick="movePage(${pagination.currentPage}<c:if test="${pagination.hasNextPage == true}">+1</c:if>,${pagination.cntPerPage},${pagination.pageSize});">
                &gt; </a> <a class="direction next" href="javascript:void(0);"
                onclick="movePage(${pagination.totalRecordCount},${pagination.cntPerPage},${pagination.pageSize});">
                &gt;&gt; </a>
        </div>
    </div>
    <!-- /paginate -->	
</body>
<script>
//10,20,30개씩 selectBox 클릭 이벤트
function changeSelectBox(currentPage, cntPerPage, pageSize){
    var selectValue = $("#cntSelectBox").children("option:selected").val();
    movePage(currentPage, selectValue, pageSize);
    
}
 
//페이지 이동
function movePage(currentPage, cntPerPage, pageSize){
    
    var url = "${pageContext.request.contextPath}/board/list";
    url = url + "?currentPage="+currentPage;
    url = url + "&cntPerPage="+cntPerPage;
    url = url + "&pageSize="+pageSize;
    
    location.href=url;
}

function toggleLike(board_seq){
 	 $.ajax({
	        url: "/board/likeMapp", // 목적지
	        type: "POST", // HTTP Method
	        data: {board_seq : board_seq}, // 전송 데이터
	        dataType: 'json', // 전송 데이터 형식
	        success: function(res){ // 성공 시 실행
	        	if($("#like_img"+board_seq).attr('src') == '/resources/img/non_like.png'){
	        	 	$("#like_img"+board_seq).attr("src", "/resources/img/like.png");
	        	}else{
	        	 	$("#like_img"+board_seq).attr("src", "/resources/img/non_like.png");	
	        	}
	        },
	        error:function(er){ //실패 시 실행
	            console.log("실패 원인 : " + er);
	        }
	    }); 

}

</script>


</html>