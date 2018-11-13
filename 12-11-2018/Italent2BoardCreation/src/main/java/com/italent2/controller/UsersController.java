package com.italent2.controller;

import java.io.IOException;

import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpResponseException;

import com.italent2.daoImpl.UsersDaoImpl;
import com.italent2.service.BoardCreationAndMessagePosting;
import com.italent2.service.UsersService;

public class UsersController 
{
	public static void main(String args[]) throws HttpResponseException, IOException, URISyntaxException
	{
		BoardCreationAndMessagePosting bcmp=new BoardCreationAndMessagePosting();
		String key=bcmp.sesiionKeyGeneration();
		
		UsersService user=new UsersService();
		HttpResponse response=user.retrieveUsers(key);
		UsersDaoImpl db=new UsersDaoImpl();
		db.createTable();
		user.insertUsersToDb(response);
	}
}
