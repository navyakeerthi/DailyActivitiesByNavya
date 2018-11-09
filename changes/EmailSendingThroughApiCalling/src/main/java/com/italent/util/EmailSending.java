package com.italent.util;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class EmailSending 
{
	public static final Logger logger=LogManager.getLogger(EmailSending.class.getName());
	static ResourceBundle rb=ResourceBundle.getBundle("application");
	public void mailSending(Connection con,Map<Integer,String> map) 
	{
		try
		{
			final String sender=rb.getString("sender");
			final String password=rb.getString("password");
			final String receipnt=rb.getString("receipnt");
			Properties properties=new Properties();
			properties.put("mail.smtp.host", "mail.emailsrvr.com");
			properties.put("mail.smtp.socketFactory.port", "143");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.port", "587");
			logger.info("Authenticating the login details of the mail");;
			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() 
			{	    
				protected PasswordAuthentication getPasswordAuthentication() 
				{ 		
					return new PasswordAuthentication(sender, password);  
				}
			});
			logger.info("successfully logged in");
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receipnt, true));					
			message.addHeader("X-Priority", "1");
			message.setSubject(rb.getString("subject")); 
			message.setContent(map.toString(), "text/html");
			logger.info("sending message...");
			Transport.send(message);
			logger.info("message sent sccessfully");	   	
		} catch (Exception e) 
		{			   	 
			logger.error("log test",e,e);				    	
		}
	}
}
