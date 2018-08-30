#Author: Trupti Jadhav Funtctionality: Teacher Grade dropdown -ASMNT-124
#Date: 3 Dec 2017
@assessmentSmoke @regression12marlocal
Feature: Class Grade dropdown
  As a Teacher 
  I should be able to select Grade drop down
  so that I can see assessments for that grade

  @Teacher
  Scenario Outline: alphabetization
    Given the url of assessment login URL
    When provid valid Csrep credentials "<username>" and "<password>"
    When I click on the class selection dropdown on the Assessments page
    Then my list of classes will be sorted by alphanumerical order

    Examples: 
      | username | password |
      | janedoe  | welcome1 |

