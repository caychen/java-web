<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dao.*,entity.*,java.util.*,Utils.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css"  href="css/style.css" />
		<title>empList</title>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<div id="header">
					<div id="rightheader">
						<p>
							<%
								Date date = new Date();
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
								out.println(sdf.format(date));
								%>
							<br/>
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						员工列表
					</h1>
					<table class="table1">
						<tr class="table_header">
							<td>ID</td>
							<td>姓名</td>
							<td>薪水</td>
							<td>年龄</td>
							<td>操作</td>
						</tr>
						<%
							EmployeeDAO dao = (EmployeeDAO)Factory.getInstance("EmployeeDAO");
							List<Employee> employees = dao.findAll();
							
							for(int i = 0;i < employees.size(); ++i)
							{
								Employee emp = employees.get(i);
						%>
								<tr class="row<%=(i % 2 + 1) %>>">
									<td><%=emp.getId()%></td>
									<td><%=emp.getName()%></td>
									<td>￥<%=emp.getSalary() %></td>
									<td><%=emp.getAge() %></td>
									<td><a href="">删除</a>&nbsp;<a href="">修改</a></td>
								</tr>
						<%
							}
						 %>
					</table>
					<p>
						<input type="button" class="button" value="添加员工" 
							onclick="location='addEmp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>