package com.italent2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="Messages")

public class Messages 
{
	@Id
	private int id;
	@Column(name="href")
	private String href;
	@Column(name="post_time")
	private Date post_time;
	@Column(name="last_edit_time")
	private Date last_edit_time;
	@Column(name="subject")
	private String subject;
	@Column(name="author")
	private String author;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	
	public Date getPost_time() {
		return post_time;
	}
	public void setPost_time(Date postTime) {
		this.post_time = postTime;
	}
	
	public Date getLast_edit_time() {
		return last_edit_time;
	}
	public void setLast_edit_time(Date last_edit_time) {
		this.last_edit_time = last_edit_time;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
