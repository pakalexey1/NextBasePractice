Feature: Log in functionality
  User Story: As a user, I should be able to login to the app

  @login
  Scenario Outline: As a help desk user I should be able to login with correct credentials
    Given user if on the Crm login page and user enters "<username>" and "<password>"
    Then user should see CRM page
    Examples:
      | username    | password |
      | help_desk29 | password |
      | help_desk30 | password |


