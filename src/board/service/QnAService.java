package board.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.Consultation;
import jdbc.connection.ConnectionProvider;
import util.Container;

public class QnAService {
	private Connection conn;

	public ArrayList<Consultation> QnAList() {
		ArrayList<Consultation> consultationList = new ArrayList<Consultation>();
		try {
			conn = ConnectionProvider.getConnection();
			consultationList = Container.qnADao.QnAList(conn, consultationList);

		} catch (Exception e) {
			System.out.println("error : QnAService.QnAList()");
			System.out.println(e.getMessage());
		}
		return consultationList;
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
