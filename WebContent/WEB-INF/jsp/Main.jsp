<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="model.User,model.Mutter,java.util.List" %>
<% User loginUser= (User) session.getAttribute("loginuser"); %>
<% List<Mutter> list = (List<Mutter>)application.getAttribute("mutterlist"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>つぶやき入力
<form action = "/dokotsubu/Main" method="post">
<p>つぶやき：<input type = "text" name = "text"><br></p>
<input type="submit" value="投稿"><input type="submit" value="更新">

</form>
<% for(Mutter mutter : list) { %>
	<%= mutter.GetName() %> : <%= mutter.GetText() %><br>
<%
    }
%>

</body>
</html>