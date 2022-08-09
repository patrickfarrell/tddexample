package com.example.vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * This class ensures that the Vending Machine implementation is working properly
 * according to the stated business or technical requirements
 * 
 * @author Patrick Farrell
 */
class VendingMachineTest {
	
	@Test
	void vendingMachineDefaultConstructorReturnsInstance() {
		VendingMachine machine = new VendingMachine();
		assertThat(machine).isNotNull();
	}
	
}