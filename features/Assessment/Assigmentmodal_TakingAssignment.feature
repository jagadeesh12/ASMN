@tag @regression  @regression12mar @regression12marlocal
Feature: Assingment modal Take assingment

  @Assign @regression @regression12mar
  Scenario Outline: Assigment modal
    Given the url of assessment login URL
    When provide valid Student credentials
    When I click on the assessment logo in the assessment program
    Then I should select class "Year 3" from the dropdown
    Then I should click on assign button
    
  @ASMNT-81 @vikramj @regression1 @test123456
  Scenario Outline: Take Assesment
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    And I should Start the assessment for "<Assesment>"
    Then I should complete the Assessment

    Examples: 
      | Assesment                      |
      | Topic 5.3: Solid Shape Pattern |
