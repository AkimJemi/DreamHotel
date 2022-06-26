<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../include/header.jsp"%>
<meta charset="UTF-8">
<title>adminRoomList.jsp</title>
<style type="text/css">
table {
	border-collapse: separate;
	border-spacing: 0 15px;
}

td {
	width: 150px;
	text-align: center;
	border: 1px solid black;
	padding: 5px;
}
</style>
</head>
<body>

	<h1>${loginedName }様お歓迎致します。</h1>
	<table>
		<thead>
			<tr>
				<td>no</td>
				<td>room_no</td>
				<td>name</td>
				<td>phone</td>
				<td>adult</td>
				<td>child</td>
				<td>option1</td>
				<td>option2</td>
				<td>option3</td>
				<td>total_cost</td>
				<td>start_date</td>
				<td>end_date</td>
				<td>bank_name</td>
				<td>bank_branch_code</td>
				<td>bank_account_number</td>
				<td>created_at</td>
				<td>updated_at</td>
				<td>delete_flag</td>
				<td>payment_flag</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="booking" items="${bookings }">
				<tr>
					<td>${booking.no}</td>
					<td>${booking.room_no}</td>
					<td>${booking.name}</td>
					<td>${booking.phone}</td>
					<td>${booking.adult}</td>
					<td>${booking.child}</td>
					<td>${booking.option1}</td>
					<td>${booking.option2}</td>
					<td>${booking.option3}</td>
					<td>${booking.total_cost}</td>
					<td>${booking.start_date}</td>
					<td>${booking.end_date}</td>
					<td>${booking.bank_name}</td>
					<td>${booking.bank_branch_code}</td>
					<td>${booking.bank_account_number}</td>
					<td>${booking.created_at}</td>
					<td>${booking.updated_at}</td>
					<c:choose>
						<c:when test="${booking.delete_flag eq 0}">
							<td>キャンセル</td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${booking.payment_flag eq 0}">
							<td></td>
						</c:when>
						<c:otherwise>
							<td>お支払い完了</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>