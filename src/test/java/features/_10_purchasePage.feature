@GroupB
Feature: Purchase Funtionality

  Scenario:purchase product from main cart with logged in user
    Given user on main page and accept cookie
    When user logins with valid "kursjava@gmail.com" and "kurs.java.123"
    And user clicks all products and adds random 2 product to cart on All catagories
    And user clicks main cart on "header" menu
    And user clicks proceed to checkout and order overview button and select payment method
    Then all order details should be visible on checkout pagee


  Scenario: purchase product from mini cart with guest user

    Given user on main page and accept cookie
    When user clicks all products and adds random 2 product to cart on All catagories
    And user clicks checkout on mini cart and fills billing details and clicks order overview button
    Then all order details should be visible on checkout pagee
