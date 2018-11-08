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
	public void createTable()
	{
		SessionCreation cs=new SessionCreation();
		Session session=cs.createSession();
		Transaction t=session.beginTransaction();
		logger.info("creating table..");
		Users user=new Users();
		logger.info("table created successfully");
		t.commit();
	}
	
	public void saveToDb(Users user)
	{
		SessionCreation cs=new SessionCreation();
		Session session=cs.createSession();
		Transaction t=session.beginTransaction();
		logger.info("inserting into table..");
		session.save(user);
		t.commit();
		logger.info("inserted successfully");
	}
}
