package com.testtechportobello.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pedidos")
public class Order {

	@Id
	private String id;

	private LocalDateTime date;

	private long orderNumber;

	private Customer customer;

	private List<Item> items;

	private Double totalValue;

	public Order() {
	}

	public Order(String id, LocalDateTime date, long orderNumber, Customer customer, List<Item> item,
			Double totalValue) {
		this.id = id;
		this.date = date;
		this.orderNumber = orderNumber;
		this.customer = customer;
		this.items = item;
		this.totalValue = totalValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> item) {
		this.items = item;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

}
