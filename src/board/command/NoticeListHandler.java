package board.command;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Notice;
import board.service.NoticeService;
import mvc.command.CommandHandler;

public class NoticeListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		NoticeService noticeService = new NoticeService();
		
		ArrayList<Notice> noticeList = new ArrayList<Notice>(); 	
		noticeList = noticeService.noticeList(noticeList);
		
		
		rq.setAttribute("noticeList", noticeList);
		return "/WEB-INF/view/board/noticeList.jsp";
	}

}
