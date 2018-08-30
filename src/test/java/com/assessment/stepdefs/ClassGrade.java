package com.assessment.stepdefs;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.assessment.pageobjects.BasePage;
import com.assessment.pageobjects.ClassGradeDropdown;
import com.assessment.pageobjects.SlzHomePg;
import com.assessment.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ClassGrade {
	
	private static final String String = null;
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	TestBase testBase = TestBaseProvider.getTestBase();
	BasePage base = new BasePage(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	ClassGradeDropdown TeacherHP = PageFactory.initElements(this.driver,
			ClassGradeDropdown.class);
		
	
	
	@Then("^the default Grade shown is the first \"([^\"]*)\" assigned to me in my dropdown list$")
	public void the_default_Grade_shown_is_the_first_assigned_to_me_in_my_dropdown_list(String Grades) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 TeacherHP.IsGradedropdownClicked();
	 TeacherHP.IsGradedisplayed("Grade 1");
     assertTrue("Grade 1 is not selected ",TeacherHP.IsGradedropdownClicked());
		
		
	}	  
		
	
	@Then("^clicked on logout linkst$")
	public void clicked_on_logout_linkst() throws Throwable {
	
	    TeacherHP.clickLogoutButton();
	    assertTrue("click on the logout ",TeacherHP.clickLogoutButton());
	    
	    
	}
	
	 @When("^the class dropdown is expanded$")
	    public void the_class_dropdown_is_expanded() throws Throwable {
		 TeacherHP.IsGradedropdownClicked();
	 }
	       
	    
	 
		@When("^I want my classes to be shown in alphanumeric order \\(e\\.g\\. Grade (\\d+) > Grade (\\d+)C > Grade (\\d+) > Grade (\\d+)B > Grade (\\d+)C\\)$")
		public void i_want_my_classes_to_be_shown_in_alphanumeric_order_e_g_Grade_Grade_C_Grade_Grade_B_Grade_C(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
			 TeacherHP.IsGradedropdownClicked();
			Thread.sleep(3000);
			TeacherHP.selectdropdown9();
			
		}

		
		@When("^I select a grade and select the checkmark next to the grade dropdown$")
		public void i_select_a_grade_and_select_the_checkmark_next_to_the_grade_dropdown() throws Throwable {
			//TeacherHP.dropdown();
			//assertTrue("Checkmark is not selected",TeacherHP.IsdeafultcheckmarkClicked());
		}
		
		
		@Then("^the grade I selected will be set as my default grade$")
		public void the_grade_I_selected_will_be_set_as_my_default_grade() throws Throwable {
		System.out.println(TeacherHP.getdefaultText());
			
		}
		//@Then("^the default will persist in all my sessions going forward \\(e\\.g\\. set Grade (\\d+)B as default, next time I enter the program, Grade (\\d+)B is still default\\)$")
		//public void the_default_will_persist_in_all_my_sessions_going_forward_e_g_set_Grade_B_as_default_next_time_I_enter_the_program_Grade_B_is_still_default(int arg1, int arg2) throws Throwable {
			// TeacherHP.clickLogoutButton();
		    // assertTrue("Logout link is not displayed",TeacherHP.clickLogoutButton());
		
		@Then("^the checkmark next to the dropdown will be replaced with a star$")
		public void the_checkmark_next_to_the_dropdown_will_be_replaced_with_a_star() throws Throwable {
			TeacherHP.Isstariconpresent();
			
			
		}
		
		@When("^I hover over the \"([^\"]*)\" tooltip icon next to the grade selection dropdown$")
		public void i_hover_over_the_tooltip_icon_next_to_the_grade_selection_dropdown(String arg1) throws Throwable {
		    TeacherHP.defaultttooltip();
		}
		
		@Then("^the tooltip will say: \"([^\"]*)\"$")
		public void the_tooltip_will_say(String arg1) throws Throwable {
		    TeacherHP.Defaulttextispresent();
		}

		@When("^I have a grade default selected$")
		public void i_have_a_grade_default_selected() throws Throwable {
		    
		    
		}
}