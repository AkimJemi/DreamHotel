package book.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class BookOptionHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		rq.setAttribute("no", rq.getParameter("no"));
		rq.setAttribute("room_num", rq.getParameter("room_num"));
		return "WEB-INF/view/book/bookOption.jsp";
	}

}
