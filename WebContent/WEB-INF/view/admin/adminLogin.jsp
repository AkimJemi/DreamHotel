<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPage.jsp</title>
</head>
<body>
	<%@ include file="../../include/header.jsp"%>
	<h1>${loginedName }様お歓迎致します。</h1>
	<form action="adminPage.do" method="post">
		<h1>
			Code : <input type="text" name="adminCode">
		</h1>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>