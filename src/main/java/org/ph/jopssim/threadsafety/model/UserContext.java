package org.ph.jopssim.threadsafety.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component("userContext")
@RequestScope
public class UserContext {
	
	private Object lock = new Object();
	private String name;
	private String nickName;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		testLock();
		return name;
	}
	
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	private void testLock() {
		synchronized(lock) {
			System.out.println("lock "+lock+" entered by: "+Thread.currentThread().toString());
			
			// try to block other threads...
			try {Thread.sleep(30000); } catch (InterruptedException e) {}
		}
	}
}
