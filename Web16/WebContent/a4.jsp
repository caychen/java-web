<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.User,bean.IDCard,java.util.*" %>    
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
		user.setInterests(new String[]{"足球","篮球"});
		IDCard card = new IDCard();
		card.setId("123456");
		user.setCard(card);
		
		request.setAttribute("user", user);
		
	%>
	<%
		request.setAttribute("propname", "name");
	%>
	name:${user["name"] }<br/>

	name:${user[propname] }<br/>
	
	interest:${user["interests"][0] }<br/>
	
	card:${user.card.id }<br/>
	
	<%
		request.setAttribute("str", "");

		List<String> li = new ArrayList<String>();
		request.setAttribute("list", li);
		
		request.setAttribute("abc", null);
	%>
	空字符串：${empty str }<br/><!-- true -->
	空集合：${empty list }<br/><!-- true -->
	null:${empty abc }<br/><!-- true -->
	找不到值：${empty zzz }<br/><!-- true -->
</body>
</html>