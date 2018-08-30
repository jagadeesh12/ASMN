
@regression  @regression12mar @regression12marlocal
Feature: Teacher Header

 @regression12mar
Scenario: Header tabs for Teacher - Home , Assessments and Reports
	Given the url of assessment login URL 
	When provide valid Teacher credentials 
	And clicked on assessement icon in myzone 
	When I click on the assessment logo in the assessment program 
	Then I navigated to Assessment Page 
	When I click on Reports in the assessment program 
	Then I navigated to Reports Page 
	And I click on logo 
	Then I navigated to Home page in the assessment program 
	
@regression12mar	
Scenario: Header tabs for CS Representative - Home , Assessments and Reports
    Given the url of assessment login URL 
	When provide valid CSREP credentials
	And search Org with OrgID "HKFJ"
	Then clicks on Organization name "AssessmentAutomation"
	And clicks on Scholastic Learning Zone
	And clicked on assessement icon in myzone 
	When I click on the assessment logo in the assessment program 
	Then I navigated to Assessment Page 
	When I click on Reports in the assessment program 
	Then I navigated to Reports Page 
	And I click on logo 
	Then I navigated to Home page in the assessment program 
	