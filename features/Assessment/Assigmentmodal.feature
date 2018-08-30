#Author: Trupti Jadhav Funtctionality: Help link -ASMNT-28
#Date: 3 Dec 2017
@tag  
Feature: As a teacher, I want to assign an individual
  assessment to a student or class so that they can take it.

  @Assign
  Scenario Outline: Assigment modal
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    When I click on the assessment logo in the assessment program
     Then I should select class "Year 3" from the dropdown
    Then I select first assessment should click on assign button
    Then Assignment modal will be displayed
    When I click on select class drop down the class dropdown is expanded
    Then I select a "French" from the dropdown

    Examples: 
      | username | password |
      | janedoe  | welcome1 |
