package org.ph.jopssim.perf.service;

import org.ph.jopssim.perf.model.UserData;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

	@Override
	public UserData getUserAccountData(String userID) {
		
		// simulate a date fetch of 100MB On-Heap for one query
		int size = 100 * 1024 * 1024;
		byte[] dataSize = new byte[size];
		
		UserData userData = new UserData("PH");
		
		userData.setAccountData(dataSize);
		
		return userData;
	}

}
