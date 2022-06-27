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
			NAME : <input type="text" name="name" class="border-2">
		</h1>
		<h1>
			PHONE : <input type="text" name="phone" class="border-2">
		</h1>
		<input type="submit" value="ログイン" class="btn-header-admin-open border border-indigo-500 bg-indigo-500 text-white rounded-md px-4 py-2 m-2 transition duration-500 ease select-none hover:bg-indigo-600 focus:outline-none focus:shadow-outline"/>
		
		
	</form>
</body>
</html>