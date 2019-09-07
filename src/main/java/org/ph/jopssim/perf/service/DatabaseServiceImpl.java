package org.ph.jopssim.perf.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.ph.jopssim.perf.model.UserData;
import org.springframework.stereotype.Service;

@Service
public class DatabaseServiceImpl implements DatabaseService {

	@Override
	public List<UserData> getAllUsers() {
		
		List<UserData> userList = new ArrayList<UserData>();
		int nbUsers = 5000000;
		
		for (int i=0; i<nbUsers; i++) {
			UserData user = new UserData("User"+i);
			
			userList.add(user);
		}
		
		return userList;
	}

}
