<!DOCTYPE html>
<%@page import="book.model.Booking"%>
<%@page import="java.util.ArrayList"%>
<html lang='en'>
<head>
<meta charset='utf-8' />
<style type="text/css">
.ForCalender {
	height: 700px;
	width: 700px;
}
</style>
<link rel="stylesheet" type="text/css" href="./css/JM.css">
<link href='fullcalendar/main.css' rel='stylesheet' />
<script src='fullcalendar/main.js'></script>
<%
	ArrayList<Booking> bookList = (ArrayList<Booking>) request.getAttribute("books");
%>
<script>
	document
			.addEventListener(
					'DOMContentLoaded',
					function() {
						var calendarEl = document.getElementById('calendar');
						var calendar = new FullCalendar.Calendar(
								calendarEl,
								{
									initialView : 'dayGridMonth',
									selectable: true,
									headerToolbar : {
										center : 'addEventButton'
									},
									customButtons : {
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
																allDay : true
															});
													alert('Great. Now, update your database...');
												} else {
													alert('Invalid date.');
												}
											}
										}
									},
									 eventClick: function(info) {
										    window.move(info.event.url);
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
										alert("selected : " + info.startStr +" to "+ info.endStr);
										window.open('<%=request.getContextPath()%>/bookOption.do?no=${no}&room_num=${room_num}');
									}
								});
						calendar.render();
					});
</script>
</head>
<body>
	<%@ include file="../../include/header.jsp"%>
	<div class="ForCalender">
		<div id='calendar'></div>
	</div>
	<br />

	<%@ include file="../../include/footer.jsp"%>
</body>
</html>
