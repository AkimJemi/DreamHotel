package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Notice;
import board.service.NoticeService;
import jdbc.Util;
import mvc.command.CommandHandler;
import util.Container;

public class NoticeDetailHandler implements CommandHandler {
	public static int no;

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		if (rq.getParameter("no") != null) {
			no = Integer.parseInt(rq.getParameter("no"));
		}
		
		if (rq.getMethod().equals("POST")) {
			return processSubmit(rq, rp);
		} else if (rq.getMethod().equals("GET"))
			return processForm(rq, rp);
		return Util.redirectMsgAndBack(rq, "NoticeDetailHandler requestMethod");
	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		Notice notice = new Notice(Container.noticeService.noticeDetail(no));
		rq.setAttribute("notice", notice);
		
		if (rq.getParameter("update") != null) 
			rq.setAttribute("update", Boolean.TRUE);
		
		return "WEB-INF/view/board/noticeDetail.jsp";
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		// TODO Auto-generated method stub
		return null;
	}

}
