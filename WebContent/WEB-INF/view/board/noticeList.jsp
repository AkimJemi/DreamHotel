<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeList.jsp</title>
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
				<table>
					<tr>
						<th>no</th>
						<th>title</th>
						<th>contents</th>
						<th>created_at</th>
					</tr>
					<c:forEach var="notice" items="${noticeList }">
						<tr>
							<td><a href="noticeDetail.do?no=${notice.no }">${notice.no }</a></td>
							<td>${notice.title }</td>
							<td>${notice.contents }</td>
							<td>${notice.created_at }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="container_center_bottom"></div>
		</div>
	</div>
</body>
</html>