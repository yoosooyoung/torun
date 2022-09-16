/**
 * 
 */
$(document).ready(function() {
    $.ajax({
        url: "/board/comment/insert", // 목적지
        type: "POST", // HTTP Method
        data: $("#comment").serialize(), // 전송 데이터
        dataType: 'json', // 전송 데이터 형식
        success: function(res){ // 성공 시 실행
        var tblresult = res.selectComment.reverse();
        var str = "";
        if(tblresult.length > 0){
            getComment(tblresult,str);
        	}
        },
        error:function(er){ //실패 시 실행
            console.log("실패 원인 : " + er);
        }
    });
});

$("#button").click(function(e){
	e.preventDefault();
	location.href = "/write?board_seq="+ $("#board_seq").val();
});

$("#list_button").click(function(e){
	e.preventDefault();
	location.href = "/";
});

$('#comment_button').click(function(e){
	e.preventDefault();
    $.ajax({
        url: "/board/comment/insert", // 목적지
        type: "POST", // HTTP Method
        data: $("#comment").serialize(), // 전송 데이터
        dataType: 'json', // 전송 데이터 형식
        success: function(res){ // 성공 시 실행
        	var tblresult = res.selectComment.reverse();
        	var str = "";
        	$("#commentList").empty();
        	getComment(tblresult,str);
        	$("#writer").val('');
        	$("#content").val('');
        },
        error:function(er){ //실패 시 실행
            console.log("실패 원인 : " + er);
        }
    });
});


function getComment(tblresult,str){
		str =  '<tr><th>작성자</th><th>댓글</th></tr>'
		$.each(tblresult, function(i){
        str += "<TR class='comment_tr'>"
        str += '<TD>' + tblresult[i].WRITER + '</TD><TD>' + tblresult[i].CONTENT + '</TD>'
        str += '</TR>'
    });
    	$("#commentList").append(str);
}

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