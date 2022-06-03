@GroupA
Feature: all products page filter functions

  Background:

    Given user on main page and accept cookie
    When user clicks all products and clicks products filter button

  Scenario: filter all products by price

    And user randomly selects "price" filter and clicks filter now button
    Then filter result products prices should be between min and max prices

  Scenario: filter all products by color

    And user randomly selects "color" filter and clicks filter now button
    Then result product should contain color name

  Scenario: filter all products by size

    And user randomly selects "size" filter and clicks filter now button
    Then result product should contain size name

  Scenario: filter all products by material

    And user randomly selects "material" filter and clicks filter now button
    Then result product should contain material name

  Scenario: filter product by gender

    And user randomly selects "gender" filter and clicks filter now button
    Then result product should contain gender name