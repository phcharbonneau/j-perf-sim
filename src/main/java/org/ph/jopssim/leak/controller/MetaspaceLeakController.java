package org.ph.jopssim.leak.controller;

import org.ph.jopssim.leak.service.MetaspaceLeakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetaspaceLeakController {
	
	private final MetaspaceLeakService service;
	
	@Autowired
	public MetaspaceLeakController(MetaspaceLeakService service) {
		this.service = service;
	}
	
	@RequestMapping("/metadataleak")
    public String simulateMetaspaceLeak(@RequestParam(value="leakObjs", defaultValue="5000") int leakObjs) {
		
		service.simulateMetaspaceLeak(leakObjs);
		
		// return the user full name
		return "Metaspace leak simulation completed! [leak objs:]"+leakObjs;
    }
}
