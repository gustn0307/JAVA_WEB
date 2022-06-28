/**
 * author : 조재청
	
 */

$(function(){
	$("#email").blur(emailOut);
	$("#pass").blur(passOut);
	$("#pass2").blur(pass2Out);
});

function emailOut(){
	//이메일주소@도메인.com
	var pattern  = /^[0-9a-zA-Z]([-_]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_]?[0-9a-zA-Z])*[.][a-zA-Z]{2,3}$/i;
	var email=$(this).val().trim();
	var result =pattern.test(email);
	//alert(result);
	if(result){
		/*$(this).parent().siblings(".result").text("패턴에 맞는 이메일 입니다.");
		$(this).parent().siblings(".result").css({"color":"green","padding-top":"15px"});
		$("#pass").removeAttr("disabled");*/
		emailCheck(email);
		/*$("#pass").attr("disabled",false);*/
	}else{
		$(this).parent().siblings(".result").text("* 이메일 형식이 아닙니다.");
		$(this).parent().siblings(".result").css({"color":"red","padding-top":"15px"});
		$("#pass").attr("disabled",true);
		return;
	}
}

function emailCheck(email_data){
	$.ajax({
		url:"email-check",
		type: "post",
		data:{email:email_data},
		success: function(result){
			/*alert(typeof result);*/
			if(result=="true"){//이미존재하는 이메일
				$("#email").parent().siblings(".result").text("* 이미 존재하거나 탈퇴한 회원입니다.").css("color","red");
				$("#pass").attr("disabled",true);
			}else{//사용가능한 이메일
				$("#email").parent().siblings(".result").text("사용 가능한 이메일입니다.").css("color","green");
				$("#pass").removeAttr("disabled");
			}
		}
	});
}


function pass2Out(){
	var pass=$("#pass").val().trim();
	var pass2=$("#pass2").val().trim();
	
	if(pass!=pass2){
		$(this).siblings(".error").text("* 비밀번호가 일치하지 않습니다.").css("color","red");
	}else{
		$(this).siblings(".error").text("비밀번호 확인 완료!").css("color","green");
		$("#btn-submit").removeAttr("disabled");
	}
}

function passOut(){
	var pattern1=/.*(?=.*[/!@#$%^&+=])/;
	var pattern2=/.*(?=.*[a-zA-Z])/;
	var pattern3=/.*(?=.*\d)/;
	var pass=$("#pass").val().trim();
	/*var v=document.getElementById("pass").value;*/
	if(pass.length<8 || pass.length>16){
		$(this).siblings(".error").text("* 패스워드 길이를 체크하세요!").css("color","red");
		$("#pass2").attr("disabled",true);
	}else if(!pattern1.test(pass)){
		$(this).siblings(".error").text("* 특수문자가 포함 되어야합니다.").css("color","red");
		$("#pass2").attr("disabled",true);
	}else if(!pattern2.test(pass)){
		$(this).siblings(".error").text("* 영문자가 포함 되어야합니다.").css("color","red");
		$("#pass2").attr("disabled",true);
	}else if(!pattern3.test(pass)){
		$(this).siblings(".error").text("* 숫자가 포함 되어야합니다.").css("color","red");
		$("#pass2").attr("disabled",true);
	}else{
		$(this).siblings(".error").text("패스워드 확인").css("color","green");
		$("#pass2").attr("disabled",false);
	}
}