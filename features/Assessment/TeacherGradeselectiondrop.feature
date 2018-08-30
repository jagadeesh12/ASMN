#Author: Trupti Jadhav Funtctionality: Teacher Grade dropdown -ASMNT-124
#Date: 3 Dec 2017
@assessmentSmoke @regression12marlocal
Feature: Assessment Grade dropdown
  As a Teacher 
  I should be able to select Grade drop down
  so that I can see assessments for that grade

  @Teacher
  Scenario Outline: Assessment Grade dropdown ASMNT -124 ,Test case-C9337
    Given the url of assessment login URL
   When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    And verify First name and last name of the logged in should be displayed
    Then the default Grade shown is the first "<Grades>" assigned to me in my dropdown list
    Then the tooltip will say: "Click the checkmark to save this grade for your default view."

    Examples: 
      | username | password |  | Grades  |
      | janedoe  | welcome1 |  | Grade 1 |

  @Teacher
  Scenario Outline: Assessment Grade
    Given the url of assessment login URL
   When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    And verify First name and last name of the logged in should be displayed
    When the class dropdown is expanded
    Then I want my classes to be shown in alphanumeric order (e.g. Grade 1 > Grade 1C > Grade 11 > Grade 11B > Grade 11C)

    Examples: 
      | username | password |
      | janedoe  | welcome1 |

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

  @Teacher13
  Scenario Outline: Assessment Grade dropdown :tooltip with grade default selected
    Given the url of assessment login URL
   When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    And verify First name and last name of the logged in should be displayed
      | username | password |  | Grades  |
      | janedoe  | welcome1 |  | Grade 1 |
