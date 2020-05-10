Feature: Testing of the book resoures
  Background: The test server is initialized
    Given The test server is initialized

  Scenario: Retrieve existing book
    When user call /api/book/isbn1
    Then the request status code is 200
    And server answer with
      | author.name 	|  Bay  |
      | author.firstName 	|  Aude  |
      | isbn 	| isbn1			      |

  Scenario: Book doesn't exist in database
    When user call /api/book/isbn32
    Then the request status code is 404
    And server answer with
      | message 	| book not found			      |
    
