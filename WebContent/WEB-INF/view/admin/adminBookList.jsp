<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminBookList.jsp</title>
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

.paging_css {
	margin-top: 30px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.paging_css_inner {
	display: flex;
	text-align: center;
	gap: 20px;
	width: 215px;
}
</style>
<script type="text/javascript">
	function paymentUpdate(ths,no) {
		if (ths == 'no') {
			if (confirm('お支払いキャンセルしますか？'))
				location.href = 'adminBookList.do?payment=' + ths +'&no=' +no;
		} else if (ths == 'yes')
			if (confirm('お支払い完了しますか？'))
				location.href = 'adminBookList.do?payment=' + ths +'&no=' +no;
	}
	function bookCancel(ths,no) {
		if (ths == 'yes') {
			if (confirm('予約をキャンセルしますか？'))
				location.href = 'adminBookList.do?cancel=' + ths +'&no=' +no;
				
		}else if (ths == 'no') 
			if (confirm('予約を復元しますか？'))
				location.href = 'adminBookList.do?cancel=' + ths +'&no=' +no;
	}
	function searchFunction(){
		alert("dd");
	}
</script>
</head>
<body>
	<%@ include file="../../include/header.jsp"%>
	
	<c:set var="page" value="searchContent=${paging.searchContent }&searchTitle=${paging.searchTitle }"/>
	
	<h1>${loginedName }様お歓迎致します。</h1>
	<form action="adminBookList.do">
		<div class="paging_css">
			<div class="paging_css_inner">
				<input type="hidden" name="currentPage" value="${paging.currentPage }"> <select
					name="searchTitle">
					<option value="0">-</option>
					<option value="1">予約番号</option>
					<option value="2">部屋番号</option>
					<option value="3">姓名</option>
				</select>
				<script type="text/javascript">
				$('select[name="searchTitle"]').val('${paging.searchTitle}');
				</script>
				<input type="text" name="searchContent" value="${paging.searchContent }"
					placeholder="入力してください" /> <input type="submit" value="検索">
			</div>
		</div>
	</form>
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
				<td>キャンセル有無</td>
				<td>キャンセル変更</td>
				<td>お支払い有無</td>
				<td>お支払い変更</td>
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
						<c:when test="${booking.cancel_flag eq 0}">
							<td>x</td>
							<td>
								<button onclick="bookCancel('yes', ${booking.no})">
									<h6>キャンセル</h6>
								</button>
							</td>
						</c:when>
						<c:when test="${booking.cancel_flag eq 2}">
							<td>-</td>
							<td>
								<button onclick="bookCancel('yes', ${booking.no})">
									<h6>キャンセル請求</h6>
								</button>
							</td>
						</c:when>
						<c:otherwise>
							<td>o</td>
							<td>
								<button onclick="bookCancel('no', ${booking.no})">予約復元</button>
							</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${booking.payment_flag eq 0}">
							<td>x</td>
							<td>
								<button onclick="paymentUpdate('yes', ${booking.no})">確認する</button>
							</td>
						</c:when>
						<c:otherwise>
							<td>o</td>
							<td><button onclick="paymentUpdate('no', ${booking.no})">未確認する</button></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="paging_css">
		<div class="paging_css_inner">
			<div>
				<c:if test="${paging.backward}">
					<a href="adminBookList.do?currentPage=${paging.begin-1 }&${page }">前へ</a>
				</c:if>
			</div>
			<c:forEach var="pagingCount" begin="${paging.begin }" end="${paging.end }">
				<div>
					<a href="adminBookList.do?currentPage=${pagingCount}&${page }">${pagingCount}</a>
				</div>
			</c:forEach>
			<div>
				<c:if test="${paging.forward}">
					<a href="adminBookList.do?currentPage=${paging.end+1 }&${page }">次へ</a>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>