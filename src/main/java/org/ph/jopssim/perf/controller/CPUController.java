package org.ph.jopssim.perf.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ph.jopssim.perf.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * CPUController
 * @author phcha
 *
 */
@RestController
public class CPUController {
	
	private static Logger log = LogManager.getLogger(PerfTraining1Controller.class);
	
	private final static int MEM_ALLOCATION_MB = 10 * 1024 * 1024; // MB memory allocation
	
	@Autowired
	public CPUController() {}
	
	
	@RequestMapping("/cpu")
    public String userData(@RequestParam(value="spin", defaultValue="1") String spin) {
		
		// simulate a date fetch of X MB On-Heap for one query
		int spinTime = Integer.parseInt(spin);
		
		// CPU spin and allocation of 1MB memory OnHeap per iteration
		for (int i=0; i<spinTime; i++) {
		
			// allocate memory but don't do anything -> eligible for GC on method exit
			byte[] dataSize = new byte[MEM_ALLOCATION_MB];
			
			System.out.println("CPU MB allocation:"+MEM_ALLOCATION_MB);
		}
		
		return spin;
    }
	
	@GetMapping("/users")
    Collection<UserData> users() {
        
		Collection<UserData> coll = new ArrayList<UserData>();
		
		for (int i=0; i<4; i++) {
			coll.add(new UserData("PH"+i));
        }
		
		return coll;
    }
}
