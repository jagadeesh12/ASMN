package com.assessment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;

import com.assessment.keys.Keys.hooksConstants;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

public class BasePage extends ParentPage implements hooksConstants {
	Logger logger = LoggerFactory.getLogger(BasePage.class);
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	TestBase testBase = TestBaseProvider.getTestBase();
	public parameters par = new parameters();

	public BasePage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
		par.TEACHERUSERNAME = testBase.getContext().getString("teacherusername");
		par.TEACHERPASSWORD = testBase.getContext().getString("teacherpassword");
		par.STUDENTUSERNAME = testBase.getContext().getString("studentusername");
		par.STUDENTPASSWORD = testBase.getContext().getString("studentpassword");
		par.CSREPUSERNAME = testBase.getContext().getString("csrepusername");
		par.CSREPPASSWORD = testBase.getContext().getString("csreppassword");
		par.CSREPURL = testBase.getContext().getString("csrepurl");

	}

	public void loginApp(String name, String password) {
		String url = testBase.getContext().getString(URL);

		if (url.contains("slz")) {
			SlzLoginPg slzlogin = new SlzLoginPg(driver);
			slzlogin.login(name, password);
		}
	}

	/*
	 * @Parameters({"teachername"}) public void loginApp(String username, String
	 * password) { String url = testBase.getContext().getString(URL);
	 * if(url.contains("slz")){ SlzLoginPg slzlogin = new SlzLoginPg(driver);
	 * slzlogin.login(username, password); } }
	 */

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}

	public void launchAppAssessment() throws InterruptedException {
		SlzHomePg slzhome = new SlzHomePg(driver);
		slzhome.launchAssessment();
	}

	public boolean launchAppAssessmentavailable() {
		SlzHomePg slzhome = new SlzHomePg(driver);
		return (slzhome.LaunchAssessmentLink());
	}

	public void loginAppCSRep(String cSREPUSERNAME, String cSREPPASSWORD, String cSREPURL) {
		String url = testBase.getContext().getString(URL);
		lazyWait(3);

		driver.navigate().to(cSREPURL);
		lazyWait(3);
		SlzLoginPg slzlogin = new SlzLoginPg(driver);
		slzlogin.login(cSREPUSERNAME, cSREPPASSWORD);
	}

}
