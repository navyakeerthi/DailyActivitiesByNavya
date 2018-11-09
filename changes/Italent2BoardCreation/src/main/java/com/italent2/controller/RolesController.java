package com.italent2.controller;

import java.io.IOException;

import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpResponseException;

import com.italent2.daoImpl.RolesDaoImpl;
import com.italent2.service.BoardCreationAndMessagePosting;
import com.italent2.service.RolesService;

public class RolesController 
{
	public static void main(String args[]) throws HttpResponseException, IOException, URISyntaxException
	{
		BoardCreationAndMessagePosting bcmp=new BoardCreationAndMessagePosting();
		String key=bcmp.sesiionKeyGeneration();
		
		RolesService roles=new RolesService();
		HttpResponse response=roles.retrieveRoles(key);
		RolesDaoImpl role=new RolesDaoImpl();
		role.createTable();
		roles.insertRolesToDb(response);
	}
}
