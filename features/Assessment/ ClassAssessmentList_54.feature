@assessmentSmoke @ASMNT-94 @regression12mar @regression12marlocal
Feature: Class Assessment List

  @regression12mar11 
  Scenario: Assessment Card assignment status - assign
    Given the url of assessment login URL
    When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    When I click the Class Assessment List report
    Then I shoud see all assesment taken in dropdown
    And I should see table for each assesment taken

  @regression12mar
  Scenario: assessment buttons interaction
    Given the url of assessment login URL
    When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    When I click the Class Assessment List report
    When I click on an assessment dropdown button
    Then the report table for that assessment will pull up
    And the assessment button I selected will be highlighted
    And when I click on another assessment button
    Then the table will refresh with the report table for my newly selected assessment
    And a student has taken the same assessment more than once

  @regression12mar 
  Scenario: student name click-through
    Given the url of assessment login URL
    When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    When I click the Class Assessment List report
     When I click on an assessment dropdown button
    Then the report table for that assessment will pull up
    And the assessment button I selected will be highlighted
    And when I click on another assessment button
    When I click on the next to the student name in the Class Assessment List table
    Then the Student Assessment List for that particular student will open

  @regression12mar 
  Scenario: assessment name click-through
    Given the url of assessment login URL
    When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    When I click the Class Assessment List report
     When I click on an assessment dropdown button
    Then the report table for that assessment will pull up
    And the assessment button I selected will be highlighted
    And when I click on another assessment button
    When I click on the > next to the student score/percentage
    Then the Student Single Assessment Result for that particular assessment will open

  Scenario Outline: case5 - date column
    Given the url of assessment login URL
    When provide valid Teacher credentials
    And clicked on assessement icon in myzone
    When I view the table on the Student Assessment List
    Then the dates under the Date column will show in the following format: Day DD MMM YYYY
