package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBeanBo {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean veriflyUser(String userName, String password) {
		boolean verified = false;
		try {
			conn = new ConnectDb().getConnection();
			ps = conn.prepareStatement("select * from userInfo where user_name = ? limit 1");
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				String passwordDb = rs.getString(5);
				if (password.equals(passwordDb)) {
					verified = true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return verified;
		
	}
	
	public boolean addUser(userBean ub) {
		boolean hasAdded = false;
		
		try {
			conn = new ConnectDb().getConnection();
			ps = conn.prepareStatement("select * from userInfo where user_name = ? limit 1");
			ps.setString(1, ub.getUserName());
			rs = ps.executeQuery();
			if (!rs.next()) {
				ps = conn.prepareStatement("insert into userInfo "
						+ "(user_name, user_firstname, user_lastname, user_password, user_email, user_phone, user_address, user_postcode) "
						+ "values (?,?,?,?,?,?,?,?)");
				ps.setString(1, ub.getUserName());
				ps.setString(2, ub.getUserFirstName());
				ps.setString(3, ub.getUserLastName());
				ps.setString(4, ub.getUserPassword());
				ps.setString(5, ub.getUserEmail());
				ps.setString(6, ub.getUserPhone());
				ps.setString(7, ub.getUserAddress());
				ps.setString(8, ub.getUserPostcode());
				ps.executeUpdate();
				hasAdded = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return hasAdded;
		
	} 
	
	
	public userBean getUserBeanByName(String userName) {
		userBean ub = new userBean();
		try {
			conn = new ConnectDb().getConnection();
			ps = conn.prepareStatement("select * from userInfo where user_name = ? limit 1");
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				ub.setUserId(rs.getInt(1));
				ub.setUserName(rs.getString(2));
				ub.setUserFirstName(rs.getString(3));
				ub.setUserLastName(rs.getString(4));
				ub.setUserPassword(rs.getString(5));
				ub.setUserEmail(rs.getString(6));
				ub.setUserPhone(rs.getString(7));
				ub.setUserAddress(rs.getString(8));
				ub.setUserPostcode(rs.getString(9));
				
				System.out.println("get ub name " + ub.getUserName());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return ub;
	}
	private void closeConnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
