package com.hibernate.controller;

import com.hibernate.daoImpl.DatabaseConnectionDaoImpl;

public class HibernateDatabaseProcessing 
{
	public static void main(String args[]) throws ClassNotFoundException
	{
		DatabaseConnectionDaoImpl db = new DatabaseConnectionDaoImpl();
		db.createTable();
	}
}
