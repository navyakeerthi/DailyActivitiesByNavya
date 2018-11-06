package com.italent2.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.italent2.dao.DatabaseConnectionDao;
import com.italent2.model.Messages;

public class DatabaseConnectionDaoImpl implements DatabaseConnectionDao
{
	public void createTable()
	{
		Configuration config=new Configuration();
		config.configure("hibernate.config.xml");
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory=config.buildSessionFactory(serviceRegistryObj);
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		System.out.println("creating table....");
		Messages message=new Messages();
		System.out.println("successfully created the table");
		t.commit();
	}
	
	public void insertIntoTable(Messages message)
	{
		Configuration config=new Configuration();
		config.configure("hibernate.config.xml");
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory=config.buildSessionFactory(serviceRegistryObj);
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		System.out.println("inserting into table");
		session.save(message);
		t.commit();
		System.out.println("successully inserted");
	}
}
