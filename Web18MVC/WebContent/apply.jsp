<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;font-style:italic;">
	<span style="color:red;">${apply_error }</span>
	<form action="apply.do" method="post">
		<fieldset>
			<legend>申请贷款</legend>
			帐号:<input name="accountNo" /><br/>
			金额:<input name="amount" /><br/>
			<input type="submit" value="提交"/>
		</fieldset>
	</form>
</body>
</html>