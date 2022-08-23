package com.example.vendingmachine;

public enum Product {
	COLA(1.0d),
	CANDY(0.65d),
	CHIPS(0d);
	
	private double price;
	
	Product(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
}
