package org.ph.jopssim.perf.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.ph.jopssim.perf.model.Software;
import org.ph.jopssim.perf.model.Technology;
import org.ph.jopssim.perf.model.Vendor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SoftwareController 2
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
		Software openjdk8 = new Software(Technology.OPENJDK8);
		openjdk8.setRefURL("https://wiki.openjdk.java.net/display/jdk8u/Main");
		coll.add(openjdk8);
		
		Software openjdk8_rh = new Software(Technology.RH_OPENJDK8);
		openjdk8_rh.setRefURL("https://access.redhat.com/articles/1299013");
		coll.add(openjdk8_rh);
		
		Software java5_ora = new Software(Technology.ORA_JAVA5);
		java5_ora.setRefURL("https://www.oracle.com/java/technologies/java-archive-javase5-downloads.html");
		java5_ora.setExtendedSupportDate("2015-04-01");
		coll.add(java5_ora);
		
		Software java6_ora = new Software(Technology.ORA_JAVA6);
		java6_ora.setRefURL("https://www.oracle.com/java/technologies/javase-java-archive-javase6-downloads.htmls");
		java6_ora.setExtendedSupportDate("2018-12-01");
		coll.add(java6_ora);
		
		Software java6_ibm = new Software(Technology.IBM_JAVA6);
		java6_ibm.setRefURL("https://developer.ibm.com/javasdk/downloads/sdk6/");
		coll.add(java6_ibm);
		
		Software java7_ibm = new Software(Technology.IBM_JAVA7);
		java7_ibm.setRefURL("https://developer.ibm.com/javasdk/downloads/sdk7/");
		coll.add(java7_ibm);
		
		Software java7_ora = new Software(Technology.ORA_JAVA7);
		java7_ora.setRefURL("https://www.oracle.com/technetwork/java/javase/downloads/java-archive-downloads-javase7-521261.html");
		java7_ora.setExtendedSupportDate("2018-12-01");
		coll.add(java7_ora);
		
		
		/**********  Build list of all Middlewares ************************/
		Software wls1036_ora = new Software(Technology.WLS_1036);
		wls1036_ora.addTechDependency(Technology.ORA_JAVA7);
		wls1036_ora.addTechDependency(Technology.JAVA_EE5);
		wls1036_ora.setRefURL("https://oracle-base.com/articles/11g/oracle-weblogic-server-11gr1-1036-installation-on-windows-64-bit");
		wls1036_ora.setExtendedSupportDate("2017-06-01");
		coll.add(wls1036_ora);
		
		Software wls12214_ora = new Software(Technology.WLS_12214);
		wls12214_ora.addTechDependency(Technology.ORA_JAVA8);
		wls12214_ora.addTechDependency(Technology.JAVA_EE7);
		wls12214_ora.setRefURL("https://docs.oracle.com/en/middleware/fusion-middleware/weblogic-server/12.2.1.4/index.html");
		wls12214_ora.setExtendedSupportDate("2025-08-01");
		coll.add(wls12214_ora);
		
		Software osm73_ora = new Software(Technology.ORA_OSM73);
		osm73_ora.addTechDependency(Technology.ORA_JAVA8);
		osm73_ora.addTechDependency(Technology.JAVA_EE7);
		osm73_ora.setRefURL("https://docs.oracle.com/en/industries/communications/order-service-management/index.html");
		osm73_ora.setExtendedSupportDate("2023-07-01");
		coll.add(osm73_ora);
		
		Software osm74_ora = new Software(Technology.ORA_OSM74);
		osm74_ora.addTechDependency(Technology.ORA_JAVA8);
		osm74_ora.addTechDependency(Technology.JAVA_EE7);
		osm74_ora.setRefURL("https://docs.oracle.com/en/industries/communications/order-service-management/index.html");
		osm74_ora.setExtendedSupportDate("2027-07-01");
		coll.add(osm74_ora);
		
		Software was800_ora = new Software(Technology.WAS_800);
		was800_ora.addTechDependency(Technology.IBM_JAVA6);
		was800_ora.addTechDependency(Technology.JAVA_EE6);
		was800_ora.setRefURL("https://www.ibm.com/support/pages/80014-websphere-application-server-v80-fix-pack-14");
		coll.add(was800_ora);
		
		Software was850_ora = new Software(Technology.WAS_850);
		was850_ora.addTechDependency(Technology.IBM_JAVA7);
		was850_ora.addTechDependency(Technology.JAVA_EE6);
		was850_ora.setRefURL("https://www.ibm.com/support/pages/855-websphere-application-server-v8550");
		coll.add(was850_ora);
		
		Software apache_http2441 = new Software(Technology.APACHE_HTTP_2441);
		apache_http2441.setRefURL("http://www.apache.org/dist/httpd/Announcement2.4.html");
		coll.add(apache_http2441);
		
		
		
		/**********  Build list of all specialized middleware products ************************/
		Collections.sort((List<Software>) coll);
		return coll;
    }
}
