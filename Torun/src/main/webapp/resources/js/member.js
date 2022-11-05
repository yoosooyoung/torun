/**
 * 
 */

$( document ).ready(function() {
	var result = $('#result').val();
	if (result == '1'){
  		const login = document.getElementById('login');
  		login.innerHTML = "<div style='color:red'>존재하지 않는 아이디입니다.</div>";
	}else if (result == '0'){
  		const login = document.getElementById('login');
  		login.innerHTML = "<div style='color:red'>비밀번호가 일치하지 않습니다.</div>";		
	}
});

$("#list_button").click(function(e){
	e.preventDefault();
	location.href = "/";
});

//id체크
function idCheck(){
	var user_id = $("#user_id").val();
	var id_check = user_id.search(/^[a-z]+[a-z0-9]{5,19}$/g);
	if(id_check < 0){
		const id_content = document.getElementById('id_content');
  		id_content.innerHTML = "<div style='color:red'>영문과 숫자 조합한 5자 이상입력해주세요.</div>";	
	}else{
		const id_content = document.getElementById('id_content');
  		id_content.innerHTML = "<div style='color:green'>사용가능한 아이디입니다.</div>";
	}

}

//pw체크
function pwCheck(){
	 var pw = $("#password").val();
	 var num = pw.search(/[0-9]/g);
	 var eng = pw.search(/[a-z]/ig);
	 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	 const pw_content = document.getElementById('pw_content');
	 if(pw.length < 8 || pw.length > 20){
  	  pw_content.innerHTML = "<div style='color:red'>8자리 ~ 20자리 이내로 입력해주세요.</div>";	
	 }else if(pw.search(/\s/) != -1){
	  pw_content.innerHTML = "<div style='color:red'>비밀번호는 공백 없이 입력해주세요.</div>";	
	 }else if(num < 0 || eng < 0 || spe < 0 ){
	  pw_content.innerHTML = "<div style='color:red'>영문,숫자, 특수문자를 혼합하여 입력해주세요.</div>";
	 }else{
	  pw_content.innerHTML = "<div style='color:green'>사용가능한 비밀번호입니다.</div>";
	}

}


//pw체크
function emailCheck(){
	 var email = $("#email").val();
	 var num = email.search(/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);
	 const email_content = document.getElementById('email_content');
	 if(num < 0){
  	  email_content.innerHTML = "<div style='color:red'>이메일형식에 맞게 입력해주세요.</div>";	
	 }else{
	  email_content.innerHTML = "<div style='color:green'>사용가능한 이메일입니다.</div>";
	}

}

//회원가입
$("#sign_btn").click(function(e){
	e.preventDefault();
	
	//id체크
	var user_id = $("#user_id").val();
	var id_check = user_id.search(/^[a-z]+[a-z0-9]{5,19}$/g);
	if(user_id == ""){
  		return false;
	}else if(id_check < 0){
		return false;
	}
	
	//비밀번호체크
	 var pw = $("#password").val();
	 var num = pw.search(/[0-9]/g);
	 var eng = pw.search(/[a-z]/ig);
	 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
	 if(pw.length < 8 || pw.length > 20){
	  alert("8자리 ~ 20자리 이내로 입력해주세요.");
	  return false;
	 }else if(pw.search(/\s/) != -1){
	  alert("비밀번호는 공백 없이 입력해주세요.");
	  return false;
	 }else if(num < 0 || eng < 0 || spe < 0 ){
	  alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
	  return false;
	 }

	//이메일체크
	 var email = $("#email").val();
	 var num = email.search(/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);
	 if(num < 0){
	  alert("이메일형식에 맞게 입력해주세요.");
	  return false;		
	 }
    $.ajax({
        url: "/join", // 목적지
        type: "POST", // HTTP Method
        data: $("#theForm").serialize(), // 전송 데이터
        dataType: 'json', // 전송 데이터 형식
        success: function(res){ // 성공 시 실행
        console.log(res);
			if(res.result == 0){
				location.href="/";
			}else{
				location.href="/signup";
			}
        },
        error:function(er){ //실패 시 실행
            console.log("실패 원인 : " + er);
        }
    });
  }); 


