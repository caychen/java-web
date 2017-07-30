<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		margin-left: 200px;
		margin-top: 50px;
	}
	
	.selected{
		background-color: #fff8dc;
	}
</style>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		//要判断浏览器类型
		var event_type = 'input';//IE不支持该事件
		if(navigator.userAgent.indexOf('MSIE') != -1){
			//IE浏览器
			event_type = 'propertychange';
		}
		
		$('#key').bind(event_type,function(){
			$.ajax({
				'url':'search.do',
				'type':'post',
				'data':'key=' + $('#key').val(),
				'dataType':'text',
				'success':function(data){
					//data:返回的数据
					//分解服务器返回的数据，追加到tips中
					$('#tips').empty();
					var arr = data.split(",");
					for(var i = 0;i < arr.length;++i){
						$('#tips').append("<div class='item'>" + arr[i] +"</div>");
					}
					
					//当光标经过提示项时，加亮
					$('.item').mouseenter(function(){
						$(this).addClass('selected').siblings().removeClass('selected');
					});
					
					//当光标点击某个选项时，该选项的值复制到key所在的文本框中
					$('.item').click(function(){
						$('#key').val($(this).text());
						$('#tips').empty();
					});
				},
				'error':function(){
					alert('Warning...');
				}
			});
		});
	});
</script>
</head>
<body>
	<table cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td>
				<input type="text" name="key" id="key"/>
			</td>
			<td>
				<input type="button" value="搜索" id="btn"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="tips"></div>
			</td>
		</tr>
	</table>
</body>
</html>