Feature: Multi-Browser Testing
  Scenario Outline: Launch browser, open application, and close browser
    Given I launch the "<browser>" browser
    When User opens URL "<URL>"
    And User enters Email as "<email>" and Password as "<pass>"
    And Clicks on SignIn
    Then Page Title should be "<title>"
    When User Clicks on logout button
    And closes the browser

    Examples:
      | browser  | URL | email | pass | title |
      | chrome   | https://sauce-demo.myshopify.com/account/login | abhistf@gmail.com | shpify98 | Account Details and Order History |

