package com.hibernate.daoImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.dao.DatabaseConnectionDao;
import com.hibernate.model.UserDetails;

public class DatabaseConnectionDaoImpl implements DatabaseConnectionDao
{
	public static final Logger logger=LogManager.getLogger(DatabaseConnectionDaoImpl.class.getName());
	public void createTable()
	{
		try
		{
			Configuration config=new Configuration();
			config.configure("hibernate.config.xml");
			ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			SessionFactory factory=config.buildSessionFactory(serviceRegistryObj);
			Session session=factory.openSession();
			Transaction t=session.beginTransaction();
			
			//creating table
			UserDetails user=new UserDetails();
			logger.info("creating table...");
		
			//session.persist(user);	
			logger.info("successfully created the table");
			
			//inserting into table
			logger.info("inserting into table");
			user.setId(111);
			user.setFName("salman");
			user.setLName("khan");
			session.saveOrUpdate(user);
			logger.info("successfully inserted into table");		
			t.commit();
			session.close();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		logger.info("successfully created");
	}
}
