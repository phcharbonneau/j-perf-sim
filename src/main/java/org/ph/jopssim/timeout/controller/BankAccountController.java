package org.ph.jopssim.timeout.controller;

import org.ph.jopssim.timeout.model.BankAccount;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountController {
	
	@RequestMapping("/banknb")
    public long banknb(@RequestParam(value="userID", defaultValue="PH") String userID) {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {}
		
		// return the current Bank account Nb
		return new Long(System.currentTimeMillis());
    }
}
