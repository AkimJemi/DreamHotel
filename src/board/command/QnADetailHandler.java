package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Consultation;
import jdbc.Util;
import mvc.command.CommandHandler;
import util.Container;

public class QnADetailHandler implements CommandHandler {
	private static int no;

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		if (rq.getParameter("no") != null) {
			no = Integer.parseInt(rq.getParameter("no"));
		}

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

		Consultation consultation = Container.qnAService.QnADetail(Integer.parseInt(rq.getParameter("no")));
		rq.setAttribute("consultation", consultation);
		return "/WEB-INF/view/board/QnADetail.jsp";
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		Consultation consultation = new Consultation(Container.qnAService
				.QnAUpdate(new Consultation(no, rq.getParameter("title"), rq.getParameter("contents"), rq.getParameter("name"),rq.getParameter("passwd"))));
		rq.setAttribute("consultation", consultation);
		return "/WEB-INF/view/board/QnADetail.jsp";
	}

}
