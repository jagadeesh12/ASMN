#Author: Rachna Pattnaik Funtctionality: Student Header -ASMNT-94
#Date: 20 Nov 2017    Pages:
@assessmentSmoke @ASMNT-94 @regression @regression12mar @regression12marlocal
Feature: History

  Scenario: List 1 - case: column headers
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    When I land on my My Results page
    Then I want the columns for my assessment history list to be:Assessment Score Date

  Scenario Outline: assessment column interaction
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    When I land on my My Results page
    When I click on the next to the student name in the Class Assessment List table
    Then the Student Assessment List for that particular student will open

    Examples: 
      | username | password |
      | Csrep    | welcome1 |

  @inprogress11
  Scenario Outline: score column
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    When I land on my My Results page
    Then the Score column will show me the breakdown of my test results:percentage I answered incorrectly

    Examples: 
      | username | password |
      | Csrep    | welcome1 |

  
  Scenario Outline: score column interaction
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    When I land on my My Results page
    When I click on the > next to the student score/percentage
    Then the Student Single Assessment Result for that particular assessment will open

    Examples: 
      | username | password |
      | Csrep    | welcome1 |
