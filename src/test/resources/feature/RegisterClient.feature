Feature: Register Client

  Scenario Outline: As a client i want to register in LineRepair.
    Given I want to register as client
    And I enter my own information like names <names>, lastNames <lastNames>, email <email>, password <password>, address <address>,cellPhoneNumber<cellPhoneNumber>,planType<planType>
    Then I should be able to see my newly account

    Examples:
      | names     | lastNames   | email              | password     | address       | cellPhoneNumber       | planType     |
      | "Carlos"  | "Leon"      | "carlos@gmail.com" | "carlos123"  | "La Victoria" | "942121545"           | "Basic"      |