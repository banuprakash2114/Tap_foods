package com.tapfoods.model;

public class restaurent {
		private int restaurentId;
		private String restaurentName;
		private int deliveryTime;
		private String cuisineType;
		private String address;
		private float ratings;
		private int adminId;
		private String imgpath;
		public restaurent() {
			super();
		}
		public restaurent(int restaurentId, String restaurentName, int deliveryTime, String cuisineType, String address,
				float ratings, int adminId, String imgpath) {
			super();
			this.restaurentId = restaurentId;
			this.restaurentName = restaurentName;
			this.deliveryTime = deliveryTime;
			this.cuisineType = cuisineType;
			this.address = address;
			this.ratings = ratings;
			this.adminId = adminId;
			this.imgpath = imgpath;
		}
		public restaurent(String restaurentName, int deliveryTime, String cuisineType, String address, float ratings,
				int adminId, String imgpath) {
			super();
			this.restaurentName = restaurentName;
			this.deliveryTime = deliveryTime;
			this.cuisineType = cuisineType;
			this.address = address;
			this.ratings = ratings;
			this.adminId = adminId;
			this.imgpath = imgpath;
		}
		public int getRestaurentId() {
			return restaurentId;
		}
		public void setRestaurentId(int restaurentId) {
			this.restaurentId = restaurentId;
		}
		public String getRestaurentName() {
			return restaurentName;
		}
		public void setRestaurentName(String restaurentName) {
			this.restaurentName = restaurentName;
		}
		public int getDeliveryTime() {
			return deliveryTime;
		}
		public void setDeliveryTime(int deliveryTime) {
			this.deliveryTime = deliveryTime;
		}
		public String getCuisineType() {
			return cuisineType;
		}
		public void setCuisineType(String cuisineType) {
			this.cuisineType = cuisineType;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public float getRatings() {
			return ratings;
		}
		public void setRatings(float ratings) {
			this.ratings = ratings;
		}
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public String getImgpath() {
			return imgpath;
		}
		public void setImgpath(String imgpath) {
			this.imgpath = imgpath;
		}
		@Override
		public String toString() {
			return "restaurent [restaurentId=" + restaurentId + ", restaurentName=" + restaurentName + ", deliveryTime="
					+ deliveryTime + ", cuisineType=" + cuisineType + ", address=" + address + ", ratings=" + ratings
					+ ", adminId=" + adminId + ", imgpath=" + imgpath + "]";
		}
	}
