<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List</title>
</head>
<body>
<h1>Todo LIST</h1>

<ul>
<li><a href="${pageContext.request.contextPath}/todo/read?no=1">1. 청소</a> 2023-05-01 DONE</li>
<li><a href="${pageContext.request.contextPath}/todo/read?no=2">2. 청소</a> 2023-05-01 DONE</li>
<li><a href="${pageContext.request.contextPath}/todo/read?no=3">3. 청소</a> 2023-05-01 DONE</li>
<li><a href="${pageContext.request.contextPath}/todo/read?no=4">4. 청소</a> 2023-05-01 DONE</li>



</ul>

<div>
${todoList}
</div>

<a href="${pageContext.request.contextPath}/todo/register">Todo Register</a>
</body>
</html>