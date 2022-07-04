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
	public String process(HttpServletRequest rq, HttpServletResponse rp) {
		if (rq.getParameter("no") != null)
			no = Integer.parseInt(rq.getParameter("no"));
		if (rq.getMethod().equals("POST"))
			return processSubmit(rq, rp);
		else if (rq.getMethod().equals("GET"))
			return processForm(rq, rp);
		return Util.redirectMsgAndBack(rq, "NoticeDetailHandler requestMethod");
	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		rq.setAttribute("notice", new Notice(Container.noticeService.noticeDetail(no)));
		if (rq.getParameter("update") != null) {
			if (rq.getSession().getAttribute("loginedAdmin") == null)
				return Util.redirectMsgAndBack(rq, "権利がない");
			rq.setAttribute("update", Boolean.TRUE);
		}
		return "WEB-INF/view/board/noticeDetail.jsp";
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		rq.setAttribute("notice", new Notice(Container.noticeService
				.noticeUpdate(new Notice(no, rq.getParameter("title"), rq.getParameter("contents")))));
		return "WEB-INF/view/board/noticeDetail.jsp";
	}

}
