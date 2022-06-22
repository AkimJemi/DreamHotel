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
	border: 5px solid;
}

.container_right {
	display: inline-block;
	width: 30%;
	height: 100%;
	border: 2px solid;
}

.container_right_top {
	width: 100%;
	height: 30%;
	border: 2px solid;
	text-align: center;
	padding: 10%;
}

.container_right_bottom {
	padding: 10%;
	text-align: center;
	width: 100%;
	height: 70%;
	border: 2px solid;
}

.container_center {
	display: inline-block;
	width: 70%;
	height: 100%;
	border: 2px solid;
}

.container_center_top {
	width: 100%;
	height: 10%;
	border: 2px solid;
}

.container_center_center {
	width: 100%;
	height: 80%;
	border: 2px solid;
}

.container_center_bottom {
	width: 100%;
	height: 10%;
	border: 2px solid;
}

table {
	width: 100%;
}
</style>
</head>
<body>
	<%@ include file="../../include/header.jsp"%>
	<div class="container_main">
		<div class="container_right">
			<div class="container_right_top">1</div>
			<div class="container_right_bottom">2</div>
		</div>
		<div class="container_center">
			<div class="container_center_top"></div>
			<div class="container_center_center">
				<c:forEach var="notice" items="${noticeList }">
				</c:forEach>
				<table>
					<tr>
						<th>no</th>
						<th>title</th>
						<th>contents</th>
						<th>created_at</th>
					</tr>
					<tr>
						<td>Row 1: Col 1</td>
						<td>Row 1: Col 2</td>
						<td>Row 1: Col 2</td>
						<td>Row 1: Col 2</td>
					</tr>
				</table>
			</div>
			<div class="container_center_bottom"></div>
		</div>
	</div>
</body>
</html>