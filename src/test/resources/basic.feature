Feature: Automated test
	Using SuiteCRM online demo page, thank you SuiteCRM!

  Background: 
    Given I use the test user "will" with password "will" to login
  
  Scenario: Editing on the main page
    Given I create a contact named "Jim Beam 2"
    Then the contact "Jim Beam 2" is there
    And I will delete the current contact
    Then the contact "Jim Beam 2" is not there anymore
	Then I can logout, mission accomplished