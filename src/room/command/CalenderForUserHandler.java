package room.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.Booking;
import book.service.BookService;
import mvc.command.CommandHandler;
import room.model.Room_Info;
import room.service.RoomService;

public class CalenderForUserHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		BookService bookService = new BookService();
		ArrayList<Booking> bookList = new ArrayList<Booking>();
		bookList = bookService.bookList(bookList);
		rq.setAttribute("no", rq.getParameter("no"));
		rq.setAttribute("room_num", rq.getParameter("room_num"));
		rq.setAttribute("books", bookList);
		return "WEB-INF/view/room/calenderForUser.jsp";
	}

}
