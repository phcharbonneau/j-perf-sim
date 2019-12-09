package org.ph.jopssim.perf.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Technology can be associated between each other e.g. specs from open source -> commercial offering
 * Technology can be associated to a vendor or open source community
 * @author phcha
 *
 */
public enum Technology {
	OPENJDK5 (Category.LANGUAGE, true, true, "OpenJDK 5", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01"),
	OPENJDK6 (Category.LANGUAGE, true, true, "OpenJDK 6", Vendor.OPENJDK_COMMUNITY, "2006-12-01", "2013-04-01"),
	OPENJDK7 (Category.LANGUAGE, true, true, "OpenJDK 7", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01"),
	OPENJDK8 (Category.LANGUAGE, true, false, "OpenJDK 8", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01"),
	OPENJDK9 (Category.LANGUAGE, true, false, "OpenJDK 9", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01"),
	OPENJDK10 (Category.LANGUAGE, true, false, "OpenJDK 10", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01"),
	OPENJDK11 (Category.LANGUAGE, true, false, "OpenJDK 11", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01"),
	OPENJDK12 (Category.LANGUAGE, true, false, "OpenJDK 12", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01"),
	OPENJDK13 (Category.LANGUAGE, true, false, "OpenJDK 13", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01"),
	OPENJDK14 (Category.LANGUAGE, true, false, "OpenJDK 14", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01"),
	OPENJDK15 (Category.LANGUAGE, true, false, "OpenJDK 15", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01"),
	OPENJDK16 (Category.LANGUAGE, true, false, "OpenJDK 16", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01"),
	ORA_JAVA5 (Category.LANGUAGE, false, true, "Oracle Java 5", Vendor.ORACLE, "2004-09-01", "2009-11-01"),
	ORA_JAVA6 (Category.LANGUAGE, false, true, "Oracle Java 6", Vendor.ORACLE, "2004-09-01", "2009-11-01"),
	ORA_JAVA7 (Category.LANGUAGE, false, true, "Oracle Java 7", Vendor.ORACLE, "2004-09-01", "2009-11-01"),
	ORA_JAVA8 (Category.LANGUAGE, false, false, "Oracle Java 8", Vendor.ORACLE, "2004-09-01", "2009-11-01"),
	ORA_JAVA9 (Category.LANGUAGE, false, false, "Oracle Java 9", Vendor.ORACLE, "2004-09-01", "2009-11-01"),
	ORA_JAVA10 (Category.LANGUAGE, false, false, "Oracle Java 10", Vendor.ORACLE, "2004-09-01", "2009-11-01"),
	ORA_JAVA11 (Category.LANGUAGE, false, false, "Oracle Java 11", Vendor.ORACLE, "2004-09-01", "2009-11-01"),
	ORA_JAVA12 (Category.LANGUAGE, false, false, "Oracle Java 12", Vendor.ORACLE, "2004-09-01", "2009-11-01"),
	ORA_JAVA13 (Category.LANGUAGE, false, false, "Oracle Java 13", Vendor.ORACLE, "2004-09-01", "2009-11-01"),
	ORA_JAVA14 (Category.LANGUAGE, false, false, "Oracle Java 14", Vendor.ORACLE, "2004-09-01", "2009-11-01"),
	ORA_JAVA15 (Category.LANGUAGE, false, false, "Oracle Java 15", Vendor.ORACLE, "2004-09-01", "2009-11-01"),
	ORA_JAVA16 (Category.LANGUAGE, false, false, "Oracle Java 16", Vendor.ORACLE, "2004-09-01", "2009-11-01"),
	JAVA_EE6 (Category.FRAMEWORK, true, false, "Java EE 6 Specs", Vendor.JAVAEE_COMMUNITY, "2004-09-01", "2009-11-01"),
	JAVA_EE7 (Category.FRAMEWORK, true, false, "Java EE 7 Specs", Vendor.JAVAEE_COMMUNITY, "2004-09-01", "2009-11-01"),
	JAKARTA_EE8 (Category.FRAMEWORK, true, false, "Jakarta EE 8 Specs", Vendor.JAKARTAEE_ECLIPSE_FOUNDATION, "2004-09-01", "2009-11-01"),
	WLS_12214 (Category.MIDDLEWARE, false, false, "Oracle WebLogic 12.2.1.4", Vendor.ORACLE, "2019-09-27", "2022-08-01"),
	APACHE_HTTPSERVER_2441 (Category.MIDDLEWARE, true, false, "Apache HTTP Server 2.4.4.1", Vendor.APACHE, "2004-09-01", "2009-11-01");
	
	private final Category category;
	private final boolean openSource;
	private final boolean eol;
	private final String version;
	private final Vendor vendor; // associated vendor or open source community
	private Date releaseDate = null;
	private Date lastFreePublicUpdateDate;
	
	Technology(Category category, boolean openSource, boolean eol, String version, Vendor vendor, String releaseDate, String lastFreeUpdateDate) {
		this.category = category;
		this.openSource = openSource;
		this.eol = eol;
		this.version = version;
		this.vendor = vendor;
		try {
			this.releaseDate = new SimpleDateFormat("yyyy-MM-dd").parse(releaseDate);
			this.lastFreePublicUpdateDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastFreeUpdateDate);
		} catch (Exception e) {
			System.out.println("Invalid date format! "+e.getMessage());
		}
	}
	

	public boolean isOpenSource() {
		return openSource;
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

	public Date getReleaseDate() {
		return releaseDate;
	}

	public Date getLastFreePublicUpdateDate() {
		return lastFreePublicUpdateDate;
	}
}
