package org.ph.jopssim.perf.service;

import org.ph.jopssim.perf.model.UserData;

public interface DataService {
	
	public UserData getUserAccountData(String userID);
}
