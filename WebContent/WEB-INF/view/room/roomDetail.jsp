<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>roomDetail.jsp</title>
<link rel="stylesheet" type="text/css" href="./css/JM.css">
</head>
<body>
	<%@ include file="../../include/header.jsp"%>
	<div class="main_container">
		<div class="main_subContainer_B_1">
			<div>
				<div>写真${room.images }</div>
				<div>・基準 ：2</div>
				<div>・客室定員、最大 5人 ： ${room.max }</div>
				<div>・大人コスト ： ${room.adult_cost }</div>
				<div>・お子様（満13歲未満）コスト ： ${room.child_cost }</div>
			</div>
		</div>
		<div class="main_subContainer_B_2">
			<div>タイトル ： ${room.room_title }</div>
			<div>${room.explanation }</div>
		</div>
		[${room.room_num}]
		<div class="main_subContainer_B_1">
			<input type="button"
					onClick="location.href='calenderForUser.do?no=${room.no}&room_num=${room.room_num}'"
					value="予約する"> <input type="button"
				value="戻る" onclick="history.back()">
		</div>
		<div class="main_subContainer_B_2">
			<div>キャンセル/返金規定</div>
			<div>予約の取消/変更およびノーショーに関するご案内</div>
			<div>ご宿泊予定日の前日18時までは、違約金なしで取消および変更が可能です。</div>
			<div>ご宿泊予定日の前日18時以降の取消/変更およびノーショー（No-show）の場合は、:</div>
		</div>
		<div class="main_subContainer_C"></div>
	</div>
</body>
</html>