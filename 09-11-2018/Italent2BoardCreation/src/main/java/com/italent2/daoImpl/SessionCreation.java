package com.italent2.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionCreation 
{
	public Session createSession()
	{
		Configuration config=new Configuration();
		config.configure("hibernate.config.xml");
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory=config.buildSessionFactory(serviceRegistryObj);
		Session session=factory.openSession();
		return session;
	}
}
