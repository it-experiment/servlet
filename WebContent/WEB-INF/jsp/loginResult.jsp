<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ page import="model.User"  %>
<% User seccess=(User) session.getAttribute("loginuser"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(seccess!=null){ %>
<p><h1>ようこそ！どこつぶへ</h1><br>
<p><%=seccess.GetName() %>さん<br>
<a href="/dokotsubu/Main">つぶやき閲覧へ</a>
<% } %>
</body>
</html>