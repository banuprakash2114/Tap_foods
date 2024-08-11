package com.tapfoods.DAOimpl;
import com.tapfoods.DAO.ordertableDAO;
import java.sql.*;
import java.util.ArrayList;
import com.tapfoods.BDUtils.DBUtils;
import com.tapfoods.model.ordertable;
public class ordertableDAOImpl implements ordertableDAO {
		    private static final String INSERT_ORDER = "INSERT INTO ordertable (restaurentId, userId, orderDate, totalAmount, status) VALUES (?, ?, ?, ?, ?)";
		    private static final String SELECT_ALL = "SELECT * FROM ordertable";
		    private static final String SELECT_BY_ID = "SELECT * FROM ordertable WHERE orderId = ?";
		    private Connection con;
		    public ordertableDAOImpl() {
		    	try {
					con=DBUtils.myConnect();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		    }

		    @Override
		    public int addOrder(ordertable o) {
		        try (PreparedStatement statement = con.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS)) {
		            statement.setInt(1, o.getRestaurentId());
		            statement.setInt(2, o.getUserId());
		            statement.setString(3, o.getOrderDate());
		            statement.setFloat(4, o.getTotalAmount());
		            statement.setString(5, o.getStatus());
		            
		            int rowsAffected = statement.executeUpdate();
		            
		            if (rowsAffected > 0) {
		                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
		                    if (generatedKeys.next()) {
		                        return generatedKeys.getInt(1); // Return the newly generated orderId
		                    }
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return 0;
		    }

		    @Override
		    public ArrayList<ordertable> getAllOrders() {
		        ArrayList<ordertable> orders = new ArrayList<>();
		        try (Statement statement = con.createStatement();
		             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
		             
		            while (resultSet.next()) {
		                orders.add(new ordertable(
		                        resultSet.getInt("orderId"),
		                        resultSet.getInt("restaurentId"),
		                        resultSet.getInt("userId"),
		                        resultSet.getString("orderDate"),
		                        resultSet.getFloat("totalAmount"),
		                        resultSet.getString("status")
		                ));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return orders;
		    }

		    @Override
		    public ordertable getOrder(int orderId) {
		        try (PreparedStatement statement = con.prepareStatement(SELECT_BY_ID)) {
		            statement.setInt(1, orderId);
		            try (ResultSet resultSet = statement.executeQuery()) {
		                if (resultSet.next()) {
		                    return new ordertable(
		                            resultSet.getInt("orderId"),
		                            resultSet.getInt("restaurentId"),
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
