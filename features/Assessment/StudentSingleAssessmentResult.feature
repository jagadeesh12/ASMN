#Author: Trupti Jadhav Funtctionality: Teacher Grade dropdown -ASMNT-124
#Date: 3 Dec 2017
@assessmentSmoke @regression12marlocal
Feature: Student Single Assessment Result
  As a Teacher 
  I should be able to select Grade drop down
  so that I can see assessments for that grade

  @Teacher
  Scenario Outline: table
    Given the url of assessment login URL
     When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    Then view the Summary Report on the Student Single Assessment Report
    Then I will see a breakdown of how the student performed on the assessment with the following column rows

  @Teacher12
  Scenario Outline: Assessment Grade dropdown ASMNT -124 ,Test case-C9337
    Given the url of assessment login URL
    When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    And verify First name and last name of the logged in should be displayed
    When I select a class from the dropdown
    And I click on the checkmark next to the grade dropdown
    Then the grade I selected will be set as my default grade
    And the checkmark next to the dropdown will be replaced with a star

    Examples: 
      | username | password |
      | janedoe  | welcome1 |

  @Teacher13
  Scenario Outline: Assessment Grade dropdown :tooltip with grade default selected
    Given the url of assessment login URL
   When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    And verify First name and last name of the logged in should be displayed
    And I have a grade default selected
    When I hover over the "i" tooltip icon next to the grade selection dropdown
    Then the tooltip will say: "[default grade] is the default view."

    Examples: 
      | username | password |
      | janedoe  | welcome1 |

  
