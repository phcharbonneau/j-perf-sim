package org.ph.jopssim.threadsafety.service;

import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	@Override
	public String getFullName(String userID) {
		
		// User name: current Thread name
		return Thread.currentThread().getName(); 
	}
}
