@GroupA
Feature: all images on main page

  Scenario: verify all images on main page

    Given user on main page and accept cookie
    Then all product images should be visible and working

