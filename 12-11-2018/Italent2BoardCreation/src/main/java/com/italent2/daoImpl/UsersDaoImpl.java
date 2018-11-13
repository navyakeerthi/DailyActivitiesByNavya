package com.italent2.daoImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.italent2.dao.UsersDao;
import com.italent2.model.Users;

public class UsersDaoImpl implements UsersDao
{
	public static final Logger logger=LogManager.getLogger(UsersDaoImpl.class.getName());
	SessionCreation sc=new SessionCreation();
	public void createTable()
	{
		Session session=sc.createSession();
		Transaction t=session.beginTransaction();
		logger.info("creating table..");
		Users user=new Users();
		logger.info("table created successfully");
		t.commit();
	}
	
	public void saveToDb(Users user)
	{
		Session session=sc.createSession();
		Transaction t=session.beginTransaction();
		logger.info("inserting into table..");
		session.save(user);
		t.commit();
		logger.info("inserted successfully");
	}
}
