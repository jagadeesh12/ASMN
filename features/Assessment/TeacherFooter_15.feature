@Assessments @regression12mar @regression12marlocal
Feature:Verify the footer title 

@Footer
Scenario Outline: Title of your scenario
 Given the url of assessment login URL 
When provide valid Student credentials
 And clicked on assessement icon in myzone 
 And when I click on the Privacy Policy
 #Then a new tab will open with the Privacy Policy document:

Examples:
 |username|password|
 |peterpan|welcome1| 
  

