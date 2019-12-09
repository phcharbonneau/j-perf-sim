package org.ph.jopssim.perf.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.ph.jopssim.perf.model.Software;
import org.ph.jopssim.perf.model.Technology;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SoftwareController
 * @author phcha
 *
 */
@RestController
public class SoftwareController {
	
	@GetMapping("/softwares")
    Collection<Software> users(final HttpServletResponse response) {
        
		response.addHeader("Access-Control-Allow-Origin", "http://ph-react-ph-wildfly10.b9ad.pro-us-east-1.openshiftapps.com");
		
		Collection<Software> coll = new ArrayList<Software>();
		
		/****** TODO: automate data mapping and refresh where possible..****/
		/**********  Build list of all languages ************************/
		Software java5_ora = new Software(Technology.ORA_JAVA5);
		java5_ora.setRefURL("https://www.oracle.com/java/technologies/java-archive-javase5-downloads.html");
		java5_ora.setLastFreePublicUpdateDate("2009-11-01");
		java5_ora.setExtendedSupportDate("2015-04-01");
		coll.add(java5_ora);
		
		Software java6_ora = new Software(Technology.ORA_JAVA6);
		java6_ora.setRefURL("https://www.oracle.com/java/technologies/javase-java-archive-javase6-downloads.htmls");
		java6_ora.setLastFreePublicUpdateDate("2013-04-01");
		java6_ora.setExtendedSupportDate("2018-12-01");
		coll.add(java6_ora);
		
		
		/**********  Build list of all Middlewares ************************/
		Software wls12214_ora = new Software(Technology.WLS_12214);
		wls12214_ora.setRefURL("https://docs.oracle.com/en/middleware/fusion-middleware/weblogic-server/12.2.1.4/index.html");
		wls12214_ora.setLastFreePublicUpdateDate("2022-08-01");
		wls12214_ora.setExtendedSupportDate("2025-08-01");
		coll.add(wls12214_ora);
		
		return coll;
    }
}
