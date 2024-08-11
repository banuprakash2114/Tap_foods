package com.tapfoods.DAO;

import java.util.ArrayList;

import com.tapfoods.model.user;

public interface userDAO {
		int addUser(user u);
		ArrayList<user> getAllUsers();
		user getUser(String email);
		int updateUser(user u);
		int deleteUser(String email);
	}
