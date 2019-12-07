package org.ph.jopssim.perf.model;

public class User {
	
	
    private String id;
	private final String name;
	
	public User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
