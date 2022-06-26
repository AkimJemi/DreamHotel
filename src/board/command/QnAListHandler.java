package board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Consultation;
import mvc.command.CommandHandler;
import util.Container;

public class QnAListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
//		ArrayList<Consultation> consultation = new QnAService().QnAList();
		ArrayList<Consultation> consultation = Container.qnAService.QnAList();
		
		rq.setAttribute("consultationList", consultation);
		
		return "WEB-INF/view/board/QnAList.jsp";
	}

}
