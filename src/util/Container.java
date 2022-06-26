package util;

import board.dao.QnDAO;
import board.service.NoticeService;
import board.service.QnAService;

public class Container {
	public static NoticeService noticeService;
	public static QnAService qnAService;
	public static QnDAO qnADao;
	static {
		noticeService = new NoticeService();
		qnAService = new QnAService();
		qnADao = new QnDAO();
	}

}
