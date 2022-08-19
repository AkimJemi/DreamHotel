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
		no = Util.checkNo(rq, no);
		if (rq.getMethod().equalsIgnoreCase("post"))
			return processSubmit(rq, rp);
		else if (rq.getMethod().equalsIgnoreCase("get"))
			return processForm(rq, rp);
		return Util.redirectMsgAndBack(rq, "QnADetailHandler process");
	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		if (rq.getParameter("sql") != null) {
			String sql = rq.getParameter("sql");
			if (sql.equals("create")) {
				rq.setAttribute("sql", "create");
				return QnADetailHandler;
			} else if (sql.equals("update")) {

				Util.checkLoginedAmind(rq);

				System.out.println("test1");
				rq.setAttribute("update", Boolean.TRUE);
			} else if (sql.equals("detail")) {
				rq.setAttribute("replys", Container.qnAService.ReplyList(Integer.parseInt(rq.getParameter("no"))));
			}

		}
		rq.setAttribute("consultation", Container.qnAService.QnADetail(no));
		return QnADetailHandler;

	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		if (rq.getParameter("sql") != null) {
			if (rq.getParameter("sql").equals("create")) {

				System.out.println("test2");
				return "QnADetail.do?sql=detail&no=" + no;
			}
		}

		rq.setAttribute("consultation",
				new Consultation(Container.qnAService.QnAUpdate(new Consultation(no, rq.getParameter("title"),
						rq.getParameter("contents"), rq.getParameter("name"), rq.getParameter("passwd")))));
		return QnADetailHandler;
	}

}
