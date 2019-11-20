package org.ph.jopssim.timeout.controller;

import java.util.Random;

import org.ph.jopssim.timeout.model.BankAccount;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountController {
	
	@RequestMapping("/banknb")
    public long banknb(@RequestParam(value="userID", defaultValue="PH") String userID) {
		
		int max = 15000;
		int min = 100;
		Random rn = new Random();
		
		int responTime = rn.nextInt(max - min + 1) + min;
		
		System.out.println("RESP TIME!! "+responTime);
		
		try {
			Thread.sleep(responTime);
		} catch (InterruptedException e) {}
		
		// return the current Bank account Nb
		return new Long(System.currentTimeMillis());
    }
}
