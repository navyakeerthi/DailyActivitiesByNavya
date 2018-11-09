package com.italent2.daoImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.italent2.dao.RolesDao;
import com.italent2.model.Roles;

public class RolesDaoImpl implements RolesDao
{
	public static final Logger logger=LogManager.getLogger(RolesDaoImpl.class.getName());
	public void createTable()
	{
		SessionCreation cs=new SessionCreation();
		Session session=cs.createSession();
		Transaction t=session.beginTransaction();
		logger.info("creating table....");
		Roles role=new Roles();
		logger.info("table created successfully");
		t.commit();
	}
	
	public void saveToDb(Roles role)
	{
		SessionCreation cs=new SessionCreation();
		Session session=cs.createSession();
		Transaction t=session.beginTransaction();
		logger.info("inserting into table..");
		session.save(role);
		t.commit();
		logger.info("inserted successfully");
	}
}
