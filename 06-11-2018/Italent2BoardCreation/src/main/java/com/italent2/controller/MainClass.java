package com.italent2.controller;

import java.io.IOException;
import java.text.ParseException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpResponseException;

import com.italent2.daoImpl.DatabaseConnectionDaoImpl;
import com.italent2.model.Messages;
import com.italent2.service.BoardCreationAndMessagePosting;

public class MainClass 
{
	public static void main(String args[]) throws HttpResponseException, IOException, ParseException
	{
		BoardCreationAndMessagePosting bcmp=new BoardCreationAndMessagePosting();
		String key=bcmp.sesiionKeyGeneration();
		bcmp.boardCreation(key);
		HttpResponse response=bcmp.setMessage(key);
		Messages message=bcmp.readMessage(response);
		
		DatabaseConnectionDaoImpl db=new DatabaseConnectionDaoImpl();
		db.createTable();
		db.insertIntoTable(message);
		
		bcmp.postReply(key);
	}
}
