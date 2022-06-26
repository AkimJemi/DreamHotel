<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../include/header.jsp"%>
<meta charset="UTF-8">
<title>myPage.jsp</title>
</head>
<body>
	
	<h1>${loginedName }様お歓迎致します。</h1>
	<form action="adminPage.do" method="post">
		<h1>
			Code : <input type="text" name="adminCode">
		</h1>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>