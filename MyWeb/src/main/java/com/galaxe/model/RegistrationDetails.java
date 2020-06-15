package com.galaxe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="RegistrationDetails")
public class RegistrationDetails {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@Email
	private String email;
	@Pattern(regexp="^.*(?=.{10,})(?=.*[0-9]).*$")
	private String contact;
	private String username;
	@Pattern(regexp="^.*(?=.{6,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*$")
	private String password;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "RegistrationDetails [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact
				+ ", username=" + username + ", password=" + password + "]";
	}
}
