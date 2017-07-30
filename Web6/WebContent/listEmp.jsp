<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="dao.*,entity.*,java.util.*,Utils.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<title>List Emp</title>
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<%@ include file="header.jsp"%>
			<div id="content">
				<p id="whereami"></p>
				<h1>员工列表</h1>
				<table class="table1">
					<tr class="table_header">
						<td>ID</td>
						<td>姓名</td>
						<td>薪水</td>
						<td>年龄</td>
						<td>操作</td>
					</tr>
					<%
							//step4、通过request获得转发绑定的数据
							List<Employee> employees = (List<Employee>)request.getAttribute("employees");
							
							for(int i = 0;i < employees.size(); ++i)
							{
								Employee emp = employees.get(i);
						%>
					<tr class="row<%=(i % 2 + 1) %>>">
						<td><%=emp.getId()%></td>
						<td><%=emp.getName()%></td>
						<td>￥<%=emp.getSalary() %></td>
						<td><%=emp.getAge() %></td>
						<td><a href="del.do?id=<%=emp.getId() %>"
							onclick="return confirm('确定删除<%=emp.getName()%>吗？')">删除</a>&nbsp;
							<a href="modify.do?id=<%=emp.getId()%>">修改</a></td>
					</tr>
					<%
							}
						 %>
				</table>
				<p>
					<input type="button" class="button" value="添加员工"
						onclick="location='addEmp.jsp'" />
				</p>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>