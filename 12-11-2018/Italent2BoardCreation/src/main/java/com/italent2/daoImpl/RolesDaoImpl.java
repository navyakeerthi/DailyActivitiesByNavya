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
	SessionCreation sc=new SessionCreation();
	public void createTable()
	{
		Session session=sc.createSession();
		Transaction t=session.beginTransaction();
		logger.info("creating table....");
		Roles role=new Roles();
		logger.info("table created successfully");
		t.commit();
	}
	
	public void saveToDb(Roles role)
	{
		Session session=sc.createSession();
		Transaction t=session.beginTransaction();
		logger.info("inserting into table..");
		session.save(role);
		t.commit();
		logger.info("inserted successfully");
	}
}
