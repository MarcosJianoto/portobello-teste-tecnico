<<<<<<< HEAD
package com.testtechportobello.dtos;

import java.util.List;

import com.testtechportobello.entities.Customer;
import com.testtechportobello.entities.Item;

public class OrderDTO {

	private String id;

	private String date;

	private long orderNumber;

	private Customer customer;

	private List<Item> items;

	private Double totalValue;

	public OrderDTO() {

	}

	public OrderDTO(String id, String date, long orderNumber, Customer customer, List<Item> items, Double totalValue) {
		this.id = id;
		this.date = date;
		this.orderNumber = orderNumber;
		this.customer = customer;
		this.items = items;
		this.totalValue = totalValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
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

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

}
=======
package com.testtechportobello.dtos;

import java.util.List;

import com.testtechportobello.entities.Customer;
import com.testtechportobello.entities.Item;

public class OrderDTO {

	private String id;

	private String date;

	private long orderNumber;

	private Customer customer;

	private List<Item> items;

	private Double totalValue;

	public OrderDTO() {

	}

	public OrderDTO(String id, String date, long orderNumber, Customer customer, List<Item> items, Double totalValue) {
		this.id = id;
		this.date = date;
		this.orderNumber = orderNumber;
		this.customer = customer;
		this.items = items;
		this.totalValue = totalValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
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

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

}
>>>>>>> aeb2af5 (Corrige backend como pasta comum e não como submódulo)
