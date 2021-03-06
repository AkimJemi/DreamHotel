package room.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import room.model.Room_Info;

public class RoomDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;
	public ArrayList<Room_Info> roomList(Connection conn, ArrayList<Room_Info> roomList) {
		try {
			pstmt = conn.prepareStatement("select * from \"room_Info\"");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				roomList.add(new Room_Info(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12)));
			}
		}catch (Exception e) {
		System.out.println(e.getMessage());
		System.out.println("error : RoomDAO.roomList()");
		}
		return roomList;
	}
	public Room_Info room(Connection conn, Room_Info room) {
		try {
			pstmt = conn.prepareStatement("select * from \"room_Info\" where no = ?");
			pstmt.setInt(1, room.getNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				room = new Room_Info(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12));
			}
		}catch (Exception e) {
		System.out.println(e.getMessage());
		System.out.println("error : RoomDAO.room()");
		}
		return room;
	}

}
