package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection connection = null;

	private ConnectionFactory() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/movieticketbooking";
		String username = "root";
		String password = "Epam123$$";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getconnection() throws SQLException {

		if (connection == null)
			new ConnectionFactory();
		return connection;

	}
}
