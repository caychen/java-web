<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<title>Login User</title>
</head>
<body>
<div id="wrap">
		<div id="top_content">
			<%@ include file="header.jsp"%>
			<div id="content">
				<p id="whereami"></p>
				<h1>登录</h1>
				<form action="login.do" method="post">
					<table cellpadding="0" cellspacing="0" border="0" class="form_table">
						<tr>
							<td valign="middle" align="right">用户名：</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="username" />
								<%
									String error_msg = (String)request.getAttribute("login_error");
								%>
								<span style="color:red;">
									<%=(error_msg == null ? "" : error_msg) %>
								</span>
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">密码：</td>
							<td valign="middle" align="left">
								<input type="password" class="inputgri" name="pwd" />
							</td>
						</tr>
						<tr>
							<td>验证码</td>
							<td>
								<input type="text"  name="number" />
								<span style="color:red;">
									<%
										String check_error = (String)request.getAttribute("check_error");
									%>
									<%=(check_error == null ? "" : check_error) %>
								</span>
							</td>
						</tr>
						<tr>
							<td><img src="../CheckCode" id="img1" onclick="this.src='../CheckCode?' + Math.random();"/></td>
							<td>
								<a href="javascript:;" onclick="document.getElementById('img1').src='../CheckCode?' + Math.random();">刷新</a>
							</td>
						</tr>
					</table>
					<p>
						<input type="submit" class="button" value="确定" />
					</p>
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>