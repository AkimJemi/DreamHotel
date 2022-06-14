<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
var select_info_str = null;
var select_info_end = null;
var result = 'null';
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
									/* customButtons : {
										addEventButton : {
											text : 'add event...',
											click : function() {
												var dateStr = prompt('Enter a date in YYYY-MM-DD format');
												var date = new Date(dateStr
														+ 'T00:00:00'); // will be in local time
												if (!isNaN(date.valueOf())) { // valid?
													calendar
															.addEvent({
																title : 'dynamic event',
																start : date,
																end : date,
																allDay : true
															});
												} else {
													alert('Invalid date.');
												}
											}
										}
									}, */
									 eventClick: function(info) {
										    /* window.move(info.event.url); */
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
											color : 'yellow', // an option!
											textColor : 'black' // an option!
										},
									<%} else {%>
									 {
											title : 'Event3',
											start : '<%=bookList.get(i).getStart_date()%>',
											end : '<%=bookList.get(i).getEnd_date()%>',
											color : 'yellow', // an option!
											textColor : 'red' // an option!
										},
									<%}
}%>
									]
									,select: function(info){
										select_info_str = info.startStr;
										select_info_end = info.endStr;
										 $.ajax({
												type:'POST',
												url:'calenderForUser.do?check=1',
												data:{"start_date": select_info_str, "end_date": select_info_end,"room_no": ${books[0].room_no} },
												dataType:'text',
												async:false
											})
											.done(function(data){
												alert(data);
												if(data.includes('成功')){
												result = 'yes';
												}else if (data.includes('失敗')){
												result = 'no';
												};
											})
											.fail(function(request, status, error){
												alert("エラー　：　" + error);
											})
										<%-- window.open('<%=request.getContextPath()%>/bookOption.do?no=${no}&room_num=${room_num}'); --%>
									}
								});
						calendar.render();
					});
	function saveDate(){
		if(result == 'yes'){
			const events = new Array();
			const allEvent = calendar.getEvents();
			for(var i =0;i<allEvent.length; i++){
				var obj = new Object();
				obj.title = allEvent[i]._def.title;
				obj.allDay = allEvent[i]._def.allDay;
				obj.start = allEvent[i]._instance.range.start;
				obj.end = allEvent[i]._instance.range.end;
				events.push(obj);
			}
			const jsondate = JSON.stringify(events);
			savedata(jsondate);
		}else if(result == 'no'){
			alert('予約できる日を選んでください')
		}else {
			alert('予約したい日を選んでください')
		}
	};
	function savedata(jsondate){
		$.ajax({
			url:'calenderSaveDate.do',
			type:'POST',
			data:{"alldata": jsondate},
			dataType:'json',
			async:false
		})
		.done(function(data){
/* 			alert("jsondate : " + jsondate );
			alert("data : " + data.title );
 */			var title = data.title;
			var start = data.start;
			var end = data.end; 
			/* alert(title +start+end);
		location.href="bookOption.do?start_date="+start+"&end_date="+end+"&title="+title; 
		 */})
		.fail(function(request, status, error){
			alert("Error : " + error );
		});
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
