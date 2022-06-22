package admin.command;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.Booking;
import book.service.BookService;
import jdbc.Util;
import mvc.command.CommandHandler;
import util.paging.Paging;

public class AdminBookListHandler implements CommandHandler {
	private BookService bookService = new BookService();

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		
		if (rq.getParameter("payment") != null)
			if (bookService.paymentUpdate(rq.getParameter("payment"), Integer.parseInt(rq.getParameter("no"))) != 1)
				return Util.redirectMsgAndBack(rq, "payment");

		if (rq.getParameter("cancel") != null)
			if (bookService.bookCancel(rq.getParameter("cancel"), Integer.parseInt(rq.getParameter("no"))) != 1)
				return Util.redirectMsgAndBack(rq, "cancel");

		
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		int searchTitle = 0;
		if (rq.getParameter("searchTitle") != null)
			searchTitle = Integer.parseInt(rq.getParameter("searchTitle"));

		
		String searchContent = null;
		if (rq.getParameter("searchContent") != null)
			searchContent = rq.getParameter("searchContent");

		int currentPage = 1;
		if (rq.getParameter("currentPage") != null)
			currentPage = Integer.parseInt(rq.getParameter("currentPage"));

		
		int total = bookService.bookTotalCount(searchTitle, searchContent);
		System.out.println("test1");
		System.out.println(total);
		Paging pagingModel = new Paging(total, currentPage, searchTitle, searchContent);
		System.out.println("test2");
		bookings = bookService.adminBookList(bookings, pagingModel);
		
		rq.setAttribute("paging", pagingModel);
		rq.setAttribute("bookings", bookings);
		if (rq.getMethod().equalsIgnoreCase("get")) {
			return porocessForm(rq, rp);
		} else if (rq.getMethod().equalsIgnoreCase("post")) {
			return processSubmit(rq, rp);
		} else
			return Util.redirectMsgAndBack(rq, "URI");

	}

	private String porocessForm(HttpServletRequest rq, HttpServletResponse rp) {

		return "WEB-INF/view/admin/adminBookList.jsp";
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		return "WEB-INF/view/admin/adminBookList.jsp";
	}
}
