package org.ph.jopssim.io.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.ph.jopssim.io.model.KeyData;
import org.ph.jopssim.threadsafety.model.UserAccount;
import org.ph.jopssim.threadsafety.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IOController {
	private Integer encryptCallNb = 0; // # of encrypt calls...
	private final UserAccountService service;
	
	@Autowired
	public IOController(UserAccountService service) {
		this.service = service;
	}
	
	@RequestMapping("/encrypt")
    public UserAccount encryptData(@RequestParam(value="userID", defaultValue="PH") String userID) {
		
		// Load unique security key from the file system
		String securirtyKey = loadSecurityKey();
		
		// Obtain user sensitive data...
		String userFullName = service.getFullName(userID);
		
		// Encrypt data...
		encrypt(userFullName);
		
		// Increment encrypt call volume..
		synchronized (encryptCallNb) {
			encryptCallNb++;
			System.out.println("# of encrypt calls is now: "+encryptCallNb);
		}
		
		// return the user full name
		return new UserAccount(userFullName);
    }
	
	private String loadSecurityKey() {
		String keyFile = "D:/Temp/key.txt";
		BufferedReader fileData = null;
		StringBuffer key = new StringBuffer();
		
		try {
			fileData = new BufferedReader(new FileReader(keyFile));
			String line = new String();
			while ((line = fileData.readLine()) != null) {
				key.append(line);
			}
			fileData.close();
		} catch (Exception e) {
			System.out.println("Error extracting security key! "+e);
		}
		return key.toString();
	}
	
	private void encrypt(String userFullName) {
		userFullName = "test";
	}
}
