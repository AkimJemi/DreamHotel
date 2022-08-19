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
			pstmt = conn.prepareStatement("select * from consultation where grno = 1 and delete_flag ='0'");
			rs = pstmt.executeQuery();
			while(rs.next()) 
				consultationList.add(new Consultation(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12)));
			
		}catch (Exception e) {
			System.out.println("error : QnADAO.QnAList() => " + e.getMessage());
		}
		return consultationList;
	}

	public Consultation QnADetail(Connection conn, Consultation consultation) {
		try {
			pstmt = conn.prepareStatement("select * from consultation where no = ?");
			pstmt.setInt(1, consultation.getNo());
			rs = pstmt.executeQuery();
			while(rs.next()) 
				consultation = new Consultation(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12));
			
		}catch (Exception e) {
			System.out.println("error : QnADAO.QnADetail() => " + e.getMessage());
		}
		return consultation;
	}

	public Consultation QnAUpdate(Connection conn, Consultation consultation) {
		
		return null;
	}

	public ArrayList<Consultation> ReplyList(Connection conn, int no, ArrayList<Consultation> consultationList) {
		try {
			pstmt = conn.prepareStatement("select no, grno, grgrod, title,contents,name, delete_flag, created_at,updated_at from consultation where grno = 2 and grgrod = ? and delete_flag ='0'");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) 
				consultationList.add(new Consultation(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getDate(9)));
		}catch (Exception e) {
			System.out.println("error : QnADAO.ReplyList() => " + e.getMessage());
		}
		return consultationList;
	}
}
