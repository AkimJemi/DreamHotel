<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPage.jsp</title>
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

button {
	width: 100px;
	height: 30px;
}
</style>
<script type="text/javascript">
function userBookCancel(ths,no) {
	if (ths == 'do') {
		if (confirm('予約をキャンセルしますか？'))
			location.href = 'myPage.do?cancel=' + ths +'&no=' +no;
			
	}else if (ths == 'no') 
		if (confirm('予約を復元しますか？'))
			location.href = 'myPage.do?cancel=' + ths +'&no=' +no;
}
</script>
</head>
<body>
	<%@ include file="../../include/header.jsp"%>
	<h1>${loginedName }様お歓迎致します。</h1>
	<table>
		<thead>
			<tr>
				<td>予約番号</td>
				<td>部屋番号</td>
				<td>姓名</td>
				<td>携帯電話</td>
				<td>大人</td>
				<td>小人</td>
				<td>大人の朝食</td>
				<td>エキストラベッド</td>
				<td>お子様の朝食</td>
				<td>総コスト</td>
				<td>開始日</td>
				<td>終了日</td>
				<td>銀行名</td>
				<td>支店番号</td>
				<td>口座番号</td>
				<td>登録日付</td>
				<td>更新日付</td>
				<td>キャンセル</td>
				<td>お支払い</td>
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
						<c:when test="${booking.cancel_flag eq 1}">
							<td>キャンセル完了</td>
						</c:when>
						<c:when test="${booking.cancel_flag eq 2}">
							<td>キャンセル確認中</td>
						</c:when>
						<c:otherwise>
							<td>
								<button onclick="userBookCancel('do', ${booking.no})">キャンセル</button>
							</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${booking.payment_flag eq 0}">
							<td>確認中</td>
						</c:when>
						<c:otherwise>
							<td>完了</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>