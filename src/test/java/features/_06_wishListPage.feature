@GroupB
Feature: wish list feature

  Background:

    Given user on main page and accept cookie

  Scenario: add wish list from product's heart icon on main page

    When user clicks randomly a product's heart icon on main page
    And user goes to wish list from "header" menu
    Then clicked product should be in wish list

  Scenario: add wish list from product's heart icon on all products page

    When user clicks all products and then clicks randomly a product's heart icon
    And user goes to wish list from "footer" menu
    Then clicked product should be in wish list

  Scenario: add wish list from wish list link on display page

    When user clicks random product from all products page
    And user clicks add wish list link and goes to wish list from "display page"
    Then clicked product should be in wish list

  Scenario: click heart icon and goes to wish list from "heartbeat" icon on all products page

    When user clicks all products and then clicks randomly a product's heart icon
    And user goes to wish list from same product's "heartbeat" icon
    Then clicked product should be in wish list

  Scenario: remove product from wish list

    When user clicks all products and then clicks randomly a product's heart icon
    And user goes to wish list from "header" menu
    And user remove all products from wish list
    Then no product should be in wish list