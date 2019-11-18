package org.ph.jopssim.leak.service;

import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import org.ph.jopssim.leak.model.ClassA;
import org.ph.jopssim.leak.model.ClassAImpl;
import org.ph.jopssim.leak.model.ClassAInvocationHandler;
import org.springframework.stereotype.Service;

@Service
public class MetaspaceLeakServiceImpl implements MetaspaceLeakService {
	
	private static Map<String, ClassA> classLeakingMap = new HashMap<String, ClassA>();
	private final static int NB_ITERATIONS_DEFAULT = 5000000;
	
	@Override
	public void simulateMetaspaceLeak(int leakObjs) {
		
		// metaspace leak simulation...
		try {

			for (int i = 0; i < leakObjs; i++) {

				String fictiousClassloaderJAR = "file:" + i + ".jar";

				URL[] fictiousClassloaderURL = new URL[] { new URL(fictiousClassloaderJAR) };

				// Create a new classloader instance
				//URLClassLoader newClassLoader = new URLClassLoader(fictiousClassloaderURL);
				URLClassLoader newClassLoader = new URLClassLoader(fictiousClassloaderURL,Thread.currentThread().getContextClassLoader());
				
				// Create a new Proxy instance
				ClassA t = (ClassA) Proxy.newProxyInstance(newClassLoader,
						new Class<?>[] { ClassA.class },
						new ClassAInvocationHandler(new ClassAImpl()));
				
				// Add the new Proxy instance to the leaking HashMap
				classLeakingMap.put(fictiousClassloaderJAR, t);
				
			}
		} 
		catch (Throwable any) {
			System.out.println("ERROR: " + any);
		}
	}

}
