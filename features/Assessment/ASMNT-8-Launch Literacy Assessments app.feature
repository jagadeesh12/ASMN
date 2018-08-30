#Author: Jagadeesh Functionality: Launch Literacy Assessments app -ASMNT-8 
#Date: 20 Feb 2018
@regression  @regression12mar @regression12marlocal
Feature: Launch Literacy Assessments app -ASMNT-8 
@regression12mar 
Scenario: Teacher assigns individual assessment to the students 
	Given the url of assessment login URL 
	When provide valid Teacher credentials 
	And clicked on assessement icon in myzone 
	Then I navigated to Assessment Page 
	Then I should select class "1A" from the dropdown 
	Then If First assessment is assinged then unassign it 
	Then Teacher should click on Assign button 
	Then select class from the dropdown 
	Then I should select class from the dropdown 
	Then I click on assign to all students 
	Then I click on assignbutton 
	Then successfully pop-up will be displayed 
	Then I close the button 

@regression12mar  
Scenario: Assessments application launch by Student
	Given the url of assessment login URL 
	When provide valid Student credentials 
	And clicked on assessement icon in myzone 
	Then assessment home page should be displayed 
	And I click on Assessment name
	And I click on Start button  
	#Then I should be able to submit the assessment
	