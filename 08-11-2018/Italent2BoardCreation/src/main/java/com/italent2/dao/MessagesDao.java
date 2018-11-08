package com.italent2.dao;

import com.italent2.model.Messages;

public interface MessagesDao 
{
	public void createTable();
	public void saveToDb(Messages message);
}
