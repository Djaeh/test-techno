Feature: Testing RestExample
  Background:
    Given the test server is initialized

  Scenario: Test path /api/tdd/
    Given responseData as input data
    When I call the service /api/tdd/
    Then The server answer contain responseData