package com.assessment.stepdefs;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.assessment.pageobjects.BasePage;
import com.assessment.pageobjects.FooterPageObject;
import com.assessment.pageobjects.SlzHomePg;
import com.assessment.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Footer{
	
	private static final String String = null;
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	TestBase testBase = TestBaseProvider.getTestBase();
	BasePage base = new BasePage(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	FooterPageObject TeacherHP = PageFactory.initElements(this.driver,
			FooterPageObject.class);
	

	
@When("^when I click on the Privacy Policy$")
public void when_I_click_on_the_Privacy_Policy() throws Throwable {
	Thread.sleep(3000);
	TeacherHP.Isprivacypolicy();
	
}

@Then("^a new tab will open with the Privacy Policy document:$")
public void a_new_tab_will_open_with_the_Privacy_Policy_document() throws Throwable {
	System.out.println(TeacherHP.getscholasticText());
	
}

}

