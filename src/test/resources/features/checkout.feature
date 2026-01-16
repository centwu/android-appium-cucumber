@checkout
Feature: Checkout
  Scenario: Successful checkout with single product
    Given user is on products page
    And user has the following items in the cart:
      | product                  | quantity | price |
      | Sauce Lab Back Packs     | 1        | 29.99 |
    And user navigates to cart page
    And user proceeds to checkout

    When user completes checkout with valid details
    And user reviews order details
    Then order summary should display correct items and total price

    When user places the order
    Then checkout success message should be displayed

  Scenario: Successful checkout with multiple product
    Given user is on products page
    And user has the following items in the cart:
      | product                  | quantity | price |
      | Sauce Lab Back Packs     | 1        | 29.99 |
      | Sauce Lab Fleece T-Shirt | 1        | 49.99 |
    And user navigates to cart page
    And user proceeds to checkout

    When user completes checkout with valid details
    And user reviews order details
    Then order summary should display correct items and total price

    When user places the order
    Then checkout success message should be displayed
