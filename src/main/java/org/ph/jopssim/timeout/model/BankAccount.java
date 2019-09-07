package org.ph.jopssim.timeout.model;

/**
 * BankAccount POJO class
 * @author PH
 *
 */
public class BankAccount {
	
	private final long accountNb;
	
	public BankAccount(long accountNb) {
		this.accountNb = accountNb;
	}
	
	public long getAccountNb() {
		return accountNb;
	}
}
