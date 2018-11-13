package com.italent2.daoImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.italent2.model.Roles;
import com.italent2.model.UserRoles;
import com.italent2.model.Users;

public class UserRolesDaoImpl 
{
	public static final Logger logger=LogManager.getLogger(UserRolesDaoImpl.class.getName());
	SessionCreation sc=new SessionCreation();
	public void saveToDb(Users user)
	{
		Session session=sc.createSession();
		Transaction t=session.beginTransaction();
		logger.info("inserting into table..");
		session.saveOrUpdate(user);
		t.commit();
		logger.info("inserted successfully");
	}
	
	public void saveToDb(Roles role)
	{
		Session session=sc.createSession();
		Transaction t=session.beginTransaction();
		logger.info("inserting into table..");
		session.saveOrUpdate(role);
		t.commit();
		logger.info("inserted successfully");
	}
	
	public void saveToDb(UserRoles ur)
	{
		Session session=sc.createSession();
		Transaction t=session.beginTransaction();
		logger.info("inserting into table..");
		session.saveOrUpdate(ur);
		t.commit();
		logger.info("inserted successfully");
	}
}
