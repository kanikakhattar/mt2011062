package org.iiitb.exam.mt2011062.tours.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

		public static Connection getConnection()
		{		
			
			String driver = "com.mysql.jdbc.Driver";
			String username = "root";
			String password = "";
			Connection conn = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tours", username,password);
			return conn;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
			
		}

	}

}


