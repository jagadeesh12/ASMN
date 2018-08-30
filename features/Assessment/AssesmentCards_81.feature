#Author: Rachna Pattnaik Funtctionality: Student Header -ASMNT-94
#Date: 20 Nov 2017    Pages:
@assessmentSmoke @ASMNT-94 @regression @regression12mar @regression12marlocal
Feature: Assessment Student header Teacher
  As a Student
  I should be able to login 
  so that I can see all tabs in home page

  @ASMNT-94 @regression @regression12mar
  Scenario Outline: Student Login to Assessments application
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    Then assessment home page should be displayed
    Then verify First name and last name of the logged in should be displayed

    Examples: 
      | username | password |
      | bose_dk  | welcome1 |

  @ASMNT-83 @regression @regression12mar 
  Scenario: Student Login to Assessments application
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    Then assessment home page should be displayed
    And verify First name and last name of the logged in should be displayed
    Then I should verify Number of assessments in the first page should be "9"
    Then I should click on Load more button and verify Number of assessments as multiple of "9" or less

  @regression @regression12mar 
  Scenario Outline: Number of Assessment in a row
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    Then assessment home page should be displayed
    And verify First name and last name of the logged in should be displayed
    Then I should verify Number of assessments as "3" in one row

    Examples: 
      | username | password |
      | student2 | welcome1 |

  @ASMNT-81 @vikramjyani @regression12mar  
  Scenario Outline: Assessment bar is show 50% After start of the Assessment and before completion of the assessment
    Given the url of assessment login URL
    When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    When I click on the assessment logo in the assessment program
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

  @ASMNT-81 @regression12mar
  Scenario Outline: Number of Assessment in a row
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    Then I should validate that the title of the Assessment should be shown
    Then I should validate number of Questions in the Assessment should be shown

    Examples: 
      | username | password |
      | student2 | welcome1 |

  @ASMNT-81 @regression12mar
  Scenario Outline: Number of Assessment in a row
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    Then I should see the Progress bar

    Examples: 
      | username | password |
      | student2 | welcome1 |

  @ASMNT-81 @regression12mar
  Scenario: Assessment bar is showing 0% before the start of the Assessment
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    Then I should click on "Not Attempted"
    Then I should see the Progress bar
    And I Verfiy that progress bar is showing 0% before the start of the Assessment

  @ASMNT-81 @assessment @regression12mar 
  Scenario Outline: Assessment bar is show 50% After start of the Assessment and before completion of the assessment
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    Then I should click on "Not Attempted"
    Then I should see the Progress bar
    And I Verfiy that progress bar is showing 0% before the start of the Assessment
    When I should click on the start button
    Then I should see a popup with message "when you are ready to begin the activity."
    And I should Start the assessment
    When I Quit the Assessment
    #Then I should see the Progress bar of above Assessment showing 50% complete

    Examples: 
      | username | password |
      | student2 | welcome1 |
