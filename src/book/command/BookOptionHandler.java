package book.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class BookOptionHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		String no = rq.getParameter("no");
		String room_num = rq.getParameter("room_num");
		String room_title = rq.getParameter("room_title");
		String start_date = rq.getParameter("start_date");
		String end_date = rq.getParameter("end_date");
		rq.setAttribute("no",no );
		rq.setAttribute("room_num", room_num);
		rq.setAttribute("room_title", room_title);
		rq.setAttribute("start_date", start_date);
		rq.setAttribute("end_date", end_date);
		return "WEB-INF/view/book/bookOption.jsp";
	}

}
