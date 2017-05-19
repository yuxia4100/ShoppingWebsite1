package model;
import java.sql.*;
import java.util.*;

public class GoodBeanBo {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	public GoodBean getGoodBean(int id) {
		GoodBean gb = new GoodBean();
		try {
			ConnectDb connectDb = new ConnectDb();
			conn = connectDb.getConnection();
			ps = conn.prepareStatement("select * from bookInfo where book_id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				gb.setBookId(rs.getInt(1));
				gb.setBookName(rs.getString(2));
				gb.setBookInfo(rs.getString(3));
				gb.setBookPrice(rs.getFloat(4));
				gb.setBookAmount(rs.getInt(5));
				gb.setBookPublisher(rs.getString(6));
				gb.setBookPhoto(rs.getString(7));
				gb.setBookType(rs.getString(8));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		
		return gb;
		
	}
	
	public List<GoodBean> getGoodsByPage(int pageSize, int pageNow) {
		List<GoodBean> res = new ArrayList<>();
		try {
			conn = new ConnectDb().getConnection();
			ps = (PreparedStatement) conn.prepareStatement("select * from bookInfo where book_id not in "
					+ "(select * from (select book_id from bookInfo limit ?) as t) limit ?");
			ps.setInt(1, pageSize * (pageNow - 1));
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				GoodBean gb = new GoodBean();
				gb.setBookId(rs.getInt(1));
				gb.setBookName(rs.getString(2));
				gb.setBookInfo(rs.getString(3));
				gb.setBookPrice(rs.getFloat(4));
				gb.setBookAmount(rs.getInt(5));
				gb.setBookPublisher(rs.getString(6));
				gb.setBookPhoto(rs.getString(7));
				gb.setBookType(rs.getString(8));
				res.add(gb);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		
		return res;
		
	}
	public int getPageCount(int pageSize) {
		int pageCount = 0;
		int rowCount = 0;
		try {
			conn = new ConnectDb().getConnection();
			ps = conn.prepareStatement("select count(*) from bookInfo");
			rs = ps.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
			}
			if (rowCount % pageSize == 0) {
				pageCount = rowCount / pageSize;
			} else {
				pageCount = rowCount / pageSize + 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return pageCount;
		
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
