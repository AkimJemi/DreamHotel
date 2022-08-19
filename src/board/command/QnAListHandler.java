package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import util.Container;

public class QnAListHandler implements CommandHandler {
	public static String QnAListHandler = "WEB-INF/view/board/QnAList.jsp";

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) {
		return Container.qnAService.QnAList(rq);
	}
}
