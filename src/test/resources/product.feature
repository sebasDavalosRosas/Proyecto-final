Feature: Product page

  Background: User login into Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Given The home page should be displayed

  Scenario Outline: Verify add product to cart from the product page
    And i click on <productName>
    Then the product page of <productName> should be displayed
    When I click on add product button
    Then The cart icon should display "1"
    And I click on remove product button
    Examples:
      | productName               |
      | "Sauce Labs Bike Light"   |
      | "Sauce Labs Bolt T-Shirt" |
      | "Sauce Labs Onesie"       |
      | "Sauce Labs Backpack"     |

    Scenario Outline: Verify Back to products button
      And i click on <productName>
      Then the product page of <productName> should be displayed
      And I return to home page
      Given The home page should be displayed
      Examples:
        | productName               |
        | "Sauce Labs Bike Light"   |
        | "Sauce Labs Bolt T-Shirt" |
        | "Sauce Labs Onesie"       |
        | "Sauce Labs Backpack"     |



