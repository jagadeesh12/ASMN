@regression @regression12mar @regression12marlocal
Feature: Clickable logo

  @regression12mar
  Scenario: Clickable logo - teacher
    Given the url of assessment login URL
    When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    When I click on the assessment logo in the assessment program
    Then I navigated to Assessment Page
    And I click on logo
    Then I navigated to Home page in the assessment program
    When I click on Reports in the assessment program
    Then I navigated to Reports Page
    And I click on logo
    Then I navigated to Home page in the assessment program

  @regression12mar
  Scenario: Clickable logo - student
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    And I click on Results Page
    And student click on logo
    Then I navigated to Student Home page

  @regression12mar
  Scenario: Clickable logo - student mid-test
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    Then assessment home page should be displayed
    And I click on Assessment name
    And I click on Start button
    And student click on logo
   # Then popup should appear
    #And click on NO button in the popup
    #Then user should be on assessment page
    #And student click on logo
    #Then popup should appear
    #And click on Yes button in the popup
    #Then I navigated to Student Home page

  @regression12mar
  Scenario Outline: logo
    Given the url of assessment login URL
    When provid valid student credentials "<username>" and "<password>"
    Then a student or teacher is in PR1ME Mathematics Digital Assessments
    Then the PR1ME Mathematics Digital Assessments logo will displayed
