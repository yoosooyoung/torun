   $(document).ready(function() {

	});

    //수정하기
    $("#mod_button").click(function(e){
    	e.preventDefault();
        $.ajax({
            url: "/board", // 목적지
            type: "PUT", // HTTP Method
            data: $("#theForm").serialize(), // 전송 데이터
            dataType: 'json', // 전송 데이터 형식
            success: function(res){ // 성공 시 실행
            	console.log(res);
               location.href="/board/view/"+res.seq;
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
            url: "/board", // 목적지
            type: "POST", // HTTP Method
            data: $("#theForm").serialize(), // 전송 데이터
            dataType: 'json', // 전송 데이터 형식
            success: function(res){ // 성공 시 실행
            	console.log(res);
               location.href="/board/list";
            },
            error:function(er){ //실패 시 실행
                console.log("실패 원인 : " + er);
            }
        });
      }); 