package book.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.Booking;
import book.service.BookService;
import jdbc.Util;
import mvc.command.CommandHandler;
import room.service.RoomService;

public class GuestInfoInsertHandler implements CommandHandler {
	private static String room_title, start_date, end_date, optionText, activity1, activity2, activity3;
	private static int no, room_no, option1, option2, option3;

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		no = Integer.parseInt(rq.getParameter("no"));
		room_no = Integer.parseInt(rq.getParameter("room_num"));
		room_title = rq.getParameter("room_title");
		start_date = rq.getParameter("start_date");
		end_date = rq.getParameter("end_date");
		option1 = Integer.parseInt(rq.getParameter("option1"));
		option2 = Integer.parseInt(rq.getParameter("option2"));
		option3 = Integer.parseInt(rq.getParameter("option3"));
		optionText = rq.getParameter("optionText");
		activity1 = rq.getParameter("activity1");
		activity2 = rq.getParameter("activity2");
		activity3 = rq.getParameter("activity3");
		rq.setAttribute("option1", option1);
		rq.setAttribute("option2", option2);
		rq.setAttribute("option3", option3);
		rq.setAttribute("optionText", optionText);
		rq.setAttribute("activity1", activity1);
		rq.setAttribute("activity2", activity2);
		rq.setAttribute("activity3", activity3);
		rq.setAttribute("no", no);
		rq.setAttribute("room_num", room_no);
		rq.setAttribute("room_title", room_title);
		rq.setAttribute("start_date", start_date);
		rq.setAttribute("end_date", end_date);
		
		if (rq.getMethod().equalsIgnoreCase("POST"))
			return processSubmit(rq, rp);
		else if (rq.getMethod().equalsIgnoreCase("GET"))
			return processForm(rq, rp);
		else
			return null;
	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		return "WEB-INF/view/book/guestInfoInsert.jsp";
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		BookService bookService = new BookService();
		RoomService roomService = new RoomService();
		Date date = new Date(System.currentTimeMillis());
		String options = rq.getParameter("option1") + "/" + rq.getParameter("option2") + "/"
				+ rq.getParameter("option3");
		int adult_cost = roomService.getAdultCostByRoom_Num(room_no);
		int child_cost = roomService.getChildCostByRoom_Num(room_no);
		int adult = Integer.parseInt(rq.getParameter("adult"));
		int child = Integer.parseInt(rq.getParameter("child"));
		int option_total_cost = bookService.getOption_A_TotalCost(option1, option2, option3);
		int total_cost = option_total_cost + (child_cost * child) + (adult_cost * adult);
		String start_dates = start_date.substring(0,4) + start_date.substring(5,7) +start_date.substring(8,10);
		String end_dates = end_date.substring(0,4) + end_date.substring(5,7) +end_date.substring(8,10);
		int result = bookService.InsertBook(new Booking(no, room_no, rq.getParameter("name"), rq.getParameter("phone"),
				adult + "", child + "", start_dates, end_dates, options, total_cost, rq.getParameter("bank_name"),
				rq.getParameter("bank_branch_code"), rq.getParameter("bank_account_number"), date, date));
		if (result != 1)
			return Util.redirectMsgAndBack(rq, "생성이 실패 하셨습니다");
		else {
			rq.setAttribute("succeed", Boolean.TRUE);
			rq.setAttribute("name", rq.getParameter("name"));
			rq.setAttribute("phone", rq.getParameter("phone"));
			rq.setAttribute("adult", rq.getParameter("adult"));
			rq.setAttribute("child", rq.getParameter("child"));
			rq.setAttribute("bak", Integer.parseInt(end_date.substring(8,10))-Integer.parseInt(start_date.substring(8,10)));
			rq.setAttribute("bank_name", rq.getParameter("bank_name"));
			rq.setAttribute("bank_branch_code", rq.getParameter("bank_branch_code"));
			rq.setAttribute("bank_account_number", rq.getParameter("bank_account_number"));
			return "WEB-INF/view/book/guestInfoInsert.jsp";
		}
	}

}
