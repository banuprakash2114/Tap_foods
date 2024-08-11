package com.tapfoods.DAOimpl;

import com.tapfoods.DAO.orderitemDAO;


import java.sql.*;
import java.util.ArrayList;

import com.tapfoods.BDUtils.DBUtils;
import com.tapfoods.model.orderitem;
public class orderitemDAOImpl implements orderitemDAO {
		    private static final String INSERT_ORDER_ITEM = "INSERT INTO orderitem (orderId, menuId, quantity, subTotal) VALUES (?, ?, ?, ?)";
		    private static final String SELECT_ALL = "SELECT * FROM orderitem";
		    private static final String SELECT_BY_ID = "SELECT * FROM orderitem WHERE orderItemId = ?";
		    private Connection con;
		    public orderitemDAOImpl() {
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
		    public int addOrderItem(orderitem oi) {
		        try (PreparedStatement statement = con.prepareStatement(INSERT_ORDER_ITEM, Statement.RETURN_GENERATED_KEYS)) {
		            statement.setInt(1, oi.getOrderId());
		            statement.setInt(2, oi.getMenuId());
		            statement.setInt(3, oi.getQuantity());
		            statement.setFloat(4, oi.getSubTotal());
		            
		            int rowsAffected = statement.executeUpdate();
		            
		            if (rowsAffected > 0) {
		                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
		                    if (generatedKeys.next()) {
		                        return generatedKeys.getInt(1); // Return the newly generated orderItemId
		                    }
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return 0;
		    }

		    @Override
		    public ArrayList<orderitem> getAllOrderItems() {
		        ArrayList<orderitem> orderItems = new ArrayList<>();
		        try (Statement statement = con.createStatement();
		             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
		             
		            while (resultSet.next()) {
		                orderItems.add(new orderitem(
		                        resultSet.getInt("orderItemId"),
		                        resultSet.getInt("orderId"),
		                        resultSet.getInt("menuId"),
		                        resultSet.getInt("quantity"),
		                        resultSet.getFloat("subTotal")
		                ));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return orderItems;
		    }

		    @Override
		    public orderitem getOrderItem(int orderItemId) {
		        try (PreparedStatement statement = con.prepareStatement(SELECT_BY_ID)) {
		            statement.setInt(1, orderItemId);
		            try (ResultSet resultSet = statement.executeQuery()) {
		                if (resultSet.next()) {
		                    return new orderitem(
		                            resultSet.getInt("orderItemId"),
		                            resultSet.getInt("orderId"),
		                            resultSet.getInt("menuId"),
		                            resultSet.getInt("quantity"),
		                            resultSet.getFloat("subTotal")
		                    );
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return null;
		    }
	}
