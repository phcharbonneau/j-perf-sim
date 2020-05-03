package org.ph.jopssim.perf.controller;

import org.ph.jopssim.threadsafety.model.StuckThread;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Deadlock Controller provide a simple way to simulate a Java-level deadlock
 * @author phcha
 *
 */
@RestController
public class DeadlockController {
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	@RequestMapping("/tlock")
    public String threadLock(@RequestParam(value="order", defaultValue="1") int lockOrder) {
       
		if (lockOrder == 1) {
			synchronized (lock1) { // attempt to acquire Lock #1...
				// do some work for 30 secs...
				try { Thread.sleep(30000); } catch (InterruptedException ignore) {}
				
				synchronized (lock2) {} // attempt to acquire Lock #2...
			}
		} else if (lockOrder == 2) {
			synchronized (lock2) { // attempt to acquire Lock #2...
				// do some work for 30 secs...
				try { Thread.sleep(30000); } catch (InterruptedException ignore) {}
				
				synchronized (lock1) {} // attempt to acquire Lock #1...
			}
		} 
		
		return "threadLock() completed!";
    }
	
	
}
