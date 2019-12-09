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
	private String refURL;
	private Date releaseDate;
	private Date lastFreePublicUpdateDate;
	private Date extendedSupportDate;
	
	public Software(Technology technology) {
		this.technology = technology;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
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

	public String getVersion() {
		return technology.getVersion();
	}
	
	public String getCategory() {
		return technology.getCategory().toString();
	}
	
	public String getVendor() {
		return technology.getVendor().toString();
	}
	
	public boolean isEol() {
		return technology.isEol();
	}
}
