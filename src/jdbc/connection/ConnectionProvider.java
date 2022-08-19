package jdbc.connection;

import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	final int a= 2;
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(
				"jdbc:apache:commons:dbcp:pool");
	}
}
