package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import board.model.Consultation;

public class QnDAO {

	private ResultSet rs;
	private PreparedStatement pstmt;
	
	public ArrayList<Consultation> QnAList(Connection conn, ArrayList<Consultation> consultationList) {
		try {
			pstmt = conn.prepareStatement("select * from consultation");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				consultationList.add(new Consultation(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12)));
			}
		}catch (Exception e) {
			System.out.println("error : QnADAO.QnAList()");
			System.out.println(e.getMessage());
		}
		return consultationList;
	}

	public Consultation QnADetail(Connection conn, Consultation consultation) {
		try {
			pstmt = conn.prepareStatement("select * from consultation where no = ?");
			pstmt.setInt(1, consultation.getNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				consultation = new Consultation(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12));
			}
		}catch (Exception e) {
			System.out.println("error : QnADAO.QnADetail()");
			System.out.println(e.getMessage());
		}
		return consultation;
	}

	public Consultation QnAUpdate(Connection conn, Consultation consultation) {
		
		return null;
	}
}
