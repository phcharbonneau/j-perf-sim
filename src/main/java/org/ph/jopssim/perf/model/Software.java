package org.ph.jopssim.perf.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 
 * @author phcha
 *
 */
public class Software implements Comparable<Software> {
	
	private Technology technology;
	private Collection<Technology> techDependencyList = new ArrayList<Technology>();
	private String refURL;
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

	public String getReleaseDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(technology.getReleaseDate());
	}
	
	public String getLastFreePersonnalPublicUpdateDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(technology.getLastFreePersonnalPublicUpdateDate()).trim();
	}
	
	public String getLastFreeCommercialPublicUpdateDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(technology.getLastFreeCommercialPublicUpdateDate()).trim();
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
	public void addTechDependency(Technology tech) {
		techDependencyList.add(tech);
	}

	public Collection<Technology> getTechDependencyList() {
		return techDependencyList;
	}

	@Override
	public int compareTo(Software o) {
		
		if ((technology.getReleaseDate().before(o.technology.getReleaseDate()))) {
			return -1;
		} else {
			return 1;
		}
		
	}

}
