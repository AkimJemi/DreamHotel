package board.service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import board.model.Consultation;
import jdbc.connection.ConnectionProvider;
import util.Container;

public class QnAService {
	private Connection conn;

	public String QnAList(HttpServletRequest rq) {
		try {
			rq.setAttribute("consultationList",
					Container.qnADao.QnAList(ConnectionProvider.getConnection(), new ArrayList<Consultation>()));
		} catch (Exception e) {
			System.out.println("error : QnAService.QnAList()");
			System.out.println(e.getMessage());
		}
		return "WEB-INF/view/board/QnAList.jsp";
	}

	public Consultation QnADetail(int no) {
		Consultation consultation = new Consultation();
		try {
			consultation.setNo(no);
			consultation = Container.qnADao.QnADetail(ConnectionProvider.getConnection(), consultation);

		} catch (Exception e) {
			System.out.println("error : QnAService.QnADetail()");
			System.out.println(e.getMessage());
		}
		return consultation;
	}

	public Consultation QnAUpdate(Consultation consultation) {
		try {
			consultation = Container.qnADao.QnAUpdate(ConnectionProvider.getConnection(), consultation);
		} catch (Exception e) {
			System.out.println("error : QnAService.QnAUpdate()");
			System.out.println(e.getMessage());
		}
		return consultation;
	}

	public ArrayList<Consultation> ReplyList(int no) {
		try {
			return Container.qnADao.ReplyList(ConnectionProvider.getConnection(), no, new ArrayList<Consultation>());
		} catch (Exception e) {
			System.out.println("error : QnAService.ReplyList()");
			System.out.println(e.getMessage());
		}
		return null;
	}

}
