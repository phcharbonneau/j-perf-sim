package org.ph.jopssim.perf.model;

/**
 * Technology can be associated between each other e.g. specs from open source -> commercial offering
 * Technology can be associated to a vendor or open source community
 * @author phcha
 *
 */
public enum Technology {
	OPENJDK5 (Category.LANGUAGE, true, true, "OpenJDK 5", Vendor.OPENJDK_COMMUNITY),
	OPENJDK6 (Category.LANGUAGE, true, true, "OpenJDK 6", Vendor.OPENJDK_COMMUNITY),
	OPENJDK7 (Category.LANGUAGE, true, true, "OpenJDK 7", Vendor.OPENJDK_COMMUNITY),
	OPENJDK8 (Category.LANGUAGE, true, false, "OpenJDK 8", Vendor.OPENJDK_COMMUNITY),
	OPENJDK9 (Category.LANGUAGE, true, false, "OpenJDK 9", Vendor.OPENJDK_COMMUNITY),
	OPENJDK10 (Category.LANGUAGE, true, false, "OpenJDK 10", Vendor.OPENJDK_COMMUNITY),
	OPENJDK11 (Category.LANGUAGE, true, false, "OpenJDK 11", Vendor.OPENJDK_COMMUNITY),
	OPENJDK12 (Category.LANGUAGE, true, false, "OpenJDK 12", Vendor.OPENJDK_COMMUNITY),
	OPENJDK13 (Category.LANGUAGE, true, false, "OpenJDK 13", Vendor.OPENJDK_COMMUNITY),
	OPENJDK14 (Category.LANGUAGE, true, false, "OpenJDK 14", Vendor.OPENJDK_COMMUNITY),
	OPENJDK15 (Category.LANGUAGE, true, false, "OpenJDK 15", Vendor.OPENJDK_COMMUNITY),
	OPENJDK16 (Category.LANGUAGE, true, false, "OpenJDK 16", Vendor.OPENJDK_COMMUNITY),
	ORA_JAVA5 (Category.LANGUAGE, false, true, "Oracle Java 5", OPENJDK5, Vendor.ORACLE),
	ORA_JAVA6 (Category.LANGUAGE, false, true, "Oracle Java 6", OPENJDK6, Vendor.ORACLE),
	ORA_JAVA7 (Category.LANGUAGE, false, true, "Oracle Java 7", OPENJDK7, Vendor.ORACLE),
	ORA_JAVA8 (Category.LANGUAGE, false, false, "Oracle Java 8", OPENJDK8, Vendor.ORACLE),
	ORA_JAVA9 (Category.LANGUAGE, false, false, "Oracle Java 9", OPENJDK9, Vendor.ORACLE),
	ORA_JAVA10 (Category.LANGUAGE, false, false, "Oracle Java 10", OPENJDK10, Vendor.ORACLE),
	ORA_JAVA11 (Category.LANGUAGE, false, false, "Oracle Java 11", OPENJDK11, Vendor.ORACLE),
	ORA_JAVA12 (Category.LANGUAGE, false, false, "Oracle Java 12", OPENJDK12, Vendor.ORACLE),
	ORA_JAVA13 (Category.LANGUAGE, false, false, "Oracle Java 13", OPENJDK13, Vendor.ORACLE),
	ORA_JAVA14 (Category.LANGUAGE, false, false, "Oracle Java 14", OPENJDK14, Vendor.ORACLE),
	ORA_JAVA15 (Category.LANGUAGE, false, false, "Oracle Java 15", OPENJDK15, Vendor.ORACLE),
	ORA_JAVA16 (Category.LANGUAGE, false, false, "Oracle Java 16", OPENJDK16, Vendor.ORACLE),
	JAVA_EE6 (Category.FRAMEWORK, true, false, "Java EE 6 Specs", Vendor.JAVAEE_COMMUNITY),
	JAVA_EE7 (Category.FRAMEWORK, true, false, "Java EE 7 Specs", Vendor.JAVAEE_COMMUNITY),
	JAKARTA_EE8 (Category.FRAMEWORK, true, false, "Jakarta EE 8 Specs", Vendor.JAKARTAEE_ECLIPSE_FOUNDATION),
	WLS_12214 (Category.MIDDLEWARE, false, false, "Oracle WebLogic 12.2.1.4", JAVA_EE7, Vendor.ORACLE),
	APACHE_HTTPSERVER_2441 (Category.MIDDLEWARE, true, false, "Apache HTTP Server 2.4.4.1", Vendor.APACHE);
	
	private final Category category;
	private final boolean openSource;
	private final boolean eol;
	private final String version;
	private final Technology specs; // associated technology ex: specifications
	private final Vendor vendor; // associated vendor or open source community
	
	Technology(Category category, boolean openSource, boolean eol, String version, Vendor vendor) {
		this.category = category;
		this.openSource = openSource;
		this.eol = eol;
		this.specs = null;
		this.version = version;
		this.vendor = vendor;
	}
	
	Technology(Category category, boolean openSource, boolean eol, String version, Technology specs, Vendor vendor) {
		this.category = category;
		this.openSource = openSource;
		this.eol = eol;
		this.specs = specs;
		this.version = version;
		this.vendor = vendor;
	}

	public boolean isOpenSource() {
		return openSource;
	}

	public Technology getSpecs() {
		return specs;
	}

	public Category getCategory() {
		return category;
	}

	public String getVersion() {
		return version;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public boolean isEol() {
		return eol;
	}
	
}
