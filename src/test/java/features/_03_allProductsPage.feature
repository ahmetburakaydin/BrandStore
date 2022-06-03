@GroupA
Feature: all products page subfunctions

  Background:
    Given user on main page and accept cookie

  Scenario: verify all images and prices on all products page

    When user clicks all products
    Then all products should have a image and a price

  Scenario: verify dropdown menu on all products

    When user clicks all products and selects random catagory from dropdown menu
    Then the result product's names should contain their dropdown menu names

  Scenario: verify sorting section on all products

    When user clicks all products and selects sorting criteria from dropdown menu
    Then the result should come according to the criteria


