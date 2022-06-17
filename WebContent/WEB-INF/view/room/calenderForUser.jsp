<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="book.model.Booking"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset='utf-8' />
<style type="text/css">
.ForCalender {
	height: 700px;
	width: 700px;
}
</style>
<link href='fullcalendar/main.css' rel='stylesheet' />
<script src='fullcalendar/main.js'></script>
<%
	ArrayList<Booking> bookList = (ArrayList<Booking>) request.getAttribute("books");
%>
<script>
var calender =null;
var title = null;
var no = ${no};
var room_num = ${room_num};
var room_title = '${room_title}';
var select_info_str = null;
var select_info_end = null;

var click_info_str = null;
var click_info_end = null;
var click_info_str_pre = null;
var click_info_end_pre = null;
var str_sub=null;
var str_sub_pre=null;
var end_sub=null;
var end_sub_pre=null;
var size = null;
var size_pre = null;
var intr=null;
var result = null;
	document
			.addEventListener(
					'DOMContentLoaded',
					function() {
						var calendarEl = document.getElementById('calendar');
						calendar = new FullCalendar.Calendar(
								calendarEl,
								{
									initialView : 'dayGridMonth',
									locale: 'ja',
									selectable: true,
									headerToolbar : {
										center : 'addEventButton'
									},
									dateClick: function(info) {
										if(click_info_str == null && click_info_end == null){
											click_info_str = info.dateStr;
											click_info_str_pre = click_info_str;
											$('td').find("[data-date='"+click_info_str+"']").css("background-color","blue");
										}else if(click_info_str != null && click_info_end == null){
											if(click_info_str ==info.dateStr){
												return;
											}
											click_info_end = info.dateStr;
											str_sub = click_info_str.substring(8,10);
											end_sub = parseInt(click_info_end.substring(8,10))+1;
											if((end_sub+"").length == 1){
												end_sub = "0"+end_sub;
											}
											if(str_sub>end_sub){
												intr =end_sub;
												end_sub=str_sub;
												str_sub=intr;
												intr =click_info_end;
												click_info_end = click_info_str;
												click_info_str = intr;
											}
											checkDateAvailable(click_info_str, click_info_end);
											if(result == "no"){
												str_sub =str_sub_pre;
												end_sub = end_sub_pre;
												click_info_end = click_info_end_pre;
												click_info_str = click_info_str_pre
												alert("no");
												return;
											}else{
											click_info = click_info_str.substring(0,8);
											size = end_sub-str_sub;
											
											click_info_end_pre = click_info_end;
											str_sub_pre=str_sub;
											end_sub_pre=end_sub;
											click_info_pre = click_info;
											size_pre = size;
											
											for(var i = 0; i<=size;i++){
												$('td').find("[data-date='"+click_info+ str_sub+"']").css("background-color","blue");
												str_sub++;
												str_sub = str_sub + "";
												
													if(str_sub.length==1){
													str_sub = "0" +str_sub;
													};
												};
											alert("yes");
											
											};
										}else if(click_info_str != null && click_info_end != null){
											if(str_sub_pre>end_sub_pre){
												intr= end_sub_pre;
												end_sub_pre=str_sub_pre;
												str_sub_pre=intr;
											}
												
											for(var i = 0; i<=size_pre;i++){
												$('td').find("[data-date='"+click_info_pre+str_sub_pre+"']").css("background-color","white");
													str_sub_pre++;
													str_sub_pre = str_sub_pre + "";
													if(str_sub_pre.length==1){
														str_sub_pre = "0" +str_sub_pre;
													};
												};
											click_info_str = info.dateStr;
											$('td').find("[data-date='"+click_info_str+"']").css("background-color","blue");
											click_info_str_pre = click_info_str;
											click_info_end= null;
											click_info_end_pre = click_info_end;
										  }
										
									},
									events : [
										<%int i = 0;
for (i = 0; i < bookList.size(); i++) {
	if (i != bookList.size() - 1) {%>
									 {
											title : 'Event2',
											start : '<%=bookList.get(i).getStart_date()%>',
											end : '<%=bookList.get(i).getEnd_date()%>',
											url: '<%=request.getContextPath()%>/bookOption.do?no=<%=bookList.get(i).getNo()%>',
											color : 'yellow', 
											textColor : 'black' 
										},
									<%} else {%>
									 {
											title : 'Event3',
											start : '<%=bookList.get(i).getStart_date()%>',
											end : '<%=bookList.get(i).getEnd_date()%>',
											color : 'yellow',
											textColor : 'red' 
										},
									<%}
}%>
									]
									,select: function(info){
										select_info_str = info.startStr;
										if(((parseInt(info.endStr.substring(8,10))-1)+ "").length == 1 ){
										select_info_end = (info.endStr).substring(0,8) + "0"+ parseInt(info.endStr.substring(8,10));
										}else {
										select_info_end = (info.endStr).substring(0,8) + parseInt(info.endStr.substring(8,10));
										}
										if(parseInt(select_info_str.substring(8,10)) == (parseInt(info.endStr.substring(8,10))-1)){
											return;
										};
										checkDateAvailable(select_info_str, select_info_end);
										alert(result);
									}
								});
						calendar.render();
					});
	function checkDateAvailable(str, end){
		$.ajax({
			type:'POST',
			url:'calenderForUser.do?check=1',
			data:{"start_date": str, "end_date": end,"room_no": ${no} },
			dataType:'text',
			async:false
		})
		.done(function(data){
			if(data.includes('成功')){
			result = 'yes';
			}else if (data.includes('失敗')){
			result = 'no';
			};
		})
		.fail(function(request, status, error){
			alert("エラー　：　" + error);
		})
	};
	function saveDate(){
		if(result == 'yes'){
			$.ajax({
				url:'calenderSaveDate.do',
				type:'POST',
				dataType: 'json',
				async:false
			})
			.done(function(data){
				var start = data.start_date;
				var end = data.end_date; 
				location.href="bookOption.do?no="+no+"&room_num="+room_num+"&start_date="+start+"&end_date="+end+"&room_title="+room_title;
			 })
			.fail(function(request, status, error){
				alert("Error : " + error );
			});
		}else if(result == 'no'){
			alert('予約できる日を選んでください')
		}else {
			alert('予約したい日を選んでください')
		}
	};
</script>
</head>
<body>
	<%@ include file="../../include/header.jsp"%>
	<div class="ForCalender">
		<div id='calendar'></div>
	</div>
	<%=bookList.size()%>
	[${book.start_date } ] [${book.end_date } ]
	<br />
	<button type="button" onclick="saveDate()">Value</button>
	<%@ include file="../../include/footer.jsp"%>
</body>
</html>
