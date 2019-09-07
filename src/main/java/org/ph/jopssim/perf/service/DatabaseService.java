package org.ph.jopssim.perf.service;

import java.util.List;

import org.ph.jopssim.perf.model.UserData;

public interface DatabaseService {
	
	public List<UserData> getAllUsers();
}
