<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/my.js"></script>
<script type="text/javascript" src="js/myjs.js"></script>
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript">
	/*function loadBody(){
		setInterval(function() {
			var xhr = getXhr();
			xhr.open("get", "quoto.do", true);
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4){
					var txt = xhr.responseText;
					//将json字符串转换成javascript组成的数组
					var arr = txt.evalJSON();
					
					//将数组中的数组取出来，添加到tbody
					var html = "";
					for(var i = 0;i < arr.length;++i){
						html += "<tr>" +
								"<td>" + arr[i].name + "</td>" + 
								"<td>" + arr[i].code + "</td>" +
								"<td>" + arr[i].price + "</td>" +
								"</tr>";
					}
					$("tb1").innerHTML = html;
				}
				
			}
			xhr.send(null);
		}, 3000);
	}*/

</script>
</head>
<body onload="loadBody();">
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