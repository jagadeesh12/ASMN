
package com.assessment.stepdefs;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.assessment.pageobjects.AssessmentlogoPageobject;

import com.assessment.pageobjects.Assessmentscreenpageobject;
import com.assessment.pageobjects.BasePage;
import com.assessment.pageobjects.SlzHomePg;
import com.assessment.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Assessmentscreen {
	
	private static final String String = null;
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	TestBase testBase = TestBaseProvider.getTestBase();
	BasePage base = new BasePage(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	Assessmentscreenpageobject TeacherHP = PageFactory.initElements(this.driver,
			Assessmentscreenpageobject.class);
	
	
	  
	@Then("^I should see timer dispalyed on screen and click on pause button$")
	public void i_should_see_timer_dispalyed_on_screen_and_click_on_pause_button() throws Throwable {
		TeacherHP.verifytimerelapsedtime();
	}

	@Then("^Activity pop-up should be dispalyed$")
	public void activity_pop_up_should_be_dispalyed() throws Throwable {
	   TeacherHP.activitypopup();
	}
	
	

@Then("^I click on continue button$")
public void i_click_on_continue_button() throws Throwable {
	
   TeacherHP.continuebuttton();
   Thread.sleep(2000);
  
   System.out.println("teacheris helping");
}

@When("^I click on \"([^\"]*)\" button  on the assessment screen$")
public void i_click_on_button_on_the_assessment_screen(String arg1) throws Throwable {
   TeacherHP.click_on_start_button();
}
@Then("^I should see message pop-up$")
public void i_should_see_message_pop_up(String popupmessage) throws Throwable {
	TeacherHP.verifystartpopup(popupmessage);
	
}

@Then("^I should see \"([^\"]*)\" pop-up$")
public void i_should_see_pop_up(String popupmessage) throws Throwable {
	TeacherHP.verifystartpopup(popupmessage);
	//assertTrue("Messagepopup should not be displayed",TeacherHP.verifystartpopup(popupmessage));
}
@When("^I mouse over on Quit icon Quit text should be displayed$")
public void i_mouse_over_on_Quit_icon_Quit_text_should_be_displayed() throws Throwable {
	TeacherHP.Quit();
    }
@When("^I mouse over on Full screen text should be displayed$")
public void i_mouse_over_on_Full_screen_text_should_be_displayed() throws Throwable {
   TeacherHP.fullscreen ();
}
@When("^I mouse over on accessiblity icon accessiblity text should be displayed$")
public void i_mouse_over_on_accessiblity_icon_accessiblity_text_should_be_displayed() throws Throwable {
	TeacherHP.accessbility ();
}
@When("^I mouse over on calculator icon calculator text should be dispalyed$")
public void i_mouse_over_on_calculator_icon_calculator_text_should_be_dispalyed() throws Throwable {
	TeacherHP.calculator();
}
@When("^I mouse over on flag item iocn flag item text should be dispalyed$")
public void i_mouse_over_on_flag_item_iocn_flag_item_text_should_be_dispalyed() throws Throwable {
	TeacherHP.flagitem();
}
}