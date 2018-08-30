package com.assessment.stepdefs;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.assessment.pageobjects.BasePage;
import com.assessment.pageobjects.CsRepLoginPg;
import com.assessment.pageobjects.HomePage;
import com.assessment.pageobjects.ResultsPg;
import com.assessment.pageobjects.SlzHomePg;
import com.assessment.pageobjects.SlzLoginPg;
import com.assessment.pageobjects.parameters;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StudentHomepage {
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	TestBase testBase = TestBaseProvider.getTestBase();
	BasePage base = new BasePage(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	CsRepLoginPg csreplogin = new CsRepLoginPg(driver);
	ResultsPg respg = new ResultsPg(driver);

	HomePage StudentHP = PageFactory.initElements(this.driver, HomePage.class);

	@Given("^the url of assessment login URL$")
	public void the_url_of_assessment_login_URL() throws Throwable {
		WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	}

	@When("^provide valid Teacher credentials$")
	public void provide_valid_Teacher_credentials() throws Throwable {
		base.loginApp(base.par.TEACHERUSERNAME, base.par.TEACHERPASSWORD);
	}

	@When("^provide valid CSREP credentials$")
	public void provide_valid_CSREP_credentials() throws Throwable {
		csreplogin.login(base.par.CSREPUSERNAME, base.par.CSREPPASSWORD, base.par.CSREPURL);
	}

	@Then("^clicks on Organization name \"([^\"]*)\"$")
	public void clicks_on_organization_name_something(String orgName) throws Throwable {
		csreplogin.clickOrganizationName(orgName);
	}

	@And("^search Org with OrgID \"([^\"]*)\"$")
	public void search_org_with_orgid_something(String OrgID) throws Throwable {
		csreplogin.searchOrg(OrgID);

	}

	@And("^clicks on Scholastic Learning Zone$")
	public void clicks_on_scholastic_learning_zone() throws Throwable {
		csreplogin.clickScholasticLearningZone();
	}

	@When("^provide valid Student credentials$")
	public void provid_valid_student_credentials() throws Throwable {
		base.loginApp(base.par.STUDENTUSERNAME, base.par.STUDENTPASSWORD);
	}

	@When("^clicked on assessement icon in myzone$")
	public void clicked_on_assessement_icon_in_myzone() throws Throwable {
		base.launchAppAssessment();
	}

	@Then("^student navigated to Myassessments page$")
	public void student_navigated_to_myassessments_page() throws Throwable {
		StudentHP.verifyStudentAssessmentPage();

	}

	@And("^verifies assigned assessment is displayed$")
	public void verifies_assigned_assessment_is_displayed() throws Throwable {
		StudentHP.verifyAssessmentDisplayed();

	}

	@Then("^student navigated to My Result page$")
	public void student_navigated_to_my_result_page() throws Throwable {
		StudentHP.verifyStudentResultPage();

	}

	@And("^I click on Results Page$")
	public void i_click_on_results_page() throws Throwable {
		StudentHP.clickOnReports();
	}

	@And("^student click on logo$")
	public void student_click_on_logo() throws Throwable {
		StudentHP.clickStudentLogo();
	}

	@Then("^I navigated to Student Home page$")
	public void i_navigated_to_student_home_page() throws Throwable {
		StudentHP.verifyStudentAssessmentPage();
	}

	@Then("^assessment home page should be displayed$")
	public void assessment_home_page_should_be_displayed() throws Throwable {
		assertTrue(StudentHP.verifyStudentAssessmentPage());
		/*
		 * assertTrue(StudentHP.Load_more_text());
		 * assertTrue(StudentHP.Assessment_logo_img());
		 * assertTrue(StudentHP.My_Assessment_left_panel_tab_verify());
		 * assertTrue(StudentHP.Already_Attempted_link_header());
		 * assertTrue(StudentHP.In_Progress_link_header());
		 * assertTrue(StudentHP.Not_Attempted_link_header());
		 * assertTrue(StudentHP.All_link_header());
		 */

	}

	@Then("^verify First name and last name of the logged in should be displayed$")
	public void verify_First_name_and_last_name_of_the_logged_in_should_be_displayed() throws Throwable {
		System.out.println(StudentHP.getUserGreetingText());
	}

	/*
	 * When("^clicked on logout linkst$") public void clicked_on_logout_linkst()
	 * throws Throwable { Write code here that turns the phrase above into
	 * StudentHP.getUserGreetingText() actions }
	 */

	@Then("^student should be redirected SLZ home page$")
	public void student_should_be_redirected_SLZ_home_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@And("^I click on Assessment name$")
	public void i_click_on_Assessment_name() throws Throwable {
		StudentHP.clickOnAssessmentName();

	}

	@Then("^I click on Start button$")
	public void i_click_on_Start_button() throws Throwable {
		StudentHP.ClickOnStrtBtn();

	}

	@Then("^I verify assessment is launched by verifying Next button$")
	public void i_verify_assessment_is_launched_by_verifying_next_button() throws Throwable {
		assertTrue(StudentHP.verifyNextButton());

	}

	@Then("^I should be able to submit the assessment")
	public void i_should_be_able_to_submit_the_assessment() throws Throwable {
		StudentHP.submitAssessment();

	}
	@When("^I land on my My Results page$")
	public void i_land_on_my_My_Results_page() throws Throwable {
		StudentHP.clickResultsbutton();
	}

	@Then("^I want to see the total number of assessments I have taken$")
	public void i_want_to_see_the_total_number_of_assessments_I_have_taken() throws Throwable {
		assertTrue("Total number not displayed",respg.isTotalNoAssDisplayed());
	}

	@Then("^I want to see the total number of assessments I have taken more than once$")
	public void i_want_to_see_the_total_number_of_assessments_I_have_taken_more_than_once() throws Throwable {
		respg.isAToNAssTakenMoreThanOnce();
	}

	@Then("^I want to see my average score from all assessments I have taken$")
	public void i_want_to_see_my_average_score_from_all_assessments_I_have_taken() throws Throwable {
		respg.isAvgScoreDisplayed();
	}
	@Then("^I want the columns for my assessment history list to be:Assessment Score Date$")
	public void i_want_the_columns_for_my_assessment_history_list_to_be_Assessment_Score_Date() throws Throwable {
		assertTrue("Assesment score date not displayed",respg.isAssesmentScoreDateDisplayed());
	}

}
