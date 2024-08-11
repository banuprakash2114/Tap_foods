package com.tapfoods.DAOimpl;

import com.tapfoods.DAO.orderhistoryDAO;
import java.sql.*;
import java.util.ArrayList;

import com.tapfoods.BDUtils.DBUtils;
import com.tapfoods.model.orderhistory;
public class orderhistoryDAOImpl implements orderhistoryDAO {
		    private static final String INSERT_ORDER_HISTORY = "INSERT INTO orderhistory (orderId, userId, orderDate, totalAmount, status) VALUES (?, ?, ?, ?, ?)";
		    private static final String SELECT_ALL = "SELECT * FROM orderhistory";
		    private static final String SELECT_BY_ID = "SELECT * FROM orderhistory WHERE orderHistoryId = ?";
		    private Connection con;
		    public orderhistoryDAOImpl() {
		    	try
		    	{
					con=DBUtils.myConnect();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		    }

		    @Override
		    public int addOrderHistory(orderhistory oh) {
		        try (PreparedStatement statement = con.prepareStatement(INSERT_ORDER_HISTORY, Statement.RETURN_GENERATED_KEYS)) {
		            statement.setInt(1, oh.getOrderId());
		            statement.setInt(2, oh.getUserId());
		            statement.setString(3, oh.getOrderDate());
		            statement.setFloat(4, oh.getTotalAmount());
		            statement.setString(5, oh.getStatus());
		            
		            int rowsAffected = statement.executeUpdate();
		            
		            if (rowsAffected > 0) {
		                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
		                    if (generatedKeys.next()) {
		                        return generatedKeys.getInt(1); // Return the newly generated orderHistoryId
		                    }
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return 0;
		    }

		    @Override
		    public ArrayList<orderhistory> getAllOrderHistories() {
		        ArrayList<orderhistory> orderHistories = new ArrayList<>();
		        try (Statement statement = con.createStatement();
		             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
		             
		            while (resultSet.next()) {
		                orderHistories.add(new orderhistory(
		                        resultSet.getInt("orderHistoryId"),
		                        resultSet.getInt("orderId"),
		                        resultSet.getInt("userId"),
		                        resultSet.getString("orderDate"),
		                        resultSet.getFloat("totalAmount"),
		                        resultSet.getString("status")
		                ));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return orderHistories;
		    }

		    @Override
		    public orderhistory getOrderHistory(int orderHistoryId) {
		        try (PreparedStatement statement = con.prepareStatement(SELECT_BY_ID)) {
		            statement.setInt(1, orderHistoryId);
		            try (ResultSet resultSet = statement.executeQuery()) {
		                if (resultSet.next()) {
		                    return new orderhistory(
		                            resultSet.getInt("orderHistoryId"),
		                            resultSet.getInt("orderId"),
		                            resultSet.getInt("userId"),
		                            resultSet.getString("orderDate"),
		                            resultSet.getFloat("totalAmount"),
		                            resultSet.getString("status")
		                    );
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return null;
		    }
	}
