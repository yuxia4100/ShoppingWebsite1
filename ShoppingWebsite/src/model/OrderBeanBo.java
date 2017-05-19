package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OrderBeanBo {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public OrderFullInfoBean addOrder(ShoppingCartBo scb, int userId) {
		OrderFullInfoBean ofib = new OrderFullInfoBean();
		try {
			conn = new ConnectDb().getConnection();
			
			ps = conn.prepareStatement("insert into user_order(user_Id, order_isPayed, order_totalprice) values(?,?,?)");
			ps.setInt(1, userId);
			ps.setString(2, "No");
			ps.setFloat(3, scb.getTotalPrice());
			int num = ps.executeUpdate();
			if (num == 1) {
				ps = conn.prepareStatement("select max(order_Id) from user_order");
				int orderId = 0;
				rs = ps.executeQuery();
				if (rs.next()) {
					orderId = rs.getInt(1);
				}
				List<GoodBean> goodList = scb.showShoppingCart();
				Statement st = conn.createStatement();
				for (int i = 0; i < goodList.size(); i++) {
					GoodBean gb = goodList.get(i);
					st.addBatch("insert into order_good values("+ orderId +","+ gb.getBookId() + "," + scb.getGoodAmountById(gb.getBookId()) + ")");
					
				}
				
				st.executeBatch();
				String sql = "select order_id, user_FirstName, user_LastName,user_address,user_postcode,user_phone,order_totalprice,user_name,user_email from userInfo, user_order  where order_Id=? and userInfo.user_Id = (select user_order.user_Id from user_order where order_Id=?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, orderId);
				ps.setInt(2, orderId);
				rs = ps.executeQuery();
				if (rs.next()) {
					ofib.setOrderId(rs.getInt(1));
					ofib.setUserFirstName(rs.getString(2));
					ofib.setUserLastName(rs.getString(3));
					ofib.setUserAddress(rs.getString(4));
					ofib.setUserPostcode(rs.getString(5));
					ofib.setUserPhone(rs.getString(6));
					ofib.setOrderTotalPrice(rs.getFloat(7));
					ofib.setUserName(rs.getString(8));
					ofib.setUserEmail(rs.getString(9));
				}
			} else {
				ofib = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		
		return ofib;
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
