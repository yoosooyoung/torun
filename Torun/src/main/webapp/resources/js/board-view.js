/**
 * 
 */
$(document).ready(function() {
    $.ajax({
        url: "/board/comment/list", // 목적지
        type: "POST", // HTTP Method
        data: $("#comment").serialize(), // 전송 데이터
        dataType: 'json', // 전송 데이터 형식
        success: function(res){ // 성공 시 실행
        var tblresult = res.selectComment;
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
	location.href = "/board/write/"+ $("#board_seq").val();
});

$("#list_button").click(function(e){
	e.preventDefault();
	location.href = "/board/list";
});

$('#comment_button').click(function(e){
	e.preventDefault();
	if($('#content').val() == ''){
		alert('댓글을 작성해주세요.')
		return false;
	}
    $.ajax({
        url: "/board/comment/insert", // 목적지
        type: "POST", // HTTP Method
        data: $("#comment").serialize(), // 전송 데이터
        dataType: 'json', // 전송 데이터 형식
        success: function(res){ // 성공 시 실행
        	var tblresult = res.selectComment;
        	var str = "";
        	$("#commentList").empty();
        	getComment(tblresult,str);
        	$("#content").val('');
        },
        error:function(er){ //실패 시 실행
            console.log("실패 원인 : " + er);
        }
    });
});


function getComment(tblresult,str){
		str =  '';
		$.each(tblresult, function(i){
        str += "<li class='comment_tr'>"
        str += `<p><span class="writer">${tblresult[i].writer}</span> <span>${tblresult[i].init_date}</span></p> <p>${tblresult[i].content}</p>`;
        str += '</li>'
    });
    	$("#commentList").append(str);
}

$("#del_button").click(function(e){
	e.preventDefault();
	var baord_seq = $('#board_seq').val();
	console.log(baord_seq);
    $.ajax({
        url: "/board/"+baord_seq, // 목적지
        type: "delete", // HTTP Method
        success: function(res){ // 성공 시 실행
           location.href="/board/list";
        },
        error:function(er){ //실패 시 실행
            console.log("실패 원인 : " + er);
        }
    });
  });   