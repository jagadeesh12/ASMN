@assessmentSmoke @ASMNT-94 @regression @regression12mar @regression12marlocal
Feature: Student Assessment List

  
  Scenario: case: report title Class Students
    Given the url of assessment login URL
    When provide valid Teacher credentials
    And clicked on assessement icon in myzone 
    When I click the Class Assessment List report
    Then the title will show as "Student Assessment List"
    And I want to see the class the report belongs to
    And I want to see the number of students in the class to which the report belongs to
