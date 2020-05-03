package org.ph.jopssim.timeout.controller;

import org.ph.jopssim.timeout.model.BankAccount;
import org.ph.jopssim.timeout.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * MyAccountController
 * @author phcha
 *
 */
@RestController
public class MyAccountController {
	
	private final BankAccountService service;
	private long accountNb = 0l;
	
	@Autowired
	public MyAccountController(BankAccountService service) {
		this.service = service;
	}
	
	@RequestMapping("/myaccount")
    public BankAccount account(@RequestParam(value="userID", defaultValue="PH") String userID) {
		
		// obtain the current user bank account number
		accountNb = service.getAccountNb(userID);
		
		// return the current Bank account Nb
		return new BankAccount(accountNb);
    }
	
}
