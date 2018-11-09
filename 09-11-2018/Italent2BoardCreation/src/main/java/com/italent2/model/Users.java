package com.italent2.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name="Users")
public class Users 
{
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Id
	@Column(name="userId")
	private int userId;
	
	@OneToMany(mappedBy = "Users")
	private Set<UserRoles> UserRoles;


	public Set<UserRoles> getUserRoles() {
	return UserRoles;
	}
	
	@Column(name="login")
	private String login;
	
	@Column(name="email")
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
