package com.italent2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="UserRoles")
public class UserRoles 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private Users Users;
	@ManyToOne
	@JoinColumn(name = "roleId")
	private Roles Roles;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getUsers() {
		return Users;
	}
	public void setUsers(Users users) {
		Users = users;
	}
	public Roles getRoles() {
		return Roles;
	}
	public void setRoles(Roles roles) {
		Roles = roles;
	}	
}
