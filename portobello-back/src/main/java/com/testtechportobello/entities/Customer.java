package com.testtechportobello.entities;

public class Customer {

	private String id;

	private String name;

	private String email;

	public Customer() {

	}

	public Customer(String idCustomer, String name, String email) {
		this.id = idCustomer;
		this.name = name;
		this.email = email;
	}

	public String getIdCustomer() {
		return id;
	}

	public void setIdCustomer(String idCustomer) {
		this.id = idCustomer;
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

}
