@Assessments @regression12marlocal
Feature: Assessment Common UI
  As a Teacher 
  I should be able to login 
  so that I can see all tabs in home page

  @TruptiTeacher1
  Scenario Outline: Title of your scenario
    Given the url of assessment login URL
    When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    When the class dropdown is expanded
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

  #ASMNT-83
  Scenario Outline: Number of Assessment in a page
    Given the url of assessment login URL
   When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    Then I should select class "Year 3" from the dropdown
    Then I should verify Number of assessments in the first page should be "9"
    And I should see "Load More" button
    Then I should click on Load more button and verify Number of assessments as multiple of "9" or less

    Examples: 
      | username | password |

  #ASMNT-83
  Scenario Outline: Number of Assessment in a row
    Given the url of assessment login URL
    When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    Then I should select class "Year 3" from the dropdown
    Then I should verify Number of assessments as "3" in one row

    Examples: 
      | username | password |
      | Teacher  | welcome1 |
