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
	
	public void saveToDb(UserRoles ur)
	{
		SessionCreation cs=new SessionCreation();
		Session session=cs.createSession();
		Transaction t=session.beginTransaction();
		logger.info("inserting into table..");
		session.save(ur);
		t.commit();
		logger.info("inserted successfully");
	}
}
