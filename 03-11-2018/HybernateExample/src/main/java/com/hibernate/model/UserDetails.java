package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="UserDetails")

public class UserDetails 
{

	@Id
	private int id;
	@Column(name="FName")
	private String fName;
	@Column(name="LName")
	private String lName;
	
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	
	
	public String getFName()
	{
		return fName;
	}
	
	public void setFName(String fName)
	{
		this.fName=fName;
	}
	
	
	public String getLName()
	{
		return lName;
	}
	
	public void setLName(String lName)
	{
		this.lName=lName;
	}
}
