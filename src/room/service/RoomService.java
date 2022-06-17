package room.service;

import java.sql.Connection;
import java.util.ArrayList;

import jdbc.connection.ConnectionProvider;
import room.dao.RoomDAO;
import room.model.Room_Info;

public class RoomService {
	private Connection conn;
	private RoomDAO roomDao = new RoomDAO();

	public ArrayList<Room_Info> RoomList(ArrayList<Room_Info> rookList) {
		try {
			conn = ConnectionProvider.getConnection();
			rookList = roomDao.roomList(conn, rookList);
		}catch (Exception e) {
			System.out.println("error : RoomService.RoomList()");
			System.out.println(e.getMessage());
		}
		return rookList;
	}

	public Room_Info getRoomByNo(Room_Info room) {
		try {
			conn = ConnectionProvider.getConnection();
			room = roomDao.room(conn, room);
		}catch (Exception e) {
			System.out.println("error : RoomService.getRoomByNo()");
			System.out.println(e.getMessage());
		}
		return room;
	}


	public int getRoomCostByNo(String parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getAdultCostByRoom_Num(int room_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getChildCostByRoom_Num(int room_num) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
