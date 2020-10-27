$(function(){
	
	$('#switch_qlogin').click(function(){
		$('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_bottom').animate({left:'0px',width:'72px'});
		$('#qlogin').css('display','none');
		$('#web_qr_login').css('display','block');
		
		});
	$('#switch_login').click(function(){
		
		$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_bottom').animate({left:'162px',width:'72px'});
		
		$('#qlogin').css('display','block');
		$('#web_qr_login').css('display','none');
		});
if(getParam("a")=='0')
{
	$('#switch_login').trigger('click');
}

	});
	
function logintab(){
	scrollTo(0);
	$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
	$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
	$('#switch_bottom').animate({left:'154px',width:'96px'});
	$('#qlogin').css('display','none');
	$('#web_qr_login').css('display','block');
	
}
function tab01(){
	if ($('#user').val() == "") {
		$('#user').focus().css({
			border: "1px solid red",
			boxShadow: "0 0 2px red"
		});
		$('#userCue').html("<font color='red'><b>×帳號不能为空</b></font>");
		return false;
	}
	if ($('#user').val().length < 4 || $('#user').val().length > 16) {

		$('#user').focus().css({
			border: "1px solid red",
			boxShadow: "0 0 2px red"
		});
		$('#userCue').html("<font color='red'><b>×帳號爲4-16字符</b></font>");
		return false;

	}
/*	$.ajax({
		type:'POST',
		url:"user",
		data: "uid=" + $("#user").val(),
		dataType: 'json',
		success: function(result) {
			if (result.ts=="NO" ) {
				$('#user').focus().css({
					border: "1px solid red",
					boxShadow: "0 0 2px red"
				});
				$("#userCue").html("<font color='red'><b>×帳號已經注冊</b></font>");
				return false;
			} else {
				$('#user').css({
					border: "1px solid #D7D7D7",
					boxShadow: "none"
				});
			$("#userCue").html("<font color='green'><b>×帳號驗證通過</b></font>");
			}

		}
	});*/
}
function tab02(){
	//alert(tab01);
	var sqq = /^[_0-9a-z]{6,}$/i;
	if (!sqq.test($('#passwd').val()) || $('#passwd').val().length < 5 || $('#passwd').val().length > 12) {
		$('#passwd').focus().css({
			border: "1px solid red",
			boxShadow: "0 0 2px red"
		});
		$('#userCue').html("<font color='red'><b>×至少６位字母或者數字或_組成混合密碼</b></font>");return false;
	} else {
		$('#passwd').css({
			border: "1px solid #D7D7D7",
			boxShadow: "none"
		});
		
	}
}

function tab03(){
	var sqq = /^[_0-9a-z]{6,}$/i;
	if (!sqq.test($('#passwd2').val()) || $('#passwd2').val().length < 6) {
		$('#passwd2').focus().css({
			border: "1px solid red",
			boxShadow: "0 0 2px red"
		});
		$('#userCue').html("<font color='red'><b>×至少６位字母或者數字或_組成混合密碼</b></font>");return false;
	} else {
		$('#passwd2').css({
			border: "1px solid #D7D7D7",
			boxShadow: "none"
		});
		
	}
	if ($('#passwd2').val() != $('#passwd').val()) {
		$('#passwd').focus().css({
			border: "1px solid red",
			boxShadow: "0 0 2px red"
		});
		$('#userCue').html("<font color='red'><b>×两次密码不一致！</b></font>");
		return false;
	}else{
		$("#userCue").html("<font color='green'><b>×密碼驗證通過</b></font>");
	}
}
//根据参数名获得该参数 pname等于想要的参数名 
function getParam(pname) { 
    var params = location.search.substr(1); // 获取参数 平且去掉？ 
    var ArrParam = params.split('&'); 
    if (ArrParam.length == 1) { 
        //只有一个参数的情况 
        return params.split('=')[1]; 
    } 
    else { 
         //多个参数参数的情况 
        for (var i = 0; i < ArrParam.length; i++) { 
            if (ArrParam[i].split('=')[0] == pname) { 
                return ArrParam[i].split('=')[1]; 
            } 
        } 
    } 
}  

$(document).ready(function() {


	$('#reg').click(function() {
		if ($('#user').val() == "") {
			$('#user').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×帳號不能为空</b></font>");
			return false;
		}
		if ($('#user').val().length < 4 || $('#user').val().length > 16) {

			$('#user').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×帳號爲4-16字符</b></font>");
			return false;

		}
		if ($('#passwd2').val() != $('#passwd').val()) {
			$('#passwd2').focus();
			$('#userCue').html("<font color='red'><b>×两次密码不一致！</b></font>");
			return false;
		}

		var sqq = /^[_0-9a-z]{6,}$/i;
		if (!sqq.test($('#passwd').val()) || $('#passwd').val().length < 5 || $('#passwd').val().length > 12) {
			$('#passwd').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×至少６位字母或者數字或_組成混合密碼</b></font>");return false;
		} else {
			$('#passwd').css({
				border: "1px solid #D7D7D7",
				boxShadow: "none"
			});
	}
	
	if ($('#passwd2').val() != $('#passwd').val()) {
		$('#passwd2').focus().css({
			border: "1px solid red",
			boxShadow: "0 0 2px red"
		});
		$('#userCue').html("<font color='red'><b>×两次密码不一致！</b></font>");
		return false;
	}
	
	if ($('#yourebei').val().length < 4) {
		$('#yourebei').focus().css({
			border: "1px solid red",
			boxShadow: "0 0 2px red"
		});
		$('#userCue').html("<font color='red'><b>×備註信息不詳細</b></font>");
		return false;
	}
	$('#regUser').submit();
});
});