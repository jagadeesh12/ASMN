#Author: Jagadeesh Functionality: Header-Student -ASMNT-94
#Date: 3 Dec 2017
@regression  @regression12mar @regression12marlocal 
Feature: As a student/CS rep, I want to navigate to different sections of the program wherever I am so that I can move through the program easily. 
Scenario: Tab display for Student - Assessment and Results tab
	Given the url of assessment login URL 
	When provide valid Student credentials 
	And clicked on assessement icon in myzone 
	Then student navigated to Myassessments page
	And I click on Results Page 
	Then student navigated to My Result page
	And student click on logo 
	Then I navigated to Student Home page 