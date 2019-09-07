package org.ph.jopssim.threadsafety.service;

import org.ph.jopssim.threadsafety.model.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuckThreadServiceImpl implements StuckThreadService {
	
	private Object lock = new Object();
	
	@Autowired
	private UserContext userContext;
	
	@Override
	public void simulateStuckThread() {
		
		//testLock();
		System.out.println("simulate stuck thread "+this);
		System.out.println("service user context "+userContext);
		userContext.setName(Thread.currentThread().toString());
		//userContext.setName("name: "+Thread.currentThread().toString());
		//System.out.println("service user context "+userContext.getName());
	}
	
	@Override
	public void simulateStuckThread2() {
		
		userContext.setNickName("PH");
		System.out.println("UserContext:" +userContext.getName() +" | " + userContext.getNickName());
	}
	
	private void testLock() {
		synchronized(lock) {
			System.out.println("lock "+lock+" entered by: "+Thread.currentThread().toString());
			
			// try to block other threads...
			try {Thread.sleep(30000); } catch (InterruptedException e) {}
		}
	}
}
