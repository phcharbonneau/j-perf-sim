package org.ph.jopssim.perf.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.ph.jopssim.perf.model.Software;
import org.ph.jopssim.perf.model.Technology;
import org.ph.jopssim.perf.model.LifeCycle;
import org.ph.jopssim.perf.model.Category;
import org.ph.jopssim.perf.model.Vendor;
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
		Software java5_ora = new Software(Technology.JAVA, Category.LANGUAGE, Vendor.ORACLE, LifeCycle.EOL);
		java5_ora.setRefURL("https://docs.oracle.com/en/middleware/fusion-middleware/weblogic-server/12.2.1.4/index.html");
		java5_ora.setLastFreePublicUpdateDate("2009-11-01");
		java5_ora.setExtendedSupportDate("2015-04-01");
		coll.add(java5_ora);
		
		Software java6_ora = new Software(Technology.JAVA, Category.LANGUAGE, Vendor.ORACLE, LifeCycle.EOL);
		java6_ora.setRefURL("https://docs.oracle.com/en/middleware/fusion-middleware/weblogic-server/12.2.1.4/index.html");
		java6_ora.setLastFreePublicUpdateDate("2013-04-01");
		java6_ora.setExtendedSupportDate("2018-12-01");
		coll.add(java6_ora);
		
		
		return coll;
    }
}
