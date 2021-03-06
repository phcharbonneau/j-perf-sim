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
	OPENJDK5 (Category.LANGUAGE, License.OPENSOURCE_GPL, true, "OpenJDK 5", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01", "2009-11-01"),
	OPENJDK6 (Category.LANGUAGE, License.OPENSOURCE_GPL, true, "OpenJDK 6", Vendor.OPENJDK_COMMUNITY, "2006-12-01", "2013-04-01", "2013-04-01"),
	OPENJDK7 (Category.LANGUAGE, License.OPENSOURCE_GPL, true, "OpenJDK 7", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01", "2009-11-01"),
	OPENJDK8 (Category.LANGUAGE, License.OPENSOURCE_GPL, false, "OpenJDK 8", Vendor.OPENJDK_COMMUNITY, "2014-03-01", "2020-03-01", "2019-01-01"),
	RH_OPENJDK8 (Category.LANGUAGE, License.COMMERCIAL_RH_IBM, false, "OpenJDK 8 (RedHat)", Vendor.REDHAT_IBM, "2014-03-01", "2023-06-01", "2023-06-01"),
	OPENJDK9 (Category.LANGUAGE, License.OPENSOURCE_GPL, false, "OpenJDK 9", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01", "2009-11-01"),
	OPENJDK10 (Category.LANGUAGE, License.OPENSOURCE_GPL, false, "OpenJDK 10", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01", "2009-11-01"),
	OPENJDK11 (Category.LANGUAGE, License.OPENSOURCE_GPL, false, "OpenJDK 11", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01", "2009-11-01"),
	OPENJDK12 (Category.LANGUAGE, License.OPENSOURCE_GPL, false, "OpenJDK 12", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01", "2009-11-01"),
	OPENJDK13 (Category.LANGUAGE, License.OPENSOURCE_GPL, false, "OpenJDK 13", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01", "2009-11-01"),
	OPENJDK14 (Category.LANGUAGE, License.OPENSOURCE_GPL, false, "OpenJDK 14", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01", "2009-11-01"),
	OPENJDK15 (Category.LANGUAGE, License.OPENSOURCE_GPL, false, "OpenJDK 15", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01", "2009-11-01"),
	OPENJDK16 (Category.LANGUAGE, License.OPENSOURCE_GPL, false, "OpenJDK 16", Vendor.OPENJDK_COMMUNITY, "2004-09-01", "2009-11-01", "2009-11-01"),
	ORA_JAVA5 (Category.LANGUAGE, License.COMMERCIAL_ORA, true, "Oracle Java 5", Vendor.ORACLE, "2004-09-01", "2009-11-01", "2009-11-01"),
	ORA_JAVA6 (Category.LANGUAGE, License.COMMERCIAL_ORA, true, "Oracle Java 6", Vendor.ORACLE, "2004-09-01", "2009-11-01", "2009-11-01"),
	ORA_JAVA7 (Category.LANGUAGE, License.COMMERCIAL_ORA, true, "Oracle Java 7", Vendor.ORACLE, "2011-07-01", "2015-04-15", "2015-04-15"),
	ORA_JAVA8 (Category.LANGUAGE, License.COMMERCIAL_ORA, false, "Oracle Java 8", Vendor.ORACLE, "2004-09-01", "2009-11-01", "2020-03-01"),
	ORA_JAVA9 (Category.LANGUAGE, License.COMMERCIAL_ORA, false, "Oracle Java 9", Vendor.ORACLE, "2004-09-01", "2009-11-01", "2009-11-01"),
	ORA_JAVA10 (Category.LANGUAGE, License.COMMERCIAL_ORA, false, "Oracle Java 10", Vendor.ORACLE, "2004-09-01", "2009-11-01", "2009-11-01"),
	ORA_JAVA11 (Category.LANGUAGE, License.COMMERCIAL_ORA, false, "Oracle Java 11", Vendor.ORACLE, "2004-09-01", "2009-11-01", "2009-11-01"),
	ORA_JAVA12 (Category.LANGUAGE, License.COMMERCIAL_ORA, false, "Oracle Java 12", Vendor.ORACLE, "2004-09-01", "2009-11-01", "2009-11-01"),
	ORA_JAVA13 (Category.LANGUAGE, License.COMMERCIAL_ORA, false, "Oracle Java 13", Vendor.ORACLE, "2004-09-01", "2009-11-01", "2009-11-01"),
	ORA_JAVA14 (Category.LANGUAGE, License.COMMERCIAL_ORA, false, "Oracle Java 14", Vendor.ORACLE, "2004-09-01", "2009-11-01", "2009-11-01"),
	ORA_JAVA15 (Category.LANGUAGE, License.COMMERCIAL_ORA, false, "Oracle Java 15", Vendor.ORACLE, "2004-09-01", "2009-11-01", "2009-11-01"),
	ORA_JAVA16 (Category.LANGUAGE, License.COMMERCIAL_ORA, false, "Oracle Java 16", Vendor.ORACLE, "2004-09-01", "2009-11-01", "2009-11-01"),
	IBM_JAVA6 (Category.LANGUAGE, License.COMMERCIAL_IBM, true, "IBM Java 6", Vendor.IBM, "2007-11-01", "2017-09-01", "2017-09-01"),
	IBM_JAVA7 (Category.LANGUAGE, License.COMMERCIAL_IBM, false, "IBM Java 7", Vendor.IBM, "2011-09-01", "2022-04-01", "2022-04-01"),
	JAVA_EE5 (Category.FRAMEWORK, License.OPENSOURCE_GPL, true, "Java EE 5 Specs", Vendor.JAVAEE_COMMUNITY, "2004-09-01", "2009-11-01", "2009-11-01"),
	JAVA_EE6 (Category.FRAMEWORK, License.OPENSOURCE_GPL, true, "Java EE 6 Specs", Vendor.JAVAEE_COMMUNITY, "2004-09-01", "2009-11-01", "2009-11-01"),
	JAVA_EE7 (Category.FRAMEWORK, License.OPENSOURCE_GPL, false, "Java EE 7 Specs", Vendor.JAVAEE_COMMUNITY, "2004-09-01", "2009-11-01", "2009-11-01"),
	JAKARTA_EE8 (Category.FRAMEWORK, License.OPENSOURCE_ECLIPSE_TSK, false, "Jakarta EE 8 Specs", Vendor.JAKARTAEE_ECLIPSE_FOUNDATION, "2004-09-01", "2009-11-01", "2009-11-01"),
	WLS_1036 (Category.MIDDLEWARE, License.COMMERCIAL_ORA, true, "Oracle WebLogic 10.3.6", Vendor.ORACLE, "2012-02-26", "2014-06-01", "2014-06-01"),
	WLS_12214 (Category.MIDDLEWARE, License.COMMERCIAL_ORA, false, "Oracle WebLogic 12.2.1.4", Vendor.ORACLE, "2019-09-27", "2022-08-01", "2022-08-01"),
	WAS_800 (Category.MIDDLEWARE, License.COMMERCIAL_IBM, true, "WebSphere Application Server  V8.0.x", Vendor.IBM, "2011-07-11", "2016-12-16", "2016-12-16"),
	WAS_850 (Category.MIDDLEWARE, License.COMMERCIAL_IBM, false, "WebSphere Application Server  V8.5.x", Vendor.IBM, "2012-12-14", "2020-09-18", "2020-09-18"),
	APACHE_HTTP_2441 (Category.MIDDLEWARE, License.OPENSOURCE_ASF2, false, "Apache HTTP Server 2.4.4.1", Vendor.APACHE, "2019-08-14", "2019-08-14", "2019-08-14"),
	ORA_OSM73 (Category.MIDDLEWARE, License.COMMERCIAL_ORA, false, "Oracle OSM 7.3.x", Vendor.ORACLE, "2015-07-01", "2020-07-01", "2020-07-01"),
	ORA_OSM74 (Category.MIDDLEWARE, License.COMMERCIAL_ORA, false, "Oracle OSM 7.4.x", Vendor.ORACLE, "2019-07-01", "2024-07-01", "2024-07-01");
	
	private final Category category;
	private final License license;
	private final boolean eol;
	private final String version;
	private final Vendor vendor; // associated vendor or open source community 
	private Date releaseDate = null;
	private Date lastFreePersonnalPublicUpdateDate;
	private Date lastFreeCommercialPublicUpdateDate;
	
	Technology(Category category, License license, boolean eol, String version, Vendor vendor, String releaseDate, String lastFreePersonnalPublicUpdateDate, String lastFreeCommercialPublicUpdateDate) {
		this.category = category;
		this.license = license;
		this.eol = eol;
		this.version = version;
		this.vendor = vendor;
		try {
			this.releaseDate = new SimpleDateFormat("yyyy-MM-dd").parse(releaseDate);
			this.lastFreePersonnalPublicUpdateDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastFreePersonnalPublicUpdateDate);
			this.lastFreeCommercialPublicUpdateDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastFreeCommercialPublicUpdateDate);
		} catch (Exception e) {
			System.out.println("Invalid date format! "+e.getMessage());
		}
	}
	

	public License getLicense() {
		return license;
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

	public Date getLastFreePersonnalPublicUpdateDate() {
		return lastFreePersonnalPublicUpdateDate;
	}

	public Date getLastFreeCommercialPublicUpdateDate() {
		return lastFreeCommercialPublicUpdateDate;
	}
}
