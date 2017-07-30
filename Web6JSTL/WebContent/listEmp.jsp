<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					<c:forEach items="${employees }" var="emp" varStatus="s">
						<tr class="row${s.index % 2 + 1 }">
						<td>${emp.id }</td>
						<td>${emp.name }</td>
						<td>￥${emp.salary }</td>
						<td>${emp.age }</td>
						<td><a href="del.do?id=${emp.id }"
							onclick="return confirm('确定删除${emp.name }吗？')">删除</a>&nbsp;
							<a href="modify.do?id=${emp.id }">修改</a></td>
					</tr>
					</c:forEach>
				</table>
				<h2>
					<c:choose>
						<c:when test="${page > 1 }">
							<a href="list.do?page=${page - 1 }">上一页</a>
						</c:when>
						<c:otherwise>
							上一页
						</c:otherwise>
					</c:choose>
					
					第${page }页
					<c:choose>
						<c:when test="${page < totalPages }">
							<a href="list.do?page=${page + 1 }">下一页</a>
						</c:when>
						<c:otherwise>
							下一页
						</c:otherwise>
					</c:choose>
					
					总共${totalPages }页
				</h2>
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