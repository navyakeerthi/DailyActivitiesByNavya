package com.italent2.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.italent2.daoImpl.UserRolesDaoImpl;

public class UserRolesService 
{
	public static final Logger logger=LogManager.getLogger(UserRolesService.class.getName());
	ResourceBundle rb=ResourceBundle.getBundle("Application");
	UserRolesDaoImpl db=new UserRolesDaoImpl();
	
	public int retrieveUsersCount(String key) throws ClientProtocolException, IOException, URISyntaxException
	{
		String url=rb.getString("url")+rb.getString("userscounturl");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		NameValuePair nv1 = new BasicNameValuePair("restapi.session_key",key.toString());
		params.add(nv1);
		NameValuePair nv2 = new BasicNameValuePair("restapi.response_format",rb.getString("format"));
		params.add(nv2);
		HttpClient client1 = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		URI uri = new URIBuilder(request.getURI()).addParameters(params).build();
		            request.setURI(uri);
		request.addHeader("Authorization",rb.getString("authorization"));
		HttpResponse response=client1.execute(request);
		logger.info("getting response");
        ObjectMapper objectMapper = new ObjectMapper();
		JsonNode tree = objectMapper.readTree(new BasicResponseHandler().handleResponse(response));
		int count=tree.get("response").get("value").get("$").asInt();
		return count;
	}
	
	public void insertToDb(int pages, String key) throws ClientProtocolException, IOException
	{
		for(int i=0;i<pages;i++)
		{
			String url="https://italent2.demo.lithium.com/restapi/vc/users?restapi.session_key="+key+"&restapi.response_format=json&pagesize=500&page="+i;
			HttpClient client1 = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);
			request.addHeader("Authorization",rb.getString("authorization"));
			HttpResponse response=client1.execute(request);
			logger.info("getting response");
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode tree = objectMapper.readTree(new BasicResponseHandler().handleResponse(response));
			System.out.println(tree);
		}
		//return response;
	}
}
