package login.service;

import java.sql.Connection;

import jdbc.connection.ConnectionProvider;
import login.dao.LoginDAO;

public class LoginService {

	private Connection conn;

	public int login(String id, String phone) {
		LoginDAO loginDao = new LoginDAO();
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			result = loginDao.login(conn, id, phone);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : LoginService.login()");
		}

		return result;
	}

}
