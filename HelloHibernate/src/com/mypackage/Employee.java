package com.mypackage;

import java.io.Serializable;

//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;

//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "App.Employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -4975405777452768298L;

	private int id;
	private String firstName, lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}