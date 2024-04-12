Feature: Login functionality

#  Background:
#    Given Open chrome browser and launch application
#    When Click on signIn

  Scenario: nf6tfj
    And uoubonj
    Then njiomy

      @ui
  Scenario: Successful Login with valid credentials
    And Enter mobile number "9347623369"
    And click on continue
    And Enter password "praneeth@9908"
    And click on sign in Btn
    Then Page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
    And Close Driver

  Scenario: Unsuccessful login with invalid mobile number
    And Enter mobile number "934723369"
    And click on continue
    Then Message should be "We cannot find an account with that mobile number"
    And Close Driver

  Scenario: Unsuccessful login with invalid email
    And Enter email "pran@gmail.co"
    And click on continue
    Then Message should be "We cannot find an account with that email address"
    And Close Driver

  Scenario: Unsuccessful login with empty input fields
    And click on continue
    Then Message for empty field should be "Enter your email or mobile phone number"
    And Close Driver

  @regression
  Scenario Outline: Login Data Driven
    And Enter mobile number "<mobile>"
    And click on continue
    And Enter password "<pwd>"
    And click on sign in Btn
    Then Page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
    And Close Driver
    Examples:
      | mobile | pwd |
      | 9347623369 | praneeth@9908 |
      | 9999546466 | pran@123 |