package com.italent.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GettingDatabaseConnection 
{
	ResourceBundle rb=ResourceBundle.getBundle("Application");
	public Connection createConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName(rb.getString("driver"));
		Connection con = DriverManager.getConnection(rb.getString("databaseurl"), rb.getString("user"),rb.getString("databasepassword"));
		return con;
	}
}
