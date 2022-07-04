package board.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.command.NoticeListHandler;
import board.dao.NoticeDAO;
import board.model.Notice;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class NoticeService {
	private Connection conn;
	private NoticeDAO noticeDao = new NoticeDAO();

	public ArrayList<Notice> noticeList(ArrayList<Notice> noticeList) {
		try {
			conn = ConnectionProvider.getConnection();
			noticeList = noticeDao.noticeList(conn, noticeList);
		} catch (Exception e) {
			System.out.println("error : NoticeService.noticeList()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return noticeList;
	}

	public Notice noticeDetail(int no) {
		Notice notice = new Notice();
		try {
			conn = ConnectionProvider.getConnection();
			notice.setNo(no);
			notice = noticeDao.noticeDetail(conn, notice);
		} catch (Exception e) {
			System.out.println("error : NoticeService.noticeDetail()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return notice;

	}

	public Notice noticeUpdate(Notice notice) {
		try {
			conn = ConnectionProvider.getConnection();
			notice = noticeDao.noticeUpdate(conn, notice);
		} catch (Exception e) {
			System.out.println("error : NoticeService.noticeUpdate()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return notice;
	}

}
