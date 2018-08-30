
@assessmentSmoke @ASMNT-94 @regression @regression12marlocal @regression12mar
Feature: ReportList

  Scenario Outline: assessments taken
    Given the url of assessment login URL
    When provide valid Teacher credentials 
	  And clicked on assessement icon in myzone 
    When I click on Reports in the assessment program 
	  Then I navigated to Reports Page 
    #Then three report cards will be displayed at default at most
    #And I want to see the school calendar year for which the reports are applicable to
    Examples: 
      | username | password |
      | Teacher  | welcome1 |

  
