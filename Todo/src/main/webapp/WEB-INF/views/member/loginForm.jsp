22 lines (19 sloc)  529 Bytes
 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>로그인    ${cookie.reid.value}  </h1>
<hr>
<form method="post">
ID : <input name="mid" value="${cookie.reid.value}"> <br>
PW : <input type="password" name="pw"> <br>
<input type="checkbox" name="reid" ${cookie.reid ne null ? 'checked' : ''} > ID 기억하기 <br>
<input type="submit" value="로그인">
</form>


</body>
</html>