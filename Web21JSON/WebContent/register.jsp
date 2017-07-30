<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.tips
	{
		color: red;
	}
</style>
<script type="text/javascript" src="js/my.js"></script>
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript">
	function getBrowserType(){
		if(navigator.userAgent.indexOf("FireFox") != -1){
			return "firefox";
		}else{
			return "other";
		}
	}
</script>
<script type="text/javascript">
	function check_username() {
		//1、用户名是否为空
		$("username_msg").innerHTML = "";
		if($F("username").strip().length == 0){
			$("username_msg").innerHTML = "用户名不能为空";
			return false;
		}
		
		//2、检查用户名是否被占用
		var flag = false;
		var xhr = getXhr();
		xhr.open("post", "check_username.do", false);
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				var txt = xhr.responseText;
				if(txt == "ok"){
					$("username_msg").innerHTML = "用户名可以使用";
					flag = true;
				}else{
					$("username_msg").innerHTML = "用户名被占用";
					flag = false;
				}
			}
		}
		xhr.send("username=" + $F("username"));
		
		return flag;
	}
	
	function beforeSubmit(){
		var flag = check_username();
		
	}
</script>
</head>
<body>
	<form action="register.do" method="post" onsubmit="return beforeSubmit();">
		<fieldset>
			<legend>注册</legend>
			用户名:<input name="username" id="username" onblur="check_username();"/>
			<span class="tips" id="username_msg"></span><br/>
			真实姓名:<input name="name" id="name" /><br/>
			<input type="submit" value="提交" />
		</fieldset>
	</form>
</body>
</html>