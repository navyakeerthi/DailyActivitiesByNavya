package com.italent.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.italent.dao.GettingDatabaseConnection;
import com.italent.util.EmailSending;

public class ApiCallingAndDatabaseProcessing 
{
	static ResourceBundle rb=ResourceBundle.getBundle("application");
	StringBuffer result;
	Statement st=null;
	PreparedStatement pst=null;
	
	public String apiCalling()
	{
		try
		{
			CloseableHttpClient client = HttpClients.createDefault();
			String url=rb.getString("url");
			HttpGet request=new HttpGet(url);
			HttpResponse response=client.execute(request);
			System.out.println("getting response");
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
			e.printStackTrace();
		}
		return result.toString();
	}
	
	public void creatingTable(Connection con) throws ClassNotFoundException, SQLException
	{
		java.sql.DatabaseMetaData dbm = con.getMetaData();
		System.out.println("connecting to database");
		if (con != null)// checking for connection
			System.out.println("successful connected to database");
		st=con.createStatement();
		pst=con.prepareStatement(rb.getString("checkquery"));
		ResultSet tables = dbm.getTables(null, null, "users", null);
		if (tables.next()) 
		{
			System.out.println("table already exists");
		}
		else 
		{
				st.executeUpdate(rb.getString("createquery"));
				System.out.println("successfully created the table in database");
		}
	}
	
	public void apiWriting(Connection con,String result) throws ParseException, ClassNotFoundException, SQLException
	{		
		JSONParser parser = new JSONParser(); 
		JSONObject json = (JSONObject) parser.parse(result);
		JSONObject jsonData=(JSONObject) json.get("data");
		JSONArray jsonItems=(JSONArray)jsonData.get("items");
		System.out.println("inserting the data into database");
		for(int i=0;i<jsonItems.size();i++)
		{
			pst=con.prepareStatement(rb.getString("insertquery"));
			JSONObject obj=(JSONObject) jsonItems.get(i);
			pst.setInt(1,Integer.parseInt(obj.get("id").toString()));
			pst.setString(2, obj.get("login").toString());
			pst.setString(3, obj.get("email").toString());
			pst.executeUpdate();
		}	
		System.out.println("successfully inserted into database");
	}
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		ApiCallingAndDatabaseProcessing api=new ApiCallingAndDatabaseProcessing();
		GettingDatabaseConnection db=new GettingDatabaseConnection();
		
		Connection ccc=db.createConnection();
		api.retrievingData(ccc);
	}
	public Map<Integer,String> retrievingData(Connection con) throws SQLException
	{
		PreparedStatement ps=con.prepareStatement(rb.getString("selectquery"));
		ResultSet rs=ps.executeQuery();
		Map<Integer, String> map = new HashMap<Integer, String>();
		System.out.println("retrieving login data from the table");
		while(rs.next())
		{
			int id=rs.getInt("id");
			String login=rs.getString("login");
			map.put(id, login);
		}
		System.out.println("The list of id and login values are\n"+map);
		return map;
	}
	public void updatingData(Connection con,Map<Integer,String> map) throws SQLException
	{
		PreparedStatement ps=con.prepareStatement(rb.getString("updatequery"));
		
		Set<Integer> keys=map.keySet();
		System.out.println("updating table");
		for(int key:keys) 
		{
			String login=map.get(key);
			String loginrename=login+"_india";
			ps.setString(1, loginrename);
			ps.setInt(2, key);
			ps.executeUpdate();
			System.out.println(loginrename);
		}
		System.out.println("successfully updated");
	}
	
}
