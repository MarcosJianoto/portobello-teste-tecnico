package com.testtechportobello.entities;

import org.springframework.data.mongodb.core.mapping.Field;

public class Item {

	@Field("id")
	private String id;

	private String productName;

	private Integer quantity;

	private Double unityPrice;

	public Item() {
	}

	public Item(String idItem, String productName, Integer quantity, Double priceUnity) {
		this.id = idItem;
		this.productName = productName;
		this.quantity = quantity;
		this.unityPrice = priceUnity;
	}

	public String getId() {
		return id;
	}

	public void setId(String idItem) {
		this.id = idItem;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnityPrice() {
		return unityPrice;
	}

	public void setUnityPrice(Double priceUnity) {
		this.unityPrice = priceUnity;
	}

}
