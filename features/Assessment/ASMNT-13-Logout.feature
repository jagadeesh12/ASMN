#Author: Jagadeesh Functionality: Logout -ASMNT-13 @regression12marlocal
#Date: 20 Feb 2018
@regression  @regression12mar
Feature: Log out 
Scenario: Teacher Logout 
	Given the url of assessment login URL 
	When provide valid Teacher credentials 
	And clicked on assessement icon in myzone 
	Then I navigated to Assessment Page 
	Then I should be able to logout from assessment window
	
Scenario: Student Logout
	Given the url of assessment login URL 
	When provide valid Student credentials 
	And clicked on assessement icon in myzone 
	Then assessment home page should be displayed 
	Then I should be able to logout from assessment window
	

Scenario: CS Rep Logout 
	Given the url of assessment login URL 
	When provide valid CSREP credentials 
	And search Org with OrgID "HKFJ" 
	Then clicks on Organization name "AssessmentAutomation" 
	And clicks on Scholastic Learning Zone 
	And clicked on assessement icon in myzone 
	When I click on the assessment logo in the assessment program 
	Then I navigated to Assessment Page 
	Then I should be able to logout from assessment window