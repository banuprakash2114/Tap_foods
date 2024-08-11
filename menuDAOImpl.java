package com.tapfoods.DAOimpl;
import com.tapfoods.DAO.menuDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfoods.BDUtils.DBUtils;
import com.tapfoods.model.menu;
public class menuDAOImpl implements menuDAO{
		    private static final String SELECT_ALL = "SELECT * FROM menu";
		    private static final String INSERT_MENU = "INSERT INTO menu (restaurentId, menuName, price, description, isAvailable, imgpath) VALUES (?, ?, ?, ?, ?, ?)";
		    private static final String SELECT_MENU_BY_ID = "SELECT * FROM menu WHERE menuId = ?";
		    private static final String UPDATE_MENU = "UPDATE menu SET restaurentId = ?, menuName = ?, price = ?, description = ?, isAvailable = ?, imgpath = ? WHERE menuId = ?";
		    private static final String DELETE_MENU = "DELETE FROM menu WHERE menuId = ?";

		    private Connection con;

		    public menuDAOImpl() {
					try {
						con=DBUtils.myConnect();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}

		    @Override
		    public int addMenu(menu m) {
		        try (PreparedStatement statement = con.prepareStatement(INSERT_MENU)) {
		            statement.setInt(1, m.getRestaurentId());
		            statement.setString(2, m.getMenuName());
		            statement.setFloat(3, m.getPrice());
		            statement.setString(4, m.getDescription());
		            statement.setString(5, m.getIsAvailable());
		            statement.setString(6, m.getImgpath());
		            return statement.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return 0;
		    }

		    @Override
		    public ArrayList<menu> getAllMenus() {
		        ArrayList<menu> menus = new ArrayList<>();
		        try (Statement statement = con.createStatement();
		             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
		            while (resultSet.next()) {
		                menus.add(new menu(
		                        resultSet.getInt("menuId"),
		                        resultSet.getInt("restaurentId"),
		                        resultSet.getString("menuName"),
		                        resultSet.getFloat("price"),
		                        resultSet.getString("description"),
		                        resultSet.getString("isAvailable"),
		                        resultSet.getString("imgpath")
		                ));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return menus;
		    }

		    @Override
		    public menu getMenu(int menuId) {
		        try (PreparedStatement statement = con.prepareStatement(SELECT_MENU_BY_ID)) {
		            statement.setInt(1, menuId);
		            try (ResultSet resultSet = statement.executeQuery()) {
		                if (resultSet.next()) {
		                    return new menu(
		                            resultSet.getInt("menuId"),
		                            resultSet.getInt("restaurentId"),
		                            resultSet.getString("menuName"),
		                            resultSet.getFloat("price"),
		                            resultSet.getString("description"),
		                            resultSet.getString("isAvailable"),
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
		    public int updateMenu(menu m) {
		        try (PreparedStatement statement = con.prepareStatement(UPDATE_MENU)) {
		            statement.setInt(1, m.getRestaurentId());
		            statement.setString(2, m.getMenuName());
		            statement.setFloat(3, m.getPrice());
		            statement.setString(4, m.getDescription());
		            statement.setString(5, m.getIsAvailable());
		            statement.setString(6, m.getImgpath());
		            statement.setInt(7, m.getMenuId());
		            return statement.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return 0;
		    }

		    @Override
		    public int deleteMenu(int menuId) {
		        try (PreparedStatement statement = con.prepareStatement(DELETE_MENU)) {
		            statement.setInt(1, menuId);
		            return statement.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return 0;
		    }
		}

