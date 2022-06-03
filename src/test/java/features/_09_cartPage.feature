@GroupB
Feature: Add to Cart Functionality

  Background:
    Given user on main page and accept cookie

  Scenario: add product to cart from main page

    When user adds 2 random products to cart from main page
    And user clicks main cart on "header" menu
    Then product names should be in main cart page

  Scenario: add product to cart from all catagoeries

    When user clicks all products and adds random 2 product to cart on All catagories
    And user clicks main cart on "footer" menu
    Then product names should be in main cart page

  Scenario: add product to cart from product display page

    When user clicks random 2 product from all products page and add product to cart from product display page
    And user clicks main cart on "mini cart" menu
    Then product names should be in main cart page

  Scenario: update random product's count in main cart

    When user clicks all products and adds random 2 product to cart on All catagories
    And user clicks main cart on "mini cart" menu
    And user update all product quantities in main cart
    Then product quantities should be new values


  Scenario: remove all product in main cart

    When user clicks all products and adds random 2 product to cart on All catagories
    And user clicks main cart on "footer" menu
    And user clicks all remove icons on main cart
    Then main cart should be empty


