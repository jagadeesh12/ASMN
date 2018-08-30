package com.util;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import com.scholastic.torque.common.FileUtils;
import com.scholastic.torque.common.TestBaseProvider;

public class Estconfig {
	static Configuration specificTestData;
	static String question;
	static String type;
	private XMLConfiguration testData;


	public static String getQuestion() {
		return question;
	}



	public static void setQuestion(String question) {
		Estconfig.question = question;
	}



	public static String getType() {
		return type;
	}



	public static void setType(String type) {
		Estconfig.type = type;
	}



	public static void main(String arsg[]) {	
		try{
			Configuration config = new XMLConfiguration(System.getProperty("user.dir")+"/Assessment.xml");
			System.out.println(config);
			setType(config.getString("testcaseid.type"));
			setQuestion(config.getString("testcaseid.xpath"));
			specificTestData=	getTestDataFromXml("Look at the pattern. Then, move the two shapes that come next into the boxes.");

			// do something with config
		}
		catch(ConfigurationException cex){
			cex.printStackTrace();
			// something went wrong, e.g. the file was not found
		}
	}
	public static Configuration getTestDataFromXml(String tcId) {
		Configuration temp = TestBaseProvider.getTestBase().getTestDataFromXml()
				.subset("testcase[@id='" + tcId + "']");

		Iterator<?> keys = temp.getKeys();
		while (keys.hasNext()) {
			String k = (String) keys.next();
			String v = temp.getString(k);
			String r = getV(v);
			temp.setProperty(k, r);
		}
		return temp;
	}
	public static String getV(String v) {
		if (!v.contains("$")) {
			return v;
		}
		if ((v.contains("$")) && (v.contains(","))) {
			String[] data = v.split(",");
			String value = TestBaseProvider.getTestBase()
					.getString(data[0].substring(2, data[0].length() - 1));
			for (int i = 1; i < data.length; i++) {
				if (TestBaseProvider.getTestBase()
						.getString(data[i].substring(2, data[i].length() - 1)) != null) {
					v = TestBaseProvider.getTestBase()
							.getString(data[i].substring(2, data[i].length() - 1));
				} else {
					v = data[i];
				}
				value = value + "," + v;
			}
			return value;
		}
		v = TestBaseProvider.getTestBase().getString(v.substring(2, v.length() - 1));
		return v;
	}

	public void loadtestdata(){
		String envResoucesFile = System.getProperties().getProperty(
				"testdata");
		for (String resouces : envResoucesFile.split(","))
			loadTestDataFromFile(resouces);
	}
	private void loadTestDataFromFile(String filename) {
		loadTestDataFromFile(FileUtils.getFile(filename));
	}
	private void loadTestDataFromFile(File file) {
		if ((file.exists()) && (file.isFile())) {
			try {
				if (file.getName().endsWith(".xml"))
					this.testData.load(file);
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}
		} else if (file.isDirectory()) {
			String[] files = file.list(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.endsWith(".xml");
				}
			});
			for (String f : files)
				loadTestDataFromFile(new File(file, f));
		}
	}
}
