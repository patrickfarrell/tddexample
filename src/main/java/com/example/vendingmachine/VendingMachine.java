package com.example.vendingmachine;

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
	
	private Set<Float> validCoins = new HashSet<>();
	private List<Float> coinReturn = new ArrayList<>();
	private List<Product> pickupBox = new ArrayList<>();
	
	private Float totalValue = 0f; 
	
	public VendingMachine() {
		validCoins.add(0.25f);
		validCoins.add(0.10f);
		validCoins.add(0.05f);
	}
	
	public String getDisplayText() {
		if (totalValue > 0) {
			return String.format("$%.2f", totalValue);
		}
		return DEFAULT_TEXT;
	}

	public void insertCoin(float coinValue) {
		if (validCoins.contains(coinValue)) {
			totalValue += coinValue;
		} else {
			coinReturn.add(coinValue);
		}
	}


	public Float[] getCoinReturn() {
		return coinReturn.toArray(new Float[0]);
	}


	public void dispenseCola() {
		if (totalValue == Product.COLA.getPrice()) {
			pickupBox.add(Product.COLA);
		}
	}
	
	public void dispenseCandy() {
		if (totalValue == Product.CANDY.getPrice()) {
			pickupBox.add(Product.CANDY);
		}
	}

	public Product[] getPickupBox() {
		return pickupBox.toArray(new Product[0]);
	}
}