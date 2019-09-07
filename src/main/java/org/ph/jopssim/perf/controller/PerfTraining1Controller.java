package org.ph.jopssim.perf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ph.jopssim.perf.model.UserData;
import org.ph.jopssim.perf.service.DataService;
import org.ph.jopssim.perf.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerfTraining1Controller {
	
	private static Logger log = LogManager.getLogger(PerfTraining1Controller.class);
	private @Autowired HttpServletRequest request;
	private final DatabaseService dbService;
	private final DataService dataService;
	
	@Autowired
	public PerfTraining1Controller(DatabaseService dbService, DataService dataService) {
		this.dbService = dbService;
		this.dataService = dataService;
	}
	
	@RequestMapping("/userlist")
    public List<UserData> userList(@RequestParam(value="userID", defaultValue="PH") String userID) {
		
		log.error("log4j in action!");
		System.out.println("HttpServletRequest: "+request.hashCode());
		System.out.println("HttpServletRequest session: "+request.getSession().getId());
		
		// obtain the list of all users (5 millions) from the DB
		List<UserData> userList = null;//dbService.getAllUsers();
		
		// Do some other work for 5 secs...
		//doWork(5);
		
		// return the list
		return userList;
    }
	
	@RequestMapping("/userdata")
    public UserData userData(@RequestParam(value="userID", defaultValue="PH") String userID) {
		
		// obtain the user data details (100MB payload) from the remote external system...
		UserData userData = dataService.getUserAccountData(userID);
		
		// Do some other work for 5 secs...
		doWork(5);
		
		// return the user full name
		return userData;
    }
	
	private void doWork(int secs) {
		// try to block other threads...
		try {Thread.sleep(secs*1000); } catch (InterruptedException e) {}
	}
}
