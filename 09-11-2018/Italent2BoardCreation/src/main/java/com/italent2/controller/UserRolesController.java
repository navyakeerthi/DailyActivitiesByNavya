package com.italent2.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ResourceBundle;

import org.apache.http.client.HttpResponseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.italent2.service.BoardCreationAndMessagePosting;
import com.italent2.service.RolesService;
import com.italent2.service.UserRolesService;

public class UserRolesController
{
	public static final Logger logger=LogManager.getLogger(RolesService.class.getName());
	static ResourceBundle rb=ResourceBundle.getBundle("Application");
	
	
	
	public static void main(String args[]) throws HttpResponseException, IOException, URISyntaxException
	{
		BoardCreationAndMessagePosting bcmp=new BoardCreationAndMessagePosting();
		String key=bcmp.sesiionKeyGeneration();
		UserRolesService urs=new UserRolesService();
		int count=urs.retrieveUsersCount(key);
		int pages=count/Integer.parseInt(rb.getString("pape_size"));
		System.out.println(pages);
		urs.insertToDb(pages, key);
	}
}