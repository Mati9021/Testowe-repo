Feature: Add new address
  As a user
  I want to add new address
  So that I can buy clothes


  Scenario Outline: Successfully account creation
    Given the user is logged in
    When the user navigates to the addresses page
    And the user clicks on Create new address
    And the user fills the address form with "<alias>", "<address>", "<city>", "<zip>", "<country>", "<phone>"
    Then the new address is added with "<alias>", "<address>", "<city>", "<zip>", "<country>", "<phone>"

    Examples:
      | alias | address          | city    | zip   | country        | phone      |
      | Home  | 123 Main St      | Bristol | 10001 | United Kingdom | 1234567890 |
      | Work  | 456 Corporate Dr | Bristol | 94111 | United Kingdom | 0987654321 |