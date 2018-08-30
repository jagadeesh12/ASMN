package com.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import com.scholastic.torque.common.TestBaseProvider;

public class Util {
	
	public static void populateTestdata(String question) {
			String testcaseid = question;
			TestBaseProvider.getTestBase().getContext().setProperty("testcaseid", testcaseid.trim());
			TestBaseProvider.getTestBase().setTestDataFromXml(testcaseid);
	
	
			try
			{
			    XMLConfiguration config = new XMLConfiguration("tables.xml");
			    // do something with config
			}
			catch(ConfigurationException cex)
			{
			    // something went wrong, e.g. the file was not found
			}}

}
