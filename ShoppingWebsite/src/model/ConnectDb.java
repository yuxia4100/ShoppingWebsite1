package model;

import java.sql.DriverManager;
import java.sql.Connection;
public class ConnectDb {
	Connection conn = null;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ShoppingWebsite","root", "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
		
	}
}
