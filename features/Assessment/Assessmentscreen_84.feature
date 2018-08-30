@tag  @regression12mar @regression12marlocal
Feature: Assesment screen

  @assessmentscreen2 @regression12mar112
  Scenario Outline: Case 5: Timer
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    And I should Start the assessment for "<Assesment>"
    Then I should see timer dispalyed on screen and click on pause button
    And Activity pop-up should be dispalyed
    And I click on continue button

    Examples: 
      | Assesment   |                                                   
      |  Topic 3.3: Addition and Subtra | 

  @assessmentscreen1
  Scenario Outline: Case 6 :Control Panel
    Given the url of assessment login URL
    When provide valid Student credentials
    And clicked on assessement icon in myzone
    And I should Start the assessment for "<Assesment>"
    When I mouse over on Quit icon Quit text should be displayed
    When I mouse over on Full screen text should be displayed
    When I mouse over on accessiblity icon accessiblity text should be displayed
    When I mouse over on calculator icon calculator text should be dispalyed
    When I mouse over on flag item iocn flag item text should be dispalyed

     Examples: 
      | Assesment   |                                                   
      |  Topic 3.3: Addition and Subtra | 


  @assessmentscreen2 
  Scenario Outline: Case 5: Exit Assesment
    Given the url of assessment login URL
     When provide valid Student credentials
    And clicked on assessement icon in myzone
    When I should click on the start button
    When I click any part of the assessment home tab
    Then a pop-up will show asking me if I am sure I want to exit
    When I click on "No," the pop-up will close
    And I can continue taking my assessment

    Examples: 
      | username   | password |  | message                                                     |
      | franMartin | welcome1 |  | Please click Start when you are ready to begin the activity |

 