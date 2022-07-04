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
			conn = ConnectionProvider.getConnection();
			ArrayList<Consultation> consultationList = Container.qnADao.QnAList(conn, new ArrayList<Consultation>());
			rq.setAttribute("consultationList", consultationList);
		} catch (Exception e) {
			System.out.println("error : QnAService.QnAList()");
			System.out.println(e.getMessage());
		}
		return "WEB-INF/view/board/QnAList.jsp";
	}

	public Consultation QnADetail(int no) {
		Consultation consultation = new Consultation();
		try {
			conn = ConnectionProvider.getConnection();
			consultation.setNo(no);
			consultation = Container.qnADao.QnADetail(conn, consultation);

		} catch (Exception e) {
			System.out.println("error : QnAService.QnADetail()");
			System.out.println(e.getMessage());
		}
		return consultation;
	}

	public Consultation QnAUpdate(Consultation consultation) {
		try {
			conn = ConnectionProvider.getConnection();
			consultation = Container.qnADao.QnAUpdate(conn, consultation);

		} catch (Exception e) {
			System.out.println("error : QnAService.QnAUpdate()");
			System.out.println(e.getMessage());
		}
		return consultation;
	}

}
