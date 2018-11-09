package com.italent.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ApiCallingAndDatabaseProcessing 
{
	public static final Logger logger=LogManager.getLogger(ApiCallingAndDatabaseProcessing.class.getName());
	static ResourceBundle rb=ResourceBundle.getBundle("application");
	StringBuffer result;
	Statement st=null;
	PreparedStatement pst=null;
	StringWriter writer=new StringWriter();
	
	public String apiCalling()
	{
		try
		{
			CloseableHttpClient client = HttpClients.createDefault();
			String url=rb.getString("url");
			HttpGet request=new HttpGet(url);
			request.addHeader("Authorization","Basic ZGVtbzAxOlN1UHIxKm1aTGk=");
			HttpResponse response=client.execute(request);
			logger.info("getting response");
			BufferedReader br=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			result = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null) 
			{
				result.append(line);
			}
			
		}
		catch(Exception e)
		{
			logger.error("error in the code"+e,e);
		}
		return result.toString();
	}
	
	public void creatingTable(Connection con) throws ClassNotFoundException, SQLException
	{
		java.sql.DatabaseMetaData dbm = con.getMetaData();
		logger.info("connecting to database");
		if (con != null)// checking for connection
			logger.info("successfully connected to the database");
		st=con.createStatement();
		pst=con.prepareStatement(rb.getString("checkquery"));
		ResultSet tables = dbm.getTables(null, null, "users", null);
		if (tables.next()) 
		{
			logger.info("table already exists");
		}
		else 
		{
				st.executeUpdate(rb.getString("createquery"));
				logger.info("Successfully created the table");
		}
	}
	
	public void apiWriting(Connection con,String result) throws ParseException, ClassNotFoundException, SQLException
	{		
		JSONParser parser = new JSONParser(); 
		JSONObject json = (JSONObject) parser.parse(result);
		JSONObject jsonData=(JSONObject) json.get("data");
		JSONArray jsonItems=(JSONArray)jsonData.get("items");
		logger.info("inserting into the database");
		for(int i=0;i<jsonItems.size();i++)
		{
			pst=con.prepareStatement(rb.getString("insertquery"));
			JSONObject obj=(JSONObject) jsonItems.get(i);
			pst.setInt(1,Integer.parseInt(obj.get("id").toString()));
			pst.setString(2, obj.get("login").toString());
			pst.setString(3, obj.get("email").toString());
			pst.executeUpdate();
		}	
		logger.info("successfully inserted");
	}
	
	public Map<Integer,String> retrievingData(Connection con) throws SQLException
	{
		PreparedStatement ps=con.prepareStatement(rb.getString("selectquery"));
		ResultSet rs=ps.executeQuery();
		Map<Integer, String> map = new HashMap<Integer, String>();
		logger.info("retrieving the login values from the database");
		while(rs.next())
		{
			int id=rs.getInt("id");
			String login=rs.getString("login");
			map.put(id, login);
		}
		logger.info("the list of Id and Login values are"+map);
		return map;
	}
	public void updatingData(Connection con,Map<Integer,String> map) throws SQLException
	{
		PreparedStatement ps=con.prepareStatement(rb.getString("updatequery"));
		
		Set<Integer> keys=map.keySet();
		logger.info("Updating the table");
		for(int key:keys) 
		{
			String login=map.get(key);
			String loginrename=login+"_india";
			ps.setString(1, loginrename);
			ps.setInt(2, key);
			ps.executeUpdate();
			System.out.println(loginrename);
		}
		logger.info("successfully updated");
	}
}
