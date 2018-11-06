package com.italent2.dao;

import com.italent2.model.Messages;

public interface DatabaseConnectionDao 
{
	public void createTable();
	public void insertIntoTable(Messages message);
}
