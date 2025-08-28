Feature: Pokemon SOAP API
  As a client
  I want to consume Pokemon data through SOAP endpoints
  So that I can get Pokemon information

  Scenario: Get Pokemon abilities
    Given I have a Pokemon name "pikachu"
    When I call the getAbilities SOAP endpoint
    Then I should receive a list of abilities
    And the request should be logged in the database

  Scenario: Get Pokemon base experience
    Given I have a Pokemon name "pikachu"
    When I call the getBaseExperience SOAP endpoint
    Then I should receive the base experience value
    And the request should be logged in the database

  Scenario: Get Pokemon ID
    Given I have a Pokemon name "pikachu"
    When I call the getId SOAP endpoint
    Then I should receive the Pokemon ID
    And the request should be logged in the database