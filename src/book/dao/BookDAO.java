package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import book.model.Booking;
import book.model.Options;
import jdbc.JdbcUtil;
import room.model.Room_Info;

public class BookDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ArrayList<Booking> bookList(Connection conn, ArrayList<Booking> bookLists) {
		ArrayList<Booking> bookList = new ArrayList<Booking>();
		try {
			pstmt = conn.prepareStatement("select no, room_no,name,start_date,end_date from booking where cancel_flag = '0' and room_no =?");
			pstmt.setInt(1, bookLists.get(0).getNo());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bookList.add(new Booking(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : RoomDAO.roomList()");
		}
		finally {
			JdbcUtil.close(pstmt, rs);
		}
		return bookList;
	}

	public void insertOptions(Connection conn, ArrayList<Options> options) {
		try {
			for (int i = 0; i < options.size(); i++) {
				pstmt = conn.prepareStatement(
						"insert into options (no,item,cost,created_at,updated_at  ) values ( ?,?,?,? ,?)");
				pstmt.setInt(1, options.get(i).getNo());
				pstmt.setString(2, options.get(i).getItem());
				pstmt.setInt(3, options.get(i).getCost());
				pstmt.setDate(4, options.get(i).getCreated_at());
				pstmt.setDate(5, options.get(i).getCreated_at());
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : RoomDAO.insertOptions()");
		}finally {
			JdbcUtil.close(pstmt, rs);
		}
	}

	public int getOptionATotal(Connection conn, int[] total_count) {
		int total = 0;
		try {
			for (int i = 0; i < total_count.length; i++) {
				pstmt = conn.prepareStatement("select cost from options where no =?");
				pstmt.setInt(1, i + 1);
				rs = pstmt.executeQuery();
				if (rs.next())
					total += rs.getInt(1) * total_count[i];
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : RoomDAO.getOptionATotal()");
		}finally {
			JdbcUtil.close(pstmt, rs);
		}
		return total;
	}

	public int getBasicTotalCost(Connection conn, int adult, int child) {
		int total = 0;
		try {
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : RoomDAO.getBasicTotalCost()");
		}finally {
			JdbcUtil.close(pstmt, rs);
		}
		return total;
	}

}
