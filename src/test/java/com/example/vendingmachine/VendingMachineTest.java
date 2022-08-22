package com.example.vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * This class ensures that the Vending Machine implementation is working properly
 * according to the stated business or technical requirements
 * 
 * 
 * Approach:
 * 1. Write a failing test
 * 2. Implement just enough code to make the test pass
 * 3. Commit our code
 * 4. Refactor
 * 5. Commit our code
 * 
 * @author Patrick Farrell
 */
class VendingMachineTest {
	
	@Test
	void vendingMachineDefaultConstructorReturnsInstance() {
		VendingMachine machine = new VendingMachine();
		assertThat(machine).isNotNull();
	}
	
	
	@Test
	void displayReadsInsertCoinWhenNoCoinsInserted() {
		VendingMachine machine = new VendingMachine();
		assertThat(machine.getDisplayText()).isEqualTo("INSERT COIN");
	}
}