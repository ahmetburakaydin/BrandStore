@GroupB
Feature: Comparison Functionality

  Background:

    Given user on main page and accept cookie

  Scenario: add same product two times to Comparison List

    When user clicks random 1 products from all products page and clicks add comparison list link
    And user clicks same product from all products page and clicks add comparison list link
    And user goes to comparison list page from header menu
    Then 1 product should be in comparison list

  Scenario: add two products to Comparison List

    When user clicks random 2 products from all products page and clicks add comparison list link
    And user goes to comparison list page from footer menu
    Then 2 product should be in comparison list

  Scenario: remove all products from comparison list

    When user clicks random 3 products from all products page and clicks add comparison list link
    And user goes to comparison list page from header menu
    And user remove all products from comparison list
    Then no product result text should be visible

