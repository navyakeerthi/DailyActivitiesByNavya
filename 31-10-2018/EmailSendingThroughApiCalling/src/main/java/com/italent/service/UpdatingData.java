package com.italent.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.italent.dao.GettingDatabaseConnection;

public class UpdatingData 
{
	ResourceBundle rb=ResourceBundle.getBundle("Application");
	public void updatingData(Map<Integer,String> map)
	{
		Set<Integer> keys=map.keySet();
		System.out.println(keys);
		for(int key:keys) {
			String login=map.get(key);
			
			String loginrename=login+"_india";
			System.out.println(loginrename);
		}
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		ApiCallingAndDatabaseProcessing api=new ApiCallingAndDatabaseProcessing();
		GettingDatabaseConnection db=new GettingDatabaseConnection();
		UpdatingData ud=new UpdatingData();
		Connection con=db.createConnection();
		Map<Integer,String> map=api.retrievingData(con);
		ud.updatingData(map);
	}
}
