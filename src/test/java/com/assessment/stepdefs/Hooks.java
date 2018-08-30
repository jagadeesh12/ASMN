package com.assessment.stepdefs;

import static com.scholastic.torque.common.TestBaseProvider.getTestBase;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.saucelabs.saucerest.SauceREST;
import com.scholastic.torque.common.SauceUtils;
import com.scholastic.torque.common.ScreenshotUtil;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;
import com.torque.automation.core.TestDataUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

@SuppressWarnings("unused")
public class Hooks {
	String status = null;

	@Before
	public void beforeHook(Scenario scenario) {
		synchronized (this) {
			getTestBase().getContext().setProperty("scenario.obj", scenario);
			TestBase testBase = TestBaseProvider.getTestBase();
			// Below one line is dashboard related (Not mandatory you can remove
			// this if not needed as of now)
			// TestDataUtils.getAndStorePlatformDetails(System.getProperty("outputdir"));
			// Calling populateTestdata method from Torque2.0
			//TestDataUtils.populateTestdata(scenario.getName());
			System.out.println(TestBaseProvider.getTestBase().getContext().getString("testdata"));
			System.out.println(TestBaseProvider.getTestBase().getContext().getString("resources"));
			testBase.getContext().clearProperty("tdm.UserProfile");
			testBase.getContext().subset("testexecution").clear();
			String session = testBase.getSessionID();
			if (!session.equalsIgnoreCase("")
					&& !testBase.getContext().getString("sauce")
							.equalsIgnoreCase("false")) {
				SauceREST sClient = new SauceREST(testBase.getContext()
						.getString("sauce.username"), testBase.getContext()
						.getString("sauce.access.key"));
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("name", scenario.getName());
				sClient.updateJobInfo(session, params);
			}
			try {
				testBase.getDriver().manage().deleteAllCookies();
			} catch (Exception e) {
				status = "Skipped";
			}
			testBase.getDriver().manage().deleteAllCookies();
			testBase.getDriver().manage().window().maximize();
			testBase.getDriver().get(testBase.getString("url"));
		}
	}

	@After
	public void afterHook(Scenario scenario) throws URISyntaxException,
			ClientProtocolException, IOException {
		synchronized (this) {
			WebDriver driver = TestBaseProvider.getTestBase().getDriver();
			if (scenario.isFailed()) {
				System.out.println("Method Failed::::::::::::"
						+ TestBaseProvider.getTestBase().getString("Method"));
				try {
					scenario.write("Current Page URL is "
							+ driver.getCurrentUrl());
				} catch (WebDriverException somePlatformsDontSupportScreenshots) {
					System.err.println(somePlatformsDontSupportScreenshots
							.getMessage());
				}
			}
			String session = TestBaseProvider.getTestBase().getSessionID();
			TestBase testBase = TestBaseProvider.getTestBase();
			if (!scenario.isFailed()) {
				status = "Passed";
			} else {
				if (status == null) {
					status = "Failed";
				} else {
					status = "Skipped";
				}
			}
			if (session.isEmpty() || session == null) {
				session = "NoSession/TC is Skipped";
			}
			System.out.println("ScenarioFailed=" + scenario.getName()
					+ "<>Session=" + session + "<>Status=" + status
					+ "<>Platform=" + testBase.getString("driver.name"));
			System.out.println("SauceOnDemandSessionID=" + session
					+ " job-name=" + scenario.getName());
			if (!testBase.getString("sauce", "false").equalsIgnoreCase("false")) {
				SauceUtils.setJobStatus(scenario.isFailed());
			}
			ScreenshotUtil.takeScreenshot(scenario);
			TestBaseProvider.getTestBase().tearDown();
		}
	}
}

