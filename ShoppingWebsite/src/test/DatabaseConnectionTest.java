package test;

import java.sql.*;

import model.ConnectDb;

public class DatabaseConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		try {
			ConnectDb connectDb = new ConnectDb();
			conn = connectDb.getConnection();
			ps = conn.prepareStatement("select * from bookInfo where book_id = ?");
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
