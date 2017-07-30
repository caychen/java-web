<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.User" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = new User();
		user.setName("张三");
		user.setAge(20);
		request.setAttribute("user", user);
		
		User user1 = new User();
		user1.setName("李四");
		user1.setAge(22);
		session.setAttribute("user", user1);
	%>
	
	name:<%
		//User user1 = (User)request.getAttribute("user");
		//out.println(user1.getName());
	%><br/>
	
	name:${user.name }<br/>
	name:${sessionScope.user.name }
</body>
</html>