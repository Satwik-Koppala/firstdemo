package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class datasource {
	static Connection getConnection() {
		return connection;
	}
	static Connection connection;
	static {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			DriverManager.registerDriver(new Driver());
			Class.forName(driver);
			System.out.println("Driver Loaded");
	
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kivtas" , "root", "Munkus@1999");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
