<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;font-style:italic;">
	hello<br/>
	<img src="../CheckCode2" id="img1" onclick="this.src='../CheckCode2?' + Math.random();"/>
	<!--加入问号，是为了欺骗浏览器，通知浏览器访问了另外一个页面 -->
	<a href="javascript:;" onclick="document.getElementById('img1').src='../CheckCode2?' + Math.random();">刷新</a>
</body>
</html>