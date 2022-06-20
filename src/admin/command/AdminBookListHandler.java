package admin.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.Booking;
import book.service.BookService;
import jdbc.Util;
import mvc.command.CommandHandler;

public class AdminBookListHandler implements CommandHandler {
	private BookService bookService = new BookService();

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		if (rq.getMethod().equalsIgnoreCase("get")) {
			return porocessForm(rq, rp);
		} else if (rq.getMethod().equalsIgnoreCase("post")) {
			return processSubmit(rq, rp);
		} else
			return Util.redirectMsgAndBack(rq, "URIé∏îs");
	}

	private String porocessForm(HttpServletRequest rq, HttpServletResponse rp) {
		if (rq.getParameter("payment") != null)
			if (bookService.paymentUpdate(rq.getParameter("payment"), Integer.parseInt(rq.getParameter("no"))) != 1)
				return Util.redirectMsgAndBack(rq, "èÓïÒÇ™àÍívÇµÇƒÇ¢Ç‹ÇπÇÒ");

		if (rq.getParameter("cancel") != null) 
			if (bookService.bookCancel(rq.getParameter("cancel"), Integer.parseInt(rq.getParameter("no"))) != 1)
				return Util.redirectMsgAndBack(rq, "èÓïÒÇ™àÍívÇµÇƒÇ¢Ç‹ÇπÇÒ");

		ArrayList<Booking> bookings = new ArrayList<Booking>();
		bookings = bookService.adminBookList(bookings);
		rq.setAttribute("bookings", bookings);
		return "WEB-INF/view/admin/adminBookList.jsp";
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		return "WEB-INF/view/admin/adminBookList.jsp";
	}
}
