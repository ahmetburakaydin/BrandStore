@GroupA
Feature: Recently viewed product section

  Scenario: Display random two product and validate on recently viewed section as a registered user

    Given user on main page and accept cookie
    When user logins with valid "kursjava@gmail.com" and "kurs.java.123"
    When user clicks all products and displays two products one after another
    Then products should  be visible recently viewed section