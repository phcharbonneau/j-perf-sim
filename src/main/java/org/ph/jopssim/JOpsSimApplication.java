package org.ph.jopssim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JOpsSimApplication {
	
	public static void main(String[] args) {
		System.out.println("Starting Java Performance Simulator...");
		
		SpringApplication.run(JOpsSimApplication.class, args);
	}
}
