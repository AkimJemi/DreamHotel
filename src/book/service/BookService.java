package book.service;

import java.sql.Connection;
import java.util.ArrayList;

import book.dao.BookDAO;
import book.model.Booking;
import book.model.Options;
import jdbc.JdbcUtil;
import jdbc.Util;
import jdbc.connection.ConnectionProvider;

public class BookService {
	private Connection conn;
	private BookDAO bookDao = new BookDAO();

	public ArrayList<Booking> bookList(ArrayList<Booking> bookList) {
		try {
			conn = ConnectionProvider.getConnection();
			bookList = bookDao.bookList(conn, bookList);
		} catch (Exception e) {
			System.out.println("error : BookService.bookList()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return bookList;
	}

	public ArrayList<Booking> myBookList(String name, String phone) {
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		try {
			conn = ConnectionProvider.getConnection();
			bookings = bookDao.myBookList(conn, name, phone);
		} catch (Exception e) {
			System.out.println("error : BookService.myBookList()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return bookings;
	}

	public ArrayList<Booking> adminBookList(ArrayList<Booking> bookings) {
		try {
			conn = ConnectionProvider.getConnection();
			bookings = bookDao.adminBookList(conn, bookings);
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
			bookDao.insertOptions(conn, options);
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
			result = bookDao.insertBook(conn, booking);
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
			total = bookDao.getOptionATotal(conn, total_count);
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
			total = bookDao.getBasicTotalCost(conn, adult, child);
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
			result = bookDao.paymentUpdate(conn, payment, no);
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
			result = bookDao.bookCancel(conn, cancel, no);
		} catch (Exception e) {
			System.out.println("error : BookService.bookCancel()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return result;
	}
}
