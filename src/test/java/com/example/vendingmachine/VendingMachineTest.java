package com.example.vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class VendingMachineTest {

	@Test
	void vendingMachineWasDelivered() {
		VendingMachine machine = new VendingMachine();
		assertThat(machine).isNotNull();
	}
}