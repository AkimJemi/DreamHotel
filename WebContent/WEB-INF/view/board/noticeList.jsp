<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeList.jsp</title>
<style>
.container_main {
	margin: auto;
	display: flex;
	width: 80%;
	height: 800px;
	background-color: red;
	height: 800px;
	display: flex;
}

.container_right {
	display: inline-block;
	width: 30%;
	height: 100%;
	background-color: blue;
	width: 30%;
}

.container_center {
	display: inline-block;
	width: 70%;
	height: 100%;
}

.container_center_top {
	width: 100%;
	height: 50%;
	background-color: yellow;
}

.container_center_bottom {
	width: 100%;
	height: 50%;
	background-color: gray;
}
</style>
</head>
<body>
	<%@ include file="../../include/header.jsp"%>
	<div class="container_main">
		<div class="container_right"></div>
		<div class="container_center">
			<div class="container_center_top"></div>
			<div class="container_center_bottom"></div>
		</div>
	</div>
</body>
</html>