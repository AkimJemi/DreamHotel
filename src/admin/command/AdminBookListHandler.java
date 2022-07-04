package admin.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.Booking;
import book.service.BookService;
import jdbc.Util;
import mvc.command.CommandHandler;
import util.Container;
import util.paging.Paging;

public class AdminBookListHandler implements CommandHandler {
	private int searchTitle = 0, currentPage = 1;
	private String searchContent = null;

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)  {

		if (rq.getParameter("payment") != null)
			if (Container.bookService.paymentUpdate(rq.getParameter("payment"),
					Integer.parseInt(rq.getParameter("no"))) != 1)
				return Util.redirectMsgAndBack(rq, "payment");

		if (rq.getParameter("cancel") != null)
			if (Container.bookService.bookCancel(rq.getParameter("cancel"),
					Integer.parseInt(rq.getParameter("no"))) != 1)
				return Util.redirectMsgAndBack(rq, "cancel");

		if (rq.getParameter("searchTitle") != null)
			searchTitle = Integer.parseInt(rq.getParameter("searchTitle"));

		if (rq.getParameter("searchContent") != null)
			searchContent = rq.getParameter("searchContent");

		if (rq.getParameter("currentPage") != null)
			currentPage = Integer.parseInt(rq.getParameter("currentPage"));

		int total = Container.bookService.bookTotalCount(searchTitle, searchContent);
		Paging pagingModel = new Paging(total, currentPage, searchTitle, searchContent);
		ArrayList<Booking> bookings = Container.bookService.adminBookList(new ArrayList<Booking>(), pagingModel);

		rq.setAttribute("paging", pagingModel);
		rq.setAttribute("bookings", bookings);

		return "WEB-INF/view/admin/adminBookList.jsp";
	}
}
