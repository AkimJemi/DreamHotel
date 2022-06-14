<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/JM.css">
<meta charset="UTF-8">
<title>guestInfoInsert.jsp</title>
<script type="text/javascript">
	function fnCalCount(type, ths) {
		var $input = $(ths).parent("div").find("input[id='a']");
		var tCount = Number($input.val());

		if (type == 'p') {
			$input.val(Number(tCount) + 1);

		} else {
			$input.val(Number(tCount) - 1);
		}
	}
</script>
</head>
<body>
	<%@ include file="../../include/header.jsp"%>
	<form name="bookOption" action="guestInfoInsert.do" method="post">
		<input type="hidden" value="${no}" name="no"> <input
			type="hidden" value="${room_num}" name="room_num"> <input
			type="hidden" value="${option1}" name="option1"> <input
			type="hidden" value="${option2}" name="option2"> <input
			type="hidden" value="${option3}" name="option3"> <input
			type="hidden" value="${optionText}" name="optionText"> <input
			type="hidden" value="${item1}" name="item1"> <input
			type="hidden" value="${item2}" name="item2"> <input
			type="hidden" value="${item3}" name="item3">


		<div class="main_container">
			<div class="main_subContainer_A">
				<h1>予約情報の入力</h1>
			</div>
			<div class="main_subContainer_C_left">
				<div>
					<div>
						お客様情報＊<input type="text" name="name" required>
					</div>
					<div>
						お問い合わせ＊<input type="text" name="phone" required>
					</div>
					<div>
						開始日 ＊<input type="date" name="start_date" required>
					</div>
					<div>
						終了日 ＊ <input type="date" name="end_date" required>
					</div>
					<div>
						泊 ＊ <input type="text" name="name" required>
					</div>
					<div>
						大人 ＊<input type="button" value="+" onclick="fnCalCount('p',this)">
						<input type="text" id="a" name="adult" value="0" readonly>
						<input type="button" value="-" onclick="fnCalCount('m', this)">
					</div>
					<div>
						小人 ＊ <input type="button" value="+" onclick="fnCalCount('p',this)">
						<input type="text" id="a" name="child" value="0" readonly>
						<input type="button" value="-" onclick="fnCalCount('m', this)">
					</div>
				</div>
			</div>
			<div class="main_subContainer_C_right">
				<div>クレジットカード情報</div>
				<div>
					<div>
						銀行名 ＊<input type="text" name="bank_name" required>
					</div>
					<div>
						支店番号 ＊<input type="text" name="bank_branch_code" required>
					</div>
					<div>
						支店番号 ＊<input type="text" name="bank_account_number" required>
					</div>
					<div>※お客様のクレジットカード情報は、 滞在によるギャランティー以外のいかなる目的でも使用されません。チェックカード
						(デビットカード）及び一部のクレジットカードはご利用できない場合もございます。 ※オンライン予約時にお支払いが完了しませんので、
						最終的な支払いはホテルフロントにてお支払いください。</div>
					<div>合計料金表（VAT込み） ￥${total_cost }</div>
					<div>
						<input type="submit" value="確認"><input type="button"
							value="戻る" onClick="history.back()">
					</div>
				</div>
			</div>
		</div>
	</form>
	<%@ include file="../../include/footer.jsp"%>
</body>
</html>