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
public class EmailSending 
{
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
			System.out.println("authenticating the login details of the ail");
			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() 
			{	    
				protected PasswordAuthentication getPasswordAuthentication() 
				{ 		
					return new PasswordAuthentication(sender, password);  
				}
			});
			System.out.println("successfully loged in");
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receipnt, true));					
			message.addHeader("X-Priority", "1");
			message.setSubject(rb.getString("subject")); 
			message.setContent(map.toString(), "text/html");
			System.out.println("sending message");
			Transport.send(message);
			System.out.println("message sent successfully");			   	
		} catch (Exception e) 
		{			   	 
			e.printStackTrace();				    	
		}
	}
}
