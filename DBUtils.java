package com.tapfoods.BDUtils;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtils {
		private static Connection con;
		private static String url = "jdbc:mysql://localhost:3306/tapfoods";
		private static String username = "root";
		private static String password = "database";
		public static Connection myConnect()
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,username,password);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return con;
		}
	}
