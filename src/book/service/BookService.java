package book.service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import book.model.Booking;
import book.model.Options;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import util.Container;
import util.paging.Paging;

public class BookService {
	private Connection conn;
	
	public ArrayList<Booking> bookList(Booking booking) {
		try {
			conn = ConnectionProvider.getConnection();
			ArrayList<Booking> bookings = Container.bookDao.bookList(conn, booking);
			return bookings;
		} catch (Exception e) {
			System.out.println("error : BookService.bookList()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return null;
	}

	public ArrayList<Booking> myBookList(String name, String phone) {
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		try {
			conn = ConnectionProvider.getConnection();
			bookings = Container.bookDao.myBookList(conn, name, phone);
		} catch (Exception e) {
			System.out.println("error : BookService.myBookList()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return bookings;
	}

	public ArrayList<Booking> adminBookList(ArrayList<Booking> bookings, Paging pagingModel) {
		try {
			conn = ConnectionProvider.getConnection();
			bookings = Container.bookDao.adminBookList(conn, bookings,pagingModel);
		} catch (Exception e) {
			System.out.println("error : BookService.adminBookList()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return bookings;
	}

	public void InsertOptions(ArrayList<Options> options) {
		try {
			conn = ConnectionProvider.getConnection();
			Container.bookDao.insertOptions(conn, options);
		} catch (Exception e) {
			System.out.println("error : BookService.InsertOptions()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
	}

	public int InsertBook(Booking booking) {
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			result = Container.bookDao.insertBook(conn, booking);
		} catch (Exception e) {
			System.out.println("error : BookService.InsertBook()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return result;
	}

	public int getOption_A_TotalCost(int option1, int option2, int option3) {
		int total = 0;
		int[] total_count = new int[3];
		try {
			conn = ConnectionProvider.getConnection();
			total_count[0] = option1;
			total_count[1] = option2;
			total_count[2] = option3;
			total = Container.bookDao.getOptionATotal(conn, total_count);
		} catch (Exception e) {
			System.out.println("error : BookService.getOption_A_TotalCost()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return total;
	}

	public int getBasic_total_cost(int adult, int child) {
		int total = 0;
		try {
			conn = ConnectionProvider.getConnection();
			total = Container.bookDao.getBasicTotalCost(conn, adult, child);
		} catch (Exception e) {
			System.out.println("error : BookService.getOption_A_TotalCost()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return total;
	}

	public int paymentUpdate(String payment, int no) {
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			result = Container.bookDao.paymentUpdate(conn, payment, no);
		} catch (Exception e) {
			System.out.println("error : BookService.paymentUpdate()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return result;
	}

	public int bookCancel(String cancel, int no) {
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			result = Container.bookDao.bookCancel(conn, cancel, no);
		} catch (Exception e) {
			System.out.println("error : BookService.bookCancel()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return result;
	}

	public int bookTotalCount(int searchTitle, String searchContent) {
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			result = Container.bookDao.bookTotalCount(conn,searchTitle,searchContent);
		} catch (Exception e) {
			System.out.println("error : BookService.bookTotalCount()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return result;
	}

	public String bookOption(HttpServletRequest rq) {
		rq.setAttribute("no", rq.getParameter("no"));
		rq.setAttribute("room_num", rq.getParameter("room_num"));
		rq.setAttribute("room_title", rq.getParameter("room_title"));
		rq.setAttribute("start_date", rq.getParameter("start_date"));
		rq.setAttribute("end_date", rq.getParameter("end_date"));
		return "WEB-INF/view/book/bookOption.jsp";
	}
}
