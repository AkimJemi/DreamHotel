package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

	private PreparedStatement pstm;
	private ResultSet rs;
	private int result;

	public int login(Connection conn, String name, String phone) {
		try {
			pstm = conn.prepareStatement("select * from booking where name = ? and phone = ?");
			pstm.setString(1, name);
			pstm.setString(2, phone);
			rs = pstm.executeQuery();
			if (rs.next()) {
				result = 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : LoginDAO.login()");

		}
		return result;
	}

}
