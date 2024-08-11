package com.tapfoods.model;

public class user {
		private int userId;
		private String email;
		private String username;
		private String password;
		private String address;
		private String phonenumber;
		public user() {
			super();
		}
		public user(int userId, String email, String username, String password, String address, String phonenumber) {
			super();
			this.userId = userId;
			this.email = email;
			this.username = username;
			this.password = password;
			this.address = address;
			this.phonenumber = phonenumber;
		}
		public user(String email, String username, String password, String address, String phonenumber) {
			super();
			this.email = email;
			this.username = username;
			this.password = password;
			this.address = address;
			this.phonenumber = phonenumber;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}
		@Override
		public String toString() {
			return "user [userId=" + userId + ", email=" + email + ", username=" + username + ", password=" + password
					+ ", address=" + address + ", phonenumber=" + phonenumber + "]";
		}
	}

