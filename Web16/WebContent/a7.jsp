<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,bean.Person" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	.row1
	{
		background-color:#fff8dc;
	}
	.row2
	{
		background-color:yellow;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<%
		
	%>
	<table width="60%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>姓名</td>
			<td>性别</td>
			<td>index</td>
			<td>count</td>
		</tr>
		<c:forEach items="${persons }" var="p" varStatus="s">
			<tr class="row${s.index % 2 + 1 }">
				<td>${p.name }</td>
				<td>
					<c:choose>
						<c:when test="${p.gender == 'm' }">男</c:when>
						<c:otherwise>女</c:otherwise>
					</c:choose>
				</td>
				<td>${s.index }</td>
				<td>${s.count }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>