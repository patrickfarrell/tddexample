package com.example.vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class VendingMachineApplicationTests {

	@Autowired
	ApplicationContext context;
	
	@Test
	void springApplicationRunMethodIsInvokedOnceByMainMethod() {
	    try (MockedStatic<SpringApplication> mockSpringApplication = 
	    	Mockito.mockStatic(SpringApplication.class)) {
	    	
	    		// Setup what should occur when the static method is invoked
	    		mockSpringApplication.when(() -> SpringApplication.run(VendingMachineApplication.class, new String[]{})).thenReturn(null);
	    		
	    		// Invoke the VendingMachineApplication.main() method to verify that it starts the SpringApplication
	    		VendingMachineApplication.main(new String[]{});
	    		
	    		// Verify that the SpringApplication.run() method was invoked once
	    		mockSpringApplication.verify(() -> SpringApplication.run(VendingMachineApplication.class, new String[]{}), times(1));
	    }
	}
	
	@Test
	void contextLoads() {
		assertThat(context).isNotNull();
	}
}
