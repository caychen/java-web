<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	tr{
		text-align: center;
	}
</style>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$('a.s1').click(function(){
			var $div = $(this).next();
			if($div.html() == ""){
				var airline = $(this).parent().siblings().eq(0).text();
				$(this).next().load("priceInfo.do", "airline=" + airline);
			}else{
				$(this).next().empty();//清空内容
			}
			
		});
	});
</script>
</head>
<body>
	<table cellpadding="0" cellspacing="0" width="60%" border="1">
		<tr>
			<td>航班号</td>
			<td><a href="#">机型</a></td>
			<td>起飞时间</td>
			<td>到达时间</td>
			<td>&nbsp;</td>
			<td>经济舱价格</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>CA1000</td>
			<td><a href="#">波音777</a></td>
			<td>8:00 am</td>
			<td>10:00 am</td>
			<td>
				<a href="javascript:;" class="s1">显示所有票价</a>
				<div></div>
			</td>
			<td>￥1200</td>
			<td><input type="button" value="订票"/></td>
		</tr>
		<tr>
			<td>MU1494</td>
			<td><a href="#">空客320</a></td>
			<td>18:00 am</td>
			<td>20:00 am</td>
			<td>
				<a href="javascript:;" class="s1">显示所有票价</a>
				<div></div>
			</td>
			<td>￥800</td>
			<td><input type="button" value="订票"/></td>
		</tr>
	</table>
</body>
</html>