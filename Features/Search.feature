Feature: Search functionality

  Background:
    Given Open chrome browser and launch application
    When Click on signIn
    And Enter mobile number "9347623369"
    And click on continue
    And Enter password "praneeth@9908"
    And click on sign in Btn
    Then Page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"

  Scenario: Verify search with valid keywords
    Given Open chrome browser and launch application
    When Search with valid keyword "books"
    And Click on search icon
    Then Message in product list page should be "results for \"books\""
    And Close Driver

  Scenario: Verify search with invalid keywords
    Given Open chrome browser and launch application
    When Search with invalid keyword "jklads"
    And Click on search icon
    Then Message in product list page for invalid should be "results for jklads"
    And Close Driver

