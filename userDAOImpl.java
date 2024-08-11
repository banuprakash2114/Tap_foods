package com.tapfoods.DAOimpl;
import com.tapfoods.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;
import com.tapfoods.BDUtils.DBUtils;
import com.tapfoods.DAO.userDAO;

public class userDAOImpl implements userDAO {
		 Connection con;
		private PreparedStatement pstmt;
		private java.sql.Statement stmt;
		private ResultSet resultSet;
		ArrayList<user> userlist = new ArrayList<user>();
		user user;
		 int status;
		 private static final String ADD_USER="insert into user(email,username,password,address,phonenumber )values(?,?,?,?,?)";
		 private static final String SELECT_All="select * from user";
		 private static final String SELECT_ON_EMAIL="select * from user where email=?";
		 private static final String UPDATE_ON_EMAIL="update user set username=?,password=?,address=?,phonenumber=? where email=?";
		 private static final String DELETE_ON_EMAIL="delete from user where email=?";
		public userDAOImpl() {
			try {
				con=DBUtils.myConnect();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		@Override
		public int addUser(user u) {
		    try {
		        // Prepare the SQL statement with the correct SQL syntax
		        pstmt = con.prepareStatement(ADD_USER);
		        pstmt.setString(1, u.getEmail());
		        pstmt.setString(2, u.getUsername());
		        pstmt.setString(3, u.getPassword());
		        pstmt.setString(4, u.getAddress());
		        pstmt.setString(5, u.getPhonenumber());

		        // Debugging: print the SQL statement and the parameters
		        System.out.println("Executing query: " + ADD_USER);
		        System.out.println("With parameters: " + u.getEmail() + ", " + u.getUsername() + ", " + u.getPassword() + ", " + u.getAddress() + ", " + u.getPhonenumber());

		        // Execute the SQL statement
		        status = pstmt.executeUpdate();

		        // Check the status of the operation
		        if (status > 0) {
		            System.out.println("User added successfully.");
		        } else {
		            System.out.println("Failed to add user.");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return status;
		}
		@Override
		public ArrayList<user> getAllUsers() {
			try {
				stmt=con.createStatement();
				resultSet=stmt.executeQuery(SELECT_All);
				userlist=extractUserFromResultSet(resultSet);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return userlist;
			
		}
		@Override
		public user getUser(String email) {
		try {
			pstmt=con.prepareStatement(SELECT_ON_EMAIL);
			pstmt.setString(1,email);
			resultSet=pstmt.executeQuery();
			userlist=extractUserFromResultSet(resultSet);
			user=userlist.get(0);	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return user;
			
		}
		@Override
		public int updateUser(user u) {
		try {
				pstmt=con.prepareStatement(UPDATE_ON_EMAIL);
				pstmt.setString(1,u.getUsername());
				pstmt.setString(2,u.getPassword());
				pstmt.setString(3,u.getAddress());
				pstmt.setString(4,u.getPhonenumber());
				pstmt.setString(5,u.getEmail());
				status=pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return status;
			
		}
		@Override
		public int deleteUser(String email) {
		try {
				pstmt=con.prepareStatement(DELETE_ON_EMAIL);
				pstmt.setString(1,email);
				status=pstmt.executeUpdate();
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return status;
			
		}
		
		ArrayList<user> extractUserFromResultSet(ResultSet resultSet) {
			
			try {
				while(resultSet.next()==true)
				{
				userlist.add(new user(resultSet.getInt("userId"),
					resultSet.getString("email"),
					resultSet.getString("username"),
					resultSet.getString("password"),
					resultSet.getString("address"),
					resultSet.getString("phonenumber")));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return userlist;
			
		}

	}
