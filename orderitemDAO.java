package com.tapfoods.DAO;

import java.util.ArrayList;

import com.tapfoods.model.orderitem;

public interface orderitemDAO {
		int addOrderItem(orderitem oi);
	    ArrayList<orderitem> getAllOrderItems();
	    orderitem getOrderItem(int orderItemId);
	}

