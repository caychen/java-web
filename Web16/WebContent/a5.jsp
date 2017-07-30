<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.Person" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Person p = new Person();
		p.setName("张三");
		p.setGender("m");
		request.setAttribute("p", p);
	%>
	姓名：${p.name }<br/>
	性别：
	<c:if test="${p.gender == 'm'}">男</c:if>
	<c:if test="${p.gender == 'f'}">女</c:if>
	
	<br/>
	性别：<c:if test="${p.gender == 'm' }" var="rs"
		scope="request">男</c:if>
		<c:if test="${!rs }">女</c:if>
	
</body>
</html>