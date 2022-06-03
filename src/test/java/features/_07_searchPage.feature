@GroupB
Feature: Search functionality

  Background:
    Given user on main page and accept cookie

  Scenario: search keyword from search field on main page

    When user search "jean"  header menu search field
    Then result product's name should contain "jean"

  Scenario: search keyword from search field on all catagories page

    When user clicks all products and searches "T-Shirt" on header menu search field
    Then result product's name should contain "T-Shirt"

  Scenario: search keyword from left-bottom search field on all catagories page

    When user clicks all products and searches "Sneakers" left bottom search field on all catagories page
    Then result product's name should contain "Sneakers"