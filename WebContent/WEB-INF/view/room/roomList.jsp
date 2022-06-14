<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="./css/JM.css">
<head>
<meta charset="UTF-8">
<title>roomList.jsp</title>
</head>
<body>
	<%@ include file="../../include/header.jsp"%>
	<div class="main_container">
		<div class="main_subContainer_A">a</div>
		<c:forEach var="rooms" items="${rooms}">
			<div class="main_subContainer_C_left">
				<div>
					<div>
						<a href="roomDetail.do?no=${rooms.no}&room_num=${rooms.room_num}">${rooms.no }</a>
					</div>
					<div>${rooms.room_num }</div>
					<div>${rooms.room_title }</div>
					<div>${rooms.max }</div>
					<div>${rooms.adult_cost }</div>
					<div>${rooms.child_cost }</div>
					<div>${rooms.explanation }</div>
					<div>${rooms.images }</div>
					<div>${rooms.color_code }</div>
					<div>${rooms.delete_flag }</div>
					<div>${rooms.created_at }</div>
					<div>${rooms.updated_at }</div>
				</div>
			</div>
			<div class="main_subContainer_C_right">
				<input type="button"
					onClick="location.href='calenderForUser.do?no=${rooms.no}&room_num=${rooms.room_num}'"
					value="予約する">
			</div>
		</c:forEach>
	</div>
	<%@ include file="../../include/footer.jsp"%>
</body>
</html>