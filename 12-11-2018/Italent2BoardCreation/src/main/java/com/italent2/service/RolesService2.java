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
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.italent2.daoImpl.RolesDaoImpl;
import com.italent2.model.Roles;

public class RolesService2 
{
	StringBuffer result;
	RolesDaoImpl db=new RolesDaoImpl();
	ResourceBundle rb=ResourceBundle.getBundle("Application");
	public static final Logger logger=LogManager.getLogger(RolesService2.class.getName());

	public HttpResponse retrieveRoles(String key) throws ClientProtocolException, IOException, URISyntaxException
	{
		String url=rb.getString("url")+rb.getString("rolesurl");
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
		return response;
	}
	
	public void insertRolesToDb(HttpResponse response) throws HttpResponseException, IOException
	{
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode tree = objectMapper.readTree(new BasicResponseHandler().handleResponse(response));
			JsonNode roles=tree.get("response").get("roles").get("role");
			Roles role=new Roles();
			for(JsonNode rolearray:roles)
			{
				int id=rolearray.get("id").get("$").asInt();
				String name=rolearray.get("name").get("$").asText();
				role.setRoleId(id);
				role.setRoleName(name);
				db.saveToDb(role);
			}
	}
}
