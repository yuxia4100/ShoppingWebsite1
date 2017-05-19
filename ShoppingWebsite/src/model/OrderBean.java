package model;

public class OrderBean {
	private int orderId;
	private int userId;
	private java.util.Date orderDate;
	private String orderPayment;
	private String orderIsPayed;
	private float orderTotalPrice;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public java.util.Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderPayment() {
		return orderPayment;
	}
	public void setOrderPayment(String orderPayment) {
		this.orderPayment = orderPayment;
	}
	public String getOrderIsPayed() {
		return orderIsPayed;
	}
	public void setOrderIsPayed(String orderIsPayed) {
		this.orderIsPayed = orderIsPayed;
	}
	public float getOrderTotalPrice() {
		return orderTotalPrice;
	}
	public void setOrderTotalPrice(float orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
	
}
