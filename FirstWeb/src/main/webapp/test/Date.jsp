<%@page import = "java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Date now = new Date();
    String name = "제니";
    out.println(name);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재 시간</title>
</head>
<body>
<h3>현재 시각 : <%=now %></h3>
<h3><%=name %></h3>

</body>
</html>