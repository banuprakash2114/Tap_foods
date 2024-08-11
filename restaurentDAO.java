package com.tapfoods.DAO;

import java.util.ArrayList;

import com.tapfoods.model.restaurent;

public interface restaurentDAO {
		int addRestaurant(restaurent r);
	    ArrayList<restaurent> getAllRestaurants();
	    restaurent getRestaurant(int restaurantId);
	    int updateRestaurant(restaurent r);
	    int deleteRestaurant(int restaurantId);
	}

