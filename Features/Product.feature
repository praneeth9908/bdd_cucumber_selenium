Feature: Product Page functionality

  Background:
    Given Open chrome browser and launch application
    When Click on signIn
    And Enter mobile number "9347623369"
    And click on continue
    And Enter password "praneeth@9908"
    And click on sign in Btn
    Then Page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
    When Search with valid keyword "books"
    And Click on search icon
    Then Message in product list page should be "results for \"books\""
    When click one product
    And Navigate to product page

    Scenario: verify the Add to Cart functionality

      And Click on add to cart
      Then Message for Add To Cart should be "Added to Cart"
      And Close Driver

    Scenario: verify the Buy now functionality
      And Click on Buy now
      Then Message for Buy Now should be "Checkout"
      And Close Driver