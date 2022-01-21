Feature: As a user I want to validate few features of Games

  Scenario: user can get all data for Games
    When User sends a GET request to list endpoint
    Then User get back a valid status code 200

  Scenario: User want to verify defaultGameFrequency should be 300000
    When User sends a GET request to list endpoint
    Then User verify 'defaultGameFrequency' should always be 300000

  Scenario: Game startTime should always be future timestamp
    When User sends a GET request to list endpoint
    Then Game startTime should always be future timestamp