package org.ph.jopssim.perf.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author phcha
 *
 */
public class Software {
	
	private Technology technology;
	private Category category;
	private Vendor vendor;
	private LifeCycle lifeCycle;
	private String version;
	private String refURL;
	private Date releaseDate;
	private Date lastFreePublicUpdateDate;
	private Date extendedSupportDate;
	
	public Software(Technology technology, Category software, Vendor vendor, LifeCycle lifeCycle) {
		this.technology = technology;
		this.category = software;
		this.vendor = vendor;
		this.lifeCycle = lifeCycle;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public LifeCycle getLifeCycle() {
		return lifeCycle;
	}

	public void setLifeCycle(LifeCycle lifeCycle) {
		this.lifeCycle = lifeCycle;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRefURL() {
		return refURL;
	}

	public void setRefURL(String refURL) {
		this.refURL = refURL;
	}

	public Date getLastFreePublicUpdateDate() {
		return lastFreePublicUpdateDate;
	}

	public void setLastFreePublicUpdateDate(String date) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = null;
		
		try {
			newDate = dateFormat.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid Last Free Update Date format:" +e.getMessage(), e);
		}
		
		this.lastFreePublicUpdateDate = newDate;
	}

	public Date getExtendedSupportDate() {
		return extendedSupportDate;
	}

	public void setExtendedSupportDate(String date) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = null;
		
		try {
			newDate = dateFormat.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid extended Support Date format:" +e.getMessage(), e);
		}
		
		this.extendedSupportDate = newDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = null;
		
		try {
			newDate = dateFormat.parse(releaseDate);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid extended Support Date format:" +e.getMessage(), e);
		}
		
		this.releaseDate = newDate;
	}

	
}
