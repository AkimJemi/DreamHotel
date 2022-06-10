package book.service;

import java.sql.Connection;
import java.util.ArrayList;

import book.dao.BookDAO;
import book.model.Booking;
import book.model.Options;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class BookService {
	private Connection conn;
	private BookDAO bookDao = new BookDAO();

	public ArrayList<Booking> bookList(ArrayList<Booking> bookList) {
		try {
			conn = ConnectionProvider.getConnection();
			bookList = bookDao.bookList(conn, bookList);
		} catch (Exception e) {
			System.out.println("error : RoomService.bookList()");
			System.out.println(e.getMessage());
		}finally {
			JdbcUtil.close(conn);
		}
		return bookList;
	}

	public void InsertOptions(ArrayList<Options> options) {
		try {
			conn = ConnectionProvider.getConnection();
			bookDao.insertOptions(conn, options);
		} catch (Exception e) {
			System.out.println("error : RoomService.InsertOptions()");
			System.out.println(e.getMessage());
		}finally {
			JdbcUtil.close(conn);
		}
	}

	public void InsertBook(Booking booking) {
		// TODO Auto-generated method stub
		
	}

	public int getOption_A_TotalCost(int option1, int option2, int option3) {
		int total =0;
		int[] total_count = new int[3];
		try {
			conn = ConnectionProvider.getConnection();
			
			total_count[0]=option1;
			total_count[1]=option2;
			total_count[2]=option3;
			total = bookDao.getOptionATotal(conn, total_count);
			System.out.println("test4");
		} catch (Exception e) {
			System.out.println("error : RoomService.getOption_A_TotalCost()");
			System.out.println(e.getMessage());
		}finally {
			JdbcUtil.close(conn);
		}
		return total;
	}

	public int getBasic_total_cost(int adult, int child) {
		int total=0;
		try {
			conn = ConnectionProvider.getConnection();
			total = bookDao.getBasicTotalCost(conn, adult,child);
			System.out.println("test4");
		} catch (Exception e) {
			System.out.println("error : RoomService.getOption_A_TotalCost()");
			System.out.println(e.getMessage());
		}finally {
			JdbcUtil.close(conn);
		}
		return total;
	}


}
