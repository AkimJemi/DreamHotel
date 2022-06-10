package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import book.model.Booking;
import book.model.Options;
import room.model.Room_Info;

public class BookDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ArrayList<Booking> bookList(Connection conn, ArrayList<Booking> bookList) {
		try {
			pstmt = conn.prepareStatement("select * from booking");
			rs = pstmt.executeQuery();
			while (rs.next()) {
//				bookList.add(new Booking(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getDate(17), rs.getDate(18)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : RoomDAO.roomList()");
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
		}
		return total;
	}

	public int getBasicTotalCost(Connection conn, int adult, int child) {
		int total = 0;
		try {
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : RoomDAO.getBasicTotalCost()");
		}
		return total;
	}

}
