#Author: Rachna Pattnaik Funtctionality: Student Header -ASMNT-94
#Date: 20 Nov 2017    Pages:
@assessmentSmoke @ASMNT-94 @regression @regression12mar @regression12marlocal
Feature: Assessment Card

  Scenario Outline: Assessment Card assignment status - assign
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    Then assessment home page should be displayed
    And I should Start the assessment for "<Assesment>"
    And I view an assessment card
    Then I want to see a short description of the assessment
    Then I want to see the number of questions in the assessment

    Examples: 
      | Assesment          |
      | Topic 12.1: Chance |

  Scenario Outline: Assessment Card assignment status - assign
    Given the url of assessment login URL
    When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    Then I navigated to Assessment Page
    Then If First assessment is assinged then unassign it
    Then Teacher should click on Assign button
    Then select class from the dropdown
    Then I should select class from the dropdown
    Then I click on assign to all students
    Then I click on assignbutton
    Then successfully pop-up will be displayed
    Then I close the button

    Examples: 
      | username | password |
      | Teacher  | welcome1 |

  Scenario Outline: Assessment Card assignment status - assigned
     Given the url of assessment login URL
    When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    Then I navigated to Assessment Page
    Then If First assessment is assinged then unassign it
    Then Teacher should click on Assign button
    Then select class from the dropdown
    Then I should select class from the dropdown
    Then I click on assign to all students
    Then I click on assignbutton
    Then successfully pop-up will be displayed
    Examples: 
      | username | password |
      | Teacher  | welcome1 |
