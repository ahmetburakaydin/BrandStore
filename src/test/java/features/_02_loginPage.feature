@GroupA
Feature: login functionality

  @Tag1
  Scenario: login website

    Given user on main page and accept cookie
    When user logins with valid "kursjava@gmail.com" and "kurs.java.123"
    Then My account should be visible on main page