package org.ph.jopssim.threadsafety.model;

public class StuckThread {
	
	private final String name;
	private final boolean isStuck;
	
	public StuckThread (String name, boolean isStuck) {
		this.name = name;
		this.isStuck = isStuck;
	}

	public String getName() {
		return name;
	}

	public boolean isStuck() {
		return isStuck;
	}
}
