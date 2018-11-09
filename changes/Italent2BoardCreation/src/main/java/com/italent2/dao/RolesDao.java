package com.italent2.dao;

import com.italent2.model.Roles;

public interface RolesDao 
{
	public void createTable();
	public void saveToDb(Roles role);
}
