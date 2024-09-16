Feature: Home page

  Background: User login into Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

    Scenario Outline: Verify that all products are displayed
      When The home page should be displayed
      Then The product "<products>" should be displayed in the home page
      Examples:
        | products                |
        | Sauce Labs Backpack     |
        | Sauce Labs Bike Light   |
        | Sauce Labs Bolt T-Shirt |
        | Sauce Labs Onesie       |

    Scenario: Verify filter high to low price works
      When I select high to low on the filter
      Then The products should be in order from high to low

    Scenario: Verify filter Z to A price works
      When I select Z to A on the filter
      Then The products should be in order from Z to A
  @run
  Scenario Outline: Verify that all products can be added to the cart
    When The home page should be displayed
    And I add to the cart the product "<products>"
    Then The cart icon should display "1"
    And I remove the product "<products>" from the cart
    Examples:
      | products                |
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light    |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Onesie       |
