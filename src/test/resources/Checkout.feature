Feature: Checkout feature

  Background: User should be able to do a checkout
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

    Scenario: Checkout a purchase
      Given The home page should be displayed
      When I add to the cart the product "Sauce Labs Backpack"
      And I click on the cart button
      And I click on the checkout button
      And I fill the checkout information with
        | Mauricio | Viscarra | 00000 |
      And I click on continue button
      And I click on finish button
      Then A message that says "Thank you for your order!" should be displayed

  Scenario: Checkout with empty fields
    Given The home page should be displayed
    When I add to the cart the product "Sauce Labs Backpack"
    And I click on the cart button
    And I click on the checkout button
    And I click on continue button
    Then An error message that says "Error: First Name is required" should be displayed

  Scenario: Cancel a purchase
    Given The home page should be displayed
    When I add to the cart the product "Sauce Labs Onesie"
    And I click on the cart button
    And I click on the checkout button
    And I fill the checkout information with
      | Mauricio | Viscarra | 00000 |
    And I click on continue button
    And I click on cancel button
    Then The home page should be displayed


