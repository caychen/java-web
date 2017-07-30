<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/my.js"></script>
<script type="text/javascript">
	function check_username_get() {
		//1、获得ajax对象
		var xhr = getXhr();

		//2、使用ajax对象发送请求
		xhr.open("get", "check_username.do?username=" + $F("username"), true);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				//只有readyState等于4时，ajax对象才能获得服务器返回的数据
				if (xhr.state == 200) {
					var txt = xhr.responseText;
					$("username_msg").innerHTML = txt;
				}
			}
		};
		xhr.send(null);
	}

	function check_username_post() {
		var xhr = getXhr();
		xhr.open('post', "check_username.do", true);

		//添加消息头
		xhr.setRequestHeader("content-type",
				"application/x-www-form-urlencoded");
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4){
				if(xhr.state == 200){
					$("username_msg").innerHTML = xhr.responseText;
				}
			}
		}
		xhr.send("username=" + $F("username"));
	}

	function check_code_get() {
		var xhr = getXhr();
		xhr.open("get", "check_code.do?number=" + $F("number"), true);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.state == 200) {//说明服务器返回数据是正确的
					var txt = xhr.responseText;
					$("codeError").innerHTML = txt;
				} else {//说明服务器运行出错
					$("codeError").innerHTML = "验证出错";
				}
			}
		}
		xhr.send(null);
	}
	
	function check_code_post() {
		var xhr = getXhr();
		xhr.open("post", "check_code.do", true);
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4){
				if(xhr.state == 200){
					$("codeError").innerHTML = xhr.responseText;
				}else{
					$("codeError").innerHTML = "验证出错";
				}
			}
		}
		xhr.send("number=" + $F("number"));
	}
</script>
<style type="text/css">
.tips {
	color: red;
}

a {
	font-size: 30px;
}
</style>
</head>
<body>
	<form action="register.do" method="post">
		<fieldset>
			<legend>用户注册</legend>
			用户名:<input type="text" name="username" id="username"
				onblur="check_username_post();" /> <span class="tips"
				id="username_msg"></span> <br /> 真实姓名:<input type="text"
				name="name" /><br /> 验证码:<input name="number"
				onblur="check_code()_get;" id="number" /><br /> <img src="CheckCode2"
				id="img1" onclick="this.src='CheckCode2?' + Math.random();" /> <a
				href="javascript:;"
				onclick="$('img1').src='CheckCode2?' + Math.random()">刷新</a> <span
				id="codeError"></span> <br /> <input type="submit" value="提交" />
		</fieldset>
	</form>
</body>
</html>