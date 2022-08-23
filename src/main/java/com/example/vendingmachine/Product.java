package com.example.vendingmachine;

public enum Product {
	COLA(1.0f);
	
	private float price;
	
	Product(float price) {
		this.price = price;
	}
	
	public float getPrice() {
		return this.price;
	}
}
