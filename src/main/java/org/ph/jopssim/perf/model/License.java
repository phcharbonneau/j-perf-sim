package org.ph.jopssim.perf.model;

/**
 * Open Source license: allows users to use the software for any purpose, to distribute it, to modify it, 
 * and to distribute modified versions of the software under the terms of the license, without concern for royalties.
 * @author pierre-hugues.charbo
 *
 */
public enum License {
	COMMERCIAL_ORA("Oracle"),
	OPENSOURCE_GPL("The GNU General Public License"),
	OPENSOURCE_ASF2("Apache License 2.0"),
	OPENSOURCE_ECLIPSE_TSK("Eclipse TCK"); //
	
	private final String type;
	
	License(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
