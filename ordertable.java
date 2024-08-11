package com.tapfoods.model;

public class ordertable {
		private int orderId;
		private int restaurentId;
		private int userId;
		private String orderDate;
		private float totalAmount;
		private String status;
		public ordertable() {
			super();
		}
		public ordertable(int orderId, int restaurentId, int userId, String orderDate, float totalAmount, String status) {
			super();
			this.orderId = orderId;
			this.restaurentId = restaurentId;
			this.userId = userId;
			this.orderDate = orderDate;
			this.totalAmount = totalAmount;
			this.status = status;
		}
		public ordertable(int restaurentId, int userId, String orderDate, float totalAmount, String status) {
			super();
			this.restaurentId = restaurentId;
			this.userId = userId;
			this.orderDate = orderDate;
			this.totalAmount = totalAmount;
			this.status = status;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public int getRestaurentId() {
			return restaurentId;
		}
		public void setRestaurentId(int restaurentId) {
			this.restaurentId = restaurentId;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(String orderDate) {
			this.orderDate = orderDate;
		}
		public float getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(float totalAmount) {
			this.totalAmount = totalAmount;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "ordertable [orderId=" + orderId + ", restaurentId=" + restaurentId + ", userId=" + userId
					+ ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status + "]";
		}
	}
