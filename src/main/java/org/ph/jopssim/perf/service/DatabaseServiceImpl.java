package org.ph.jopssim.perf.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.ph.jopssim.perf.model.User;
import org.springframework.stereotype.Service;

@Service
public class DatabaseServiceImpl implements DatabaseService {

	@Override
	public List<User> getAllUsers() {
		
		List<User> userList = new ArrayList<User>();
		int nbUsers = 5000000;
		
		for (int i=0; i<nbUsers; i++) {
			User user = new User("User"+i);
			
			userList.add(user);
		}
		
		return userList;
	}

}
