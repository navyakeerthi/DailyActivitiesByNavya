package com.hibernate.daoImpl;

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
			System.out.println("creating table....");
		
			//session.persist(user);	
			System.out.println(user.getId());
			System.out.println("successfully created table");
			
			//inserting into table
			System.out.println("inserting into the table");
			user.setId(111);
			user.setFName("salman");
			user.setLName("khan");
			session.saveOrUpdate(user);
			System.out.println("successfully inserted into the table");			
			t.commit();
			session.close();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("successfully created");
	}
}
