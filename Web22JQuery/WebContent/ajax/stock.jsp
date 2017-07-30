<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		setInterval(quoto, 3000);
	});
	
	function quoto(){
		//为了避免IE存在缓存，在get和post方式中选择post请求
		$.post('quoto.do',function(data){
			//$.get/post，$.ajax会自动将服务器返回的字符串转换成js对象
			//data:服务器返回的数据
			
			$('#tb1').empty();//在追加之前先清空
			
			for(var i = 0;i < data.length;++i){
				$('#tb1').append("<tr>" + 
								"<td>" + data[i].name + "</td>" +
								"<td>" + data[i].code + "</td>" +
								"<td>" + data[i].price + "</td>" 
								+ "</tr>");
			}
		}, 'json');
	}
</script>
</head>
<body>
	<div id="d1">
		<div id="d2">股票实时行情</div>
		<div id="d3">
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<thead>
					<tr>
						<td>股票名称</td>
						<td>股票代码</td>
						<td>股票价格</td>
					</tr>
				</thead>
				<tbody id="tb1">

				</tbody>
			</table>
		</div>
	</div>
</body>
</html>