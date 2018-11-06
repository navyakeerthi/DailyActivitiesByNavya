package com.italent2.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class RolesService 
{
	ResourceBundle rb=ResourceBundle.getBundle("Application");
	StringBuffer result;
	public void retrieveRoles(String key) throws ClientProtocolException, IOException, URISyntaxException
	{
		String url=rb.getString("rolesurl");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		NameValuePair nv1 = new BasicNameValuePair("restapi.session_key",key.toString());
		params.add(nv1);
		NameValuePair nv2 = new BasicNameValuePair("restapi.response_format","json");
		params.add(nv2);
		HttpClient client1 = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		URI uri = new URIBuilder(request.getURI()).addParameters(params).build();
		            request.setURI(uri);
		request.addHeader("Authorization","Basic ZGVtbzAxOlN1UHIxKm1aTGk=");
		HttpResponse response=client1.execute(request);
		System.out.println("getting response");
		BufferedReader br=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		result = new StringBuffer();
		String line = "";
		while ((line = br.readLine()) != null) 
		{
			result.append(line);
		}
		System.out.println(result);
	}
}
