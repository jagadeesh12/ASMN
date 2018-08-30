#Author: Jagadeesh Functionality: Help link -ASMNT-14
#Date: 20 Feb 2018
@regression   @regression12marlocal
Feature: Help Link
 
Scenario: help "?" icon display and interaction for Student 
	Given the url of assessment login URL 
	When provide valid Student credentials 
	And clicked on assessement icon in myzone 
	Then assessment home page should be displayed 
	#Then I want the "?" icon for the Help Center to show up throughout the program 
#	When I click on the "?" icon in the header 
	#Then a new tab will open with the Help Center page
	
	
Scenario: help "?" icon display and interaction for Teacher 
	Given the url of assessment login URL 
	When provide valid Teacher credentials
	And clicked on assessement icon in myzone 
	Then I navigated to Assessment Page 
	#Then I want the "?" icon for the Help Center to show up throughout the program 
	#When I click on the "?" icon in the header 
	
	
Scenario: help "?" icon display and interaction for CSRep 
	Given the url of assessment login URL 
	When provide valid CSREP credentials 
	And search Org with OrgID "HKFJ" 
	Then clicks on Organization name "AssessmentAutomation" 
	And clicks on Scholastic Learning Zone 
	And clicked on assessement icon in myzone 
   # Then I want the "?" icon for the Help Center to show up throughout the program 
	#When I click on the "?" icon in the header 
