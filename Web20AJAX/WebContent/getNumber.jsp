<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/my.js"></script>
<script type="text/javascript">
	function getNumber(){
		var xhr = getXhr();
		xhr.open("get", "getNumber.do", true);
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4){
				$("div").innerHTML = xhr.responseText;
			}
		}
		xhr.send(null);
	}
</script>
</head>
<body>
	<a href="javascript:;" onclick="getNumber();">显示随机数</a>
	<br/>
	<div id="div">
		
	</div>
</body>
</html>