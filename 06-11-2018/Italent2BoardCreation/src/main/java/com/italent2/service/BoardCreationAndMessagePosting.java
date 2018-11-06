package com.italent2.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.italent2.model.Messages;

public class BoardCreationAndMessagePosting 
{
	ResourceBundle rb=ResourceBundle.getBundle("Application");
	public String sesiionKeyGeneration() throws HttpResponseException, IOException
	{
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost postRequest=new HttpPost(rb.getString("posturl"));
			postRequest.addHeader("Authorization","Basic ZGVtbzAxOlN1UHIxKm1aTGk=");
			HttpResponse response=client.execute(postRequest);
			int statusCode=response.getStatusLine().getStatusCode();
			if(statusCode!=200)
			{
				throw new RuntimeException("failed with response code"+statusCode);
			}
			System.out.println(response);
			System.out.println("generating a session key");
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode tree = objectMapper.readTree(new BasicResponseHandler().handleResponse(response));
			JsonNode response1=tree.get("response");
			JsonNode value=response1.get("value");
			String key=value.get("$").asText();
			System.out.println("Generated session key is: "+key);
			return key;
	}
	
	public void boardCreation(String key)
	{
		try
		{
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost postRequest=new HttpPost(rb.getString("boardurl"));
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("restapi.session_key",key.toString()));
			params.add(new BasicNameValuePair("restapi.response_format","json"));
			postRequest.setEntity(new UrlEncodedFormEntity(params));
			postRequest.addHeader("Authorization","Basic ZGVtbzAxOlN1UHIxKm1aTGk=");
			HttpResponse response=client.execute(postRequest);
			int statusCode=response.getStatusLine().getStatusCode();
			if(statusCode!=200)
			{
				throw new RuntimeException("failed with response code"+statusCode);
			}
			System.out.println("successfully created the board");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public HttpResponse setMessage(String key) throws ClientProtocolException, IOException
	{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost postRequest=new HttpPost(rb.getString("messageurl"));
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("restapi.session_key",key.toString()));
		params.add(new BasicNameValuePair("restapi.response_format","json"));
		postRequest.setEntity(new UrlEncodedFormEntity(params));
		postRequest.addHeader("Authorization","Basic ZGVtbzAxOlN1UHIxKm1aTGk=");
		HttpResponse response=client.execute(postRequest);
		int statusCode=response.getStatusLine().getStatusCode();
		if(statusCode!=200)
		{
			throw new RuntimeException("failed with response code"+statusCode);
		}
		System.out.println("message added successfully");
		return response;
	}
	
	public Messages readMessage(HttpResponse response) throws HttpResponseException, IOException, ParseException
	{
        ObjectMapper objectMapper = new ObjectMapper();
		JsonNode tree = objectMapper.readTree(new BasicResponseHandler().handleResponse(response));
		JsonNode response1=tree.get("response");
		System.out.println(tree);
		JsonNode message=response1.get("message");
		
		String href=message.get("href").asText();
		String post_time=message.get("post_time").get("$").asText();
		String last_edit_time=message.get("last_edit_time").get("$").asText();
		String subject=message.get("subject").get("$").asText();
		String author=message.get("author").get("login").get("$").asText();
		int id=message.get("id").get("$").asInt();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
		Date postTime=format.parse(post_time);
		Date lastEditTime=format.parse(last_edit_time);
		
		//create model 
		Messages msg=new Messages();
		
		//set model
		msg.setId(id);
		msg.setHref(href);
		msg.setPost_time(postTime);
		msg.setLast_edit_time(lastEditTime);
		msg.setSubject(subject);
		msg.setAuthor(author);
		return msg;
	}
	public void postReply(String key) throws ClientProtocolException, IOException
	{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost postRequest=new HttpPost(rb.getString("replyurl"));	
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("restapi.session_key",key.toString()));
		params.add(new BasicNameValuePair("restapi.response_format","json"));
		postRequest.setEntity(new UrlEncodedFormEntity(params));
		postRequest.addHeader("Authorization","Basic ZGVtbzAxOlN1UHIxKm1aTGk=");
		HttpResponse response=client.execute(postRequest);
		int statusCode=response.getStatusLine().getStatusCode();
		if(statusCode!=200)
		{
			throw new RuntimeException("failed with response code"+statusCode);
		}
		System.out.println("replied successfully");
	}
	
}
