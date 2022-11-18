Feature: Login feature

  Scenario: Verify valid user able to login to application
    Given User is on login page
    When User enters login credentials
    Then User login to application
