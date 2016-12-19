Feature: Automated test
	Using SuiteCRM online demo page, thank you SuiteCRM!

  Background: 
    Given I use the test user "will" with password "will" to login
  
  Scenario: Editing on the main page
    Given I try to create a contact named "Jim Beam"
    Then I will delete it
	Then I can logout, mission accomplished