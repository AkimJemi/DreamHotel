package board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Notice;
import mvc.command.CommandHandler;
import util.Container;

public class NoticeListHandler implements CommandHandler {
	private static String NoticeListHandler = "/WEB-INF/view/board/noticeList.jsp";

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) {
		rq.setAttribute("noticeList", Container.noticeService.noticeList(new ArrayList<Notice>()));
		return NoticeListHandler;
	}

	public static String noticeListHandler() {
		return NoticeListHandler;

	}

}
