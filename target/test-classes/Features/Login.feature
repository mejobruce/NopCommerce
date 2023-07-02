Feature: Validate login page
@moov
  Scenario: Successful login with valid credentials
    Given I am on the nopCommerce demo store login page
    When I enter my valid "username" and "password"
      | Mejo  |
      | Mejo@06101991 |
  And I click on the login button
  Then I should be redirected to the user account dashboard
    And I should see a welcome message with my username


