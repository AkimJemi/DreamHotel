package util;

import java.util.ArrayList;

import board.dao.QnDAO;
import board.service.NoticeService;
import board.service.QnAService;
import book.dao.BookDAO;
import book.model.Booking;
import book.service.BookService;

public class Container {
	public static NoticeService noticeService;
	public static QnAService qnAService;
	public static QnDAO qnADao;
	public static BookService bookService;
	public static BookDAO bookDao;
	public static ArrayList<Booking> arrayList_Booking;

	static {
		bookDao = new BookDAO();
		arrayList_Booking = new ArrayList<Booking>();
		bookService = new BookService();
		noticeService = new NoticeService();
		qnAService = new QnAService();
		qnADao = new QnDAO();
	}

}
