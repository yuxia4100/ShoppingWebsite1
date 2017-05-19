package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ShoppingCartBo {
	HashMap<Integer, Integer> map = new HashMap<>();
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private float totalPrice;
	
	public void addGoods(int goodId, int goodAmount) {
		map.put(goodId, goodAmount);
	}
	
	public void deleteGoods(int goodId) {
		map.remove(goodId);
	}
	
	public void deleteAllGoods() {
		map.clear();
	}
	
	public void updateGoods(int goodId, int goodAmount) {
		map.put(goodId, goodAmount);
	}
	
	public int getGoodAmountById(int goodId) {
		return map.get(goodId);
	}
	
	public float getTotalPrice() {
		return this.totalPrice;
	}
	
	public void setTotalPricec(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<GoodBean> showShoppingCart() {
		List<GoodBean> res = new ArrayList<>();
		if (map.size() <= 0) {
			return res;
		}
		try {
			System.out.println("the map size is " + map.size());
			String sub = "(";
			Iterator<Integer> it = map.keySet().iterator();
			while (it.hasNext()) {
				int goodId = (int)it.next();
				if (it.hasNext()) {
					sub += goodId + ",";
				} else {
					sub += goodId + ")";
				}
			}
			System.out.println(sub);
			String sql = "select * from bookInfo where book_id in " + sub;
			System.out.println(sql);
			conn = new ConnectDb().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			this.totalPrice = 0;
			while (rs.next()) {
				GoodBean gb = new GoodBean();
				int bookId = rs.getInt(1);
				gb.setBookId(bookId);
				gb.setBookName(rs.getString(2));
				gb.setBookInfo(rs.getString(3));
				float price = rs.getFloat(4);
				gb.setBookPrice(price);
				gb.setBookAmount(rs.getInt(5));
				gb.setBookPublisher(rs.getString(6));
				gb.setBookPhoto(rs.getString(7));
				gb.setBookType(rs.getString(8));
				this.totalPrice +=  price * this.getGoodAmountById(bookId);
				res.add(gb);
				System.out.println(gb.getBookName());
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		
		return res;
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
