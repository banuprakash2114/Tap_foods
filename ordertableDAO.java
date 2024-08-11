package com.tapfoods.DAO;

import java.util.ArrayList;

import com.tapfoods.model.ordertable;

public interface ordertableDAO {
		int addOrder(ordertable o);
	    ArrayList<ordertable> getAllOrders();
	    ordertable getOrder(int orderId);

	}
