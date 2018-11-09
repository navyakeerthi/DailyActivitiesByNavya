package com.italent2.dao;

import com.italent2.model.Users;

public interface UsersDao 
{
	public void createTable();
	public void saveToDb(Users user);
}
