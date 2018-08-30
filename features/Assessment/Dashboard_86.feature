#Author: Rachna Pattnaik Funtctionality: Student Header -ASMNT-94
#Date: 20 Nov 2017    Pages:
@assessmentSmoke @ASMNT-94 @regression  @regression12mar @regression12marlocal
Feature: Dashboard

  Scenario: assessments taken
    Given the url of assessment login URL
   	When provide valid Student credentials
   	And clicked on assessement icon in myzone
    When I land on my My Results page
    Then I want to see the total number of assessments I have taken
    Then I want to see the total number of assessments I have taken more than once
    Then I want to see my average score from all assessments I have taken

  
