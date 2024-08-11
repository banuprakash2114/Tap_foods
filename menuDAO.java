package com.tapfoods.DAO;

import java.util.ArrayList;

import com.tapfoods.model.menu;

public interface menuDAO {
		    int addMenu(menu m);
		    ArrayList<menu> getAllMenus();
		    menu getMenu(int menuId);
		    int updateMenu(menu m);
		    int deleteMenu(int menuId);
		}
