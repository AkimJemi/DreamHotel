package room.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import room.model.Room_Info;
import room.service.RoomService;

public class RoomListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)  {
		if (rq.getMethod().equals("POST"))
			return processPost(rq, rp);
		else if (rq.getMethod().equals("GET"))
			return processGet(rq, rp);
		else
			return null;
	}

	private String processGet(HttpServletRequest rq, HttpServletResponse rp) {
		RoomService roomService = new RoomService();
		ArrayList<Room_Info> roomList = roomService.RoomList(roomList = new ArrayList<Room_Info>());
		rq.setAttribute("rooms", roomList);
		return "/WEB-INF/view/room/roomList.jsp";
	}

	private String processPost(HttpServletRequest rq, HttpServletResponse rp) {
		return "/WEB-INF/view/room/roomList.jsp";
	}

}
