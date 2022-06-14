<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookOption.jsp</title>
<link rel="stylesheet" type="text/css" href="./css/JM.css">
<style type="text/css">
.main_subContainer_B_1 {
	display: flex;
}
</style>
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
	<form name="bookOption" action="guestInfoInsert.do">
		<input type="hidden" value="${no}" name="no"> <input
			type="hidden" value="${room_num}" name="room_num"> 
			<input type="hidden" value="${book.start_date }" name="start_date" />
			<input type="hidden" value="${book.start_date }" name="start_date" />
			<input type="hidden" value="${book.start_date }" name="start_date" />
		<div class="main_container">
			<div class="main_subContainer_A">
				<h1>客室オプション</h1>
			</div>
			<div class="main_subContainer_C_left">
				<div>
					<div>オプション事項</div>
					<div>
						大人の朝食 / ￥4,545<input type="button" value="+"
							onclick="fnCalCount('p',this)"> <input type="text" id="a"
							name="option1" value="0" readonly> <input type="button"
							value="-" onclick="fnCalCount('m', this)">
					</div>
					<div>
						エキストラベッド / ￥3,300<input type="button" value="+"
							onclick="fnCalCount('p',this)"> <input type="text" id="a"
							name="option2" value="0" readonly> <input type="button"
							value="-" onclick="fnCalCount('m', this)">
					</div>
					<div>
						お子様の朝食 / ￥3,181 <input type="button" value="+"
							onclick="fnCalCount('p',this)"> <input type="text" id="a"
							name="option3" value="0" readonly> <input type="button"
							value="-" onclick="fnCalCount('m', this)">
					</div>
					<div>
						<br />
					</div>
					<div>*上記の料金にVAT 10％が加算されます。</div>
					<div>*上記の朝食料金は大人の宿泊客に限り割引料金で提供しております。</div>
					<div>＊チェックイン後に追加で申し込みの場合は通常料金の7,000￥でご利用いただけます。</div>
					<div>*大人基準：13歳以上、お子様基準：37か月以上12歳以下</div>
					<div>*朝食を含むパッケージを予約される場合、追加人数の朝食のみをお選びください。</div>
					<div>*37ヶ月未満のお子様は、朝食は無料です。</div>
				</div>
			</div>
			<div class="main_subContainer_C_right">
				<div>追加要求事項</div>
				<div>
					<textarea rows="7" cols="70" name="optionText"></textarea>
				</div>
				<div>*特殊文字または絵文字の使用が制限されますので、テキストのみを</div>
				<div>入力してください。</div>
				<div>*ビューは、チェックイン当日の都合によりご希望に添えない場合が</div>
				<div>ございますので、</div>
				<div>
					<input type="submit" value="確認"><input type="button"
						value="戻る" onClick="history.back()">
				</div>

			</div>
		</div>
	</form>
	<%@ include file="../../include/footer.jsp"%>
</body>
</html>