<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<form action="login.do" method="post">
		<h1>
			NAME : <input type="text" name="name">
		</h1>
		<h1>
			PHONE : <input type="text" name="phone">
		</h1>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>