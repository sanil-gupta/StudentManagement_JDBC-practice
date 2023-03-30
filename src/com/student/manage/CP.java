package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP 
{
	static Connection con;
	
	public static Connection createC()
	{
		try
		{
			//load the driver..
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create the connection...
			String url = "jdbc:mysql://localhost:3306/student_manage"; //At the last we have to mention our DB name
			String user = "root";  //user_name of DB
			String password = "redhat"; //user_password of DB
			
			con = DriverManager.getConnection(url,user,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
