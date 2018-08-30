
package com.assessment.stepdefs;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.assessment.pageobjects.AssessmentlogoPageobject;
import com.assessment.pageobjects.BasePage;
import com.assessment.pageobjects.SlzHomePg;
import com.assessment.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Assessmentlogo {

	private static final String String = null;
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	TestBase testBase = TestBaseProvider.getTestBase();
	BasePage base = new BasePage(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	AssessmentlogoPageobject TeacherHP = PageFactory.initElements(this.driver, AssessmentlogoPageobject.class);

	@When("^I click on the assessment logo in the assessment program$")
	public void i_click_on_the_assessment_logo_in_the_assessment_program() throws Throwable {
		// TeacherHP.verifylogo();
	}

	@Then("^the logo should be displayed$")
	public void the_logo_should_be_displayed() throws Throwable {
		System.out.println(TeacherHP.Assessmentlogoimg());

	}

	@Then("^I navigated to Assessment Page$")
	public void i_navigated_to_Assessment_Page() throws Throwable {
		TeacherHP.clickOnAssessment();
		System.out.println(TeacherHP.verifyAssessmentPage());

	}

	@Then("^I click on logo$")
	public void i_click_on_logo() throws Throwable {

		TeacherHP.clickOnLogo();

	}

	@Then("^I navigated to Home page in the assessment program$")
	public void i_navigated_to_Home_page_in_the_assessment_program() throws Throwable {
		TeacherHP.verifyHomePage();

	}

	@And("^I selected \"([^\"]*)\" from the dropdown$")
	public void i_selected_from_the_dropdown(String classname) throws Throwable {
		TeacherHP.clickClassDropdown();
		TeacherHP.selectClass(classname);
	}

	@Then("^I verify dropdown on the upper-left of the page$")
	public void i_verify_dropdown_on_the_upper_left_of_the_page() throws Throwable {
		TeacherHP.verifyClassDropdown();

	}

	@When("^I click on Reports in the assessment program$")
	public void i_click_on_Reports_in_the_assessment_program() throws Throwable {
		TeacherHP.clickOnReports();

	}

	@Then("^I navigated to Reports Page$")
	public void i_navigated_to_Reports_Page() throws Throwable {
		TeacherHP.verifyReportsPage();
	}

	@Then("^I should be able to logout from assessment window$")
	public void i_should_be_able_to_logout_from_assessment_window() throws Throwable {
		TeacherHP.logout();

	}

}
