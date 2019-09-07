package org.ph.jopssim.perf.model;

public class UserData {
	
	private Object accountData = null;
	private final String name;
	
	public UserData(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public Object getAccountData() {
		return accountData;
	}

	public void setAccountData(Object accountData) {
		this.accountData = accountData;
	}
}
