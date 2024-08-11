package com.tapfoods.DAOimpl;

import com.tapfoods.DAO.restaurentDAO;
import java.sql.*;
import java.util.ArrayList;
import com.tapfoods.BDUtils.DBUtils;
import com.tapfoods.model.restaurent;
public class restaurentDAOImpl implements restaurentDAO {
			private Connection con;
			private int status;
			private static final String ADD_RESTAURENT = "INSERT INTO restaurent (restaurentName, deliveryTime, cuisineType, address, ratings, adminId, imgpath) VALUES (?, ?, ?, ?, ?, ?, ?)";
			private static final String SELECT_ALL = "SELECT * FROM restaurent";
			private static final String SELECT_ON_EMAIL = "SELECT * FROM restaurent WHERE restaurentId = ?";
			private static final String UPDATE_ON_EMAIL = "UPDATE restaurent SET restaurentName = ?, deliveryTime = ?, cuisineType = ?, address = ?, ratings = ?, adminId = ?, imgpath = ? WHERE restaurentId = ?";
			private static final String DELETE_ON_EMAIL = "DELETE FROM restaurent WHERE restaurentId = ?";
		    public restaurentDAOImpl() {
				try {
					con=DBUtils.myConnect();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		    @Override
		    public int addRestaurant(restaurent r) {
		        try {
		             PreparedStatement statement = con.prepareStatement(ADD_RESTAURENT);
		            statement.setString(1, r.getRestaurentName());
		            statement.setInt(2, r.getDeliveryTime());
		            statement.setString(3, r.getCuisineType());
		            statement.setString(4, r.getAddress());
		            statement.setFloat(5, r.getRatings());
		            statement.setInt(6, r.getAdminId());
		            statement.setString(7, r.getImgpath());
		             status=statement.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return status;
		    }

		    @Override
		    public ArrayList<restaurent> getAllRestaurants() {
		        ArrayList<restaurent> restaurants = new ArrayList<>();
		        try (Statement statement = con.createStatement();
		             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
		            while (resultSet.next()) {
		                restaurants.add(new restaurent(
		                        resultSet.getInt("restaurentId"),
		                        resultSet.getString("restaurentName"),
		                        resultSet.getInt("deliveryTime"),
		                        resultSet.getString("cuisineType"),
		                        resultSet.getString("address"),
		                        resultSet.getFloat("ratings"),
		                        resultSet.getInt("adminId"),
		                        resultSet.getString("imgpath")
		                ));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return restaurants;
		    }
		    @Override
		    public restaurent getRestaurant(int restaurantId) {
		        try {
		             PreparedStatement statement = con.prepareStatement(SELECT_ON_EMAIL);
		            statement.setInt(1, restaurantId);
		            try (ResultSet resultSet = statement.executeQuery()) {
		                if (resultSet.next()) {
		                    return new restaurent(
		                            resultSet.getInt("restaurentId"),
		                            resultSet.getString("restaurentName"),
		                            resultSet.getInt("deliveryTime"),
		                            resultSet.getString("cuisineType"),
		                            resultSet.getString("address"),
		                            resultSet.getFloat("ratings"),
		                            resultSet.getInt("adminId"),
		                            resultSet.getString("imgpath")
		                    );
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return null;
		    }

		    @Override
		    public int updateRestaurant(restaurent r) {
		        try {
		             PreparedStatement statement = con.prepareStatement(UPDATE_ON_EMAIL);
		            statement.setString(1, r.getRestaurentName());
		            statement.setInt(2, r.getDeliveryTime());
		            statement.setString(3, r.getCuisineType());
		            statement.setString(4, r.getAddress());
		            statement.setFloat(5, r.getRatings());
		            statement.setInt(6, r.getAdminId());
		            statement.setString(7, r.getImgpath());
		            statement.setInt(8, r.getRestaurentId());
		            return statement.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return 0;
		    }

		    @Override
		    public int deleteRestaurant(int restaurantId) {
		        try {
		             PreparedStatement statement = con.prepareStatement(DELETE_ON_EMAIL);
		            statement.setInt(1, restaurantId);
		            return statement.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return 0;
		    }
		}
