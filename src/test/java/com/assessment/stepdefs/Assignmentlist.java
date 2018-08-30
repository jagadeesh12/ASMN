
package com.assessment.stepdefs;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.assessment.pageobjects.AssignmnetmodalPageobject;
import com.assessment.pageobjects.BasePage;
import com.assessment.pageobjects.SlzHomePg;
import com.assessment.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Assignmentlist {
	
	private static final String String = null;
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	TestBase testBase = TestBaseProvider.getTestBase();
	BasePage base = new BasePage(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	AssignmnetmodalPageobject TeacherHP = PageFactory.initElements(this.driver,
			AssignmnetmodalPageobject.class);
	

	
	
	

@Then("^I should select class \"([^\"]*)\" from the dropdown$")
public void i_should_select_class_from_the_dropdown(String Grade) throws Throwable {
	TeacherHP.IsGradedropdownClicked();
	TeacherHP.ClickGrade(Grade);
}

@Then("^I should click on assign button$")
public void i_should_click_on_assign_button() throws Throwable {
	TeacherHP.Clickonassign();
    
}
}