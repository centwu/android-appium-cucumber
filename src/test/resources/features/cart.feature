Feature: Cart

  Background:
    Given user is on products page

  Scenario Outline: Add item(s) to cart
    When user navigates to "<item>" detail page
    And user selects color "<color>"
    And user sets quantity to <quantity>
    And user adds the item to the cart
    Then the cart count should be <count>
    And the cart should contain "<item>" with quantity <quantity>
    #    MARK: Not able to verify cart items due to Cart UI does not expose color name

    Examples:
      | item                 | color | quantity | count |
      | Sauce Lab Back Packs | Red   | 1        | 1     |
      | Sauce Lab Back Packs | Black | 2        | 2     |

  Scenario Outline: Add multiple item variants to cart
    When user navigates to "<item>" detail page
    And user selects color "<color_1>"
    And user sets quantity to <first_qty>
    And user adds the item to the cart
    And user selects color "<color_2>"
    And user sets quantity to <second_qty>
    And user adds the item to the cart
    Then the cart count should be <total_qty>
    And the cart page total items should be <total_qty>
    And the cart page total price should be <total_price>
#    MARK: Not able to verify cart items due to Cart UI does not expose color name
#    And the cart should contain "Sauce Lab Back Packs" with color "Black" and quantity 1
#    And the cart should contain "Sauce Lab Back Packs" with color "Blue" and quantity 2

    Examples:
      | item                 | color_1 | first_qty | color_2 | second_qty | total_qty | total_price |
      | Sauce Lab Back Packs | Black   | 1         | Blue    | 2          | 3         | 89.97       |

  Scenario: Empty cart page
    When user goes to the cart page
    Then the cart should be empty

  Scenario Outline: Remove item from cart
    When user navigates to "<item>" detail page
    And user sets quantity to <quantity>
    And user adds the item to the cart
    And user navigates to cart page
    And user clicks remove item for "<item>"
    Then the cart should not contain "<item>"

    Examples:
      | item                 | quantity |
      | Sauce Lab Back Packs | 1        |
