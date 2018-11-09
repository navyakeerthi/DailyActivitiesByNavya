package com.italent.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.http.client.HttpResponseException;
import org.json.simple.parser.ParseException;

import com.italent.dao.GettingDatabaseConnection;
import com.italent.service.ApiCallingAndDatabaseProcessing;
import com.italent.util.EmailSending;

public class ApiJsonProcessing 
{
	ResourceBundle rb=ResourceBundle.getBundle("Application");
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException, ParseException, HttpResponseException, IOException
	{
		GettingDatabaseConnection dc=new GettingDatabaseConnection();
		Connection con=dc.createConnection();
		ApiCallingAndDatabaseProcessing api=new ApiCallingAndDatabaseProcessing();

		String json=api.apiCalling();
		api.creatingTable(con);
		api.apiWriting(con, json);
		Map<Integer,String> map=api.retrievingData(con);
		EmailSending email=new EmailSending();
		email.mailSending(con, map);
		api.updatingData(con, map);
		Map<Integer,String> map1=api.retrievingData(con);
		email.mailSending(con, map1);
	}
}
