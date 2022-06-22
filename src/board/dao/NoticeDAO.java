package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import board.model.Notice;
import jdbc.JdbcUtil;

public class NoticeDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ArrayList<Notice> noticeList(Connection conn, ArrayList<Notice> noticeList) {
		try {
			pstmt = conn.prepareStatement(
					"select * from notice order by no");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				noticeList.add(
						new Notice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : NoticeDAO.noticeList()");
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return noticeList;
	}

	public Notice noticeDetail(Connection conn, Notice notice) {
		try {
			pstmt = conn.prepareStatement(
					"select * from notice where no = ?");
			pstmt.setInt(1, notice.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
					return new Notice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : NoticeDAO.noticeDetail()");
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return null;
	}

}
