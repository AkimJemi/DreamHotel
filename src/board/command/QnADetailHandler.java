package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Consultation;
import jdbc.Util;
import mvc.command.CommandHandler;
import util.Container;

public class QnADetailHandler implements CommandHandler {
	private static int no;
	private static String QnADetailHandler = "/WEB-INF/view/board/QnADetail.jsp";

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) {
		Util.checkNo(rq, no);

		if (rq.getMethod().equalsIgnoreCase("post"))
			return processSubmit(rq, rp);
		else if (rq.getMethod().equalsIgnoreCase("get"))
			return processForm(rq, rp);
		return Util.redirectMsgAndBack(rq, "QnADetailHandler process");
	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		if (rq.getParameter("update") != null) {
			if (rq.getSession().getAttribute("loginedAdmin") == null)
				return Util.redirectMsgAndBack(rq, "権利がない");
			rq.setAttribute("update", Boolean.TRUE);
		}
		rq.setAttribute("consultation", Container.qnAService.QnADetail(Integer.parseInt(rq.getParameter("no"))));
		return QnADetailHandler;
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		rq.setAttribute("consultation",
				new Consultation(Container.qnAService.QnAUpdate(new Consultation(no, rq.getParameter("title"),
						rq.getParameter("contents"), rq.getParameter("name"), rq.getParameter("passwd")))));
		return QnADetailHandler;
	}

}
