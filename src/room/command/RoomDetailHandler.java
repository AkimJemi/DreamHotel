package room.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import room.model.Room_Info;
import room.service.RoomService;

public class RoomDetailHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		int no = 0;
		if(rq.getParameter("no") != null )
			no = Integer.parseInt(rq.getParameter("no")) ;
		RoomService roomService = new RoomService();
		Room_Info room = new Room_Info();
		room.setNo(no);
		room = roomService.getRoomByNo(room);
		rq.setAttribute("room", room);
		return "WEB-INF/view/room/roomDetail.jsp";
	}
	

}
