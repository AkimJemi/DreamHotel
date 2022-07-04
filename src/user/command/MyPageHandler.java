package user.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.Booking;
import book.service.BookService;
import jdbc.Util;
import mvc.command.CommandHandler;

public class MyPageHandler implements CommandHandler {
	private BookService bookService = new BookService();

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)  {
		if(rq.getMethod().equalsIgnoreCase("get")){
			return porocessForm(rq,rp);
		}else if(rq.getMethod().equalsIgnoreCase("post")){
			return processSubmit(rq,rp);
		}else
			return Util.redirectMsgAndBack(rq, "URI���s");
	}

	private String porocessForm(HttpServletRequest rq, HttpServletResponse rp) {
		if (rq.getParameter("cancel") != null) 
			if (bookService.bookCancel(rq.getParameter("cancel"), Integer.parseInt(rq.getParameter("no"))) != 1)
				return Util.redirectMsgAndBack(rq, "��񂪈�v���Ă��܂���");
		
		String name = (String) rq.getSession().getAttribute("loginedName");
		String phone = (String)rq.getSession().getAttribute("loginedPhone");
		ArrayList<Booking> bookings = bookService.myBookList(name, phone);
		rq.setAttribute("bookings", bookings);
		return "WEB-INF/view/user/myPage.jsp";
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		return "WEB-INF/view/user/myPage.jsp";
	}
}
