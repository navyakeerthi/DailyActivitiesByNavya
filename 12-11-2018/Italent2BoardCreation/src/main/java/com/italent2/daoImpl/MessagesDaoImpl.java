package com.italent2.daoImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.italent2.dao.MessagesDao;
import com.italent2.model.Messages;

public class MessagesDaoImpl implements MessagesDao
{
	public static final Logger logger=LogManager.getLogger(MessagesDaoImpl.class.getName());
	SessionCreation sc=new SessionCreation();
	public void createTable()
	{
		
		Session session=sc.createSession();
		Transaction t=session.beginTransaction();
		logger.info("creating table....");
		Messages message=new Messages();
		logger.info("table created sucessfully");
		t.commit();
	}
	
	public void saveToDb(Messages message)
	{
		Session session=sc.createSession();
		Transaction t=session.beginTransaction();
		logger.info("inserting into table...");
		session.save(message);
		t.commit();
		logger.info("inserted successfully");
	}
	
}
