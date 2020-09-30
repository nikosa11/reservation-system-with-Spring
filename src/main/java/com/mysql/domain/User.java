package com.mysql.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
	@GeneratedValue
	@Id
	private long id;
	
	@NotNull
	@Size(min=2, max=30)
	private String firstname;
	
	@NotNull
	@Size(min=2, max=30)
	private String lastname;
	
	@NotNull
	@Min(18)
	Integer age;
	
	@NotNull
	@Size(min=6, max=30)
	String email;
	
	@NotNull
	@Size(min=2, max=30)
	String destination;
	
	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public boolean invalid() {
		if ((firstname.length()<=2||lastname.length()<=2||age<18 ||email.length()<=5||destination.length()<=2)) {
			return false;
		}
		return true;
	}
}
