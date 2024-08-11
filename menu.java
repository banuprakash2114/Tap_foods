package com.tapfoods.model;

public class menu {
		private int menuId;
		private int restaurentId;
		private String menuName;
		private float price;
		private String description;
		private String isAvailable;
		private String imgpath;
		public menu() {
			super();
		}
		public menu(int menuId, int restaurentId, String menuName, float price, String description, String isAvailable,
				String imgpath) {
			super();
			this.menuId = menuId;
			this.restaurentId = restaurentId;
			this.menuName = menuName;
			this.price = price;
			this.description = description;
			this.isAvailable = isAvailable;
			this.imgpath = imgpath;
		}
		public menu(int restaurentId, String menuName, float price, String description, String isAvailable,
				String imgpath) {
			super();
			this.restaurentId = restaurentId;
			this.menuName = menuName;
			this.price = price;
			this.description = description;
			this.isAvailable = isAvailable;
			this.imgpath = imgpath;
		}
		public int getMenuId() {
			return menuId;
		}
		public void setMenuId(int menuId) {
			this.menuId = menuId;
		}
		public int getRestaurentId() {
			return restaurentId;
		}
		public void setRestaurentId(int restaurentId) {
			this.restaurentId = restaurentId;
		}
		public String getMenuName() {
			return menuName;
		}
		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getIsAvailable() {
			return isAvailable;
		}
		public void setIsAvailable(String isAvailable) {
			this.isAvailable = isAvailable;
		}
		public String getImgpath() {
			return imgpath;
		}
		public void setImgpath(String imgpath) {
			this.imgpath = imgpath;
		}
		@Override
		public String toString() {
			return "menu [menuId=" + menuId + ", restaurentId=" + restaurentId + ", menuName=" + menuName + ", price="
					+ price + ", description=" + description + ", isAvailable=" + isAvailable + ", imgpath=" + imgpath
					+ "]";
		}
	}

