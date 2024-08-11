package com.tapfoods.DAO;

import java.util.ArrayList;

import com.tapfoods.model.orderhistory;

public interface orderhistoryDAO {
		int addOrderHistory(orderhistory oh);
	    ArrayList<orderhistory> getAllOrderHistories();
	    orderhistory getOrderHistory(int orderHistoryId);
	}

