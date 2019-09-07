package org.ph.jopssim.threadsafety.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.ph.jopssim.threadsafety.model.StuckThread;
import org.ph.jopssim.threadsafety.service.StuckThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuckThreadController {
	
	private Object lock = new Object();
	private final StuckThreadService service;
	
	@Autowired
	public StuckThreadController(StuckThreadService service) {
		this.service = service;
	}
	
	@RequestMapping("/stuckthread")
    public StuckThread stuckThread(@RequestParam(value="name", defaultValue="PH") String name) {
       
		System.out.println(this);
		System.out.println("Service impl: "+service);
		
		//testLock();
		service.simulateStuckThread();
		service.simulateStuckThread2();
		
		return new StuckThread("PH", true);
    }
	
	private void testLock() {
		synchronized(lock) {
			System.out.println("lock "+lock+" entered by: "+Thread.currentThread().toString());
			
			// try to block other threads...
			try {Thread.sleep(30000); } catch (InterruptedException e) {}
		}
	}
}
