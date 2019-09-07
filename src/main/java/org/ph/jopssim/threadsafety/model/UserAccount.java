package org.ph.jopssim.threadsafety.model;

/**
 * UserAccount POJO class
 * @author PH
 *
 */
public class UserAccount {
	
	private final String name;
	
	public UserAccount(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
