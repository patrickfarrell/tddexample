package com.example.vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class represents a physical Vending Machine
 * 
 * @author Patrick Farrell
 */
public class VendingMachine {
	
	public static final String DEFAULT_TEXT = "INSERT COIN";
	
	private Set<Double> validCoins = new HashSet<>();
	private List<Double> coinReturn = new ArrayList<>();
	private List<Product> pickupBox = new ArrayList<>();
	
	private double totalValue = 0f; 
	
	public VendingMachine() {
		validCoins.add(0.25d);
		validCoins.add(0.10d);
		validCoins.add(0.05d);
	}
	
	public String getDisplayText() {
		if (totalValue > 0) {
			return String.format("$%.2f", totalValue);
		}
		return DEFAULT_TEXT;
	}

	public void insertCoin(double coinValue) {
		if (validCoins.contains(coinValue)) {
			totalValue += coinValue;
		} else {
			coinReturn.add(coinValue);
		}
	}

	public Double[] getCoinReturn() {
		return coinReturn.toArray(new Double[0]);
	}

	public void dispenseCola() {
		if (totalValue >= Product.COLA.getPrice()) {
			pickupBox.add(Product.COLA);
			makeChange(Product.COLA);
		}
	}
	
	public void dispenseCandy() {
		if (totalValue >= Product.CANDY.getPrice()) {
			pickupBox.add(Product.CANDY);
			makeChange(Product.CANDY);
		}
	}
	
	public void dispenseChips() {
		if (totalValue >= Product.CHIPS.getPrice()) {
			pickupBox.add(Product.CHIPS);
			makeChange(Product.CHIPS);
		}
	}

	public Product[] getPickupBox() {
		return pickupBox.toArray(new Product[0]);
	}
	
	private void makeChange(Product product) {
		double totalChange = BigDecimal.valueOf(totalValue).subtract(BigDecimal.valueOf(product.getPrice())).doubleValue();
		int quarters = ((BigDecimal.valueOf(totalChange).multiply(BigDecimal.valueOf(100))).intValue()) / 25;
		//totalChange = BigDecimal.valueOf(totalValue).subtract(BigDecimal.valueOf(quarters).multiply(BigDecimal.valueOf(0.25d))).doubleValue();
		int dimes = (BigDecimal.valueOf(totalChange).multiply(BigDecimal.valueOf(100))).intValue() / 10;
		double nickels = (totalChange - (quarters * 0.25d) - (dimes * 0.10d)) % 0.05d;
		System.out.println("Change: TotalChange: + " + totalChange + " Quarters: " + quarters + " Dimes: " + dimes + " Nickels: " + nickels);
	}
}