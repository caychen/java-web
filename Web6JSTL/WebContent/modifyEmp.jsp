<%@page import="entity.Employee"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Modify Emp</title>
		<link rel="stylesheet" type="text/css"  href="./css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<%@ include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						修改员工
					</h1>
					
					<form action="comfirm.do?id=${employee.id }" method="post">
						<table cellpadding="0" cellspacing="0" border="1"
							class="form_table">
							<tr>
								<td valign="middle" align="right">ID:
								</td>
								<td valign="middle" align="left">
									${employee.id }
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="${employee.name }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">薪水:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="${employee.salary }"/>
								</td>
							</tr>	
							<tr>
								<td valign="middle" align="right">年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="${employee.age }"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确认" />
						</p>
					</form>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>