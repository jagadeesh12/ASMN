package com.assessment.stepdefs;

//import static org.testng.Assert.assertTrue;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.assessment.pageobjects.BasePage;
import com.assessment.pageobjects.HomePage;
import com.assessment.pageobjects.SlzHomePg;
import com.assessment.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

import com.assessment.pageobjects.ReportsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AssessmentcommonUIStDf {
	private static final String String = null;
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	// Scenario scenario;
	// LitProUserType lpUserType;
	BasePage base = new BasePage(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	HomePage StudentHP = new HomePage(driver);
	ReportsPage RepPg = new ReportsPage(driver);

	/*
	 * @When("^I launch assessment as \"([^\"]*)\"$") public void
	 * i_launch_assessment_as(String userType) throws Throwable { slzLogin = new
	 * SlzLoginPg(driver); //assertTrue(
	 * "Failed to Launch AUT due to missing info. Check the log.", //
	 * slzLogin.launchSlz()); lpUserType = slzLogin.getLitProUserType(userType);
	 * // scenario.write("Credentials: "+slzLogin.getUserCreds());
	 * base.launchPortal(lpUserType); base.launchAppJoey(lpUserType); //
	 * base.launchAppAssessment(); }
	 */
	@Then("^I click on the Assessments tab$")
	public void i_click_on_the_Assessments_tab() throws Throwable {
		System.out.println("trupti is deing");
		StudentHP.clickAssesmentButton();
		System.out.println("trupti is deing");

	}

	// @Then("^the tab will show as selected with a darker purple color$")
	// public void the_tab_will_show_as_selected_with_a_darker_purple_color()
	// throws Throwable {

	//
	@Then("^I click on the Reports tab$")
	public void i_click_on_the_Reports_tab() throws Throwable {
		System.out.println("trupti is deing");
		StudentHP.clickReportstButton();
		System.out.println("trupti is deing");
	}

	//
	// @When("^I click on the \"([^\"]*)\" icon in the header$")
	// public void i_click_on_the_something_icon_in_the_header(String strArg1)
	// throws Throwable {
	// System.out.println("trupti is snowring");
	// StudentHP.clickneedhelpbutton();
	// System.out.println("trupti is snowring");

	// }

	// @Then("^a new tab will open with the Help Center page$")
	// public void a_new_tab_will_open_with_the_help_center_page() throws
	// Throwable {

	// @Then("^class shown is the first class assigned to me in my dropdown
	// list$")
	// public void
	// class_shown_is_the_first_class_assigned_to_me_in_my_dropdown_list()
	// throws Throwable {
	// StudentHP.clickdropdown();

	// @When("^the class dropdown is expanded$")
	// public void the_class_dropdown_is_expanded() throws Throwable {
	// System.out.print("truos fgoing ");
	// StudentHP.selectdrop(String);

	// @When("^I want my classes to be shown in alphanumeric order \\(e\\.g\\.
	// Grade (\\d+) > Grade (\\d+)C > Grade (\\d+) > Grade (\\d+)B > Grade
	// (\\d+)C\\)$")
	// public void
	// i_want_my_classes_to_be_shown_in_alphanumeric_order_e_g_Grade_Grade_C_Grade_Grade_B_Grade_C(int
	// arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
	// StudentHP.clickdropdown();
	// StudentHP.selectdropdown8();
	// StudentHP. selectdropdown9();

	@When("^I want ghost text to show \"([^\"]*)\" next to the class$")
	public void i_want_ghost_text_to_show_next_to_the_class(String arg1) throws Throwable {
		System.out.println("going to aricent");
		Thread.sleep(3000);
		StudentHP.clickassessment();
		System.out.println("going to aricentdfdf");
	}

	@Then("^Teacher should click on Assign button$")
	public void teacher_should_click_on_Assign_button() throws Throwable {
		System.out.println("trupti is cooking");
		Thread.sleep(3000);
		StudentHP.selectassessment();
		System.out.println("trupti lost somewhere");
	}

	@Then("^select class from the dropdown$")
	public void select_class_from_the_dropdown() throws Throwable {

		StudentHP.selectclasss();
	}

	@Then("^I should select class from the dropdown$")
	public void i_should_select_class_from_the_dropdown() throws Throwable {
		System.out.println("chilld is crying");
		Thread.sleep(3000);
		StudentHP.selectdropdown2("Grade2");

	}

	// @Then("^I should select checkbox from the list of students$")
	// public void i_should_select_checkbox_from_the_list_of_students() throws
	// Throwable {
	// System.out.println("trupi is working");
	// Thread.sleep(3000);
	// //StudentHP.selectcheckbox();

	@Then("^I click on assign to all students$")
	public void i_click_on_assign_to_all_students() throws Throwable {
		System.out.println("trupti is workinghard");
		StudentHP.alllinks();
	}

	@Then("^I click on assignbutton$")
	public void i_click_on_assignbutton() throws Throwable {
		System.out.println("assigning the class");
		StudentHP.assignbutton();
	}

	@Then("^successfully pop-up will be displayed$")
	public void successfully_pop_up_will_be_displayed() throws Throwable {
		StudentHP.getsuccessfullymessageText();
	}

	@Then("^I close the button$")
	public void i_close_the_button() throws Throwable {
		StudentHP.closebutton();
	}

	@Then("^I click on privacy policy link$")
	public void i_click_on_privacy_policy_link() throws Throwable {
		StudentHP.privacypolicy();
	}

	@Then("^I should close the tab$")
	public void i_should_close_the_tab() throws Throwable {
		StudentHP.privacypolicyswitch();

	}
	// @Then("^the checkmark next to the dropdown will be replaced with a
	// star$")
	// public void
	// the_checkmark_next_to_the_dropdown_will_be_replaced_with_a_star() throws
	// Throwable {
	// StudentHP.Clickdeafult();

	/*---------------------------------------------------------------------------------------------------------------------*/
	/*
	 * @Then("^I should select class \"([^\"]*)\" from the dropdown$") public
	 * void i_should_select_class_from_the_dropdowns(String Grade) throws
	 * Throwable { StudentHP.ClickGrade(Grade); }
	 */

	@Then("^I should verify Number of assessments in the first page should be \"([^\"]*)\"$")
	public void i_should_verify_number_of_assessments_in_the_first_page_should_be_something(int AssessmentNumber)
			throws Throwable {
		assertTrue("MAX Number of assessment in one page is More or Less then 9",
				StudentHP.AssessmentOfNumber(AssessmentNumber));
	}

	@And("^I should see \"([^\"]*)\" button$")
	public void i_should_see_something_button(String BtnText) throws Throwable {
		assertTrue("Either Load more button is not visible or number of Assessments are less then 9",
				StudentHP.LoadMoreBtn(BtnText));
	}

	@Then("^I should click on Load more button and verify Number of assessments as multiple of \"([^\"]*)\" or less$")
	public void i_should_click_on_load_more_button_and_verify_number_of_assessments_as_multiple_of_something_or_less(
			int AssessmentNumber) throws Throwable {
		assertTrue("MAX Number of assessment in one page is More or Less then Multiples of ",
				StudentHP.NumberofAssessLoadMore(AssessmentNumber));
	}

	@Then("^I should verify Number of assessments as \"([^\"]*)\" in one row$")
	public void i_should_verify_number_of_assessments_as_something_in_one_row(int AssessNumRow) throws Throwable {
		assertTrue("Number of Assessments in a Row Less or more then expected ",
				StudentHP.NumberofAssessRow(AssessNumRow));
	}

	@Then("^I should validate that the title of the Assessment should be shown$")
	public void i_should_validate_that_the_title_of_the_Assessment_should_be_shown() throws Throwable {
		assertTrue("The title of the Assessment is not shown ", StudentHP.TitleofAssess());
	}

	@Then("^I should validate number of Questions in the Assessment should be shown$")
	public void i_should_validate_number_of_questions_in_the_assessment_should_be_shown() throws Throwable {
		assertTrue("Questions of the Assessment is not shown ", StudentHP.QuesofAssess());
	}

	@Then("^I should click on \"([^\"]*)\"$")
	public void i_should_click_on(String Attempts) throws Throwable {
		StudentHP.clickTopLft(Attempts);
	}

	@Then("^I should see the Progress bar$")
	public void i_should_see_the_progress_bar() throws Throwable {
		assertTrue("Progress bar of the Assessment is not shown ", StudentHP.ProgressBar());
	}

	@And("^I Verfiy that progress bar is showing 0% before the start of the Assessment$")
	public void i_verfiy_that_progress_bar_is_showing_0_before_the_start_of_the_assessment() throws Throwable {
		assertTrue("Progress bar is not showing 0% ", StudentHP.ProgressBarZeroPer());
	}

	@When("^I should click on the start button$")
	public void i_should_click_on_the_start_button() throws Throwable {
		StudentHP.ClickOnStrtBtn();
	}

	@Then("^I should see a popup with message \"([^\"]*)\"$")
	public void i_should_see_a_popup_with_message_something(String Message) throws Throwable {
		String expected = StudentHP.AssessPopupMess(Message);
		String actual = Message;
		assertTrue("Assessemnt Pop up is not shown ", expected.contains(actual));
	}

	@And("^I should Start the assessment$")
	public void i_should_click_on_the_start_button_ass_popup() throws Throwable {
		StudentHP.StartBtnPopup();
	}

	@When("^I Quit the Assessment$")
	public void i_quit_the_assessment() throws Throwable {
		StudentHP.QuitAssement();
	}

	@Then("^I should see that assessment bar should shown 50% completed$")
	public void i_should_see_that_assessment_bar_should_shown_50_completed() throws Throwable {
		StudentHP.QuitAssement();
	}

	@Then("^I should see the Progress bar of above Assessment showing 50% complete$")
	public void i_should_see_the_progress_bar_of_above_assessment_showing_50_complete() throws Throwable {
		StudentHP.ProgressFifty();
	}

	@Then("^Assignment modal will be displayed$")
	public void assignment_modal_will_be_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^I click on select class drop down the class dropdown is expanded$")
	public void i_click_on_select_class_drop_down_the_class_dropdown_is_expanded() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^If First assessment is assinged then unassign it$")
	public void if_first_assessment_is_assinged_then_unassign_it() throws Throwable {
		StudentHP.UnAssign();
	}

	@And("^I should Start the assessment for \"([^\"]*)\"$")
	public void i_should_start_the_assessment_for_something(String Assessment) throws Throwable {
		StudentHP.OpenAssessment(Assessment);
	}

	@Then("^I should complete the Assessment$")
	public void i_should_complete_the_assessment() throws Throwable {
		StudentHP.CompleteAssessment();
	}

	@When("^I click the Class Assessment List report$")
	public void i_click_the_Class_Assessment_List_report() throws Throwable {
		StudentHP.clickReportstButton();
		RepPg.clickStudentAssesList();
		RepPg.isStudentAssesmentListDisplayed();
	}

	@Then("^the title will show as \"([^\"]*)\"$")
	public void the_title_will_show_as(String arg1) throws Throwable {
		RepPg.isStudentAssesmentListPgDisplayed();
	}

	@Then("^I want to see the class the report belongs to$")
	public void i_want_to_see_the_class_the_report_belongs_to() throws Throwable {
		RepPg.isStudentAssesmentClassNameDisplayed();
	}

	@Then("^I want to see the number of students in the class to which the report belongs to$")
	public void i_want_to_see_the_number_of_students_in_the_class_to_which_the_report_belongs_to() throws Throwable {
		assertTrue("Assessemnt List  up is not shown ", RepPg.isStudentAssesmentListNofStudentsDisplayed());
	}

	@Then("^I shoud see all assesment taken in dropdown$")
	public void i_shoud_see_all_assesment_taken_in_dropdown() throws Throwable {
		assertTrue("Assessemnt drpdown up is not shown ", RepPg.AssesmentTakenDropdown());
	}

	@Then("^I should see table for each assesment taken$")
	public void i_should_see_table_for_each_assesment_taken() throws Throwable {
		assertTrue("Assessemnt table up is not shown ", RepPg.isAssesementScoreTableDisplayed());
	}

	@When("^I click on an assessment dropdown button$")
	public void i_click_on_an_assessment_dropdown_button() throws Throwable {
		RepPg.clickAssesmentDropdown();
	}

	@Then("^the report table for that assessment will pull up$")
	public void the_report_table_for_that_assessment_will_pull_up() throws Throwable {

	}

	@Then("^the assessment button I selected will be highlighted$")
	public void the_assessment_button_I_selected_will_be_highlighted() throws Throwable {

	}

	@Then("^when I click on another assessment button$")
	public void when_I_click_on_another_assessment_button() throws Throwable {
		RepPg.selectAssesement();
	}

	@Then("^the table will refresh with the report table for my newly selected assessment$")
	public void the_table_will_refresh_with_the_report_table_for_my_newly_selected_assessment() throws Throwable {
		RepPg.isSelectedDropdownDisplayed();
	}

	@Then("^a student has taken the same assessment more than once$")
	public void a_student_has_taken_the_same_assessment_more_than_once() throws Throwable {

	}

	@Then("^all completed attempts \\(assessment attempt has a score\\) will be shown in the table$")
	public void all_completed_attempts_assessment_attempt_has_a_score_will_be_shown_in_the_table() throws Throwable {
		assertTrue("Assessemnt multople is not  shown ", RepPg.isMultipleAssesmentTakenDisplayed());
	}

	@When("^I click on the next to the student name in the Class Assessment List table$")
	public void i_click_on_the_next_to_the_student_name_in_the_Class_Assessment_List_table() throws Throwable {
		RepPg.clickStudentLink();
	}

	@Then("^the Student Assessment List for that particular student will open$")
	public void the_Student_Assessment_List_for_that_particular_student_will_open() throws Throwable {
		assertTrue("Student Page is not displayed ", RepPg.isStudentPAgeDisplayed());
	}

	@When("^I click on the > next to the student score/percentage$")
	public void i_click_on_the_next_to_the_student_score_percentage() throws Throwable {
		RepPg.clickScoreLink();
	}

	@Then("^the Student Single Assessment Result for that particular assessment will open$")
	public void the_Student_Single_Assessment_Result_for_that_particular_assessment_will_open() throws Throwable {
		assertTrue("Student Page is not displayed ", RepPg.isScorePAgeDisplayed());
	}

	@Then("^I view an assessment card$")
	public void i_view_an_assessment_card() throws Throwable {

	}

	@Then("^I want to see a short description of the assessment$")
	public void i_want_to_see_a_short_description_of_the_assessment() throws Throwable {
		StudentHP.isDescriptionDisplayed();
	}

	@Then("^I want to see the number of questions in the assessment$")
	public void i_want_to_see_the_number_of_questions_in_the_assessment() throws Throwable {
		assertTrue("Pagination is not displayed ", StudentHP.isNoOfquestionsDisplayed());
	}
	@Then("^the Score column will show me the breakdown of my test results:percentage I answered incorrectly$")
	public void the_Score_column_will_show_me_the_breakdown_of_my_test_results_percentage_I_answered_incorrectly() throws Throwable {
		assertTrue("Tooltip  is not displayed ", RepPg.IsScoreToolTipisDisplayed());
	}
	@When("^I click any part of the assessment home tab$")
	public void i_click_any_part_of_the_assessment_home_tab() throws Throwable {
		StudentHP.clickOnAnyOtherPlace();
	}

	@Then("^a pop-up will show asking me if I am sure I want to exit$")
	public void a_pop_up_will_show_asking_me_if_I_am_sure_I_want_to_exit() throws Throwable {
		assertTrue("Pop  is not displayed ",StudentHP.isPopUpDisplayed());
	}

	@When("^I click on \"([^\"]*)\" the pop-up will close$")
	public void i_click_on_the_pop_up_will_close(String arg1) throws Throwable {
		StudentHP.ClosePopUp();
	}

	@When("^I can continue taking my assessment$")
	public void i_can_continue_taking_my_assessment() throws Throwable {
		StudentHP.IsAssingmentContinued();
	}
}
