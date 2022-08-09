package com.example.vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * This class ensures that the VendingMachine is working properly
 * based on the stated business or technical requirements
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