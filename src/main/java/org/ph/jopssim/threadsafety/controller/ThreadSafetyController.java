package org.ph.jopssim.threadsafety.controller;

import org.ph.jopssim.threadsafety.model.StuckThread;
import org.ph.jopssim.threadsafety.model.UserAccount;
import org.ph.jopssim.threadsafety.service.StuckThreadService;
import org.ph.jopssim.threadsafety.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadSafetyController {
	
	private String currentUserFullName = null;
	private final UserAccountService service;
	
	@Autowired
	public ThreadSafetyController(UserAccountService service) {
		this.service = service;
	}
	
	@RequestMapping("/name")
    public UserAccount fullName(@RequestParam(value="userID", defaultValue="PH") String userID) {
		
		// obtain the current user Full Name from the DB ex: P-H Charbonneau
		currentUserFullName = service.getFullName(userID);
		
		// Do some other work for 5 secs...
		doWork(5);
		
		// Validate for current Thread-safety...
		validateThreadSafety(currentUserFullName);
		
		// return the user full name
		return new UserAccount(currentUserFullName);
    }
	
	private void validateThreadSafety(String currentUserFullName) {
		
		// Thread name is used as current user Full Name...
		String currentThreadName = Thread.currentThread().getName();
		
		if (null != currentUserFullName) {
			
			if (!currentUserFullName.equals(currentThreadName)) {
				StringBuilder str = new StringBuilder();
				
				str.append("** Thread safety detected **");
				str.append("value:["+currentUserFullName+"]");
				str.append("expecting: ["+currentThreadName);
				
				System.out.println(str.toString());
			}
		}
	}
	
	private void doWork(int secs) {
		// try to block other threads...
		try {Thread.sleep(secs*1000); } catch (InterruptedException e) {}
	}
}
